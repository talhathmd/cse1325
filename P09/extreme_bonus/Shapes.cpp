#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>

#include <SFML/Graphics.hpp>

int main() {
    // Create a window for drawing the visual representation
    sf::RenderWindow window(sf::VideoMode(400, 400), "Shapes Visual Representation");

    // Create a vector to hold objects of different shapes
    std::vector<Shape*> shapes;

    // Create objects of Rectangle and Circle
    Rectangle rectangle(25.0, 30.0);
    Circle circle(2.0);

    // Add the objects to the vector
    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    // Print the text-based representation of the shapes
    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    while (window.isOpen()) {
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed) {
                window.close();
            }
        }

        window.clear();

        // Draw the visual representations of the shapes
        for (Shape* shape : shapes) {
            if (dynamic_cast<Rectangle*>(shape)) {
                sf::RectangleShape sfmlRectangle(sf::Vector2f(dynamic_cast<Rectangle*>(shape)->getWidth() * 10.0, dynamic_cast<Rectangle*>(shape)->getHeight() * 10.0));
                sfmlRectangle.setFillColor(sf::Color::Transparent); // Transparent fill
                sfmlRectangle.setOutlineColor(sf::Color::Red); // Border color
                sfmlRectangle.setOutlineThickness(2); // Border thickness
                sfmlRectangle.setPosition(50, 50);
                window.draw(sfmlRectangle);
            } 
        }

        window.display();
    }

    return 0;

}
