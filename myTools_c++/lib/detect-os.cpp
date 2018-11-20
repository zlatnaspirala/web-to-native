#include <iostream>
#include <stdio.h>
#include <string>
#include "detect-os.h"
using namespace std;

int test() {
    return 100;
}

#ifdef _WIN32
   //define something for Windows (32-bit and 64-bit, this part is common)
      cout << "Windows OS " << endl;
   #ifdef _WIN64
      cout << "Windows (64-bit only)" << endl;
   #else
      cout << "Windows (32-bit only)" << endl;
      //define something for Windows (32-bit only)
   #endif

#elif __APPLE__
    #include "TargetConditionals.h"
    #if TARGET_IPHONE_SIMULATOR
        // iOS Simulator
        cout << "iOS simulator" << endl;
    #elif TARGET_OS_IPHONE
        // iOS device
        cout << "iOS" << endl;
    #elif TARGET_OS_MAC
        // Other kinds of Mac OS
        cout << "MAC OS" << endl;
        
    #else
    #   error "Unknown Apple platform"
    #endif
#elif __linux__
    // linux
    cout << "LINUX" << endl;
#elif (defined (LINUX) || defined (__linux__))
    // linux code
    cout << "LINUX" << endl;
#elif __unix__ // all unices not caught above
    // Unix
    cout << "UNIX" << endl;
#elif defined(_POSIX_VERSION)
    // POSIX
#else
#   error "Unknown compiler";
#endif

