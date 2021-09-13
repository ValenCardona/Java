import java.util.Scanner;
/**
 * Write a description of class deducido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deducido
{
    // instance variables - replace the example below with your own
    private int libranza;
    Scanner teclado = new Scanner(System.in);
    
    public void ingresarDatos()
    {
        System.out.println("Digite el valor de libranza: $");
        libranza = teclado.nextInt();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public long calcularTotalDeducido(long totalConDevengado)
    {
        // put your code here
        long valorSalud = calcularSalud(totalConDevengado);
        long valorPension = calcularPension(totalConDevengado);
        long valorSindicato = calcularSindicato(totalConDevengado);
        System.out.println("El valor de la libranza es: $"+libranza);
        System.out.println("El total a pagar por salud es: $"+valorSalud);
        System.out.println("El total a pagar por pensión es: $"+valorPension);
        System.out.println("El total a pagar por el sindicato es: $"+valorSindicato);
        return valorSalud + valorPension + valorSindicato + libranza;
    }
    
    private long calcularSalud(long totalConDevengado)
    {
        return totalConDevengado * 8/100;
    }
    
    private long calcularPension(long totalConDevengado)
    {
        return totalConDevengado * 4/100;
    }
    
    private long calcularSindicato(long totalConDevengado)
    {
       return totalConDevengado * 2/100;
    }
}
