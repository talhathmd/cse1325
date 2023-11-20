#include <iostream>
#include <fstream>
#include <sstream>
#include "Index.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <filename1> <filename2> ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;

        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                word.erase(word.begin(), std::find_if_not(word.begin(), word.end(), ::ispunct));
                word.erase(std::find_if_not(word.rbegin(), word.rend(), ::ispunct).base(), word.end());
                std::transform(word.begin(), word.end(), word.begin(), ::tolower);

                // Adding the word to the index
                index.add_word(word, argv[i], line_number);
            }

            ++line_number;
        }

        file.close();
    }

    // Printing the index
    std::cout << index;

    return 0;
}
