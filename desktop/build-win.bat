
@echo "Ready to generate Visual Studio Project [press any key]"
Pause

cd cef-win
cmake -G "Visual Studio 16" -A x64 ../cef
