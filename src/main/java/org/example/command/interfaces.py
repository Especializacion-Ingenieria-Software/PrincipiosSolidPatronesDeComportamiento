from abc import ABC, abstractmethod


class Command(ABC):
    @abstractmethod
    def execute(self) -> None:
        """Ejecuta el comando"""
        pass

    @abstractmethod
    def undo(self) -> None:
        """Deshace el comando"""
        pass

    @property
    @abstractmethod
    def description(self) -> str:
        """Descripción del comando para el registro"""
        pass