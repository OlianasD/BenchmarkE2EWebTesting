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

    echo Avvio containers Mediawiki...
    docker compose up -d

    timeout /t 15 /nobreak >nul

    echo Installazione Mediawiki...
    mvn -Dtest=Installer test

    echo Copio LocalSettings.php...
    docker cp LocalSettings.php mediawiki-1400-mediawiki-1:/var/www/html

    timeout /t 5 /nobreak >nul

    echo Esecuzione test con Maven...
    mvn -Dtest=TestSuite test
    timeout /t 5 /nobreak >nul
    echo Salvataggio risultati...
    mkdir "..\..\..\..\flakycheck\mediawiki\java21-selenium314159-chrome138-headlesnew\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\mediawiki\java21-selenium314159-chrome138-headlesnew\%%i\"

    echo Arresto e rimozione container Docker...
    docker stop browser >nul
    docker rm browser >nul
    docker stop mediawiki-1400-mediawiki-1 >nul
    docker rm mediawiki-1400-mediawiki-1 >nul
    docker stop mediawiki-1400-database-1 >nul
    docker rm mediawiki-1400-database-1 >nul
    docker volume rm mediawiki-1400_images >nul
    docker volume rm mediawiki-1400_db >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
