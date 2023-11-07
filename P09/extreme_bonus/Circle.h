#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double r);
    double getRadius() const;

    // Declaration of overridden methods
    std::string name() const override;
    double area() const override;
};

#endif // CIRCLE_H
