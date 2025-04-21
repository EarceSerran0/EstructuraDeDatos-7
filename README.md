# EstructuraDeDatos-7

## Descripción:

Juego donde los jugadores se turnan para tirar dados y avanzar a través del tablero. El objetivo es ser el primer jugador en llegar a la posición meta (posición a escoger). El juego cuenta con un sistema de premios y castigos donde caer en posiciones pares otorga premios y caer en posiciones impares resulta en castigos. Además, incluye un chatbot de preguntas frecuentes implementado con estructura de árbol binario.

## Características del Juego

- Soporte para 1-4 jugadores
- Juego por turnos con tiradas de dados
- Sistema dinámico de premios y castigos
- Seguimiento de la posición de los jugadores
- Sistema completo de menú para la gestión del juego
- Chatbot de preguntas frecuentes con estructura de árbol binario

## Cómo Jugar

- Selecciona la opción 1 para iniciar el juego y registrar jugadores (máximo 4)
- Usa la opción 2 para tirar los dados y tomar turnos
- Los jugadores tiran dos dados y avanzan la suma de los valores
- Caer en posiciones pares otorga un premio, las posiciones impares resultan en un castigo
- El primer jugador en alcanzar la posición a escoger gana!

## Premios y Castigos

- **Premios**: Marcados con el símbolo '+', permiten a los jugadores avanzar posiciones adicionales
- **Castigos**: Vienen en dos tipos:
  - Símbolo '-': Obliga al jugador a retroceder
  - Símbolo '=': Envía al jugador a una posición específica

## Opciones del Menú

1. **Iniciar Juego**: Registrar nombres de jugadores
2. **Jugar**: Tirar dados y avanzar
3. **Listar Premios**: Ver premios disponibles en la pila
4. **Listar Castigos**: Ver castigos disponibles en la pila
5. **Abandonar Juego**: Eliminar un jugador de la cola
6. **Listar Jugadores**: Mostrar jugadores actuales y sus posiciones
7. **Adicionar Jugador**: Agregar un nuevo jugador durante la partida
8. **Estado Actual del Juego**: Visualizar el tablero con las posiciones
9. **Bitácora-Historial**: Ver el recorrido histórico de cada jugador
10. **Ayuda**: Mostrar instrucciones del juego
11. **Chatbot de Preguntas Frecuentes**: Acceder al sistema de preguntas frecuentes
12. **Salir**: Salir del juego

## Chatbot de Preguntas Frecuentes

El chatbot implementa un sistema de navegación basado en árbol binario que permite:
- Navegar por categorías de preguntas (jugadores y administradores)
- Consultar preguntas específicas y ver sus respuestas
- Agregar y modificar categorías y preguntas (para administradores)
- Visualizar la estructura del árbol de preguntas

## Información Técnica

Desarrollado en Java NetBeans con maven, utilizando diferentes estructuras de datos:
- **Colas** para la gestión de jugadores
- **Pilas** para premios y castigos
- **Listas enlazadas** para el historial de posiciones
- **Listas doblemente enlazadas circulares** para el historial de jugadores
- **Listas circulares** para el estado del juego
- **Árbol binario** para el chatbot de preguntas frecuentes

## Estructura del Proyecto

### Juego Principal
- **JuegoProyecto.java**: Clase principal con bucle de juego y manejo de menú
- **ColaJugadores.java**: Implementación de cola para gestión de jugadores
- **Jugador.java**: Clase jugador con seguimiento de posición
- **NodoJugador.java**: Clase nodo para la cola de jugadores
- **PilaJuego.java**: Clase abstracta padre para pilas
- **PilaPremios.java**: Implementación de pila para premios
- **PilaCastigos.java**: Implementación de pila para castigos
- **Nodo.java**: Clase nodo para pilas
- **Datos.java**: Clase para datos de premios/castigos
- **EstadoDeJuego.java**: Lista circular para representar el tablero
- **NodoPosicionPartida.java**: Nodo para la lista circular del tablero
- **JugadorHistorial.java**: Lista doble circular para el historial
- **NodoJugadorHistorial.java**: Nodo para el historial de jugadores
- **ListaPosicion.java**: Lista simple para historial de posiciones
- **NodoPosicion.java**: Nodo para la lista de posiciones

### Chatbot
- **Chatbot.java**: Interfaz para el chatbot de preguntas frecuentes
- **arbolChatbot.java**: Implementación del árbol binario para el chatbot
- **NodoPreguntas.java**: Nodo para el árbol binario del chatbot
- **preguntas.java**: Clase para representar una pregunta
- **listaPreguntas.java**: Lista enlazada para almacenar preguntas
- **NodoPreguntaLista.java**: Nodo para la lista de preguntas

## Equipo de Desarrollo

- Esteban Arce
- Diana Medina
- Andrés Quesada

## Versión
1.3

¡Disfruta del juego!
