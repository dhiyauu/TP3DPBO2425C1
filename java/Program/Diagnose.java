// ===== Class Diagnose =====
// Merepresentasikan data diagnosis medis yang dimiliki seorang pasien
public class Diagnose {
    // ===== Attribute =====
    private String code;        // Kode unik diagnosis
    private String name;        // Nama diagnosis
    private String description; // Deskripsi detail diagnosis

    // ===== Constructor =====
    // Konstruktor lengkap dengan code, name, dan description
    public Diagnose(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    // Overloaded Constructor
    // Jika deskripsi tidak diberikan, otomatis kosong ("")
    public Diagnose(String code, String name) {
        this(code, name, "");
    }

    // ===== Getter =====
    // Mengambil nilai code diagnosis
    public String getCode() {
        return code;
    }

    // Mengambil nama diagnosis
    public String getName() {
        return name;
    }

    // Mengambil deskripsi diagnosis
    public String getDescription() {
        return description;
    }

    // ===== Setter =====
    // Mengubah nama diagnosis
    public void setName(String name) {
        this.name = name;
    }

    // Mengubah deskripsi diagnosis
    public void setDescription(String description) {
        this.description = description;
    }

    // Representasi objek dalam bentuk String yang mudah dibaca
    @Override
    public String toString() {
        return "Diagnose[Code=" + code + ", Name=" + name + ", Desc=" + description + "]";
    }
}