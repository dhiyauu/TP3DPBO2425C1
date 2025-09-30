#pragma once
#include <string>
#include <vector>
#include "Person.h"
#include "Schedule.h"
using namespace std;

// Konstruktor
class Nurse : public Person {
private:
    string registrationNo;
    string level;
    vector<Schedule*> schedules;   // tambahan

public:
    Nurse();
    Nurse(string pid, string pname, string dob, string g, string c,
          string regNo, string lvl);

    // Getter
    string getRegistrationNo();
    string getLevel();
    
    // Setter
    void setRegistrationNo(string regNo);
    void setLevel(string lvl);

    void addSchedule(Schedule* s);
    vector<Schedule*> getSchedules();
};