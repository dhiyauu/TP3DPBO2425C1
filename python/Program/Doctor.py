from __future__ import annotations
from datetime import date
from typing import List, Optional, TYPE_CHECKING

from Person import Person
from Schedule import Schedule

# Hindari circular import saat type hint
if TYPE_CHECKING:
    from Department import Department

class Doctor(Person):

    def __init__(
        self,
        id: str,
        name: str,
        date_of_birth: date,
        gender: str,
        contact: str,
        license_no: str,
        specialization: str,
    ) -> None:
        super().__init__(id, name, date_of_birth, gender, contact)
        self.__license_no: str = license_no
        self.__specialization: str = specialization
        self.__schedules: List[Schedule] = []          
        self.__departments: List["Department"] = []

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_license_no(self) -> str:
        return self.__license_no

    def get_specialization(self) -> str:
        return self.__specialization

    def get_schedules(self) -> List[Schedule]:
        return list(self.__schedules)

    def get_departments(self) -> List["Department"]:
        return list(self.__departments)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_license_no(self, license_no: str) -> None:
        self.__license_no = license_no

    def set_specialization(self, specialization: str) -> None:
        self.__specialization = specialization

    # Komposisi dari Schedule
    def add_schedule(self, schedule: Schedule) -> None:
        """Menambahkan jadwal ke dokter (dimiliki oleh Doctor)."""
        # Hindari duplikat berdasarkan id
        if all(s.get_id() != schedule.get_id() for s in self.__schedules):
            self.__schedules.append(schedule)

    def remove_schedule_by_id(self, schedule_id: str) -> None:
        self.__schedules = [s for s in self.__schedules if s.get_id() != schedule_id]

    # membuat jadwal langsung di dalam Doctor
    def create_schedule(self, id: str, day_of_week: int, start_time: str, end_time: str) -> Schedule:
        sch = Schedule(id=id, day_of_week=day_of_week, start_time=start_time, end_time=end_time)
        self.add_schedule(sch)
        return sch

    # Asosiasi dari Department (Many to Many)
    def link_department(self, department: "Department") -> None:
        """Hubungkan dokter dengan departemen (many-to-many, dua arah jika sisi Department menyediakan API)."""
        if department not in self.__departments:
            self.__departments.append(department)
        # Sinkron dua arah bila Department punya add_doctor()
        if hasattr(department, "add_doctor"):
            try:
                department.add_doctor(self)
            except Exception:
                pass

    def unlink_department(self, department: "Department") -> None:
        if department in self.__departments:
            self.__departments.remove(department)
        # Sinkron dua arah bila Department punya remove_doctor()
        if hasattr(department, "remove_doctor"):
            try:
                department.remove_doctor(self)
            except Exception:
                pass

    def __str__(self) -> str:
        return (
            f"Doctor[ID={self.get_id()}, Name={self.get_name()}, "
            f"License={self.__license_no}, Spec={self.__specialization}]"
        )