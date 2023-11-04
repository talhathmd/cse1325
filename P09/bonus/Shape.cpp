#include "Shape.h"

// Implementing the name() method for the Shape class
std::string Shape::name() const {
    return "Shape";
}

// Implementing the area() method for the Shape class
double Shape::area() const {
    return 0.0;
}

// Implementing the to_string() method for the Shape class
std::string Shape::to_string() const {
    return name() + " with area " + std::to_string(area());
}
