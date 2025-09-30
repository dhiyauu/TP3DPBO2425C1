# Saya Dhiya Ulhaq dengan NIM 2407716 mengerjakan Tugas Praktikum 3 dalam mata kuliah desain & pemrograman berorientasi objek untuk keberkahan-Nya maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan

from datetime import date

class Person:

    def __init__(self, id: str, name: str, date_of_birth: date, gender: str, contact: str):
        self.__id = id
        self.__name = name
        self.__date_of_birth = date_of_birth
        self.__gender = gender
        self.__contact = contact

    # Getter untuk mengambil nilai dari masing-masing atribut 
    def get_id(self) -> str:
        return self.__id

    def get_name(self) -> str:
        return self.__name

    def get_date_of_birth(self) -> date:
        return self.__date_of_birth

    def get_gender(self) -> str:
        return self.__gender

    def get_contact(self) -> str:
        return self.__contact

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_name(self, name: str) -> None:
        self.__name = name

    def set_date_of_birth(self, dob: date) -> None:
        self.__date_of_birth = dob

    def set_gender(self, gender: str) -> None:
        self.__gender = gender

    def set_contact(self, contact: str) -> None:
        self.__contact = contact

    def __str__(self) -> str:
        return f"Person[ID={self.__id}, Name={self.__name}, DOB={self.__date_of_birth}, Gender={self.__gender}, Contact={self.__contact}]"