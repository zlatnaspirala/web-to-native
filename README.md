
# C++ cef client 'web-to-native'

### Objective

 - Help to create native application based on cef implementation.
 - Prepare mobile projects


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


### Run for windows

```bat
  build-win.bat 
```

  OR

```bash
  cd cef-win
  cmake -G "Visual Studio 16" -A x64 ../cef
```

 After success building look at cef-win/
 You can make yout own modification or separate 
 project from root project `web-to-native`
 Because if you run again build command you will override all changes 
 in cef-win or cef-mac folder...

 Except in case that we use modification in cef source files. In this case
 git pull for submodule will override this kind of changes.


### Run for macos:

```bash
  cd cef-mac
  cmake -G "Xcode" ../cef
```

### Run for android:

Open with android studio folder `android` 
and build your apk.
Used last version:
Android studio 4.1.1
android-30 ndk 22 

