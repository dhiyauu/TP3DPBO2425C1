from __future__ import annotations
from typing import List, TYPE_CHECKING

if TYPE_CHECKING:
    from Doctor import Doctor
    from Nurse import Nurse


class Department:

    def __init__(self, id: str, name: str, location: str, phone: str = "", email: str = "") -> None:
        self.__id: str = id
        self.__name: str = name
        self.__location: str = location
        self.__phone: str = phone
        self.__email: str = email
        self.__doctors: List["Doctor"] = []
        self.__nurses: List["Nurse"] = []

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_id(self) -> str:
        return self.__id

    def get_name(self) -> str:
        return self.__name

    def get_location(self) -> str:
        return self.__location

    def get_phone(self) -> str:
        return self.__phone

    def get_email(self) -> str:
        return self.__email

    def get_doctors(self) -> List["Doctor"]:
        return list(self.__doctors)

    def get_nurses(self) -> List["Nurse"]:
        return list(self.__nurses)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_name(self, name: str) -> None:
        self.__name = name

    def set_location(self, location: str) -> None:
        self.__location = location

    def set_phone(self, phone: str) -> None:
        self.__phone = phone

    def set_email(self, email: str) -> None:
        self.__email = email

    # Asosiasi dari Doctor
    def add_doctor(self, doctor: "Doctor") -> None:
        if doctor not in self.__doctors:
            self.__doctors.append(doctor)
        if hasattr(doctor, "link_department"):
            try:
                doctor.link_department(self)  # sinkron ke sisi Doctor
            except Exception:
                pass

    def remove_doctor(self, doctor: "Doctor") -> None:
        if doctor in self.__doctors:
            self.__doctors.remove(doctor)
        if hasattr(doctor, "unlink_department"):
            try:
                doctor.unlink_department(self)
            except Exception:
                pass

    # Asosiasi dari Nurse
    def add_nurse(self, nurse: "Nurse") -> None:
        if nurse not in self.__nurses:
            self.__nurses.append(nurse)
        if hasattr(nurse, "link_department"):
            try:
                nurse.link_department(self)  # sinkron ke sisi Nurse
            except Exception:
                pass

    def remove_nurse(self, nurse: "Nurse") -> None:
        if nurse in self.__nurses:
            self.__nurses.remove(nurse)
        if hasattr(nurse, "unlink_department"):
            try:
                nurse.unlink_department(self)
            except Exception:
                pass

    def __str__(self) -> str:
        return (
            f"Department[ID={self.__id}, Name={self.__name}, "
            f"Doctors={len(self.__doctors)}, Nurses={len(self.__nurses)}]"
        )