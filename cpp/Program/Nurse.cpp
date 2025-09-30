#include "Nurse.h"

Nurse::Nurse() {}

// Konstruktor
Nurse::Nurse(string pid, string pname, string dob, string g, string c,
             string regNo, string lvl)
    : Person(pid, pname, dob, g, c) {
    registrationNo = regNo;
    level = lvl;
}

// Getter
string Nurse::getRegistrationNo() {
    return registrationNo;
}
string Nurse::getLevel() {
    return level;
}

// Setter
void Nurse::setRegistrationNo(string regNo) {
    registrationNo = regNo;
}
void Nurse::setLevel(string lvl) {
    level = lvl;
}

void Nurse::addSchedule(Schedule* s) {
    schedules.push_back(s);
}
vector<Schedule*> Nurse::getSchedules() {
    return schedules;
}