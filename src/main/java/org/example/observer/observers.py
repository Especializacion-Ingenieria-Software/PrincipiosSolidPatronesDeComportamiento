from typing import Dict, Any
from interfaces import Observer


class EmailNotifier(Observer):
    def __init__(self, email: str):
        self.email = email

    def update(self, message: str, data: Dict[str, Any]) -> None:
        print(f"EmailNotifier: Enviando email a {self.email}")
        print(f"  Asunto: {message}")
        print(f"  Datos: {data}")


class SMSNotifier(Observer):
    def __init__(self, phone: str):
        self.phone = phone

    def update(self, message: str, data: Dict[str, Any]) -> None:
        print(f"SMSNotifier: Enviando SMS a {self.phone}")
        print(f"  Mensaje: {message}")
        # Los SMS suelen ser breves, así que omitimos los datos detallados


class PushNotifier(Observer):
    def __init__(self, device_id: str):
        self.device_id = device_id

    def update(self, message: str, data: Dict[str, Any]) -> None:
        print(f"PushNotifier: Enviando push notification a dispositivo {self.device_id}")
        print(f"  Alerta: {message}")
        print(f"  Payload: {data}")