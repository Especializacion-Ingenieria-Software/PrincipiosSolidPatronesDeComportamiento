from typing import List
from .interfaces import Command
from .receivers import Light, Thermostat


# Comandos para controlar luces
class LightOnCommand(Command):
    def __init__(self, light: Light):
        self.light = light
        self._previous_state = False

    def execute(self) -> None:
        self._previous_state = self.light.is_on
        self.light.turn_on()

    def undo(self) -> None:
        if not self._previous_state:
            self.light.turn_off()

    @property
    def description(self) -> str:
        return f"Encender luz en {self.light.location}"


class LightOffCommand(Command):
    def __init__(self, light: Light):
        self.light = light
        self._previous_state = False

    def execute(self) -> None:
        self._previous_state = self.light.is_on
        self.light.turn_off()

    def undo(self) -> None:
        if self._previous_state:
            self.light.turn_on()

    @property
    def description(self) -> str:
        return f"Apagar luz en {self.light.location}"


class DimLightCommand(Command):
    def __init__(self, light: Light, level: int):
        self.light = light
        self.level = level
        self._previous_level = 0

    def execute(self) -> None:
        self._previous_level = self.light.brightness
        self.light.set_brightness(self.level)

    def undo(self) -> None:
        self.light.set_brightness(self._previous_level)

    @property
    def description(self) -> str:
        return f"Ajustar brillo de luz en {self.light.location} a {self.level}%"


# Comandos para controlar el termostato
class ThermostatSetCommand(Command):
    def __init__(self, thermostat: Thermostat, temperature: float):
        self.thermostat = thermostat
        self.temperature = temperature
        self._previous_temp = 22.0

    def execute(self) -> None:
        self._previous_temp = self.thermostat.temperature
        self.thermostat.set_temperature(self.temperature)

    def undo(self) -> None:
        self.thermostat.set_temperature(self._previous_temp)

    @property
    def description(self) -> str:
        return f"Ajustar temperatura en {self.thermostat.location} a {self.temperature}°C"


# Macro comando (compuesto)
class MacroCommand(Command):
    def __init__(self, commands: List[Command], name: str):
        self.commands = commands
        self.name = name

    def execute(self) -> None:
        print(f"Ejecutando macro '{self.name}':")
        for command in self.commands:
            command.execute()

    def undo(self) -> None:
        print(f"Deshaciendo macro '{self.name}':")
        # Deshacer en orden inverso
        for command in reversed(self.commands):
            command.undo()

    @property
    def description(self) -> str:
        return f"Macro '{self.name}' ({len(self.commands)} comandos)"