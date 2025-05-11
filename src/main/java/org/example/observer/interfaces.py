from abc import ABC, abstractmethod
from typing import Dict, Any

class Observer(ABC):
    @abstractmethod
    def update(self, message: str, data: Dict[str, Any]) -> None:
        """Método llamado cuando el sujeto observado cambia de estado"""
        pass

class Subject(ABC):
    @abstractmethod
    def attach(self, observer: Observer) -> None:
        """Registra un nuevo observador"""
        pass

    @abstractmethod
    def detach(self, observer: Observer) -> None:
        """Elimina un observador existente"""
        pass

    @abstractmethod
    def notify(self, message: str, data: Dict[str, Any]) -> None:
        """Notifica a todos los observadores sobre un cambio"""
        pass