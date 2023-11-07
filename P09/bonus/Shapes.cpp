#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>

int main() {
    std::vector<Shape*> shapes; // Creating a vector to hold shapes

    // Creating objects of Rectangle and Circle and add them to the vector
    Rectangle rectangle(3.0, 4.0);
    Circle circle(2.0);
    
    // Adding the objects to the vector using dynamic memory
    shapes.push_back(new Rectangle(3.0, 4.0));
    shapes.push_back(new Circle(2.0));

    // Iterating over the vector and print the result of to_string() for each shape
    for (const Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    // Cleaning up dynamic memory


    return 0;
}
