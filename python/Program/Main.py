from datetime import date

from Hospital import Hospital
from Department import Department
from Doctor import Doctor
from AcademicDoctor import AcademicDoctor
from Nurse import Nurse
from Patient import Patient
from Schedule import Schedule

def main():
    # Data Lengkap Rumah Sakit
    hospital = Hospital("H001", "RS Harapan Bangsa", "RS-001", "Public", "A")

    # ---------- CETAK DATA AWAL ----------
    print("\n========== DATA HOSPITAL (SEBELUM DITAMBAHKAN) ==========")
    print(f"- ID            : {hospital.get_id()}")
    print(f"- Name          : {hospital.get_name()}")
    print(f"- Code          : {hospital.get_official_code()}")
    print(f"- Type          : {hospital.get_type()}")
    print(f"- Accreditation : {hospital.get_accreditation()}")
    print(f"- Total Patients: {len(hospital.get_patients())}")
    print(f"- Total Doctors : {len(hospital.get_doctors())}")
    print(f"- Total Dept    : {len(hospital.get_departments())}")

    # ---------- TAMBAH DATA ----------
    dep_cardio = Department("D01", "Kardiologi", "Lantai 2", "021-123", "cardio@rs.com")
    dep_neuro = Department("D02", "Neurologi", "Lantai 3", "021-456", "neuro@rs.com")
    hospital.add_department(dep_cardio)
    hospital.add_department(dep_neuro)

    doc1 = Doctor("DR01", "dr. Rama", date(1980, 5, 10), "M", "0812-111", "LIC-123", "Kardiologi")
    doc2 = AcademicDoctor(
        "DR02", "dr. Dina", date(1978, 7, 20), "F", "0813-222", "LIC-999", "Neurologi",
        "Stroke Research", "Associate Professor", ["Publikasi A", "Publikasi B"]
    )
    hospital.add_doctor(doc1)
    hospital.add_doctor(doc2)
    doc1.create_schedule("S1", 0, "08:00", "12:00")
    doc1.create_schedule("S2", 2, "09:00", "13:00")
    doc2.create_schedule("S3", 1, "10:00", "14:00")
    doc1.link_department(dep_cardio)
    doc2.link_department(dep_neuro)

    nurse1 = Nurse("N01", "Suster Sari", date(1990, 2, 14), "F", "0814-333", "STR-01", "Senior")
    nurse2 = Nurse("N02", "Suster Budi", date(1992, 4, 22), "M", "0815-444", "STR-02", "Junior")
    nurse1.link_department(dep_cardio)
    nurse2.link_department(dep_neuro)
    nurse1.assign_schedule(Schedule("SN1", 0, "07:00", "15:00"))
    nurse2.assign_schedule(Schedule("SN2", 1, "15:00", "22:00"))

    pat1 = Patient("P01", "Andi", date(1995, 8, 1), "M", "0816-555", "MRN-001", "O", "Sakit kepala")
    pat2 = Patient("P02", "Siti", date(2000, 12, 12), "F", "0817-666", "MRN-002", "A", "Nyeri dada")
    hospital.add_patient(pat1)
    hospital.add_patient(pat2)
    pat1.add_diagnose("DX1", "Hipertensi", "Tekanan darah tinggi")
    pat2.add_diagnose("DX2", "Angina", "Nyeri dada akibat sumbatan pembuluh darah")

    # ---------- CETAK DATA SESUDAH ----------
    print("\n========== DATA HOSPITAL (SESUDAH DITAMBAHKAN) ==========")
    print(f"- ID            : {hospital.get_id()}")
    print(f"- Name          : {hospital.get_name()}")
    print(f"- Code          : {hospital.get_official_code()}")
    print(f"- Type          : {hospital.get_type()}")
    print(f"- Accreditation : {hospital.get_accreditation()}")
    print(f"- Total Patients: {len(hospital.get_patients())}")
    print(f"- Total Doctors : {len(hospital.get_doctors())}")
    print(f"- Total Dept    : {len(hospital.get_departments())}")

    print("\n========== DEPARTMENTS ==========")
    for dep in hospital.get_departments():
        print(f"* {dep.get_id()} - {dep.get_name()}")
        print(f"   Location : {dep.get_location()}")
        print(f"   Phone    : {dep.get_phone()}")
        print(f"   Email    : {dep.get_email()}")
        print(f"   Doctors  : {[d.get_name() for d in dep.get_doctors()]}")
        print(f"   Nurses   : {[n.get_name() for n in dep.get_nurses()]}")

    print("\n========== DOCTORS ==========")
    for d in hospital.get_doctors():
        print(f"* {d.get_id()} - {d.get_name()}")
        print(f"   License No    : {d.get_license_no()}")
        print(f"   Specialization: {d.get_specialization()}")
        if isinstance(d, AcademicDoctor):
            print(f"   Research Area : {d.get_research_area()}")
            print(f"   Academic Rank : {d.get_academic_rank()}")
            print(f"   Publications  : {d.get_publications()}")
        print("   Schedules:")
        for sch in d.get_schedules():
            print(f"      - {sch}")
        print("   Departments:")
        for dept in d.get_departments():
            print(f"      - {dept.get_name()}")

    print("\n========== NURSES ==========")
    for n in [nurse1, nurse2]:
        print(f"* {n.get_id()} - {n.get_name()}")
        print(f"   RegNo : {n.get_registration_no()}")
        print(f"   Level : {n.get_level()}")
        print("   Schedules:")
        for sch in n.get_schedules():
            print(f"      - {sch}")
        print("   Departments:")
        for dept in n.get_departments():
            print(f"      - {dept.get_name()}")

    print("\n========== PATIENTS ==========")
    for p in hospital.get_patients():
        print(f"* {p.get_id()} - {p.get_name()}")
        print(f"   MRN      : {p.get_medical_record_number()}")
        print(f"   BloodType: {p.get_blood_type()}")
        print(f"   Complaint: {p.get_complaint()}")
        print("   Diagnoses:")
        for dx in p.get_diagnoses():
            print(f"      - {dx}")


if __name__ == "__main__":
    main()