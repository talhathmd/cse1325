#ifndef SHAPE_H
#define SHAPE_H

#include <string> // For strings

class Shape {
public:

    // Pure virtual methods (making Shape an abstract class)
    virtual std::string name() const = 0;
    virtual double area() const = 0;
    virtual std::string to_string() const;
};

#endif
