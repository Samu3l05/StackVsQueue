
public abstract class StackGrupo extends Grupos {

    Nodo cima;
    int tamaño=0;
    @Override
    public void add(pocketMonster poke){
        Nodo NodoStack = new Nodo(poke);
        
        NodoStack.pokenext=cima;
        cima = NodoStack;
        tamaño++;
        
    }
    

    @Override
    public pocketMonster remove(){
        pocketMonster aux = cima.poke;
       cima = cima.pokenext;
       tamaño--;
    return aux;
    }
    
    @Override
    public String show(){
       Nodo recorrido = cima;
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
    
    public int tamaño() {
        return tamaño;
    }
    
    public boolean isEmpty() {
        return cima == null;
    }
 }