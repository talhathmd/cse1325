#include "Rectangle.h"

Rectangle::Rectangle(double width, double height) : width(width), height(height) {
    // Initializing the width and height members
}

std::string Rectangle::name() const {
    return "Rectangle " + std::to_string(width) + "x" + std::to_string(height);
}

double Rectangle::area() const {
    return width * height;
}
