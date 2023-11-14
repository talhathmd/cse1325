// Talha Tahmid 1001910304

#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

public:
    Time(int hour, int minute, int second);
    Time(); // Default constructor

    Time operator+(const Time& time) const;
    Time operator++(); // Pre-increment
    Time operator++(int); // Post-increment
    bool operator==(const Time& time) const;
    bool operator!=(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;
    friend std::ostream& operator<<(std::ostream& ost, const Time& time);
    friend std::istream& operator>>(std::istream& ist, Time& time);


private:
    void rationalize();
    int compare(const Time& time) const;
};

#endif // TIME_H
