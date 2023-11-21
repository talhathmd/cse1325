// Index.cpp
#include "Index.h"

void Index::add_word(const Word& word, const std::string& filename, int line) {
    _index.insert(std::make_pair(word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& ost, const Index& index) {
    std::unordered_set<Index::Word> unique_words;
    for (const auto& entry : index._index) {
        unique_words.insert(entry.first);
    }

    for (const auto& word : unique_words) {
        ost << word << ": ";
        auto range = index._index.equal_range(word);
        auto it = range.first;
        while (it != range.second) {
            ost << it->second;
            ++it;
            if (it != range.second) {
                ost << ", ";
            }
        }
        ost << std::endl;
    }
    return ost;
}
