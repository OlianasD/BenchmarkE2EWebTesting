@echo off
setlocal enabledelayedexpansion

REM ======= CONFIGURA QUI IL NUMERO DI ESECUZIONI ==========
set n=17

REM ======= PERCORSO BASE PER I RISULTATI ===================

for /L %%i in (1,1,%n%) do (
    echo.
    echo [ESECUZIONE %%i DI %n%]

    echo Avvio container browser...
    docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:138.0-chromedriver-138.0

    timeout /t 5 /nobreak >nul

    echo Avvio containers Prestashop...
    docker run -ti --name some-mysql --network prestashop-net -e MYSQL_ROOT_PASSWORD=admin -p 3307:3306 -d mysql:5.7
    docker run -ti --name some-prestashop --network prestashop-net -e DB_SERVER=some-mysql -p 8080:80 -d prestashop/prestashop:1.7.8.5

    timeout /t 10 /nobreak >nul

    echo Installazione Prestashop...
    mvn -Dtest=Installer test

    echo Eliminazione directory installazione e rinominazione directory admin...
    docker exec some-prestashop bash -c "rm -rf install"
    docker exec some-prestashop bash -c "mv admin administrator"

    timeout /t 5 /nobreak >nul

    echo Chiusura introduzione app...
    mvn -Dtest=StopOnboarding test

    echo Esecuzione test con Maven...
    mvn -Dtest=TestSuite test
    timeout /t 5 /nobreak >nul
    echo Salvataggio risultati...
    mkdir "..\..\..\..\flakycheck\prestashop-1.7.8.5\java21-selenium314159-chrome137-headlessnew\%%i"
    xcopy /E /Y "target\surefire-reports\*" "..\..\..\..\flakycheck\prestashop-1.7.8.5\java21-selenium314159-chrome137-headlessnew\%%i\"

    echo Arresto e rimozione container Docker...
    docker stop browser >nul
    docker rm browser >nul
    docker stop some-prestashop >nul
    docker rm some-prestashop >nul
    docker stop some-mysql >nul
    docker rm some-mysql >nul

    timeout /t 5 /nobreak >nul
)

echo.
echo ======= COMPLETATO =======
pause
