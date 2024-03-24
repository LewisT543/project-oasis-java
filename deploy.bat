@echo off
echo Preparing shared library...
cd ./oasis-shared-library
call mvn clean install
echo %ERRORLEVEL%
if %ERRORLEVEL% neq 0 (
  echo Failed to prepare shared library.
  exit /b %ERRORLEVEL%
)

echo Preparing property service...
cd ../property-service
call mvn clean install compile package
echo %ERRORLEVEL%
if %ERRORLEVEL% neq 0 (
  echo Failed to prepare property service.
  exit /b %ERRORLEVEL%
)

echo Deploying services...
cd ..
call docker-compose up --build