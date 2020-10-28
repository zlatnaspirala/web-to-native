#include <iostream> // header in standard library
#include "myspace.h" // header in local directory
using namespace std;

void My_class::doit () {
    cout << "Just do it !" ;
}

string My_class::getPlatform() {

    string platform = "windows";

    #ifdef _WIN32
            //define something for Windows (32-bit and 64-bit, this part is common)
            // cout << "Windows OS " << endl;
            platform = "windows";
       #ifdef _WIN64
            // cout << "Windows (64-bit only)" << endl;
            platform = "windows 64-bit";
       #else
            // define something for Windows (32-bit only)
            // cout << "Windows (32-bit only)" << endl;
            platform = "windows 32-bit";
       #endif

    #elif __APPLE__
        #include "TargetConditionals.h"
        #if TARGET_IPHONE_SIMULATOR
            // iOS Simulator
            // cout << "iOS simulator" << endl;
            platform = "iOS simulator";
        #elif TARGET_OS_IPHONE
            // iOS device
            // cout << "iOS" << endl;
            platform = "iOS";
        #elif TARGET_OS_MAC
            // Other kinds of Mac OS
            // cout<< "MAC OS" << endl;
            platform = "mac-os";
        #else
        #   error "Unknown Apple platform"
        #endif
    #elif __linux__
        // linux
        // cout << "LINUX" << endl;
        platform = "linux";
    #elif (defined (LINUX) || defined (__linux__))
        // linux code
        // cout << "LINUX" << endl;
        platform = "linux";
    #elif __unix__ // all unices not caught above
        // Unix
        // cout << "UNIX" << endl;
        platform = "unix";
    #elif defined(_POSIX_VERSION)
        // POSIX
        platform = "POSIX";
    #else
    #   error "Unknown compiler";
    #endif

    return platform;
}
