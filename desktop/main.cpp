#include <iostream>
#include <vector>
#include <stdio.h>
#include <string>
#include <stdexcept>

#include "lib/myspace.h"
using namespace std;

class Rectangle {
    int width, height;
  public:
    void set_values (int,int);
    int area() {return width*height;}
};

void Rectangle::set_values (int x, int y) {
  width = x;
  height = y;
}

std::string exec(const char* cmd) {
    std::array<char, 128> buffer;
    std::string result;
    std::unique_ptr<FILE, decltype(&pclose)> pipe(popen(cmd, "r"), pclose);
    if (!pipe) {
        throw std::runtime_error("popen() failed!");
    }
    while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {
        result += buffer.data();
    }
    return result;
}

int main(/**int argc, char *argv[]*/) {

  cout << "###########################" << endl;
  cout << "# Welcome :  man !        #" << endl;
  cout << "###########################" << endl;

  Rectangle rect;
  rect.set_values (3,4);
  cout << "area: " << rect.area() << endl;

  My_class t;
  t.doit();

  std::string myPlatform = t.getPlatform();
  cout << myPlatform << endl;

  // exec("cd cef-win")

  exec("cd cef-win;cmake -G 'Visual Studio 16' -A x64 ../cef/cef-project");

  return 0;

}
