
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante
{
    //Se crean los atributos del metodo Estudiante, con su tipo dato
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long numeroCelular;
    private long numeroTelefonico;
    private String programa;
    
    /*
    * Se genera el uso de las funciones get y set para la captura e impresión de cada uno de los atributos
    */
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellido()
    {
        return this.apellido;
    }
    
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public String getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getCorreoInstitucional()
    {
        return this.correoInstitucional;
    }
    
    public void setCorreoInstitucional(String correoInstitucional)
    {
        this.correoInstitucional = correoInstitucional;
    }
    
    public String getCorreoPersonal()
    {
        return this.correoPersonal;
    }
    
    public void setCorreoPersonal(String correoPersonal)
    {
        this.correoPersonal = correoPersonal;
    }
    
    public long getNumeroCelular()
    {
        return this.numeroCelular;
    }
    
    public void setNumeroCelular(long numeroCelular)
    {
        this.numeroCelular = numeroCelular;
    }
    
    public long getNumeroTelefonico()
    {
        return this.numeroTelefonico;
    }
    
    public void setNumeroTelefonico(long numeroTelefonico)
    {
        this.numeroTelefonico = numeroTelefonico;
    }
    
    public String getPrograma()
    {
        return this.programa;
    }
    
    public void setPrograma(String programa)
    {
        this.programa = programa;
    }
}
