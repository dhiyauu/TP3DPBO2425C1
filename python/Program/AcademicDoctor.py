from __future__ import annotations
from datetime import date
from typing import List
from Doctor import Doctor

class AcademicDoctor(Doctor):

    def __init__(
        self,
        id: str,
        name: str,
        date_of_birth: date,
        gender: str,
        contact: str,
        license_no: str,
        specialization: str,
        research_area: str,
        academic_rank: str,
        publications: List[str] = None
    ) -> None:
        super().__init__(id, name, date_of_birth, gender, contact, license_no, specialization)
        self.__research_area: str = research_area
        self.__academic_rank: str = academic_rank
        self.__publications: List[str] = publications if publications else []

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_research_area(self) -> str:
        return self.__research_area

    def get_academic_rank(self) -> str:
        return self.__academic_rank

    def get_publications(self) -> List[str]:
        return list(self.__publications)

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_research_area(self, research_area: str) -> None:
        self.__research_area = research_area

    def set_academic_rank(self, rank: str) -> None:
        self.__academic_rank = rank

    def add_publication(self, title: str) -> None:
        self.__publications.append(title)

    def remove_publication(self, title: str) -> None:
        if title in self.__publications:
            self.__publications.remove(title)

    def __str__(self) -> str:
        return (
            f"AcademicDoctor[ID={self.get_id()}, Name={self.get_name()}, "
            f"Spec={self.get_specialization()}, Rank={self.__academic_rank}, "
            f"Research={self.__research_area}, Pubs={len(self.__publications)}]"
        )