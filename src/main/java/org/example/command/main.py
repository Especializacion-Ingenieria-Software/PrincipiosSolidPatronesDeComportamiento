import datetime
from .receivers import Light, Thermostat
from .commands import (
    LightOnCommand, LightOffCommand, DimLightCommand,
    ThermostatSetCommand, MacroCommand
)
from .invokers import RemoteControl, CommandScheduler


def main():
    # Crear receptores (dispositivos)
    living_room_light = Light("Sala de estar")
    bedroom_light = Light("Dormitorio")
    kitchen_light = Light("Cocina")
    living_room_thermostat = Thermostat("Sala de estar")

    # Crear comandos
    living_room_light_on = LightOnCommand(living_room_light)
    living_room_light_off = LightOffCommand(living_room_light)
    bedroom_light_on = LightOnCommand(bedroom_light)
    bedroom_light_off = LightOffCommand(bedroom_light)
    kitchen_light_dim = DimLightCommand(kitchen_light, 50)
    set_living_room_temp = ThermostatSetCommand(living_room_thermostat, 24.5)

    # Crear invoker (control remoto)
    remote = RemoteControl()

    # Uso directo: encender luces
    print("\n--- Control directo de dispositivos ---")
    remote.execute_command(living_room_light_on)
    remote.execute_command(bedroom_light_on)
    remote.execute_command(kitchen_light_dim)
    remote.execute_command(set_living_room_temp)

    # Ver estado actual
    print("\n--- Estado actual de dispositivos ---")
    print(living_room_light.get_status())
    print(bedroom_light.get_status())
    print(kitchen_light.get_status())
    print(living_room_thermostat.get_status())

    # Deshacer comandos
    print("\n--- Deshacer comandos ---")
    remote.undo_last_command()  # Deshace ajuste de temperatura
    remote.undo_last_command()  # Deshace ajuste de luz de cocina

    # Crear y usar macro comando
    print("\n--- Usando macro comando ---")
    night_mode = MacroCommand([
        LightOffCommand(living_room_light),
        DimLightCommand(bedroom_light, 20),
        LightOffCommand(kitchen_light),
        ThermostatSetCommand(living_room_thermostat, 20)
    ], "Modo Noche")

    remote.execute_command(night_mode)

    # Programar comandos
    print("\n--- Programando comandos ---")
    scheduler = CommandScheduler()

    # Programar para "mañana" (simulado)
    now = datetime.datetime.now()
    tomorrow_morning = now + datetime.timedelta(seconds=5)  # Simulamos "mañana" en 5 segundos

    morning_mode = MacroCommand([
        LightOnCommand(living_room_light),
        LightOnCommand(kitchen_light),
        ThermostatSetCommand(living_room_thermostat, 22)
    ], "Modo Mañana")

    scheduler.schedule(morning_mode, tomorrow_morning)

    # Simular que ha pasado el tiempo
    print(f"\nSimulando avance de tiempo a {tomorrow_morning}")
    scheduler.run_due_commands(tomorrow_morning)

    # Ver historial de comandos
    print("\n--- Historial de comandos ejecutados ---")
    for i, cmd_desc in enumerate(remote.get_history(), 1):
        print(f"{i}. {cmd_desc}")


if __name__ == "__main__":
    main()