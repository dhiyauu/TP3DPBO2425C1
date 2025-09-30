from __future__ import annotations
from datetime import date
from typing import List, TYPE_CHECKING

from Person import Person
from Schedule import Schedule

if TYPE_CHECKING:
    from Department import Department


class Nurse(Person):

    def __init__(
        self,
        id: str,
        name: str,
        date_of_birth: date,
        gender: str,
        contact: str,
        registration_no: str,
        level: str
    ) -> None:
        super().__init__(id, name, date_of_birth, gender, contact)
        self.__registration_no: str = registration_no
        self.__level: str = level
        self.__schedules: List[Schedule] = []           
        self.__departments: List["Department"] = []      

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_registration_no(self) -> str:
        return self.__registration_no

    def get_level(self) -> str:
        return self.__level

    def get_schedules(self) -> List[Schedule]:
        return list(self.__schedules)

    def get_departments(self) -> List["Department"]:
        return list(self.__departments)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_registration_no(self, reg_no: str) -> None:
        self.__registration_no = reg_no

    def set_level(self, level: str) -> None:
        self.__level = level

    # Asosiasi dari Schedule
    def assign_schedule(self, schedule: Schedule) -> None:
        if schedule not in self.__schedules:
            self.__schedules.append(schedule)

    def remove_schedule(self, schedule: Schedule) -> None:
        if schedule in self.__schedules:
            self.__schedules.remove(schedule)

    # Asosiasi dari Department
    def link_department(self, dept: "Department") -> None:
        if dept not in self.__departments:
            self.__departments.append(dept)
        if hasattr(dept, "add_nurse"):
            try:
                dept.add_nurse(self)
            except Exception:
                pass

    def unlink_department(self, dept: "Department") -> None:
        if dept in self.__departments:
            self.__departments.remove(dept)
        if hasattr(dept, "remove_nurse"):
            try:
                dept.remove_nurse(self)
            except Exception:
                pass

    def __str__(self) -> str:
        return (
            f"Nurse[ID={self.get_id()}, Name={self.get_name()}, "
            f"RegNo={self.__registration_no}, Level={self.__level}]"
        )