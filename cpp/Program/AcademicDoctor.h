#pragma once
#include <string>
#include <vector>
#include "Doctor.h"
using namespace std;

class AcademicDoctor : public Doctor {
private:
    // ====== Data akademik tambahan ======
    string researchArea;
    string academicRank;
    vector<string> publications;

public:
    // ====== Konstruktor ======
    AcademicDoctor();
    AcademicDoctor(string pid, string pname, string dob, string g, string c,
                   string lic, string spec,
                   string rArea, string aRank, vector<string> pubs = {});

    // Getter
    string getResearchArea();
    string getAcademicRank();
    vector<string> getPublications();

    // Setter
    void setResearchArea(string rArea);
    void setAcademicRank(string aRank);
    void setPublications(vector<string> pubs);

    void addPublication(string pub);
    void removePublication(string pub);
};