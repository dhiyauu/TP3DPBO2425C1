class Schedule:

    def __init__(self, id: str, day_of_week: int, start_time: str, end_time: str) -> None:

        self.__id = id
        self.__day_of_week = day_of_week
        self.__start_time = start_time
        self.__end_time = end_time

    # Getter untuk mengambil nilai dari masing-masing atribut
    def get_id(self) -> str:
        return self.__id

    def get_day_of_week(self) -> int:
        return self.__day_of_week

    def get_start_time(self) -> str:
        return self.__start_time

    def get_end_time(self) -> str:
        return self.__end_time

    # Setter untuk menyimpan nilai masing-masing atribut
    def set_day_of_week(self, day_of_week: int) -> None:
        self.__day_of_week = day_of_week

    def set_start_time(self, start_time: str) -> None:
        self.__start_time = start_time

    def set_end_time(self, end_time: str) -> None:
        self.__end_time = end_time

    def __str__(self) -> str:
        day_map = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
        d = day_map[self.__day_of_week] if 0 <= self.__day_of_week <= 6 else str(self.__day_of_week)
        return f"Schedule[ID={self.__id}, {d} {self.__start_time}-{self.__end_time}]"