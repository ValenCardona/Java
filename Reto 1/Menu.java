import java.util.Scanner;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private int estrato;
    private int cantidad;
    private int opc; 
    Scanner teclado = new Scanner(System.in);
    CalculoServicios operacion = new CalculoServicios();

    /**
     * Constructor for objects of class Operaciones
     */
    public Menu()
    {
        // initialise instance variables
        this.estrato = estrato;
        this.opc = opc;
        this.cantidad = cantidad;
    }

    
    public void leerDatos()
    {
        // put your code here
        System.out.println("Estrato del inmueble:");
        estrato = teclado.nextInt();
        System.out.println("Consumo del inmueble:");
        cantidad = teclado.nextInt();
    }
    
    public void menu()
    {
        do
        {
            menuVista();
            switch(opc)
            {
               case 1:
                   System.out.println("Pago de Servicio de Energia");
                   leerDatos();
                   operacion.valorLuz(estrato, cantidad);
                   break;
               case 2:
                   System.out.println("Pago de Servicio de Acueducto");
                   leerDatos();
                   operacion.valorAgua(estrato, cantidad);
                   break;
               case 3:
                   System.out.println("Pago de Servicio de Gas Natural");
                   leerDatos();
                   operacion.valorGas(estrato, cantidad);
                   break;
               case 4:
                   System.out.println("Hasta pronto");
                   System.exit(0);
                   break;
            }
        }while (opc != 4);
    }
    
    public void menuVista()
    {
       /* try { 
            Thread.sleep(10000); 
        } catch (InterruptedException e) { 

        }*/
        System.out.print("\n");
        System.out.println("PAGO DE SERVICIOS PUBLICOS");
        System.out.println("Seleccione el servicio publico:");
        System.out.println("1. Energia");
        System.out.println("2. Acueducto");
        System.out.println("3. Gas natural");
        System.out.println("4. Salir");
        System.out.println("Opcion:");
        opc = teclado.nextInt();
    }
}
