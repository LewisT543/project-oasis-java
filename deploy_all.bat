@echo off
echo Preparing shared library...
cd ./oasis-shared-library
call mvn clean install
echo %ERRORLEVEL%
if %ERRORLEVEL% neq 0 (
  echo Failed to prepare shared library.
  exit /b %ERRORLEVEL%
)

call ../scripts/prepare_service.bat property
call ../scripts/prepare_service.bat applicant
call ../scripts/prepare_service.bat mortgage

echo Deploying services...
cd ..
call docker-compose up --build