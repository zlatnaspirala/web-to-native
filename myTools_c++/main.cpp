#include <iostream>
#include <vector>
#include <stdio.h>
#include <string>
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

int main(int argc, char *argv[]) {

  cout << "###########################" << endl;
  cout << "# Welcome :  man !        #" << endl;
  cout << "###########################" << endl;
  
  Rectangle rect;
  rect.set_values (3,4);
  cout << "area: " << rect.area() << endl;

  My_class t;
  t.doit();

  std::string myPlatform = t.getPlatform();
  cout << myPlatform << endl;;

  return 0;

}
