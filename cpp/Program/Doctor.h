#pragma once
#include <string>
#include <vector>
#include "Person.h"
#include "Schedule.h"
using namespace std;

class Doctor : public Person {
private:
    string licenseNo;
    string specialization;
    vector<Schedule> schedules;

public:
    // Constructor default
    Doctor();

    // Constructor dengan parameter (termasuk Person)
    Doctor(string pid, string pname, string dob, string g, string c,
           string lic, string spec);

    // Getter
    string getLicenseNo();
    string getSpecialization();

    // Setter
    void setLicenseNo(string lic);
    void setSpecialization(string spec);

    void addSchedule(Schedule s);
    vector<Schedule> getSchedules();

    virtual ~Doctor() {}
};