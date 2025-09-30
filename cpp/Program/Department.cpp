#include "Department.h"

Department::Department() {}

// Konstruktor
Department::Department(string did, string dname, string loc, string ph, string em) {
    id = did;
    name = dname;
    location = loc;
    phone = ph;
    email = em;
}

// Getter
string Department::getId() { 
    return id; 
}
string Department::getName() { 
    return name; 
}
string Department::getLocation() { 
    return location; 
}
string Department::getPhone() { 
    return phone; 
}
string Department::getEmail() { 
    return email; 
}

vector<Doctor*> Department::getDoctors() { 
    return doctors; 
}
vector<Nurse*> Department::getNurses() { 
    return nurses; 
}

// Setter
void Department::setId(string did) { 
    id = did; 
}
void Department::setName(string dname) { 
    name = dname; 
}
void Department::setLocation(string loc) { 
    location = loc; 
}
void Department::setPhone(string ph) { 
    phone = ph; 
}
void Department::setEmail(string em) { 
    email = em; 
}

void Department::addDoctor(Doctor* d) { 
    doctors.push_back(d); 
}
void Department::addNurse(Nurse* n) { 
    nurses.push_back(n); 
}