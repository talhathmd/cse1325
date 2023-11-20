#pragma once
#include <map>
#include <set>
#include <string>
#include "Location.h"

class Index {
private:
    typedef std::string Word;
    typedef std::set<Location> Locations;
    std::map<Word, Locations> _index;

public:
    void add_word(const Word& word, const std::string& filename, int line);
    friend std::ostream& operator<<(std::ostream& ost, const Index& index);
};
