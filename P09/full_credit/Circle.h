#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"
#include <string>

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double radius);

    // Overriding the name() and area() methods
    std::string name() const override;
    double area() const override;
};

#endif
