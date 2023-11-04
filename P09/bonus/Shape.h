#ifndef SHAPE_H
#define SHAPE_H

#include <string> // For strings

class Shape {
public:

    // Declaring the methods
    virtual std::string name() const;
    virtual double area() const;
    virtual std::string to_string() const;
};

#endif
