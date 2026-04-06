@echo off
echo Building and starting GeoExplorer...
echo (First run takes several minutes to build - please wait)
echo.
docker compose up --build -d
echo.
echo ================================================
echo   GeoExplorer is running at http://localhost
echo ================================================
echo.
echo Waiting for backend to finish starting...
timeout /t 15 /nobreak > nul
start http://localhost
echo.
echo Showing logs (Ctrl+C to stop watching logs - app keeps running)
docker compose logs -f
