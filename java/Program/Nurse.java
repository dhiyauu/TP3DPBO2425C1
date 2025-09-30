import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Nurse mewarisi Person
public class Nurse extends Person {
    private String registrationNo;
    private String level;

    // Asosiasi: jadwal dan departemen disimpan sebagai referensi
    private final List<Schedule> schedules;
    private final List<Department> departments;

    // Constructor
    public Nurse(String id, String name, LocalDate dateOfBirth, String gender, String contact,
                 String registrationNo, String level) {
        super(id, name, dateOfBirth, gender, contact);
        this.registrationNo = registrationNo;
        this.level = level;
        this.schedules = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    // Getter
    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getLevel() {
        return level;
    }

    // Kembalikan salinan list agar aman dari modifikasi luar
    public List<Schedule> getSchedules() {
        return new ArrayList<>(schedules);
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    // Setter
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Asosiasi dengan Schedule
    public void assignSchedule(Schedule schedule) {
        if (schedule == null) return;
        if (!schedules.contains(schedule)) {
            schedules.add(schedule);
        }
    }

    public void removeSchedule(Schedule schedule) {
        if (schedule == null) return;
        schedules.remove(schedule);
    }

    // Asosiasi dengan Department (dua arah, jika sisi Department menyediakan API-nya)
    public void linkDepartment(Department dept) {
        if (dept == null) return;
        if (!departments.contains(dept)) {
            departments.add(dept);
        }
        // Coba sinkronkan sisi Department -> Nurse
        try {
            dept.addNurse(this);
        } catch (Throwable ignored) {
            // Abaikan bila Department belum punya method addNurse atau terjadi siklus panggilan
        }
    }

    public void unlinkDepartment(Department dept) {
        if (dept == null) return;
        departments.remove(dept);
        try {
            dept.removeNurse(this);
        } catch (Throwable ignored) {
            // Abaikan bila Department belum punya method removeNurse
        }
    }

    @Override
    public String toString() {
        return "Nurse[ID=" + getId()
                + ", Name=" + getName()
                + ", RegNo=" + registrationNo
                + ", Level=" + level + "]";
    }
}
