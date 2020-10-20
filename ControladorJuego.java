/*Esta clase es la encargada de la lógica del programa*/
import javax.swing.JOptionPane;

public class ControladorJuego
{
    //Decalracion de variables
    private VistaJuego vista = new VistaJuego();
    private ModeloJuego modelo = new ModeloJuego();
    int opcion=0,opcion2=0,numJugador=0,opcionMaq=0;
    boolean ganador=false;
    //metodo para ejecutar el juego
    public void ejecutar(){
        numJugador=vista.escogerJugadores(numJugador);
        modelo.CrearTablero();
        //aqui analiza la opcion del jugador
        if(numJugador==1){
            //aqui llama a los metodos en vista y modelo para realizar el juego
            while(ganador==false){
                opcion=vista.MostrarTableroOpcion(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero(),opcion);
                modelo.opcionJugador(opcion,modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                //si el valor retornado es 1 entonces gana el jugador
                if(modelo.comprobacionJugador()==1){
                    JOptionPane.showMessageDialog(null,"USTED A GANADO");
                    vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                    ganador=true;
                }
                modelo.opcionMaquina(opcionMaq,modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                //si el valor retornado es 2 entonces gana la maquina
                if(modelo.comprobacionMaquina()==2){
                    JOptionPane.showMessageDialog(null,"LA MÁQUINA A GANADO");  
                    vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                    ganador=true;
                }
                //si el valor retornado es 3 entonces significa que hay un empate
                if(modelo.comprobacionJugador()==3){
                    JOptionPane.showMessageDialog(null,"EMPATE");  
                    vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                    ganador=true;
                }

            }
        }else{
            if(numJugador==2){

                while(ganador==false){

                    JOptionPane.showMessageDialog(null,"TURNO DEL JUGADOR ->N<-");
                    opcion=vista.MostrarTableroOpcion(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero(), opcion);
                    modelo.opcionJugador(opcion,modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                    //si el valor retornado es 1 entonces gana el jugador N
                    if(modelo.comprobacionJugador()==1){
                        JOptionPane.showMessageDialog(null,"A GANADO JUGADOR ->N<-");
                        vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                        ganador=true;
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"TURNO DEL JUGADOR ->B<-");
                    opcion2=vista.MostrarTableroOpcion(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero(), opcion);
                    modelo.opcionJugador2(opcion2,modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                    //si el valor retornado es 2 entonces gana el jugador 2, cabe aclarar que se uso el metodo de maquina, para no realizar dos metodos iguales
                    if(modelo.comprobacionMaquina()==2){
                        JOptionPane.showMessageDialog(null,"A GANADO JUGADOR ->B<-");  
                        vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                        ganador=true;
                        break;
                    }
                    if(modelo.comprobacionJugador()==3){
                        //si el valor retornado es 3 entonces significa que hay un empate
                        JOptionPane.showMessageDialog(null,"EMPATE");  
                        vista.MostrarTablero(modelo.getFilas(), modelo.getColumnas(), modelo.getTablero());
                        ganador=true;
                        break;
                    }
                }

            }
        }
    }
}
