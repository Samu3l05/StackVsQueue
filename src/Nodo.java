
public class Nodo {
  
        pocketMonster poke;
        Nodo pokenext;
         Nodo() {
            this.poke = null;
            this.pokenext = null;
         }

        public Nodo(pocketMonster poke) {
            this.poke = poke;
            this.pokenext = null;
        }
        public Nodo(pocketMonster poke,Nodo nodo){
        this.poke=poke;
        this.pokenext=nodo;
        
    }

   

    public pocketMonster getPoke() {
        return poke;
    }

    public void setPoke(pocketMonster poke) {
        this.poke = poke;
    }

    public Nodo getPokenext() {
        return pokenext;
    }

    public void setPokenext(Nodo pokenext) {
        this.pokenext = pokenext;
    }
        
        
        
        
        
    }


