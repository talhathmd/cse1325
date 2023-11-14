// Talha Tahmid 1001910304

#include "Time.h"
#include <iomanip>

Time::Time(int hour, int minute, int second)
    : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

Time::Time()
    : _hour(0), _minute(0), _second(0) {}

Time Time::operator+(const Time& time) const {
    Time result = *this;
    result._hour += time._hour;
    result._minute += time._minute;
    result._second += time._second;
    result.rationalize();
    return result;
}

Time Time::operator+(int seconds) const {
    Time result = *this;
    result._second += seconds;
    result.rationalize();
    return result;
}

Time Time::operator++() {
    _second++;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp = *this;
    _second++;
    rationalize();
    return temp;
}

bool Time::operator==(const Time& time) const {
    return compare(time) == 0;
}

bool Time::operator!=(const Time& time) const {
    return compare(time) != 0;
}

bool Time::operator<(const Time& time) const {
    return compare(time) < 0;
}

bool Time::operator>(const Time& time) const {
    return compare(time) > 0;
}

bool Time::operator<=(const Time& time) const {
    return compare(time) <= 0;
}

bool Time::operator>=(const Time& time) const {
    return compare(time) >= 0;
}

std::ostream& operator<<(std::ostream& ost, const Time& time) {
    ost << std::setfill('0') << std::setw(2) << time._hour << ":"
        << std::setw(2) << time._minute << ":" << std::setw(2) << time._second;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time) {
    ist >> time._hour;
    ist.ignore(1); 
    ist >> time._minute;
    ist.ignore(1); 
    ist >> time._second;
    time.rationalize();
    return ist;
}

void Time::rationalize() {
    _minute += _second / 60;
    _second %= 60;
    _hour += _minute / 60;
    _minute %= 60;
    _hour %= 24;

    // Ensuring non-negative values for minute and second
    if (_minute < 0) {
        _minute += 60;
        _hour--;
    }
    if (_second < 0) {
        _second += 60;
        _minute--;
    }

    // Ensuring non-negative value for hour
    if (_hour < 0) {
        _hour += 24;
    }
}

int Time::compare(const Time& time) const {
    if (_hour != time._hour) {
        return _hour - time._hour;
    } else if (_minute != time._minute) {
        return _minute - time._minute;
    } else {
        return _second - time._second;
    }
}
