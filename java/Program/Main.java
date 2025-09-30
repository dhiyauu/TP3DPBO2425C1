import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // ===== DATA HOSPITAL =====
        Hospital hospital = new Hospital("H001", "RS Harapan Bangsa", "RS-001", "Public", "A");

        // ---------- CETAK DATA AWAL ----------
        System.out.println("\n========== DATA HOSPITAL (SEBELUM DITAMBAHKAN) ==========");
        System.out.println("- ID            : " + hospital.getId());
        System.out.println("- Name          : " + hospital.getName());
        System.out.println("- Code          : " + hospital.getOfficialCode());
        System.out.println("- Type          : " + hospital.getType());
        System.out.println("- Accreditation : " + hospital.getAccreditation());
        System.out.println("- Total Patients: " + hospital.getPatients().size());
        System.out.println("- Total Doctors : " + hospital.getDoctors().size());
        System.out.println("- Total Dept    : " + hospital.getDepartments().size());

        // ===== TAMBAH DATA =====
        Department depCardio = new Department("D01", "Kardiologi", "Lantai 2", "021-123", "cardio@rs.com");
        Department depNeuro = new Department("D02", "Neurologi", "Lantai 3", "021-456", "neuro@rs.com");
        hospital.addDepartment(depCardio);
        hospital.addDepartment(depNeuro);

        Doctor doc1 = new Doctor("DR01", "dr. Rama", LocalDate.of(1980, 5, 10), "M",
                                 "0812-111", "LIC-123", "Kardiologi");

        AcademicDoctor doc2 = new AcademicDoctor(
                "DR02", "dr. Dina", LocalDate.of(1978, 7, 20), "F",
                "0813-222", "LIC-999", "Neurologi",
                "Stroke Research", "Associate Professor",
                Arrays.asList("Publikasi A", "Publikasi B")
        );

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);

        doc1.createSchedule("S1", 0, "08:00", "12:00");
        doc1.createSchedule("S2", 2, "09:00", "13:00");
        doc2.createSchedule("S3", 1, "10:00", "14:00");

        doc1.linkDepartment(depCardio);
        doc2.linkDepartment(depNeuro);

        Nurse nurse1 = new Nurse("N01", "Suster Sari", LocalDate.of(1990, 2, 14),
                                 "F", "0814-333", "STR-01", "Senior");
        Nurse nurse2 = new Nurse("N02", "Suster Budi", LocalDate.of(1992, 4, 22),
                                 "M", "0815-444", "STR-02", "Junior");

        nurse1.linkDepartment(depCardio);
        nurse2.linkDepartment(depNeuro);

        nurse1.assignSchedule(new Schedule("SN1", 0, "07:00", "15:00"));
        nurse2.assignSchedule(new Schedule("SN2", 1, "15:00", "22:00"));

        Patient pat1 = new Patient("P01", "Andi", LocalDate.of(1995, 8, 1),
                                   "M", "0816-555", "MRN-001", "O", "Sakit kepala");
        Patient pat2 = new Patient("P02", "Siti", LocalDate.of(2000, 12, 12),
                                   "F", "0817-666", "MRN-002", "A", "Nyeri dada");

        hospital.addPatient(pat1);
        hospital.addPatient(pat2);

        pat1.addDiagnose("DX1", "Hipertensi", "Tekanan darah tinggi");
        pat2.addDiagnose("DX2", "Angina", "Nyeri dada akibat sumbatan pembuluh darah");

        // ---------- CETAK DATA SESUDAH PENAMBAHAN ----------
        System.out.println("\n========== DATA HOSPITAL (SESUDAH DITAMBAHKAN) ==========");
        System.out.println("- ID            : " + hospital.getId());
        System.out.println("- Name          : " + hospital.getName());
        System.out.println("- Code          : " + hospital.getOfficialCode());
        System.out.println("- Type          : " + hospital.getType());
        System.out.println("- Accreditation : " + hospital.getAccreditation());
        System.out.println("- Total Patients: " + hospital.getPatients().size());
        System.out.println("- Total Doctors : " + hospital.getDoctors().size());
        System.out.println("- Total Dept    : " + hospital.getDepartments().size());

        // ===== CETAK DETAIL =====
        System.out.println("\n========== DEPARTMENTS ==========");
        for (Department dep : hospital.getDepartments()) {
            System.out.println("* " + dep.getId() + " - " + dep.getName());
            System.out.println("   Location : " + dep.getLocation());
            System.out.println("   Phone    : " + dep.getPhone());
            System.out.println("   Email    : " + dep.getEmail());
            System.out.print("   Doctors  : ");
            System.out.println(dep.getDoctors().stream().map(Doctor::getName).toList());
            System.out.print("   Nurses   : ");
            System.out.println(dep.getNurses().stream().map(Nurse::getName).toList());
        }

        System.out.println("\n========== DOCTORS ==========");
        for (Doctor d : hospital.getDoctors()) {
            System.out.println("* " + d.getId() + " - " + d.getName());
            System.out.println("   License No    : " + d.getLicenseNo());
            System.out.println("   Specialization: " + d.getSpecialization());

            if (d instanceof AcademicDoctor ad) {
                System.out.println("   Research Area : " + ad.getResearchArea());
                System.out.println("   Academic Rank : " + ad.getAcademicRank());
                System.out.println("   Publications  : " + ad.getPublications());
            }

            System.out.println("   Schedules:");
            for (Schedule sch : d.getSchedules()) {
                System.out.println("      - " + sch);
            }

            System.out.println("   Departments:");
            for (Department dept : d.getDepartments()) {
                System.out.println("      - " + dept.getName());
            }
        }

        System.out.println("\n========== NURSES ==========");
        for (Nurse n : Arrays.asList(nurse1, nurse2)) {
            System.out.println("* " + n.getId() + " - " + n.getName());
            System.out.println("   RegNo : " + n.getRegistrationNo());
            System.out.println("   Level : " + n.getLevel());
            System.out.println("   Schedules:");
            for (Schedule sch : n.getSchedules()) {
                System.out.println("      - " + sch);
            }
            System.out.println("   Departments:");
            for (Department dept : n.getDepartments()) {
                System.out.println("      - " + dept.getName());
            }
        }

        System.out.println("\n========== PATIENTS ==========");
        for (Patient p : hospital.getPatients()) {
            System.out.println("* " + p.getId() + " - " + p.getName());
            System.out.println("   MRN      : " + p.getMedicalRecordNumber());
            System.out.println("   BloodType: " + p.getBloodType());
            System.out.println("   Complaint: " + p.getComplaint());
            System.out.println("   Diagnoses:");
            for (Diagnose dx : p.getDiagnoses()) {
                System.out.println("      - " + dx);
            }
        }
    }
}