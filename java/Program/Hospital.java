import java.util.ArrayList;
import java.util.List;

public class Hospital {
    // ===== Atribut utama =====
    private final String id;
    private String name;
    private String officialCode;
    private String type;
    private String accreditation;

    // Agregasi
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Department> departments;

    // Constructor
    public Hospital(String id, String name, String officialCode, String type, String accreditation) {
        this.id = id;
        this.name = name;
        this.officialCode = officialCode;
        this.type = type;
        this.accreditation = accreditation;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOfficialCode() {
        return officialCode;
    }

    public String getType() {
        return type;
    }

    public String getAccreditation() {
        return accreditation;
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setOfficialCode(String code) {
        this.officialCode = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    // Agregasi - Patient
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Agregasi - Doctor
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    // Agregasi - Department
    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    @Override
    public String toString() {
        return "Hospital[ID=" + id
                + ", Name=" + name
                + ", Code=" + officialCode
                + ", Type=" + type
                + ", Accreditation=" + accreditation
                + ", Patients=" + patients.size()
                + ", Doctors=" + doctors.size()
                + ", Departments=" + departments.size()
                + "]";
    }
}