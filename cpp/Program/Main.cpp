#include <iostream>
#include <vector>
#include "Hospital.h"
#include "Department.h"
#include "Doctor.h"
#include "AcademicDoctor.h"
#include "Nurse.h"
#include "Patient.h"
#include "Schedule.h"
#include "Diagnose.h"
using namespace std;

int main() {
    // ================== INISIALISASI DATA RUMAH SAKIT ==================
    Hospital hospital("H001", "RS Harapan Bangsa", "RS-001", "Public", "A");

    // ---------- CETAK DATA AWAL (masih kosong) ----------
    cout << "\n========== DATA HOSPITAL (SEBELUM DITAMBAHKAN) ==========\n";
    cout << "- ID            : " << hospital.getId() << endl;
    cout << "- Name          : " << hospital.getName() << endl;
    cout << "- Code          : " << hospital.getOfficialCode() << endl;
    cout << "- Type          : " << hospital.getType() << endl;
    cout << "- Accreditation : " << hospital.getAccreditation() << endl;
    cout << "- Total Patients: " << hospital.getPatients().size() << endl;
    cout << "- Total Doctors : " << hospital.getDoctors().size() << endl;
    cout << "- Total Dept    : " << hospital.getDepartments().size() << endl;

    // ================== BUAT OBJEK & TAMBAHKAN DATA ==================
    Department dep_cardio("D01", "Kardiologi", "Lantai 2", "021-123", "cardio@rs.com");
    Department dep_neuro("D02", "Neurologi",  "Lantai 3", "021-456", "neuro@rs.com");

    Doctor doc1("DR01", "dr. Rama", "1980-05-10", "M", "0812-111", "LIC-123", "Kardiologi");
    AcademicDoctor doc2("DR02", "dr. Dina", "1978-07-20", "F", "0813-222", "LIC-999", "Neurologi",
                        "Stroke Research", "Associate Professor", {"Publikasi A", "Publikasi B"});

    hospital.addDoctor(&doc1);
    hospital.addDoctor(&doc2);

    Schedule s1("S1", 0, "08:00", "12:00");
    Schedule s2("S2", 2, "09:00", "13:00");
    Schedule s3("S3", 1, "10:00", "14:00");
    doc1.addSchedule(s1);
    doc1.addSchedule(s2);
    doc2.addSchedule(s3);

    Nurse nurse1("N01", "Suster Sari", "1990-02-14", "F", "0814-333", "STR-01", "Senior");
    Nurse nurse2("N02", "Suster Budi", "1992-04-22", "M", "0815-444", "STR-02", "Junior");

    Schedule sn1("SN1", 0, "07:00", "15:00");
    Schedule sn2("SN2", 1, "15:00", "22:00");
    nurse1.addSchedule(&sn1);
    nurse2.addSchedule(&sn2);

    dep_cardio.addDoctor(&doc1);
    dep_cardio.addNurse(&nurse1);
    dep_neuro.addDoctor(&doc2);
    dep_neuro.addNurse(&nurse2);

    hospital.addDepartment(dep_cardio);
    hospital.addDepartment(dep_neuro);

    Patient pat1("P01", "Andi", "1995-08-01", "M", "0816-555", "MRN-001", "O", "Sakit kepala");
    Patient pat2("P02", "Siti", "2000-12-12", "F", "0817-666", "MRN-002", "A", "Nyeri dada");

    Diagnose d1("DX1", "Hipertensi", "Tekanan darah tinggi");
    Diagnose d2("DX2", "Angina",     "Nyeri dada akibat sumbatan pembuluh darah");
    pat1.addDiagnose(d1);
    pat2.addDiagnose(d2);

    hospital.addPatient(pat1);
    hospital.addPatient(pat2);

    // ================== CETAK RINGKASAN HOSPITAL ==================
    cout << "\n========== DATA HOSPITAL (SESUDAH DITAMBAHKAN) ==========\n";
    cout << "- ID            : " << hospital.getId() << endl;
    cout << "- Name          : " << hospital.getName() << endl;
    cout << "- Code          : " << hospital.getOfficialCode() << endl;
    cout << "- Type          : " << hospital.getType() << endl;
    cout << "- Accreditation : " << hospital.getAccreditation() << endl;
    cout << "- Total Patients: " << hospital.getPatients().size() << endl;
    cout << "- Total Doctors : " << hospital.getDoctors().size() << endl;
    cout << "- Total Dept    : " << hospital.getDepartments().size() << endl;

    // ================== CETAK DEPARTEMEN + ANGGOTA ==================
    cout << "\n========== DEPARTMENTS ==========\n";
    for (int i = 0; i < hospital.getDepartments().size(); i++) {
        Department dep = hospital.getDepartments()[i]; // by value (copy). Oke untuk display.
        cout << "* " << dep.getId() << " - " << dep.getName() << endl;
        cout << "   Location : " << dep.getLocation() << endl;
        cout << "   Phone    : " << dep.getPhone() << endl;
        cout << "   Email    : " << dep.getEmail() << endl;

        cout << "   Doctors:" << endl;
        for (int j = 0; j < dep.getDoctors().size(); j++) {
            Doctor* dptr = dep.getDoctors()[j]; // pointer -> polymorphism ready
            cout << "      - " << dptr->getName() << endl;
        }

        cout << "   Nurses:" << endl;
        for (int k = 0; k < dep.getNurses().size(); k++) {
            Nurse* nptr = dep.getNurses()[k];
            cout << "      - " << nptr->getName() << endl;
        }
    }

    // ================== CETAK DOKTER (TERMASUK INFO AKADEMIK) ==================
    cout << "\n========== DOCTORS ==========\n";
    for (int i = 0; i < hospital.getDoctors().size(); i++) {
        Doctor* d = hospital.getDoctors()[i]; // base pointer
        cout << "* " << d->getId() << " - " << d->getName() << endl;
        cout << "   License No    : " << d->getLicenseNo() << endl;
        cout << "   Specialization: " << d->getSpecialization() << endl;

        // Tampilkan jadwal (komposisi di sisi Doctor)
        cout << "   Schedules:" << endl;
        vector<Schedule> ss = d->getSchedules(); // diasumsikan Doctor menyimpan by value
        for (int s = 0; s < ss.size(); s++) {
            cout << "      - " << ss[s].getId() << " " << ss[s].getStartTime()
                 << "-" << ss[s].getEndTime() << endl;
        }

        // Polymorphism check:
        // Jika objek aslinya AcademicDoctor, dynamic_cast akan sukses.
        AcademicDoctor* ad = dynamic_cast<AcademicDoctor*>(d);
        if (ad) {
            cout << "   Research Area : " << ad->getResearchArea() << endl;
            cout << "   Academic Rank : " << ad->getAcademicRank() << endl;
            cout << "   Publications  : ";
            vector<string> pubs = ad->getPublications();
            for (int p = 0; p < pubs.size(); p++) {
                cout << pubs[p];
                if (p + 1 < pubs.size()) cout << "; ";
            }
            cout << endl;
        }
    }

    // ================== CETAK NURSE + JADWAL (ASOSIASI) ==================
    cout << "\n========== NURSES ==========\n";
    // Di sini kita buat list sementara. Alternatif: simpan nurse di Hospital juga bila perlu.
    vector<Nurse*> nursesTemp;
    nursesTemp.push_back(&nurse1);
    nursesTemp.push_back(&nurse2);

    for (int i = 0; i < nursesTemp.size(); i++) {
        Nurse* n = nursesTemp[i];
        cout << "* " << n->getId() << " - " << n->getName() << endl;
        cout << "   RegNo : " << n->getRegistrationNo() << endl;
        cout << "   Level : " << n->getLevel() << endl;
        cout << "   Schedules:" << endl;

        // Catatan: getSchedules() untuk Nurse mengembalikan vector<Schedule*>,
        // menegaskan hubungan ASOSIASI (bukan komposisi).
        vector<Schedule*> ns = n->getSchedules();
        for (int s = 0; s < ns.size(); s++) {
            cout << "      - " << ns[s]->getId() << " "
                 << ns[s]->getStartTime() << "-" << ns[s]->getEndTime() << endl;
        }
    }

    // ================== CETAK PATIENT + DIAGNOSIS (KOMPOSISI) ==================
    cout << "\n========== PATIENTS ==========\n";
    for (int i = 0; i < hospital.getPatients().size(); i++) {
        Patient p = hospital.getPatients()[i]; // by value untuk display
        cout << "* " << p.getId() << " - " << p.getName() << endl;
        cout << "   MRN      : " << p.getMedicalRecordNumber() << endl;
        cout << "   BloodType: " << p.getBloodType() << endl;
        cout << "   Complaint: " << p.getComplaint() << endl;
        cout << "   Diagnoses:" << endl;

        // Komposisi: Patient menyimpan vector<Diagnose> by value
        vector<Diagnose> dxx = p.getDiagnoses();
        for (int x = 0; x < dxx.size(); x++) {
            cout << "      - " << dxx[x].getCode() << " " << dxx[x].getName()
                 << " (" << dxx[x].getDescription() << ")" << endl;
        }
    }

    return 0;
}