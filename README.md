
# C++ cef client 'web-to-native'

### Objective

 - Help to create on easy way native application based on cef implementation.
 - Prepare mobile projects works
 - Make help for better understanding concept of browser applilcation and 
   directives for editing.
 - Leave it in native order to be full customized. No globals, defaults, enum
   and roles except existing roles of building cef.

### Generally 3 ways to use this project.

  - For advanced level programmers 
    Change core of cef functional implementation.
    Build native wrapper.
    Run some extra ordinary code.
  - For middle level
    Build cef project (any platform).
    Exclude builded project.
    Edit project with VisualStudio, xCode etc...
    Create and connect web part with project.(set home page url)
    Build binaries.
  - For everyone
    Build cef.
    Connect with web part (set home page url)
    Build Project.

### Instalaltion

```js
git clone --recurse-submodules -j8 https://github.com/zlatnaspirala/web-to-native
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

