import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Kelas AcademicDoctor adalah turunan dari Doctor (multilevel inheritance).
public class AcademicDoctor extends Doctor {
    private String researchArea;
    private String academicRank;
    private List<String> publications;

    // Konstruktor utama
    public AcademicDoctor(
        String id,
        String name,
        LocalDate dateOfBirth,
        String gender,
        String contact,
        String licenseNo,
        String specialization,
        String researchArea, // Bidang penelitian
        String academicRank, // Jabatan akademik
        List<String> publications // Daftar publikasi
    ) {
        super(id, name, dateOfBirth, gender, contact, licenseNo, specialization);
        this.researchArea = researchArea;
        this.academicRank = academicRank;
        this.publications = (publications != null) ? new ArrayList<>(publications) : new ArrayList<>();
    }

    // Overloaded constructor tanpa publications
    public AcademicDoctor(
        String id,
        String name,
        LocalDate dateOfBirth,
        String gender,
        String contact,
        String licenseNo,
        String specialization,
        String researchArea,
        String academicRank
    ) {
        this(id, name, dateOfBirth, gender, contact, licenseNo, specialization, researchArea, academicRank, null);
    }

    // ===== Getter =====
    public String getResearchArea() {
        return researchArea;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    // Mengembalikan salinan daftar publikasi
    public List<String> getPublications() {
        return new ArrayList<>(publications);
    }

    // ===== Setter =====
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public void setAcademicRank(String rank) {
        this.academicRank = rank;
    }

    // ===== Mutator untuk publications =====
    // Menambahkan publikasi baru ke daftar
    public void addPublication(String title) {
        publications.add(title);
    }

    // Menghapus publikasi dari daftar
    public void removePublication(String title) {
        publications.remove(title);
    }

    @Override
    public String toString() {
         // dipakai objek mencetak data
        return "AcademicDoctor[ID=" + getId() +
               ", Name=" + getName() +
               ", Spec=" + getSpecialization() +
               ", Rank=" + academicRank +
               ", Research=" + researchArea +
               ", Pubs=" + publications.size() + "]";
    }
}