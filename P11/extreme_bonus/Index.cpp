// Index.cpp
#include "Index.h"

void Index::add_word(const Word& word, const std::string& filename, int line) {
    _index.insert(std::make_pair(word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& ost, const Index& index) {
    std::unordered_set<Index::Word> printed_words;

    for (const auto& entry : index._index) {
        const auto& word = entry.first;
        const auto& location = entry.second;

        // Check if the word has already been printed
        if (printed_words.find(word) == printed_words.end()) {
            ost << word << ": " << location;

            // Mark the word as printed
            printed_words.insert(word);

            // Find other occurrences of the same word and print them
            auto range = index._index.equal_range(word);
            auto it = range.first;
            ++it; // Move to the next occurrence
            while (it != range.second) {
                ost << ", " << it->second;
                ++it;
            }

            ost << std::endl;
        }
    }

    return ost;
}