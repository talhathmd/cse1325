#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>

int main() {
    std::vector<Shape*> shapes; // Creating a vector to hold shapes

    // Creating objects of Rectangle and Circle and add them to the vector
    Rectangle rectangle(4.0, 3.0);
    Circle circle(2.0);
    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    // Iterating over the vector and print the result of to_string() for each shape
    for (const Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }


    return 0;
}
