
set mypath=%cd%
@echo %mypath%
Pause

cd %mypath%\cef-win
cmake -G "Visual Studio 16" -A x64 ../cef/cef-project
