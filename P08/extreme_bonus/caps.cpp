// Talha Tahmid 1001910304
#include <iostream>
#include <string>
#include <vector>


int main(int argc, char* argv[]) {
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>();

    for (int i = 1; i < argc; ++i) {
        std::string arg = argv[i];

        if (!arg.empty()) {
            char firstChar = arg[0];
            if (std::isupper(firstChar)) {
                caps.push_back(arg);
            } else {
                no_caps->push_back(arg);
            }
        }
    }

    // Sorting the caps vector by its natural sort order.
    std::sort(caps.begin(), caps.end());

    // Sorting the no_caps vector first by length and then by natural sort order.
    std::sort(no_caps->begin(), no_caps->end(),
        [](const std::string& a, const std::string& b) {
            if (a.length() != b.length()) {
                return a.length() < b.length();
            }
            return a < b;
        }
    );


    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }

    std::cout << std::endl;

    std::cout << "Lower Case:" << std::endl;
    for (const std::string& word : *no_caps) {
        std::cout << word << std::endl;
    }

    //deleting the dynamically allocated vector.
    delete no_caps;

    return 0;
}