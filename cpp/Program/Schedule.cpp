#include "Schedule.h"

// Constructor default
Schedule::Schedule() {
    dayOfWeek = 0;
    startTime = "00:00";
    endTime = "00:00";
}

// Constructor dengan parameter
Schedule::Schedule(string sid, int dow, string start, string end) {
    id = sid;
    dayOfWeek = dow;
    startTime = start;
    endTime = end;
}

// Getter
string Schedule::getId() {
    return id;
}
int Schedule::getDayOfWeek() { 
    return dayOfWeek;
}
string Schedule::getStartTime() {
    return startTime;
}
string Schedule::getEndTime() {
    return endTime;
}

// Setter
void Schedule::setId(string sid) {
    id = sid;
}
void Schedule::setDayOfWeek(int dow) {
    dayOfWeek = dow;
}
void Schedule::setStartTime(string start) {
    startTime = start;
}
void Schedule::setEndTime(string end) {
    endTime = end;
}