#include "AcademicDoctor.h"
#include <algorithm>

// ===== Constructor Default =====
AcademicDoctor::AcademicDoctor() {}

// ===== Constructor dengan Parameter =====
AcademicDoctor::AcademicDoctor(string pid, string pname, string dob, string g, string c,
                               string lic, string spec,
                               string rArea, string aRank, vector<string> pubs)
    : Doctor(pid, pname, dob, g, c, lic, spec),
      researchArea(rArea),
      academicRank(aRank),
      publications(pubs) {}

// Getter
string AcademicDoctor::getResearchArea() { 
    return researchArea; 
}
string AcademicDoctor::getAcademicRank() { 
    return academicRank; 
}
vector<string> AcademicDoctor::getPublications() { 
    return publications; 
}

// Setter
void AcademicDoctor::setResearchArea(string rArea) { 
    researchArea = rArea; 
}
void AcademicDoctor::setAcademicRank(string aRank) { 
    academicRank = aRank; 
}
void AcademicDoctor::setPublications(vector<string> pubs) { 
    publications = pubs; 
}

// Menambahan publikasi
void AcademicDoctor::addPublication(string pub) { 
    publications.push_back(pub); 
}
//Menghapus publikasi
void AcademicDoctor::removePublication(string pub) {
    publications.erase(remove(publications.begin(), publications.end(), pub), publications.end());
}