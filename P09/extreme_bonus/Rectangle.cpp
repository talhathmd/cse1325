#include "Rectangle.h"

// Constructor definition
Rectangle::Rectangle(double w, double h) : width(w), height(h) {
}

// Implement the overridden methods
std::string Rectangle::name() const {
    return "Rectangle of width " + std::to_string(width) + " and height " + std::to_string(height);
}

double Rectangle::area() const {
    return width * height;
}

// Getter methods
double Rectangle::getWidth() const {
    return width;
}

double Rectangle::getHeight() const {
    return height;
}
