#pragma once
#include <iostream>
#include <string>

class Location {
private:
    static std::string last_filename; // New static field

    std::string _filename;
    int _line;

public:
    Location(const std::string& filename, int line);
    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;
    friend std::ostream& operator<<(std::ostream& ost, const Location& location);

    static void next_word(); // New static method
};
