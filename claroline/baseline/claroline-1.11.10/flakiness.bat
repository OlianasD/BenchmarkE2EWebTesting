@echo off
setlocal enabledelayedexpansion

REM ======= CONFIGURA QUI IL NUMERO DI ESECUZIONI ==========
set n=50

REM ======= PERCORSO BASE PER I RISULTATI ===================

for /L %%i in (1,1,%n%) do (
    echo.
    echo [ESECUZIONE %%i DI %n%]

    echo Avvio container browser...
    docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:140.0-chromedriver-140.0

    timeout /t 5 /nobreak >nul

    echo Avvio container Claroline...
    docker run -it --workdir=/home/claroline --name=claroline --expose 80 --expose 3306 -p 3000:80 -p 3306:3306 -d --entrypoint ./run-services-docker.sh olianasd/claroline-strongpsw bash

    timeout /t 5 /nobreak >nul

    echo Esecuzione test con Maven...
    mvn -Dtest=Claroline_TestSuite test

    echo Salvataggio risultati...
    mkdir "..\..\..\..\flakycheck\claroline\java21-selenium435-chrome140-headlessnew\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\claroline\java21-selenium435-chrome140-headlessnew\%%i\"

    echo Arresto e rimozione container Docker...
    docker stop browser >nul
    docker rm browser >nul
    docker stop claroline >nul
    docker rm claroline >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
