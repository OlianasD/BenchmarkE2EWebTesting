@echo off
setlocal enabledelayedexpansion

REM ======= CONFIGURA QUI IL NUMERO DI ESECUZIONI ==========
set n=50

REM ======= PERCORSO BASE PER I RISULTATI ===================

for /L %%i in (1,1,%n%) do (
    echo.
    echo [ESECUZIONE %%i DI %n%]

    echo Avvio container browser...
    docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:139.0-chromedriver-139.0

    timeout /t 5 /nobreak >nul

    echo Avvio containers MantisBT...
    docker compose up -d

    timeout /t 10 /nobreak >nul

    echo Installazione MantisBT...
    mvn -Dtest=Installer test

    timeout /t 5 /nobreak >nul

    echo Esecuzione test con Maven...
    mvn -Dtest=TestSuite test
    timeout /t 5 /nobreak >nul
    echo Salvataggio risultati...
    mkdir "..\..\..\..\flakycheck\mantisbt-2.25.4\java21-selenium434-chrome138-headlessnew\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\mantisbt-2.25.4\java21-selenium434-chrome138-headlessnew\%%i\"

    echo Arresto e rimozione container Docker...
    docker stop browser >nul
    docker rm browser >nul
    docker stop mantisbt-2254-mantisbt-1 >nul
    docker rm mantisbt-2254-mantisbt-1 >nul
    docker stop mantisbt-2254-mysql-1 >nul
    docker rm mantisbt-2254-mysql-1 >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
