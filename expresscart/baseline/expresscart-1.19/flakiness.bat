@echo off
setlocal enabledelayedexpansion

REM ======= CONFIGURA QUI IL NUMERO DI ESECUZIONI ==========
set n=50

REM ======= PERCORSO BASE PER I RISULTATI ===================

for /L %%i in (1,1,%n%) do (
    echo.
    echo [ESECUZIONE %%i DI %n%]

    echo Avvio container browser...
    docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:138.0-chromedriver-138.0

    timeout /t 5 /nobreak >nul

    echo Avvio container Expresscart...
    docker run -i -t  --name=expresscart -p "3000:1111" -d olianasd/expresscart-strongpsw

    timeout /t 10 /nobreak >nul

    echo Esecuzione test con Maven...
    mvn -Dtest=TestSuite test

    echo Salvataggio risultati...
    mkdir "..\..\..\..\flakycheck\expresscart\java21-selenium434-chrome138-headlesnew\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\expresscart\java21-selenium434-chrome138-headlesnew\%%i\"

    echo Arresto e rimozione container Docker...
    docker stop browser >nul
    docker rm browser >nul
    docker stop expresscart >nul
    docker rm expresscart >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
