import java.io.File;
import java.util.ArrayList;
public class EstudianteDTO
{
    private ArrayList<Estudiante> estudiante;
    private EstudianteDAO EstudianteDAO;
    private File file = new File("datos_estudiantes.dat");
    private Archivo archivo;
    
    /**
     * Constructor for objects of class EstudianteDTO
     */
    public EstudianteDTO()
    {
        estudiante = new ArrayList<Estudiante>();
        archivo = new Archivo(file);
        EstudianteDAO = new EstudianteDAO(archivo);
        estudiante = archivo.leerArchivo(file);
    }

    public ArrayList<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ArrayList<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }

    public EstudianteDAO getEstudianteDAO() {
        return EstudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAO estudianteDAO) {
        this.EstudianteDAO = estudianteDAO;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}
