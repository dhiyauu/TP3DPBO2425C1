#pragma once
#include <string>
#include <vector>
#include "Patient.h"
#include "Doctor.h"
#include "Department.h"
using namespace std;

class Hospital {
private:
    string id;
    string name;
    string officialCode;
    string type;
    string accreditation;

    vector<Patient> patients;      
    vector<Doctor*> doctors;       // pointer agar polymorphism jalan
    vector<Department> departments;

public:
    Hospital();
    Hospital(string hid, string hname, string code, string htype, string accred);

    // Getter
    string getId();
    string getName();
    string getOfficialCode();
    string getType();
    string getAccreditation();

    vector<Patient> getPatients();
    vector<Doctor*> getDoctors();
    vector<Department> getDepartments();

    // Setter
    void setId(string hid);
    void setName(string hname);
    void setOfficialCode(string code);
    void setType(string htype);
    void setAccreditation(string accred);

    void addPatient(Patient p);
    void addDoctor(Doctor* d);
    void addDepartment(Department dep);
};