class Diagnose:

    def __init__(self, code: str, name: str, description: str = "") -> None:
        self.__code = code
        self.__name = name
        self.__description = description

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_code(self) -> str:
        return self.__code

    def get_name(self) -> str:
        return self.__name

    def get_description(self) -> str:
        return self.__description

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_name(self, name: str) -> None:
        self.__name = name

    def set_description(self, desc: str) -> None:
        self.__description = desc

    def __str__(self) -> str:
        return f"Diagnose[Code={self.__code}, Name={self.__name}, Desc={self.__description}]"