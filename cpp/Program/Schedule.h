#pragma once
#include <string>
using namespace std;

class Schedule {
private:
    string id;
    int dayOfWeek;    
    string startTime; 
    string endTime;   

public:
    // Constructor
    Schedule();
    Schedule(string sid, int dow, string start, string end);

    // Getter
    string getId();
    int getDayOfWeek();
    string getStartTime();
    string getEndTime();

    // Setter
    void setId(string sid);
    void setDayOfWeek(int dow);
    void setStartTime(string start);
    void setEndTime(string end);
};