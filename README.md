# TP3DPBO2425C1
## Janji

Saya Dhiya Ulhaq dengan NIM 2407716 Mengerjakan Tugas Praktikum 3 (Inheritance Lanjutan) dalam Mata Kuliah Desain Pemrograman Berorientasi Objek untuk Keberkahan-Nya Maka Saya Tidak Akan Melakukan Kecurangan Seperti Yang Telah di Spesifikasikan. Aamiin.

## Desain Diagram


## Penjelasan Atribut dan Methods
Pada sembilan kelas terdapat beberapa atribut dan methods untuk menyimpan informasi yang membedakan satu objek dengan objek lain, diantaranya:

### `Person`
1. id: str – identitas unik orang.
2. name: str – nama lengkap.
3. date_of_birth: date – tanggal lahir.
4. gender: str – jenis kelamin.
5. contact: str – info kontak (telepon/email).

**Konstruktor Default**
```cpp
Person::Person() {}
```
Membuat objek `Person`.

**Konstruktor parameter**
```cpp
Person::Person(string pid, string pname, string dob, string g, string c) {
    id = pid;
    name = pname;
    dateOfBirth = dob;
    gender = g;
    contact = c;
}
```
Membuat objek `Person` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: `get_id()`, `get_name()`, `get_date_of_birth()`, `get_gender()`, `get_contact()`.
- Setter: `set_name(name)`, `set_date_of_birth(dob)`, `set_gender(gender)`, `set_contact(contact)`.

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

### Patient
1. medical_record_number: str – nomor rekam medis (unik di RS).
2. blood_type: Optional[str] – golongan darah (bisa kosong).
3. complaint: str – keluhan utama.
4. diagnoses: List[Diagnose] – daftar diagnosis milik pasien. Komposisi (riwayat menempel ke pasien).

**Konstruktor Default**
```cpp
Patient::Patient() {}
```
Membuat objek `Patient`.

**Konstruktor parameter**
```cpp
Patient::Patient(string pid, string pname, string dob, string g, string c,
                 string mrn, string bt, string comp)
    : Person(pid, pname, dob, g, c) {
    medicalRecordNumber = mrn;
    bloodType = bt;
    complaint = comp;
}
```
Membuat objek `Patient` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_medical_record_number(), get_blood_type(), get_complaint(), get_diagnoses() (salinan list).
- Setter: set_blood_type(blood_type), set_complaint(complaint).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

**Komposisi**
- add_diagnose(code, name, description="") -> Diagnose – membuat & menambahkan Diagnose baru.
- remove_diagnose(code) – hapus diagnosa berdasarkan kode.

### Doctor
1. license_no: str – nomor izin praktik.
2. specialization: str – spesialisasi (Kardiologi, dll).
3. schedules: List[Schedule] – jadwal praktik milik dokter. Komposisi (dibuat/di-manage Doctor).
4. departments: List[Department] – departemen tempat dokter bergabung. Asosiasi many-to-many.

**Konstruktor Default**
```cpp
Doctor::Doctor() {}
```
Membuat objek `Doctor`.

**Konstruktor parameter**
```cpp
Doctor::Doctor(string pid, string pname, string dob, string g, string c,
               string lic, string spec)
    : Person(pid, pname, dob, g, c) {
    licenseNo = lic;
    specialization = spec;
}
```
Membuat objek `Doctor` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_license_no(), get_specialization(), get_schedules(), get_departments().
- Setter: set_license_no(license_no), set_specialization(specialization).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

**Komposisi**
- add_schedule(schedule) – tambah jadwal (hindari duplikat id).
- remove_schedule_by_id(schedule_id) – hapus jadwal via id.
- create_schedule(id, day_of_week, start_time, end_time) -> Schedule – buat & simpan jadwal baru.

**Asosiasi Department (M:N)**
- link_department(department) – kaitkan ke departemen.
- unlink_department(department) – lepas asosiasi.

### AcademicDoctor
1. research_area: str – bidang riset.
2. academic_rank: str – jabatan akademik (Lecturer/Assoc. Prof./Prof.).
3. publications: List[str] – judul publikasi (daftar string).

**Konstruktor Default**
```cpp
AcademicDoctor::AcademicDoctor() {}
```
Membuat objek `AcademicDoctor`.

**Konstruktor parameter**
```cpp
AcademicDoctor::AcademicDoctor(string pid, string pname, string dob, string g, string c,
                               string lic, string spec,
                               string rArea, string aRank, vector<string> pubs)
    : Doctor(pid, pname, dob, g, c, lic, spec),
      researchArea(rArea),
      academicRank(aRank),
      publications(pubs) {}
```
Membuat objek `AcademicDoctor` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_research_area(), get_academic_rank(), get_publications().
- Setter: set_research_area(research_area), set_academic_rank(rank).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

Mutator publikasi
- add_publication = menambah publikasi
- remove_publication = menghapus publikasi

### Nurse
1. registration_no: str – nomor registrasi perawat.
2. level: str – level (Junior/Senior).
3. schedules: List[Schedule] – asosiasi jadwal (bukan komposisi; Nurse tidak “memiliki” jadwal).
4. departments: List[Department] – asosiasi departemen (M:N mirip dokter).

**Konstruktor Default**
```cpp
Nurse::Nurse() {}
```
Membuat objek `Nurse`.

**Konstruktor parameter**
```cpp
Nurse::Nurse(string pid, string pname, string dob, string g, string c,
             string regNo, string lvl)
    : Person(pid, pname, dob, g, c) {
    registrationNo = regNo;
    level = lvl;
}
```
Membuat objek `Nurse` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_registration_no(), get_level(), get_schedules(), get_departments().
- Setter: set_registration_no(reg_no), set_level(level).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

**Asosiasi Schedule**
assign_schedule(schedule) = dipakai untuk menghubungkan sebuah jadwal ke perawat.
remove_schedule(schedule) = dipakai untuk melepaskan hubungan jadwal dari perawat

**Asosiasi Department** 
link_department(dept) = menghubungkan perawat atau dokter dengan sebuah departemen
unlink_department(dept) = memutuskan hubungan dengan departemen

### Department
1. id: str – id departemen.
2. name: str – nama.
3. location: str – lokasi/ruangan/lantai.
4. phone: str, email: str – kontak.
5. doctors: List[Doctor] – daftar dokter terkait (asosiasi M:N).
6. nurses: List[Nurse] – daftar perawat terkait (asosiasi M:N).

**Konstruktor Default**
```cpp
Department::Department() {}
```
Membuat objek `Department`.

**Konstruktor parameter**
```cpp
Department::Department(string did, string dname, string loc, string ph, string em) {
    id = did;
    name = dname;
    location = loc;
    phone = ph;
    email = em;
}
```
Membuat objek `Department` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_id(), get_name(), get_location(), get_phone(), get_email(), get_doctors(), get_nurses().
- Setter: set_name(name), set_location(location), set_phone(phone), set_email(email).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

**Asosiasi Doctor**
- add_doctor(doctor) = menambahkan dokter
- remove_doctor(doctor) = menghapus dokter

**Asosiasi Nurse**
- add_nurse(nurse) = menambahkan perawat
- remove_nurse(nurse) = menghapus perawat

### Hospital
1. id: str, name: str, official_code: str, type: str, accreditation: str.
2. patients: List[Patient] – agregasi (Hospital menyimpan pasien).
3. doctors: List[Doctor] – agregasi.
4. departments: List[Department] – agregasi.

**Konstruktor Default**
```cpp
Hospital::Hospital() {}
```
Membuat objek `Hospital`.

**Konstruktor parameter**
```cpp
Hospital::Hospital(string hid, string hname, string code, string htype, string accred) {
    id = hid;
    name = hname;
    officialCode = code;
    type = htype;
    accreditation = accred;
}
```
Membuat objek `Hospital` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_id(), get_name(), get_official_code(), get_type(), get_accreditation(),
get_patients(), get_doctors(), get_departments().
- Setter: set_name(name), set_official_code(code), set_type(type), set_accreditation(accreditation).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

**Agregasi**
- add_patient(patient)
- remove_patient(patient)
- add_doctor(doctor) 
- remove_doctor(doctor)
- add_department(department) 
- remove_department(department)

### Schedule
1. id: str – id jadwal.
2. day_of_week: int – 0..6 (Mon..Sun).
3. start_time: str – “HH:MM”.
4. end_time: str – “HH:MM”.

**Konstruktor Default**
```cpp
Schedule::Schedule() {
    dayOfWeek = 0;
    startTime = "00:00";
    endTime = "00:00";
}
```
Membuat objek `Schedule`.

**Konstruktor parameter**
```cpp
Schedule::Schedule(string sid, int dow, string start, string end) {
    id = sid;
    dayOfWeek = dow;
    startTime = start;
    endTime = end;
}
```
Membuat objek `Schedule` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_id(), get_day_of_week(), get_start_time(), get_end_time().
- Setter: set_day_of_week(day_of_week), set_start_time(start_time), set_end_time(end_time).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

### Diagnose
1. code: str – kode diagnosa (ICD/internal).
2. name: str – nama diagnosa.
3. description: str – keterangan.

**Konstruktor Default**
```cpp
Diagnose::Diagnose() {}
```
Membuat objek `Diagnose`.

**Konstruktor parameter**
```cpp
Diagnose::Diagnose(string c, string n, string desc) {
    code = c;
    name = n;
    description = desc;
}
```
Membuat objek `Diagnose` sambil mengisi semua atributnya.

**Getter & Setter**
- Getter: get_code(), get_name(), get_description().
- Setter: set_name(name), set_description(desc).

Membuat Getter yang berfungsi mengambil nilai masing-masing atribut. Sedangkan, Setter berfungsi untuk menetapkan atau mengubah nilai suatu atribut.

## Penjelasan Desain
Kelas Person dipakai sebagai kelas dasar, sehingga Patient, Doctor, dan Nurse mewarisi (extends) Person karena masing-masing menambah atribut spesifik dari setiap kelas. Lalu, kelas AcademicDoctor tetap mewarisi (extends) seluruh perilaku Doctor sehingga ada tambahan juga pada atribut (`ResearchArea, AcademicRank, Publications[]`).

Kelas Hospital agregasi dengan banyak kelas agar “memiliki” daftar referensi ke Patient/Doctor/Department, namun sistem objek tidak harus diatur Hospital karena objek bisa hidup di luar Hospital.

Kelas Department memiliki hubungan asosiasi dua arah kepada Doctor dan Nurse misalnya, satu dokter bisa di beberapa departemen dan satu departemen punya banyak dokter, begitupun juga perawat.

Komposisi kelas Doctor dengan Schedule agar jadwal dimiliki oleh satu dokter dan tidak dibagi dengan dokter lain. Jika dokter dihapus, jadwalnya akan ikut hilang.

Kelas Nurse dibuat asosiasi dengan Schedule agar jadwal dikelola sistem penjadwalan global (shift mingguan), yang bisa berubah atau dipakai ulang tanpa bergantung pada satu perawat. Perawat dapat dipindahkan jadwal shift jika semisal ada cuti, maka jadwal yang kosong diisi oleh perawat lain tanpa mengubah sistem jadwalnya.

Kelas Patient komposisi dengan Diagnose agara rekam medis pasien terhubung dengan pasien. Jika Patient hilang, maka Diagnose nya pun hilang.

## Alur Program

### a. Inisialisasi Class
```cpp
Hospital hospital("H001", "RS Harapan Bangsa", "RS-001", "Public", "A");
```
Dimulai dengan membuatkan objek `Hospital` karena menjadi pusat data yang menyimpan daftar pasien, dokter (sebagai pointer agar polymorphism berjalan), dan departemen.
Lalu, dibuat 2 `Department` seperti Kardiologi dan Neurologi, setelah itu ditambahkan ke `Hospital`.

### b. Pembuatan Doctor dan AcademicDoctor
Dibuat `Doctor` biasa (doc1) dan `AcademicDoctor` (doc2) yang merupakan turunan `Doctor`.
`AcademicDoctor` punya atribut tambahan: researchArea, academicRank, dan daftar publications.
```cpp
hospital.addDoctor(&doc1);
hospital.addDoctor(&doc2);
```
Kedua dokter dimasukkan ke `Hospital` melalui `addDoctor(&doc1)` dan `addDoctor(&doc2)`. Karena `Hospital` menyimpan `vector<Doctor*>`, agar polymorphism bisa dipakai. Polymorphism dibuat agar dapat menampung berbagai jenis dokter tanpa mengubah kelas `Hospital`.

### c. Jadwal Dokter (Schedule)
```cpp
doc1.addSchedule(s1);
doc1.addSchedule(s2);
doc2.addSchedule(s3);
```
Mwmbuat 3 jadwal `Schedule (s1, s2, s3)`. Lalu, ditambahkan ke masing-masing dokter dengan `addSchedule()`. Ini merupakan hubungan komposisi, karena jadwal dianggap dimiliki oleh dokter.

### d. Pembuatan Nurse dan Schedule Nurse
```cpp
nurse1.addSchedule(&sn1);
nurse2.addSchedule(&sn2);
```
Membuat 2 `Nurse (nurse1, nurse2)` dengan data registrasi dan level. Lalu, dibuat jadwal untuk `Nurse (sn1, sn2)`, kemudian dihubungkan dengan `addSchedule(&sn1)`. Hubungan ini asosiasi karena Nurse tidak memiliki jadwal, hanya mereferensikan.

### e. Hubungan Department dengan Doctor dan Nurse
`dep_cardio.addDoctor(&doc1); dep_cardio.addNurse(&nurse1);`
`dep_neuro.addDoctor(&doc2); dep_neuro.addNurse(&nurse2);`
Hubungan ini asosiasi many-to-many, karena satu dokter bisa masuk lebih dari satu departemen. Setelah itu, `Department` ditambahkan ke `Hospital`.

### f. Pembuatan Patient dan Diagnose
```cpp
pat1.addDiagnose(d1);
pat2.addDiagnose(d2);

hospital.addPatient(pat1);
hospital.addPatient(pat2);
```
Dibuat 2 `Patient (pat1, pat2)` dan 2 `Diagnose (d1, d2)`, lalu ditambahkan ke pasien dengan `addDiagnose()`. Ini merupakan hubungan komposisi, karena diagnosa menempel ke pasien. Setelah itu, Pasien dimasukkan ke Hospital `(hospital.addPatient(pat1);)`.

### g. Pencetakan Data Rumah Sakit
Program mencetak:
- Data umum `Hospital`: ID, Nama, Kode, Tipe, Akreditasi, jumlah pasien, jumlah dokter, jumlah departemen.
- Detail setiap `Department` beserta daftar dokter & perawatnya.
- Detail setiap `Doctor`: ID, lisensi, spesialisasi, jadwal. Jika dynamic_cast berhasil ke `AcademicDoctor`, ditampilkan juga researchArea, academicRank, dan publications.
- Detail `Nurse`: ID, regNo, level, jadwal, dan departemen.
- Detail `Patient`: MRN, golongan darah, keluhan, serta daftar Diagnosa.

## Dokumentasi