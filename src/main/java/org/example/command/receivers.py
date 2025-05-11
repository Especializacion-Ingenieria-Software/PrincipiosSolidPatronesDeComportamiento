class Light:
    def __init__(self, location: str):
        self.location = location
        self.is_on = False
        self.brightness = 0  # 0-100%

    def turn_on(self) -> None:
        self.is_on = True
        print(f"Luz en {self.location} encendida")

    def turn_off(self) -> None:
        self.is_on = False
        print(f"Luz en {self.location} apagada")

    def set_brightness(self, level: int) -> None:
        if 0 <= level <= 100:
            self.brightness = level
            self.is_on = level > 0
            print(f"Brillo de luz en {self.location} ajustado a {level}%")
        else:
            print(f"Nivel de brillo debe estar entre 0-100")

    def get_status(self) -> str:
        status = "encendida" if self.is_on else "apagada"
        return f"Luz en {self.location}: {status}, brillo: {self.brightness}%"


class Thermostat:
    def __init__(self, location: str):
        self.location = location
        self.temperature = 22  # en grados Celsius
        self.is_on = False

    def turn_on(self) -> None:
        self.is_on = True
        print(f"Termostato en {self.location} encendido")

    def turn_off(self) -> None:
        self.is_on = False
        print(f"Termostato en {self.location} apagado")

    def set_temperature(self, temp: float) -> None:
        if 10 <= temp <= 30:
            self.temperature = temp
            print(f"Temperatura en {self.location} ajustada a {temp}°C")
        else:
            print(f"Temperatura debe estar entre 10-30°C")

    def get_status(self) -> str:
        status = "encendido" if self.is_on else "apagado"
        return f"Termostato en {self.location}: {status}, temperatura: {self.temperature}°C"