
# C++ cef client 'web-to-native'

### Objective

 - Help to create native GUI application based on cef.


### Status

  UNDERCONSTRUCT

  cd cef-win
  cmake -G "Visual Studio 16" -A x64 ../cef/cef-project


### Language c++

I want to try multiplatform build for windowds, mac, linux.

### Project structure ###

<pre>

├── project/
|   ├── public/
|       ├── .vscode/  [auto generated][not important]
|       ├── cef/ [clone cef]
|       ├── cef-win/ [cef build for windows]
|       ├── cef-mac/ [cef build for mac os]
├── .gitignore   [auto generated]
├── .gitmodules  [auto generated]
├── README.MD  [This file]
├── tools.code-workspace  [Workspace for visual code]

</pre>

