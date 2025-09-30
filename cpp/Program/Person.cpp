#include "Person.h"

// Constructor default
Person::Person() {}

// Constructor dengan parameter
Person::Person(string pid, string pname, string dob, string g, string c) {
    id = pid;
    name = pname;
    dateOfBirth = dob;
    gender = g;
    contact = c;
}

// Getter
string Person::getId() { 
    return id; 
}
string Person::getName() { 
    return name; 
}
string Person::getDateOfBirth() { 
    return dateOfBirth; 
}
string Person::getGender() { 
    return gender;
}
string Person::getContact() { 
    return contact; 
}

// Setter
void Person::setId(string pid) { 
    id = pid; 
}
void Person::setName(string pname) { 
    name = pname; 
}
void Person::setDateOfBirth(string dob) { 
    dateOfBirth = dob; 
}
void Person::setGender(string g) { 
    gender = g; 
}
void Person::setContact(string c) { 
    contact = c; 
}