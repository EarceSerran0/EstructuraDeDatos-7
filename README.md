# EstructuraDeDatos-7

Descripción:

Juego donde los jugadores se turnan para tirar dados y avanzar a través del tablero. El objetivo es ser el primer jugador en llegar a la posición meta (posición a escoger). El juego cuenta con un sistema de premios y castigos donde caer en posiciones pares otorga premios y caer en posiciones impares resulta en castigos.







Características del Juego

Soporte para 1-4 jugadores
Juego por turnos con tiradas de dados
Sistema dinámico de premios y castigos
Seguimiento de la posición de los jugadores
Sistema completo de menú para la gestión del juego

Cómo Jugar

Selecciona la opción 1 para iniciar el juego y registrar jugadores (máximo 4)
Usa la opción 2 para tirar los dados y tomar turnos
Los jugadores tiran dos dados y avanzan la suma de los valores
Caer en posiciones pares otorga un premio, las posiciones impares resultan en un castigo
El primer jugador en alcanzar la posición a escoger gana!

Premios y Castigos

Premios: Marcados con el símbolo '+', permiten a los jugadores avanzar posiciones adicionales
Castigos: Vienen en dos tipos:

Símbolo '-': Obliga al jugador a retroceder
Símbolo '=': Envía al jugador a una posición específica



Opciones del Menú

Iniciar Juego: Registrar nombres de jugadores
Jugar: Tirar dados y avanzar
Listar Premios: Ver premios disponibles en la pila
Listar Castigos: Ver castigos disponibles en la pila
Abandonar Juego: Eliminar un jugador de la cola
Listar Jugadores: Mostrar jugadores actuales y sus posiciones
Ayuda: Mostrar instrucciones del juego
Salir: Salir del juego

Información Técnica

Desarrollado en Java NetBeans con maven! 
Utilizamos colas para la gestión de jugadores
Utilizamos pilas para premios y castigos
Implementa conceptos de poo

Estructura del Proyecto

JuegoProyecto.java: Clase principal con bucle de juego y manejo de menú
ColaJugadores.java: Implementación de cola para gestión de jugadores
Jugador.java: Clase jugador con seguimiento de posición
NodoJugador.java: Clase nodo para la cola de jugadores
PilaJuego.java: Clase abstracta padre para pilas
PilaPremios.java: Implementación de pila para premios
PilaCastigos.java: Implementación de pila para castigos
Nodo.java: Clase nodo para pilas
Datos.java: Clase para datos de premios/castigos




Equipo de Desarrollo

Esteban Arce
Diana Medina
Yanko Domenech
Andrés Quesada


Versión
1.0



¡Disfruta del juego!