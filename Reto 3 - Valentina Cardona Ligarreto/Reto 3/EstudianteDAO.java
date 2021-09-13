import java.io.*;

import java.util.ArrayList;
public class EstudianteDAO
{
    // instance variables - replace the example below with your own
    private Archivo archivo;


    /**
     * Constructor for objects of class EstudianteDAO
     */
    public EstudianteDAO(Archivo arch)
    {
        // initialise instance variables
        archivo = arch;
    }

    public String verEstudiante(File file) {
        ArrayList<Estudiante> estudiantes = archivo.leerArchivo(file);
        String texto = "";
        for (int i = 0; i < estudiantes.size(); i++) {
            texto = texto.concat(estudiantes.get(i) + "\n");
        }
        return texto;
    }

    public Estudiante buscarEstudiante(String correoInstitucional, ArrayList<Estudiante> estudiantes) {
        Estudiante encontrado = null;

        if (!estudiantes.isEmpty()) {
            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).getCorreoInstitucional().equals(correoInstitucional)) {
                    encontrado = estudiantes.get(i);
                    
                }
            }
        }

        return encontrado;
    }

    public boolean agregarEstudiante(String nombre, String apellido, String fechaNacimiento, String correoInstitucional, String correoPersonal,  
    long numeroCelular, long numeroTelefonico, String programa,
    ArrayList<Estudiante> estudiantes,File file) 
    {
        Estudiante nuevo = new Estudiante(nombre, apellido, fechaNacimiento, correoInstitucional, correoPersonal, numeroCelular, numeroTelefonico, programa);

        if (buscarEstudiante(correoInstitucional, estudiantes) == null) {
            estudiantes.add(nuevo);
            archivo.escribirEnArchivo(estudiantes, file);
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminarEstudiante(String correoInstitucional, ArrayList<Estudiante> estudiantes, File file) {
        boolean resp = false;
        try {
            Estudiante e = buscarEstudiante(correoInstitucional,estudiantes);
            if (e != null) {
                estudiantes.remove(e);
                file.delete();
                file.createNewFile();
                archivo.escribirEnArchivo(estudiantes, file);
                resp = true;
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
        return resp;
    }
}
