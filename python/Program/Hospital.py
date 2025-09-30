from __future__ import annotations
from typing import List, TYPE_CHECKING

if TYPE_CHECKING:
    from Patient import Patient
    from Doctor import Doctor
    from Department import Department

class Hospital:

    def __init__(self, id: str, name: str, official_code: str, type: str, accreditation: str) -> None:
        self.__id: str = id
        self.__name: str = name
        self.__official_code: str = official_code
        self.__type: str = type
        self.__accreditation: str = accreditation
        self.__patients: List["Patient"] = []
        self.__doctors: List["Doctor"] = []
        self.__departments: List["Department"] = []

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_id(self) -> str:
        return self.__id

    def get_name(self) -> str:
        return self.__name

    def get_official_code(self) -> str:
        return self.__official_code

    def get_type(self) -> str:
        return self.__type

    def get_accreditation(self) -> str:
        return self.__accreditation

    def get_patients(self) -> List["Patient"]:
        return list(self.__patients)

    def get_doctors(self) -> List["Doctor"]:
        return list(self.__doctors)

    def get_departments(self) -> List["Department"]:
        return list(self.__departments)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_name(self, name: str) -> None:
        self.__name = name

    def set_official_code(self, code: str) -> None:
        self.__official_code = code

    def set_type(self, type: str) -> None:
        self.__type = type

    def set_accreditation(self, accreditation: str) -> None:
        self.__accreditation = accreditation

    # Agregasi dari Patient
    def add_patient(self, patient: "Patient") -> None:
        if patient not in self.__patients:
            self.__patients.append(patient)

    def remove_patient(self, patient: "Patient") -> None:
        if patient in self.__patients:
            self.__patients.remove(patient)

    # Agregasi dari Doctor
    def add_doctor(self, doctor: "Doctor") -> None:
        if doctor not in self.__doctors:
            self.__doctors.append(doctor)

    def remove_doctor(self, doctor: "Doctor") -> None:
        if doctor in self.__doctors:
            self.__doctors.remove(doctor)

    # Agregasi dari Department
    def add_department(self, department: "Department") -> None:
        if department not in self.__departments:
            self.__departments.append(department)

    def remove_department(self, department: "Department") -> None:
        if department in self.__departments:
            self.__departments.remove(department)

    def __str__(self) -> str:
        return (
            f"Hospital[ID={self.__id}, Name={self.__name}, Code={self.__official_code}, "
            f"Type={self.__type}, Accreditation={self.__accreditation}, "
            f"Patients={len(self.__patients)}, Doctors={len(self.__doctors)}, "
            f"Departments={len(self.__departments)}]"
        )