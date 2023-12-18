public abstract class QueueGrupo extends Grupos {
    Nodo inicio, ultimo;
    int tamaño = 0;

    // Otros métodos de la clase

    public int tamaño() {
        return tamaño;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public void add(pocketMonster poke) {
        Nodo NodoQueue = new Nodo();
        NodoQueue.poke = poke;
        NodoQueue.pokenext = null;

        if (isEmpty()) {
            inicio = NodoQueue;
            ultimo = NodoQueue;
        } else {
            ultimo.pokenext = NodoQueue;
            ultimo = NodoQueue;
        }
        tamaño++;
    }

    @Override
    public pocketMonster remove() {
        if (!isEmpty()) {
            pocketMonster poke = inicio.poke;

            if (inicio == ultimo) {
                inicio = null;
                ultimo = null;
            } else {
                inicio = inicio.pokenext;
            }
            tamaño--;
            return poke;
        } else {
            pocketMonster nulo = null;
            return nulo;
        }
    }

      @Override
    public String show(){
        Nodo recorrido = inicio;
        StringBuilder mostrar = new StringBuilder();
        while(recorrido!=null){
       mostrar.append(recorrido.poke.getNombre()).append("/").append(recorrido.poke.getTipo()).append(", ");
       recorrido= recorrido.pokenext;
       
       }
       if (mostrar.length() > 0) {
            mostrar.setLength(mostrar.length() - 2);
        }
        return mostrar.toString();
        }
    }
    
 