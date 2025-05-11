from typing import List, Dict, Any
from interfaces import Subject, Observer


class NotificationSystem(Subject):
    def __init__(self, name: str):
        self._name = name
        self._observers: List[Observer] = []

    def attach(self, observer: Observer) -> None:
        print(f"NotificationSystem: Agregando observador a {self._name}")
        if observer not in self._observers:
            self._observers.append(observer)

    def detach(self, observer: Observer) -> None:
        print(f"NotificationSystem: Eliminando observador de {self._name}")
        self._observers.remove(observer)

    def notify(self, message: str, data: Dict[str, Any]) -> None:
        print(f"NotificationSystem: Notificando observadores de {self._name}")
        for observer in self._observers:
            observer.update(message, data)

    def create_notification(self, message: str, data: Dict[str, Any]) -> None:
        print(f"\nNotificationSystem: Nueva notificación en {self._name}")
        self.notify(message, data)