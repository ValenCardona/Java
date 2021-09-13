import java.util.Scanner;
/**
 * Write a description of class devengado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class devengado
{
    // instance variables - replace the example below with your own
    private int hd;
    private int hn;
    private int hdom;
    private int comision;
    Scanner teclado = new Scanner(System.in);
    
    public void ingresarDatos()
    {
        System.out.println("Digite la cantidad de horas extras diurnas: ");
        hd = teclado.nextInt();
        System.out.println("Digite la cantidad de horas extras nocturnas: ");
        hn = teclado.nextInt();
        System.out.println("Digite la cantidad de horas extras dominicales: ");
        hdom = teclado.nextInt();
        System.out.println("Digite la comisión que recibio el empleado: $");
        comision = teclado.nextInt();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public long calcularTotalConDevengado(long totalSalario)
    {
        // put your code here
        long valorHD = calcularVHD();
        long valorHN = calcularVHN();
        long valorHDom = calcularVHDom();
        long totalHE = calcularHorasExtras(valorHD, valorHN, valorHDom);  
        System.out.println("El valor de las horas extras diurnas es: $"+valorHD);
        System.out.println("El valor de las horas extras nocturas es: $"+valorHN);
        System.out.println("El valor de las horas extras dominicales es: $"+valorHDom);
        System.out.println("El valor total de las horas extras es: $"+totalHE);
        System.out.println("La comisión que recibio el empleado: $"+comision);
        return totalHE + comision + totalSalario;
    }
    
    private long calcularVHD()
    {
        return hd * 1500;
    }
    
    private long calcularVHN()
    {
        return hn * 2000;
    }
    
    private long calcularVHDom()
    {
        return hdom * 2500;
    }
    
    private long calcularHorasExtras(long calcularVHD, long calcularVHN, long calcularVHDom)
    {
       return  calcularVHD + calcularVHN + calcularVHDom;
    }
}
