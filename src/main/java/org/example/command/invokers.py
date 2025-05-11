from typing import List, Dict
import datetime
from .interfaces import Command


class RemoteControl:
    def __init__(self):
        self._command_history: List[Command] = []

    def execute_command(self, command: Command) -> None:
        command.execute()
        self._command_history.append(command)

    def undo_last_command(self) -> None:
        if self._command_history:
            command = self._command_history.pop()
            print(f"Deshaciendo: {command.description}")
            command.undo()
        else:
            print("No hay comandos para deshacer")

    def get_history(self) -> List[str]:
        return [cmd.description for cmd in self._command_history]


class CommandScheduler:
    def __init__(self):
        self._scheduled_commands: Dict[datetime.datetime, List[Command]] = {}

    def schedule(self, command: Command, execution_time: datetime.datetime) -> None:
        if execution_time not in self._scheduled_commands:
            self._scheduled_commands[execution_time] = []
        self._scheduled_commands[execution_time].append(command)
        print(f"Comando '{command.description}' programado para {execution_time}")

    def run_due_commands(self, current_time: datetime.datetime) -> None:
        due_times = [time for time in self._scheduled_commands if time <= current_time]

        for time in due_times:
            print(f"\nEjecutando comandos programados para {time}:")
            for command in self._scheduled_commands[time]:
                print(f"- {command.description}")
                command.execute()
            del self._scheduled_commands[time]