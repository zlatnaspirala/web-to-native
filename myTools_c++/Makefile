SRC_DIR := ./src
BUILD := ./build
OBJ_DIR := $(BUILD)/obj
SRC_FILES := $(wildcard $(SRC_DIR)/*.cpp)
OBJ_FILES := $(patsubst $(SRC_DIR)/%.cpp,$(OBJ_DIR)/%.o,$(SRC_FILES))
CXX      := -c++
CXXFLAGS := -pedantic-errors -Wall -Wextra -Werror
LDFLAGS  := -L lib -lstdc++ -lm

main.exe: $(OBJ_FILES)
		g++ $(LDFLAGS) -o $@ $^

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.cpp
		@mkdir -p $(OBJ_DIR)
		g++ $(CPPFLAGS) $(CXXFLAGS) -c -o $@ $<

clean:
	rm -f main.exe

