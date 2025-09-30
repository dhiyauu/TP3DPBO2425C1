#include "Diagnose.h"

// Constructor default
Diagnose::Diagnose() {}

// Constructor dengan parameter
Diagnose::Diagnose(string c, string n, string desc) {
    code = c;
    name = n;
    description = desc;
}

// Getter
string Diagnose::getCode() { 
    return code; 
}
string Diagnose::getName() { 
    return name; 
}
string Diagnose::getDescription() { 
    return description; 
}

// Setter
void Diagnose::setCode(string c) { 
    code = c; 
}
void Diagnose::setName(string n) { 
    name = n; 
}
void Diagnose::setDescription(string desc) { 
    description = desc; 
}