#include "Circle.h"

// Constructor definition
Circle::Circle(double r) : radius(r) {
}

// Implement the overridden methods
std::string Circle::name() const {
    return "Circle of radius " + std::to_string(radius);
}

double Circle::area() const {
    return 3.14159265358979323846 * radius * radius;
}

// Getter method
double Circle::getRadius() const {
    return radius;
}
