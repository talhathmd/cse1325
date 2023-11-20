// Location.cpp
#include "Location.h"

std::string Location::last_filename = ""; // Initializing the static field

Location::Location(const std::string& filename, int line) : _filename(filename), _line(line) {}

bool Location::operator==(const Location& rhs) const {
    return (_filename == rhs._filename) && (_line == rhs._line);
}

bool Location::operator!=(const Location& rhs) const {
    return !(*this == rhs);
}

bool Location::operator<(const Location& rhs) const {
    if (_filename == rhs._filename) {
        return _line < rhs._line;
    }
    return _filename < rhs._filename;
}

bool Location::operator>(const Location& rhs) const {
    return rhs < *this;
}

bool Location::operator<=(const Location& rhs) const {
    return !(*this > rhs);
}

bool Location::operator>=(const Location& rhs) const {
    return !(*this < rhs);
}

std::ostream& operator<<(std::ostream& ost, const Location& location) {
    if (location._filename != Location::last_filename) {
        ost << location._filename << " line ";
        Location::last_filename = location._filename; // Updating last_filename
    }
    ost << location._line;
    return ost;
}

void Location::next_word() {
    Location::last_filename = ""; // Reseting last_filename
}