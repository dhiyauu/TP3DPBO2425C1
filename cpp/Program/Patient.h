#pragma once
#include <string>
#include <vector>
#include "Person.h"
#include "Diagnose.h"
using namespace std;

// Konstruktor
class Patient : public Person {
private:
    string medicalRecordNumber;
    string bloodType;
    string complaint;
    vector<Diagnose> diagnoses;  // tambahan

public:
    Patient();
    Patient(string pid, string pname, string dob, string g, string c,
            string mrn, string bt, string comp);

    // Getter
    string getMedicalRecordNumber();
    string getBloodType();
    string getComplaint();

    // Setter
    void setMedicalRecordNumber(string mrn);
    void setBloodType(string bt);
    void setComplaint(string comp);

    void addDiagnose(Diagnose dx);
    vector<Diagnose> getDiagnoses();
};