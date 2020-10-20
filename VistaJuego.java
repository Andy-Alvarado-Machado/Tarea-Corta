/*
 * Esta clase es la encargada de desplegar el juego en la pantalla
 *@author Andy Alvarado Machado
 */
import javax.swing.JOptionPane;
public class VistaJuego
{
    //Muestra las condiciones en las que está el tablero
    public void MostrarTablero(int filas, int columnas,String tablero[][])
    {
        String mostrar="";
        for(int contador=0;contador<filas;contador++){
            for(int contador2=0;contador2<columnas;contador2++){
                mostrar+=tablero[contador][contador2]+"|";
            }
            mostrar+="\n";
        }
        JOptionPane.showMessageDialog(null, "1|2|3|4|5|6|7 \n"+mostrar);
    }
    //Pide una opcion al jugador y muestra un tablero
    public int MostrarTableroOpcion(int filas, int columnas,String tablero[][],int opcion)
    {
        String mostrar="";
        for(int contador=0;contador<filas;contador++){
            for(int contador2=0;contador2<columnas;contador2++){
                mostrar+=tablero[contador][contador2]+"|";
            }
            mostrar+="\n";
        }
        opcion=Integer.parseInt(JOptionPane.showInputDialog("1|2|3|4|5|6|7 \n"+mostrar));
        return opcion;
    }
    //Pide al jugador escoger el numero de jugadores
    public int escogerJugadores(int numJugador)
    {
        numJugador=Integer.parseInt(JOptionPane.showInputDialog("Escoja el número de jugadores\n1=Un jugador\n2=Dos jugadores"));
        return numJugador;
    }
}
