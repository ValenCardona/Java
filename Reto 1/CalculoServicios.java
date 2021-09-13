import java.util.Scanner;
/**
 * Write a description of class CalculoServicios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalculoServicios
{
    private float descuento1;
    private float descuento2;
    private float sobrecarga1;
    private float totalValorAgua;
    private float totalValorLuz;
    private float totalValorGas;
    
   
    public void valorAgua(int estrato, int cantidad)
    {
        float consumo = (cantidad * 9256);
        float descuento;
        float impuesto;
        float sobrecarga;
        if ((estrato == 1) || (estrato == 2))
        {
            descuento = consumo * 50/100;
            descuento1 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorAgua = descuento1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 9256.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorAgua);       
        }
        else if((estrato == 3) || (estrato == 4))
        {
            descuento = consumo * 10/100;
            descuento2 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorAgua = descuento2 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 9256.0"); 
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorAgua);  
        }
        else if ((estrato == 5) || (estrato == 6))
        {
            sobrecarga = consumo * 25/100;
            sobrecarga1 = consumo + (sobrecarga);
            impuesto = consumo* 1/100;
            totalValorAgua = sobrecarga1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 9256.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: "+sobrecarga);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorAgua);  
        }
        
    }
    
    public void valorLuz(int estrato, int cantidad)
    {
        float consumo = (cantidad * 6200);
        float descuento;
        float impuesto;
        float sobrecarga;
        if ((estrato == 1) || (estrato == 2))
        {
            descuento = consumo * 50/100;
            descuento1 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorLuz = descuento1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 6200.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR:"+totalValorLuz);
        }
        else if((estrato == 3) || (estrato == 4))
        {
            descuento = consumo * 10/100;
            descuento2 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorLuz = descuento2 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 6200.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorLuz);
        }
        else if ((estrato == 5) || (estrato == 6))
        {
            sobrecarga = consumo * 25/100;
            sobrecarga1 = consumo + (sobrecarga);
            impuesto = consumo* 1/100;
            totalValorLuz = sobrecarga1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 6200.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: "+sobrecarga);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorLuz);
        } 
        
    }
    
    public void valorGas(int estrato, int cantidad)
    {
        float consumo = (cantidad * 5234);
        float descuento;
        float impuesto;
        float sobrecarga;
        if ((estrato == 1) || (estrato == 2))
        {
            descuento = consumo*50/100;
            descuento1 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorGas = descuento1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 5234.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorGas);
        }
        else if((estrato == 3) || (estrato == 4))
        {
            descuento = consumo * 10/100;
            descuento2 = consumo - (descuento);
            impuesto = consumo* 1/100;
            totalValorGas = descuento2 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 5234.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: -"+descuento);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorGas);
        }
        else if ((estrato == 5) || (estrato == 6))
        {
            sobrecarga = consumo * 25/100;
            sobrecarga1 = consumo + (sobrecarga);
            impuesto = consumo* 1/100;
            totalValorGas = sobrecarga1 + (impuesto);
            System.out.println("El consumo fue: "+cantidad);
            System.out.println("Valor unidad: 5234.0");
            System.out.println("Estrato del inmueble: "+estrato);
            System.out.println("Costo total: "+consumo);
            System.out.println("Descuento o sobrecosto: "+sobrecarga);
            System.out.println("Impuesto por infraestructura: "+impuesto);
            System.out.println("TOTAL A PAGAR: "+totalValorGas);
        } 
    }
}
