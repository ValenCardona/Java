import java.util.Scanner;
/**
 * Write a description of class nomina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nomina
{
    // instance variables - replace the example below with your own
    private deducido deducidoClase; 
    private devengado devengadoClase;
    private String nombre;
    private long salario;
    private int dia;  
    Scanner teclado = new Scanner(System.in);
    
    /**
     * Constructor for objects of class nomina
     */
    public nomina()
    {
        deducidoClase = new deducido();
        devengadoClase = new devengado();
    }
    
    public void ingresarDatos()
    {
        System.out.println("Digite el nombre del trabajador: ");
        nombre = teclado.nextLine();
        System.out.println("Digite el salario del trabajador: $");
        salario = teclado.nextLong();
        System.out.println("Digite el numero de días que laboro el trabajador: ");
        dia = teclado.nextInt();
        
        devengadoClase.ingresarDatos();
        deducidoClase.ingresarDatos();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void calcularNomina()
    {
        
        System.out.print('\u000C');
        int nuevoEmpleado = 1;
        while (nuevoEmpleado == 1)
        {
            System.out.println("El nombre del empleado es: "+nombre);
            System.out.println("El salario munsual del empleado es: $"+salario);
            System.out.println("Los días laborados por el empleado es: "+dia);
            long totalSalario = calcularTotalSalario();
            System.out.println("El total del salario es: $"+totalSalario);
            long totalConDevengado = devengadoClase.calcularTotalConDevengado(totalSalario);
            System.out.println("El total devengado es: $"+totalConDevengado);
            long totalDeducido = deducidoClase.calcularTotalDeducido(totalConDevengado);
            System.out.println("El total deducido es: $"+totalDeducido);
            long totalPagar = totalConDevengado - totalDeducido;
            System.out.println("El total a pagar al trabajdor es: $"+ totalPagar);
            
            System.out.println("Desea registrar la nomina de otro empleado 1(si)/2(no): ");
            nuevoEmpleado = teclado.nextInt();
            
            ingresarDatos();
        }
       
        
    }
    
    private long calcularTotalSalario()
    {
        return (dia*salario)/30;
    }
}
