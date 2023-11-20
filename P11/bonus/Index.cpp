#include "Index.h"

void Index::add_word(const Word& word, const std::string& filename, int line) {
    Locations& locations = _index[word];
    locations.insert(Location(filename, line));
    Location::next_word(); // Calling the static method to reset last_filename
}

std::ostream& operator<<(std::ostream& ost, const Index& index) {
    for (const auto& entry : index._index) {
        ost << entry.first << ": ";
        for (const auto& location : entry.second) {
            ost << location << ", ";
        }
        ost << "\n";
        Location::next_word(); // Calling the static method to reset last_filename for the next word
    }
    return ost;
}
