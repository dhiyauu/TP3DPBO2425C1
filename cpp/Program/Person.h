//Saya Dhiya Ulhaq dengan NIM 2407716 mengerjakan Tugas Praktikum 3 dalam mata kuliah desain & pemrograman berorientasi objek untuk keberkahan-Nya maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan//

#pragma once
#include <string>
using namespace std;

// Konstruktor
class Person {
private:
    string id;
    string name;
    string dateOfBirth;
    string gender;
    string contact;

public:
    Person();
    Person(string pid, string pname, string dob, string g, string c);

    // Getter
    string getId();
    string getName();
    string getDateOfBirth();
    string getGender();
    string getContact();

    // Setter
    void setId(string pid);
    void setName(string pname);
    void setDateOfBirth(string dob);
    void setGender(string g);
    void setContact(string c);
};