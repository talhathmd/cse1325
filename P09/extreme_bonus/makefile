# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17

# SFML flags
SFML_LIBS = -L//opt/homebrew/Cellar/sfml/2.6.1/lib -lsfml-graphics -lsfml-window -lsfml-system
SFML_INCLUDE = -I/opt/homebrew/Cellar/sfml/2.6.1/include

# Source files and headers
SRCS = Shapes.cpp Shape.cpp Rectangle.cpp Circle.cpp
HEADERS = Shape.h Rectangle.h Circle.h

# Object files
OBJS = $(SRCS:.cpp=.o)

# Target executable
TARGET = shapes

# Build the executable
$(TARGET): $(OBJS)
	$(CXX) $(CXXFLAGS) -o $(TARGET) $(OBJS) $(SFML_LIBS)

# Compile source files into object files
%.o: %.cpp $(HEADERS)
	$(CXX) $(CXXFLAGS) $(SFML_INCLUDE) -c $< -o $@

# Clean rule
clean:
	rm -f $(OBJS) $(TARGET)
