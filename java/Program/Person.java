//Saya Dhiya Ulhaq dengan NIM 2407716 mengerjakan Tugas Praktikum 3 dalam mata kuliah desain & pemrograman berorientasi objek untuk keberkahan-Nya maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan//

import java.time.LocalDate;

// Base class
public class Person {
    private final String id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String contact;

    // Constructor
    public Person(String id, String name, LocalDate dateOfBirth, String gender, String contact) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contact = contact;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person[ID=" + id 
                + ", Name=" + name 
                + ", DOB=" + dateOfBirth 
                + ", Gender=" + gender 
                + ", Contact=" + contact + "]";
    }
}