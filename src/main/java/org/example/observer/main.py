from subjects import NotificationSystem
from observers import EmailNotifier, SMSNotifier, PushNotifier


def main():
    # Crear el sistema de notificaciones
    notification_system = NotificationSystem("Sistema principal")

    # Crear observadores
    email_client = EmailNotifier("usuario@ejemplo.com")
    sms_client = SMSNotifier("+34612345678")
    mobile_app = PushNotifier("DEVICE-123456")

    # Registrar observadores
    notification_system.attach(email_client)
    notification_system.attach(sms_client)
    notification_system.attach(mobile_app)

    # Generar notificación
    notification_system.create_notification(
        "Actualización importante del sistema",
        {"tipo": "actualización", "prioridad": "alta", "detalles": "Nueva versión disponible"}
    )

    # Eliminar un observador
    notification_system.detach(sms_client)

    # Generar otra notificación
    notification_system.create_notification(
        "Recordatorio de mantenimiento",
        {"tipo": "recordatorio", "prioridad": "media", "fecha": "2025-05-15"}
    )


if __name__ == "__main__":
    main()