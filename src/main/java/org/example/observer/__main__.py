def print_header(title):
    print("\n" + "=" * 50)
    print(f"  {title}")
    print("=" * 50 + "\n")


if __name__ == "__main__":
    # Ejemplo de Observer
    print_header("PATRÓN OBSERVER: SISTEMA DE NOTIFICACIONES")
    from main import main as observer_main

    observer_main()

    # Ejemplo de Command
    #print_header("PATRÓN COMMAND: SISTEMA DE HOGAR INTELIGENTE")
    #from command.main import main as command_main

    #command_main()