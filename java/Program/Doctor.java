import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Subclass dari Person
public class Doctor extends Person {
    private String licenseNo;
    private String specialization;
    private final List<Schedule> schedules;
    private final List<Department> departments;

    public Doctor(String id, String name, LocalDate dateOfBirth, String gender, String contact,
                  String licenseNo, String specialization) {
        super(id, name, dateOfBirth, gender, contact);
        this.licenseNo = licenseNo;
        this.specialization = specialization;
        this.schedules = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // ===== Getter =====
    public String getLicenseNo() { return licenseNo; }
    public String getSpecialization() { return specialization; }
    public List<Schedule> getSchedules() { return new ArrayList<>(schedules); }
    public List<Department> getDepartments() { return new ArrayList<>(departments); }

    // ===== Setter =====
    public void setLicenseNo(String licenseNo) { this.licenseNo = licenseNo; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    // ===== Komposisi Schedule =====
    public void addSchedule(Schedule schedule) {
        // Jika sudah ada schedule dengan ID yang sama, hentikan metode (tanpa break)
        for (Schedule s : schedules) {
            if (s.getId().equals(schedule.getId())) {
                return; // early-exit, tidak menambah duplikat
            }
        }
        schedules.add(schedule);
    }

    // Menghapus schedule berdasarkan ID
    public void removeScheduleById(String scheduleId) {
        schedules.removeIf(s -> s.getId().equals(scheduleId));
    }

    // Membuat dan langsung menambahkan schedule baru
    public Schedule createSchedule(String id, int dayOfWeek, String startTime, String endTime) {
        Schedule sch = new Schedule(id, dayOfWeek, startTime, endTime);
        addSchedule(sch);
        return sch;
    }

    // ===== Asosiasi Department (Many-to-Many) =====
    public void linkDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
        if (!department.getDoctors().contains(this)) {
            department.addDoctor(this);
        }
    }

    // Putuskan hubungan dokter dengan departemen
    public void unlinkDepartment(Department department) {
        departments.remove(department);
        if (department.getDoctors().contains(this)) {
            department.removeDoctor(this);
        }
    }

    @Override
    public String toString() {
        return "Doctor[ID=" + getId() + ", Name=" + getName() +
               ", License=" + licenseNo + ", Spec=" + specialization + "]";
    }
}