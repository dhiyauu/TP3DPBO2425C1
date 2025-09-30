#pragma once
#include <string>
#include <vector>
#include "Doctor.h"
#include "Nurse.h"
using namespace std;

// Konstruktor
class Department {
private:
    string id;
    string name;
    string location;
    string phone;
    string email;

    vector<Doctor*> doctors;   // pakai pointer
    vector<Nurse*> nurses;     // pakai pointer

public:
    Department();
    Department(string did, string dname, string loc, string ph, string em);

    // Getter
    string getId();
    string getName();
    string getLocation();
    string getPhone();
    string getEmail();

    // Menyimpan pointer ke objek
    vector<Doctor*> getDoctors();
    vector<Nurse*> getNurses();

    // Setter
    void setId(string did);
    void setName(string dname);
    void setLocation(string loc);
    void setPhone(string ph);
    void setEmail(string em);

    void addDoctor(Doctor* d);
    void addNurse(Nurse* n);
};