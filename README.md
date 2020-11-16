
# C++ cef client 'web-to-native'

### Objective

 - Help to create native GUI application based on cef.


### Run for win

```bat
  build-win.bat 
```

  OR

```bash
  cd cef-win
  cmake -G "Visual Studio 16" -A x64 ../cef
```


### Project structure ###

[auto-generated] Folders can be deleted but also you can use 
 generated instance and make separated project developed 
 in top dev tools like visual-studio or x-code.

 For simple fullscreen porting we no need any GUI controls.

<pre>

├── root/
|   ├── desktop/
|       ├── .vscode/  [auto generated][not important]
|       ├── cef/ [clone cef - submodule]
|       ├── cef-win/ [build - auto-generated]  
|       ├── cef-mac/ [build - auto-generated]
├── .gitignore   [auto generated]
├── .gitmodules  [auto generated]
├── README.MD  [This file]
├── tools.code-workspace  [Workspace for visual code]

</pre>

### Build


