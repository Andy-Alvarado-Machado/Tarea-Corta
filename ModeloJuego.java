/*Esta clase es la encargada de las interacciones con respecto a los datos*/
public class ModeloJuego
{
    //Decalracion de variables
    private int filas=4,columnas=7,ganador=0,opcionMaquina1,opcion=0,vuelta=1,opcion2=0, empate=0;
    private double opcionMaquina;
    private String tablero[][] = new String[filas][columnas];
    //Crea en la matriz el tablero
    public void CrearTablero()
    {
        for(int contador=0;contador<filas;contador++){
            for(int contador2=0;contador2<columnas;contador2++){
                tablero[contador][contador2]="x";
            }
        }
    }
    //Introduce en el tablero la opcion del jugador
    public void opcionJugador(int opcion,int filas, int columnas, String tablero[][])
    {
        opcion=opcion-1;
        for(int contador=filas-1;contador>=0;contador--){
            if(tablero[contador][opcion].equalsIgnoreCase("x")){
                tablero[contador][opcion]="N";
                contador=0;

            }
        }

    }
    //Introduce en el tablero la opcion del jugador 2
    public void opcionJugador2(int opcion2,int filas, int columnas, String tablero[][])
    {
        opcion2=opcion2-1;
        for(int contador=filas-1;contador>=0;contador--){

            if(tablero[contador][opcion2].equalsIgnoreCase("x")){
                tablero[contador][opcion2]="B";
                contador=0;

            }
        }

    }
    //Introduce en el tablero la opcion de la máquina
    public void opcionMaquina(int opcionMaq, int filas, int columnas, String tablero[][]){
        double opcionMaq1=0;
        opcionMaq1=Math.random()*(7);
        opcionMaq = (int)opcionMaq1; 
        for(int contador=filas-1;contador>=0;contador--){

            if(tablero[contador][opcionMaq].equalsIgnoreCase("x")){
                tablero[contador][opcionMaq]="B";
                contador=0;
            }
        }

    }
    //Comprueba las fichas si existe un gane
    public int comprobacionJugador(){
        int ganador=0;
        //Horizontal

        int horizontal=0, vertical=0,diagonal=0;

        for(int contador=0;contador<filas;contador++){
            for(int contador2=0;contador2<columnas;contador2++){
                if(tablero[contador][contador2].equals("N")){
                    for(int h=contador2+1;h<columnas;h++){
                        if(tablero[contador][h].equals("N")){
                            horizontal++;
                            if(horizontal==3){
                                ganador=1;
                                break;
                            }
                        }else{
                            h=columnas;
                            horizontal=0;
                        }
                    }
                }
            }
        }

        //Vertical
        for(int contador=0;contador<columnas;contador++){
            for(int contador2=0;contador2<filas;contador2++){
                if(tablero[contador2][contador].equals("N")){
                    vertical++;
                    if(vertical==4){
                        ganador=1;
                        break;
                    }
                }else{
                    contador2=filas;
                    vertical=0;
                }
            }
        }
        //Diagonal
        //Este código es opcional, ya que no se pudo realizar la correcta busqueda en diagonal por medio de ciclos
        if((tablero[0][0]=="N"&&tablero[1][1]=="N"&&tablero[2][2]=="N"&&tablero[3][3]=="N")||(tablero[0][1]=="N"&&tablero[1][2]=="N"&&tablero[2][3]=="N"&&tablero[3][4]=="N")
        ||(tablero[0][2]=="N"&&tablero[1][3]=="N"&&tablero[2][4]=="N"&&tablero[3][5]=="N")||(tablero[0][3]=="N"&&tablero[1][4]=="N"&&tablero[2][5]=="N"&&tablero[3][6]=="N")
        ||(tablero[0][6]=="N"&&tablero[1][5]=="N"&&tablero[2][4]=="N"&&tablero[3][3]=="N")||(tablero[0][5]=="N"&&tablero[1][4]=="N"&&tablero[2][3]=="N"&&tablero[3][2]=="N")
        ||(tablero[0][4]=="N"&&tablero[1][3]=="N"&&tablero[2][2]=="N"&&tablero[3][1]=="N")||(tablero[0][3]=="N"&&tablero[1][2]=="N"&&tablero[2][1]=="N"&&tablero[3][0]=="N"))
        {
            ganador=1;
        }
        //Se integró el código de prueba para la busqueda diagonal por medio de ciclos como un comentario, solo con fines de constatar el intento
        /*
        int contador=0;
        for(int i=0; i<columnas;i++){
        contador=i;
        for(int j=0; j<filas;j++){
        if(tablero[j][i]=="N"){
        if(i<3){
        contador++;
        if(tablero[j+1][contador]=="N"){
        diagonal++;
        }
        } else{
        if(i>3){           
        for(int h=columnas-1; h>=0; h--){
        contador++;
        if(tablero[contador][h]=="N"){
        diagonal++;
        }
        if(diagonal==4){
        break;
        }
        }
        }            
        }
        }
        }
        }
         */
            empate++;
        if(empate>28){
            ganador=3;
        }
        return ganador;

    }
    //Comprueba las fichas si existe un gane
    public int comprobacionMaquina(){
        int ganador=0;
        int horizontal=0,vertical=0;
        //Horizontal

        for(int contador=0;contador<filas;contador++){
            for(int contador2=0;contador2<columnas;contador2++){
                if(tablero[contador][contador2].equals("B")){
                    for(int h=contador2+1;h<columnas;h++){
                        if(tablero[contador][h].equals("B")){
                            horizontal++;
                            if(horizontal==3){
                                ganador=2;
                                break;
                            }
                        }else{
                            h=columnas;
                            horizontal=0;
                        }
                    }
                }
            }
        }

        //Vertical
        for(int contador=0;contador<columnas;contador++){
            for(int contador2=0;contador2<filas;contador2++){
                if(tablero[contador2][contador].equals("B")){
                    vertical++;
                    if(vertical==4){
                        ganador=2;
                        break;
                    }
                }else{
                    contador2=filas;
                    vertical=0;
                }
            }
        }
        //Este código es opcional, ya que no se pudo realizar la correcta busqueda en diagonal por medio de ciclos
        //Diagonal
        if((tablero[0][0]=="B"&&tablero[1][1]=="B"&&tablero[2][2]=="B"&&tablero[3][3]=="B")||(tablero[0][1]=="B"&&tablero[1][2]=="B"&&tablero[2][3]=="B"&&tablero[3][4]=="B")
                ||(tablero[0][2]=="B"&&tablero[1][3]=="B"&&tablero[2][4]=="B"&&tablero[3][5]=="B")||(tablero[0][3]=="B"&&tablero[1][4]=="B"&&tablero[2][5]=="B"&&tablero[3][6]=="B")
                ||(tablero[0][6]=="B"&&tablero[1][5]=="B"&&tablero[2][4]=="B"&&tablero[3][3]=="B")||(tablero[0][5]=="B"&&tablero[1][4]=="B"&&tablero[2][3]=="B"&&tablero[3][2]=="B")
                ||(tablero[0][4]=="B"&&tablero[1][3]=="B"&&tablero[2][2]=="B"&&tablero[3][1]=="B")||(tablero[0][3]=="B"&&tablero[1][2]=="B"&&tablero[2][1]=="B"&&tablero[3][0]=="B"))
                 {
            ganador=2;
        }
        //Se integró el código de prueba para la busqueda diagonal por medio de ciclos como un comentario, solo con fines de constatar el intento
        /*
        int contador=0;
        for(int i=0; i<columnas;i++){
        contador=i;
        for(int j=0; j<filas;j++){
        if(tablero[j][i]=="B"){
        if(i<3){
        contador++;
        if(tablero[j+1][contador]=="B"){
        diagonal++;
        }
        } else{
        if(i>3){           
        for(int h=columnas-1; h>=0; h--){
        contador++;
        if(tablero[contador][h]=="N"){
        diagonal++;
        }
        if(diagonal==4){
        break;
        }
        }
        }            
        }
        }
        }
        }
         */
        return ganador;
    }
    //metodos get para obetener los valores de las variables fila y columnas, y tablero
    public int getFilas(){
        return this.filas;
    }

    public int getColumnas(){
        return this.columnas;
    }

    public String [][] getTablero(){
        return this.tablero;
    }

}
