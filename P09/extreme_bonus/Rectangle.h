#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {
private:
    double width;
    double height;

public:
    Rectangle(double w, double h);
    double getWidth() const;
    double getHeight() const;

    // Declaration of overridden methods
    std::string name() const override;
    double area() const override;
};

#endif // RECTANGLE_H
