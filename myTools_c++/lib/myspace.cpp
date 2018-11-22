#include <iostream> // header in standard library
#include "myspace.h" // header in local directory
using namespace std;

void My_class::doit () {
    cout << "Just do it !" ;
};

string My_class::getPlatform() {

    #ifdef _WIN32
            //define something for Windows (32-bit and 64-bit, this part is common)
            // cout << "Windows OS " << endl;
            string platform = "windows";
       #ifdef _WIN64
            // cout << "Windows (64-bit only)" << endl;
            string platform = "windows 64-bit";
       #else
            // define something for Windows (32-bit only)
            // cout << "Windows (32-bit only)" << endl;
            string platform = "windows 32-bit";
       #endif

    #elif __APPLE__
        #include "TargetConditionals.h"
        #if TARGET_IPHONE_SIMULATOR
            // iOS Simulator
            // cout << "iOS simulator" << endl;
            string platform = "iOS simulator";
        #elif TARGET_OS_IPHONE
            // iOS device
            // cout << "iOS" << endl;
            string platform = "iOS";
        #elif TARGET_OS_MAC
            // Other kinds of Mac OS
            // cout<< "MAC OS" << endl;
            string platform = "mac-os";
        #else
        #   error "Unknown Apple platform"
        #endif
    #elif __linux__
        // linux
        // cout << "LINUX" << endl;
        string platform = "linux";
    #elif (defined (LINUX) || defined (__linux__))
        // linux code
        // cout << "LINUX" << endl;
        string platform = "linux";
    #elif __unix__ // all unices not caught above
        // Unix
        // cout << "UNIX" << endl;
        string platform = "unix";
    #elif defined(_POSIX_VERSION)
        // POSIX
    #else
    #   error "Unknown compiler";
    #endif

    return platform;
};

