import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Archivo 
{

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Archivo(File archivo) 
    {
        if (archivo.exists()) 
        {

        } else
        {
            try 
            {
                archivo.createNewFile();
            } 
            catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void escribirEnArchivo(ArrayList<Estudiante> estudiante, File archivo) 
    {
        try 
        {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(estudiante);
            salida.close();
        } 
        catch (FileNotFoundException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Estudiante> leerArchivo(File archivo) 
    {

        ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();
        if (archivo.length() != 0)
        {
            try 
            {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                estudiante = (ArrayList<Estudiante>) entrada.readObject();
            } 
            catch (FileNotFoundException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return estudiante;
    }

    public ObjectInputStream getEntrada() 
    {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) 
    {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida()
    {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida)
    {
        this.salida = salida;
    }

}
