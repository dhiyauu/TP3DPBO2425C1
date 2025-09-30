import java.util.ArrayList;
import java.util.List;

// ===== Class Department =====
// Merepresentasikan sebuah departemen dalam rumah sakit.
// Memiliki asosiasi dengan Doctor dan Nurse (Many-to-Many).
public class Department {
    // ===== Attribute =====
    private String id;       // ID unik untuk departemen
    private String name;     // Nama departemen
    private String location; // Lokasi departemen (misalnya lantai)
    private String phone;    // Nomor telepon departemen
    private String email;    // Email resmi departemen

    // List dokter dan perawat yang terhubung dengan departemen ini
    private List<Doctor> doctors;
    private List<Nurse> nurses;

    // ===== Constructor =====
    // Konstruktor lengkap
    public Department(String id, String name, String location, String phone, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.doctors = new ArrayList<>(); // inisialisasi list kosong
        this.nurses = new ArrayList<>();
    }

    // Konstruktor overload (tanpa phone & email)
    public Department(String id, String name, String location) {
        this(id, name, location, "", "");
    }

    // ===== Getter =====
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Mengembalikan salinan list agar tidak bisa diubah langsung dari luar
    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Nurse> getNurses() {
        return new ArrayList<>(nurses);
    }

    // ===== Setter =====
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ===== Asosiasi dengan Doctor =====
    // Menambahkan dokter ke departemen ini
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
        if (doctor != null) {
            // Sinkronisasi dua arah -> dokter juga tahu bahwa dia bagian dari departemen ini
            doctor.linkDepartment(this);
        }
    }

    // Menghapus dokter dari departemen
    public void removeDoctor(Doctor doctor) {
        if (doctors.contains(doctor)) {
            doctors.remove(doctor);
        }
        if (doctor != null) {
            doctor.unlinkDepartment(this);
        }
    }

    // ===== Asosiasi dengan Nurse =====
    // Menambahkan perawat ke departemen ini
    public void addNurse(Nurse nurse) {
        if (!nurses.contains(nurse)) {
            nurses.add(nurse);
        }
        if (nurse != null) {
            // Sinkronisasi dua arah -> perawat juga tahu bahwa dia bagian dari departemen ini
            nurse.linkDepartment(this);
        }
    }

    // Menghapus perawat dari departemen
    public void removeNurse(Nurse nurse) {
        if (nurses.contains(nurse)) {
            nurses.remove(nurse);
        }
        if (nurse != null) {
            nurse.unlinkDepartment(this);
        }
    }

    // ===== toString =====
    // Mengembalikan representasi string ringkas dari objek Department
    @Override
    public String toString() {
        return "Department[ID=" + id + ", Name=" + name +
               ", Doctors=" + doctors.size() +   // jumlah dokter
               ", Nurses=" + nurses.size() + "]"; // jumlah perawat
    }
}