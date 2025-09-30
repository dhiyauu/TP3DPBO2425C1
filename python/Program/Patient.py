# patient.py
from __future__ import annotations
from datetime import date
from typing import List, Optional

from Person import Person
from Diagnose import Diagnose


class Patient(Person):

    def __init__(
        self,
        id: str,
        name: str,
        date_of_birth: date,
        gender: str,
        contact: str,
        medical_record_number: str,
        blood_type: Optional[str] = None,
        complaint: str = ""
    ) -> None:
        super().__init__(id, name, date_of_birth, gender, contact)
        self.__medical_record_number: str = medical_record_number
        self.__blood_type: Optional[str] = blood_type
        self.__complaint: str = complaint
        self.__diagnoses: List[Diagnose] = []  # komposisi

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_medical_record_number(self) -> str:
        return self.__medical_record_number

    def get_blood_type(self) -> Optional[str]:
        return self.__blood_type

    def get_complaint(self) -> str:
        return self.__complaint

    def get_diagnoses(self) -> List[Diagnose]:
        return list(self.__diagnoses)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_blood_type(self, blood_type: str) -> None:
        self.__blood_type = blood_type

    def set_complaint(self, complaint: str) -> None:
        self.__complaint = complaint

    # Komposisi dari Diagnose
    def add_diagnose(self, code: str, name: str, description: str = "") -> Diagnose:
        # Membuat diagnosis baru dan melekatkannya ke pasien
        dx = Diagnose(code, name, description)
        self.__diagnoses.append(dx)
        return dx

    def remove_diagnose(self, code: str) -> None:
        # Menghapus diagnosis berdasarkan code
        self.__diagnoses = [d for d in self.__diagnoses if d.get_code() != code]

    def __str__(self) -> str:
        return (
            f"Patient[ID={self.get_id()}, Name={self.get_name()}, MRN={self.__medical_record_number}, "
            f"BloodType={self.__blood_type}, Complaint={self.__complaint}]"
        )