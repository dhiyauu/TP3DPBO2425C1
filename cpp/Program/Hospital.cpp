#include "Hospital.h"

Hospital::Hospital() {}

// Konstruktor
Hospital::Hospital(string hid, string hname, string code, string htype, string accred) {
    id = hid;
    name = hname;
    officialCode = code;
    type = htype;
    accreditation = accred;
}

// Getter
string Hospital::getId() { 
    return id; 
}
string Hospital::getName() { 
    return name; 
}
string Hospital::getOfficialCode() { 
    return officialCode; 
}
string Hospital::getType() { 
    return type; 
}
string Hospital::getAccreditation() { 
    return accreditation; 
}

// Setter
vector<Patient> Hospital::getPatients() { 
    return patients; 
}
vector<Doctor*> Hospital::getDoctors() { 
    return doctors; 
}
vector<Department> Hospital::getDepartments() { 
    return departments;
}

void Hospital::setId(string hid) {
    id = hid;
}
void Hospital::setName(string hname) {
    name = hname;
}
void Hospital::setOfficialCode(string code) {
    officialCode = code;
}
void Hospital::setType(string htype) {
    type = htype;
}
void Hospital::setAccreditation(string accred) {
    accreditation = accred; 
}

void Hospital::addPatient(Patient p) { 
    patients.push_back(p); 
}
void Hospital::addDoctor(Doctor* d) { 
    doctors.push_back(d); 
}
void Hospital::addDepartment(Department dep) { 
    departments.push_back(dep); 
}