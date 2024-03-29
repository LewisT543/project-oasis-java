@echo off

rem Prepare a service for docker deployment
echo Preparing %1 service...
cd ../%1-service
call mvn clean install compile package
echo %ERRORLEVEL%
if %ERRORLEVEL% neq 0 (
  echo Failed to prepare %1 service.
  exit /b %ERRORLEVEL%
)

