#include "Circle.h"
#include <cmath> // Including this for M_PI

Circle::Circle(double radius) : radius(radius) {
    // Initializung the radius member
}

std::string Circle::name() const {
    return "Circle with radius " + std::to_string(radius);
}

double Circle::area() const {
    return M_PI * radius * radius; // The formula for the area of a circle
}
