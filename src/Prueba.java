import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Prueba {
    
   public static void crearArchivo(String nombreArchivo){
    File archivo = new File(nombreArchivo);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.close();
    } catch (FileNotFoundException ex) {
       ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
       Grupos pokedexStack = new StackGrupo() {};
       Grupos teamStack = new StackGrupo() {}; 
       Grupos tiposTeamS = new QueueGrupo() {}; 
       Grupos pokedexQueue = new QueueGrupo() {}; 
       Grupos teamQueue = new QueueGrupo() {};
       Grupos tiposTeamQ = new QueueGrupo() {};
       
       crearArchivo("C:\\Users\\Samuel\\Desktop\\Programacion\\Salida.mpdm");
       
        String SalidaStackPokedex = null;
        String SalidaQueuePokedex = null;
        String SalidaStackTeam = null;
        String SalidaQueueTeam = null;
        String SalidaBatalla = null;
        
          try {String lineaActual;
         BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
            
            while ((lineaActual = lector.readLine()) != null) {
                if (lineaActual.equals("CREATE STACK POKEDEX")) {              
                    System.out.println("\nSe encontró la instrucción CREATE STACK POKEDEX");                   
                    CreateStackPokedex((StackGrupo) pokedexStack); } 
                if (lineaActual.equals("SHOW STACK POKEDEX")) {
                    System.out.println("Se encontró la instrucción SHOW STACK POKEDEX");
                    SalidaStackPokedex = showStackPokedex((StackGrupo) pokedexStack);
                }
                if (lineaActual.equals("CREATE QUEUE POKEDEX")) {
                    System.out.println("Se encontró la instrucción CREATE QUEUE POKEDEX");
                    CreateQueuePokedex((QueueGrupo) pokedexQueue);                   
                }
                if (lineaActual.equals("SHOW QUEUE POKEDEX")) {
                    System.out.println("Se encontró la instrucción SHOW QUEUE POKEDEX");
                    SalidaQueuePokedex = showQueuePokedex((QueueGrupo) pokedexQueue);
                }
                if (lineaActual.equals("CREATE STACK TEAM")) {
                    System.out.println("Se encontró la instrucción CREATE STACK TEAM");
                    CreateStackTeam((QueueGrupo) tiposTeamQ, (StackGrupo) pokedexStack, (StackGrupo) teamStack); 
                }
                 if (lineaActual.equals("SHOW STACK TEAM")) {
                    System.out.println("Se encontró la instrucción SHOW STACK TEAM");
                    SalidaStackTeam = showStackTeam((StackGrupo) teamStack);
                }
                 if (lineaActual.equals("CREATE QUEUE TEAM")) {
                    System.out.println("Se encontró la instrucción CREATE QUEUE TEAM");
                    CreateQueueTeam((QueueGrupo) tiposTeamS, (QueueGrupo) pokedexQueue, (QueueGrupo) teamQueue); 
                }
                if (lineaActual.equals("SHOW QUEUE TEAM")) {
                    System.out.println("Se encontró la instrucción SHOW QUEUE TEAM");
                    SalidaQueueTeam = showQueueTeam((QueueGrupo) teamQueue);
                    }
                if (lineaActual.equals("ENCOUNTER")) {
                    System.out.println("Se encontró la instrucción ENCOUNTER");
                    SalidaBatalla = Torneo((StackGrupo) teamStack, (QueueGrupo) teamQueue);
                    } 
            }      

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    EscribirArchivo("C:\\Users\\Samuel\\Desktop\\Programacion\\Salida.mpdm",SalidaStackPokedex,SalidaQueuePokedex,SalidaStackTeam,SalidaQueueTeam,SalidaBatalla);
    }

 
private static void CreateStackPokedex(StackGrupo pokedexStack){
      
    try {
    BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));

    String primeraLinea = lector.readLine();

    if (primeraLinea != null && primeraLinea.equals("CREATE STACK POKEDEX")) {
    
        int numeroLineaDeseada = 1; 

        for (int i = 1; i < numeroLineaDeseada; i++) {
            lector.readLine();
        }

        String lineaDeseada = lector.readLine();

        if (lineaDeseada != null) {
            String[] bloques = lineaDeseada.split(", ");
            for (String bloque : bloques) {
                String[] partes = bloque.split("/");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    String tipo = partes[1].trim();
                    pokedexStack.add(new pocketMonster(nombre, tipo));
                }
            }
        }
    }

    lector.close();
}
    catch(IOException e){
        System.out.println("Error al leer el archivo "+e.getMessage());
    }
     
  }

  private static String showStackPokedex(StackGrupo pokedexStack){
       StringBuilder result = new StringBuilder();
        try {
        BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
        String lineaDeseada;

        while ((lineaDeseada = lector.readLine()) != null) {
            if (lineaDeseada.equals("SHOW STACK POKEDEX")) {
                result.append("Lista del equipo STACK:\n").append(pokedexStack.show()).append("\n");
                break;
            }
        }
        } catch (IOException e) {
        result.append("Error al leer el archivo ").append(e.getMessage());
        }
    return result.toString();
}

  private static void CreateQueuePokedex(QueueGrupo pokedexQueue ){
      
    try {
    BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
     String lineaDeseada;
     while((lineaDeseada = lector.readLine())!= null){     
          if (lineaDeseada.equals("CREATE QUEUE POKEDEX")) {
       
        String lineaDeseadaPokemon = lector.readLine();
             
        if (lineaDeseadaPokemon != null) {
            String[] bloques = lineaDeseadaPokemon.split(",");
            for (String bloque : bloques) {
                String[] partes = bloque.split("/");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    String tipo = partes[1].trim();
                    pokedexQueue.add(new pocketMonster(nombre, tipo));
                }
             }              
           }
        }
          
     }    
    lector.close();
}
    catch(IOException e){
        System.out.println("Error al leer el archivo "+e.getMessage());
    }
   
}
private static String showQueuePokedex(QueueGrupo pokedexQueue){                     
    StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("CREATE QUEUE POKEDEX")) {
               result.append("Lista del equipo QUEUE:\n").append(pokedexQueue.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   return result.toString();
 }

private static void CreateStackTeam(QueueGrupo tiposTeamS, StackGrupo pokedexStack, StackGrupo teamStack) {
    try {
        BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));

        String lineaActual;
        while ((lineaActual = lector.readLine()) != null) {
            if (lineaActual.equals("CREATE STACK TEAM")) {

                String lineaDeseadaEquipo = lector.readLine();

                if (lineaDeseadaEquipo != null) {
                    String[] bloques = lineaDeseadaEquipo.split(" ");

                    for (String type : bloques) {
                        tiposTeamS.add(new pocketMonster("", type));
                    }
                }
            }
        }

        lector.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo " + e.getMessage());
    }

    Nodo tipoActual = tiposTeamS.inicio;
    while (tipoActual != null) {
        String tipoBuscado = tipoActual.poke.getTipo();

        Nodo recorridoPokedex = pokedexStack.cima;
        Nodo anteriorPokedex = null;

        while (recorridoPokedex != null) {
            if (recorridoPokedex.poke.getTipo().equalsIgnoreCase(tipoBuscado)) {
                teamStack.add(new pocketMonster(recorridoPokedex.poke.getNombre(), recorridoPokedex.poke.getTipo()));
                if (anteriorPokedex != null) {
                    anteriorPokedex.pokenext = recorridoPokedex.pokenext;
                } else {
                    pokedexStack.cima = recorridoPokedex.pokenext;
                }
                break; 
            }
            anteriorPokedex = recorridoPokedex;
            recorridoPokedex = recorridoPokedex.pokenext;
        }
        tipoActual = tipoActual.pokenext;
    }
}
private static String showStackTeam(StackGrupo teamStack){
    StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("CREATE STACK TEAM")) {
               result.append("Lista del equipo STACK:\n").append(teamStack.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   return result.toString();
    
}

private static void CreateQueueTeam(QueueGrupo tiposTeamQ, QueueGrupo pokedexQueue, QueueGrupo teamQueue) {
    try {
        BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
        String lineaActual;
        while ((lineaActual = lector.readLine()) != null) {
            if (lineaActual.equals("CREATE QUEUE TEAM")) {
                String lineaDeseadaEquipo = lector.readLine();

                if (lineaDeseadaEquipo != null) {
                    String[] bloques = lineaDeseadaEquipo.split(" ");

                    for (String type : bloques) {
                        tiposTeamQ.add(new pocketMonster("", type));
                    }
                }
            }
        }
        lector.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo " + e.getMessage());
    } 
            Nodo tipoActual = tiposTeamQ.inicio;

        while (tipoActual != null) {
            String tipoBuscado = tipoActual.poke.getTipo();

            Nodo recorridoPokedex = pokedexQueue.inicio;
            Nodo anteriorPokedex = null;

            while (recorridoPokedex != null) {
                if (recorridoPokedex.poke.getTipo().equalsIgnoreCase(tipoBuscado)) {

                    teamQueue.add(new pocketMonster(recorridoPokedex.poke.getNombre(), recorridoPokedex.poke.getTipo()));
    
                    if (anteriorPokedex != null) {
                        anteriorPokedex.pokenext = recorridoPokedex.pokenext;
                    } else {
                        pokedexQueue.inicio = recorridoPokedex.pokenext;
                    }
                    break; 
                }

                anteriorPokedex = recorridoPokedex;
                recorridoPokedex = recorridoPokedex.pokenext;
            }

            tipoActual = tipoActual.pokenext;
        }
    }
private static String showQueueTeam(QueueGrupo teamQueue){
    
  StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Desktop\\Programacion\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("SHOW QUEUE TEAM")) {
               result.append("Lista del equipo QUEUE:\n").append(teamQueue.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   
   return result.toString();
}


public static String Torneo(StackGrupo teamStack, QueueGrupo teamQueue) {
    StringBuilder resultadoBatalla = new StringBuilder();
    int turn = 1;
    int empates = 0;

    while (!teamStack.isEmpty() && !teamQueue.isEmpty()) {
        resultadoBatalla.append("      TURN ").append(turn).append("\n");
        Nodo stackPokemon = teamStack.cima;
        Nodo queuePokemon = teamQueue.inicio;
        resultadoBatalla.append(stackPokemon.poke.getNombre()).append(" VS ").append(queuePokemon.poke.getNombre()).append("\n");

        int result = comparaTipos(stackPokemon.poke.getTipo(), queuePokemon.poke.getTipo());

        if (result > 0) {
            resultadoBatalla.append("---- ").append(stackPokemon.poke.getNombre()).append("/").append(stackPokemon.poke.getTipo()).append(" GANO ----\n");
            teamStack.remove();
            teamStack.add(new pocketMonster(stackPokemon.poke.getNombre(), stackPokemon.poke.getTipo()));
            teamQueue.remove();
        } else if (result < 0) {
            resultadoBatalla.append("---- ").append(queuePokemon.poke.getNombre()).append("/").append(queuePokemon.poke.getTipo()).append(" GANO ----\n");
            teamQueue.remove();
            teamQueue.add(new pocketMonster(queuePokemon.poke.getNombre(), queuePokemon.poke.getTipo()));
            teamStack.remove();
        } else {
            resultadoBatalla.append("---- EMPATE ----\n");
            teamStack.remove();
            teamStack.add(new pocketMonster(stackPokemon.poke.getNombre(), stackPokemon.poke.getTipo()));
            teamQueue.remove();
            teamQueue.add(new pocketMonster(queuePokemon.poke.getNombre(), queuePokemon.poke.getTipo()));
            empates++;
        }

        if (empates > teamQueue.tamaño) {
            resultadoBatalla.append("---- TERMINA EN EMPATE ----\n");
            break;
        }
        turn++;
    }

    if (teamStack.isEmpty() && !teamQueue.isEmpty()) {
        resultadoBatalla.append("TEAM QUEUE WINS");
    }

    if (!teamStack.isEmpty() && teamQueue.isEmpty()) {
        resultadoBatalla.append("TEAM STACK WINS");
    }

    return resultadoBatalla.toString();
}

private static int comparaTipos(String typeStack, String typeQueue) {
    if ((typeStack.equalsIgnoreCase("Water") && typeQueue.equalsIgnoreCase("Fire")) ||
            (typeStack.equalsIgnoreCase("Fire") && typeQueue.equalsIgnoreCase("Grass")) ||
            (typeStack.equalsIgnoreCase("Grass") && typeQueue.equalsIgnoreCase("Water"))) {
        return 1;
    } else if ((typeStack.equalsIgnoreCase("Fire") && typeQueue.equalsIgnoreCase("Water")) ||
            (typeStack.equalsIgnoreCase("Grass") && typeQueue.equalsIgnoreCase("Fire")) ||
            (typeStack.equalsIgnoreCase("Water") && typeQueue.equalsIgnoreCase("Grass"))) {
        return -1;
    } else {
        return 0;
    }
}

     public static void EscribirArchivo(String nombreArchivo,String showStackPokedex,String showQueuePokedex,String teamStack,String teamQueue, String Torneo){
    File archivo = new File(nombreArchivo);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.print(showStackPokedex);
        salida.print(showQueuePokedex);
        salida.print(teamStack);
        salida.print(teamQueue);
        salida.print(Torneo);
        salida.close();
    } catch (FileNotFoundException ex) {
       ex.printStackTrace(System.out);
        }
    }
    

}


