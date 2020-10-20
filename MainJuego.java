public class MainJuego
{
    public static void main(String [] args)
    {
        //Contiene un objeto para llamar al metodo ejecutar de la clase controlador
        ControladorJuego controlador=new ControladorJuego();
        controlador.ejecutar();
        System.exit(0);
    }
}
