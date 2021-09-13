
import java.io.Serializable;
public class Estudiante implements Serializable
{
    //Se crean los atributos del metodo Estudiante, con su tipo dato
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long numeroCelular;
    private long numeroTelefonico;
    private String programa;
    
    public Estudiante (String nombre, String apellido, String fechaNacimiento,
    String correoInstitucional, String correoPersonal, long numeroCelular, long numeroTelefonico, String programa)
    {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.numeroCelular = numeroCelular;
        this.numeroTelefonico = numeroTelefonico;
        this.programa = programa;
    }
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
    
    @Override
    public String toString() {
        return    "Nombres: " + nombre + 
        "\nApellidos: " + apellido + 
        "\nFecha nacimiento: " + fechaNacimiento+ 
        "\nCorreo institucional: " + correoInstitucional + 
        "\nCorreo personal: " + correoPersonal +
        "\nNúmero de teléfono celular: " +numeroCelular +
        "\nNúmero de teléfono fijo: "+numeroTelefonico +
        "\nPrograma académico: " + programa +"\n";
    }
}
