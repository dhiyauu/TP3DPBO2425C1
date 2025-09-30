#include "Doctor.h"

Doctor::Doctor() {}

// Konstruktor
Doctor::Doctor(string pid, string pname, string dob, string g, string c,
               string lic, string spec)
    : Person(pid, pname, dob, g, c) {
    licenseNo = lic;
    specialization = spec;
}

// Getter
string Doctor::getLicenseNo() { 
    return licenseNo; 
}
string Doctor::getSpecialization() { 
    return specialization; 
}

// Setter
void Doctor::setLicenseNo(string lic) { 
    licenseNo = lic; 
}
void Doctor::setSpecialization(string spec) { 
    specialization = spec; 
}

void Doctor::addSchedule(Schedule s) { 
    schedules.push_back(s); 
}
vector<Schedule> Doctor::getSchedules() {
    return schedules; 
}