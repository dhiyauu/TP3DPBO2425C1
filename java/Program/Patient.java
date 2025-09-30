import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Patient mewarisi Person
public class Patient extends Person {
    private final String medicalRecordNumber;
    private String bloodType;
    private String complaint;
    private List<Diagnose> diagnoses;  // komposisi: Patient memiliki Diagnose

    // Constructor
    public Patient(String id, String name, LocalDate dateOfBirth, String gender, String contact,
                   String medicalRecordNumber, String bloodType, String complaint) {
        super(id, name, dateOfBirth, gender, contact);
        this.medicalRecordNumber = medicalRecordNumber;
        this.bloodType = bloodType;
        this.complaint = complaint;
        this.diagnoses = new ArrayList<>();
    }

    // Overloaded constructor kalau bloodType/complaint tidak diisi
    public Patient(String id, String name, LocalDate dateOfBirth, String gender, String contact,
                   String medicalRecordNumber) {
        this(id, name, dateOfBirth, gender, contact, medicalRecordNumber, null, "");
    }

    // Getter
    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getComplaint() {
        return complaint;
    }

    public List<Diagnose> getDiagnoses() {
        return new ArrayList<>(diagnoses); // return copy biar aman
    }

    // Setter
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    // Komposisi: menambah Diagnose
    public Diagnose addDiagnose(String code, String name, String description) {
        Diagnose dx = new Diagnose(code, name, description);
        this.diagnoses.add(dx);
        return dx;
    }

    public void removeDiagnose(String code) {
        diagnoses.removeIf(d -> d.getCode().equals(code));
    }

    @Override
    public String toString() {
        return "Patient[ID=" + getId()
                + ", Name=" + getName()
                + ", MRN=" + medicalRecordNumber
                + ", BloodType=" + bloodType
                + ", Complaint=" + complaint + "]";
    }
}