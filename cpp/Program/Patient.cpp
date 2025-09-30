#include "Patient.h"

Patient::Patient() {}

// Konstruktor
Patient::Patient(string pid, string pname, string dob, string g, string c,
                 string mrn, string bt, string comp)
    : Person(pid, pname, dob, g, c) {
    medicalRecordNumber = mrn;
    bloodType = bt;
    complaint = comp;
}

// Getter
string Patient::getMedicalRecordNumber() { 
    return medicalRecordNumber; 
}
string Patient::getBloodType() { 
    return bloodType; 
}
string Patient::getComplaint() { 
    return complaint; 
}

// Setter
void Patient::setMedicalRecordNumber(string mrn) {
    medicalRecordNumber = mrn; 
}
void Patient::setBloodType(string bt) { 
    bloodType = bt; 
}
void Patient::setComplaint(string comp) { 
    complaint = comp; 
}

void Patient::addDiagnose(Diagnose dx) { 
    diagnoses.push_back(dx); 
}
vector<Diagnose> Patient::getDiagnoses() { 
    return diagnoses; 
}