# StackVsQueue
Los eternos rivales Stack y Queue siempre se encuentra compitiendo

Estructura del Programa
Clase Principal (Prueba):

Responsable de la ejecución principal del programa.
Contiene métodos para crear archivos, leer instrucciones desde un archivo, y realizar operaciones de Stack y Queue.
Utiliza clases abstractas StackGrupo y QueueGrupo para la implementación de las estructuras de datos tipo pila y cola, respectivamente.
Define métodos específicos para operaciones como la creación de equipos (CreateStackTeam y CreateQueueTeam), mostrar el contenido de equipos (showStackTeam y showQueueTeam), y la simulación de batallas (Torneo).
Método main: Encargado de la ejecución principal del programa.
Inicializa las estructuras de datos (pokedexStack, teamStack, tiposTeamS, pokedexQueue, teamQueue, tiposTeamQ) y el archivo de salida (Salida.mpdm).
Lee instrucciones desde el archivo de entrada (Entrada.mpdm).
Llama a métodos específicos según las instrucciones leídas.
Escribe los resultados en el archivo de salida.
-Método crearArchivo: Crea un archivo vacío con el nombre especificado.

Clases Abstractas (StackGrupo y QueueGrupo):
Representan las implementaciones abstractas de las estructuras de datos tipo pila y cola, respectivamente.
Contienen métodos abstractos como add, remove, y show que son implementados en las clases concretas.
-Método add: Añade un nuevo elemento a la estructura de datos.
-Método remove: Elimina y retorna el elemento superior (pila) o frontal (cola) de la estructura de datos.
-Método show: Retorna una representación en cadena de la estructura de datos.

Clase Concreta (Nodo):Representa un nodo de la estructura de datos, que contiene un Pokémon (pocketMonster) y una referencia al siguiente nodo (pokenext).
Atributos:
-pocketMonster: Representa un Pokémon con atributos como nombre y tipo.
-pokenext: Referencia al siguiente nodo.

Métodos Específicos:
-Método CreateStackPokedex:
Lee instrucciones para crear un stack de la Pokédex desde un archivo.
Utiliza la clase concreta Nodo para almacenar Pokémon en la pila.
-Método showStackPokedex:
Muestra el contenido del stack de la Pokédex.
Utiliza el método show de la clase abstracta StackGrupo.
-Método CreateQueuePokedex:
Lee instrucciones para crear una cola de la Pokédex desde un archivo.
Utiliza la clase concreta Nodo para almacenar Pokémon en la cola.
-Método showQueuePokedex:
Muestra el contenido de la cola de la Pokédex.
Utiliza el método show de la clase abstracta QueueGrupo.
-Método CreateStackTeam:
Lee instrucciones para crear un equipo utilizando una pila.
Utiliza la clase concreta Nodo para almacenar Pokémon en la pila del equipo.
-Método showStackTeam:
Muestra el contenido del equipo creado con una pila.
Utiliza el método show de la clase abstracta StackGrupo.
-Método CreateQueueTeam:
Lee instrucciones para crear un equipo utilizando una cola.
Utiliza la clase concreta Nodo para almacenar Pokémon en la cola del equipo.
-Método showQueueTeam:
Muestra el contenido del equipo creado con una cola.
Utiliza el método show de la clase abstracta QueueGrupo.
-Método Torneo:
Simula batallas entre equipos de pila y cola.
Utiliza el método comparaTipos para determinar los resultados de las batallas.
-Método comparaTipos:
Compara los tipos de dos Pokémon en base a reglas predefinidas.
Retorna un valor positivo si el primer tipo es superior, negativo si el segundo tipo es superior, y cero en caso de empate.
Método EscribirArchivo:Escribe los resultados en un archivo de salida.
