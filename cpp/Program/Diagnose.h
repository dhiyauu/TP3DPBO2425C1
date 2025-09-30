#pragma once
#include <string>
using namespace std;

class Diagnose {
private:
    string code;
    string name;
    string description;

public:
    // Constructor default
    Diagnose();

    // Constructor dengan parameter
    Diagnose(string c, string n, string desc);

    // Getter
    string getCode();
    string getName();
    string getDescription();

    // Setter
    void setCode(string c);
    void setName(string n);
    void setDescription(string desc);
};