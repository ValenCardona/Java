/**
 * Clase controlador en la que se ejecuta el funcionamiento del programa para el reto 3, en esta clase se en cuentra 
 * el menu para acceder a cada una de las funciones
 */
public class Controlador
{
    // instance variables - replace the example below with your own
    private Vista vista;
    private EstudianteDTO estudiante;

    /**
     * Constructor for objects of class Controlador
     */
    public Controlador()
    {
        // initialise instance variables
        vista = new Vista();
        estudiante = new EstudianteDTO();
        menu();
    }

    /**
     * Metodo menu, en la que se muestran las opciones a las que se pueden acceder y se direcciona a la opción seleccionada
     */
    public void menu()
    {
        int op = 0;
        String menuOpc = "INSTITUTO LA FLORESTA" + "\n"+
            "Seleccione tarea a realizar:"+ "\n"+
            "1. Ingresar estudiante"+ "\n"+
            "2. Buscar estudiante"+ "\n"+
            "3. Modificar estudiante"+ "\n"+
            "4. Eliminar Estudiante"+ "\n"+
            "5. Ver directorio de estudiantes"+ "\n"+
            "6. Salir"+ "\n"+
            "Opción:";
        do{  
            try 
            { 
                Thread.sleep(5000); 
            } catch (InterruptedException err) 
            { 

            }
            //System.out.print('\u000C');
            op = vista.leerDatoEntero(menuOpc);
            switch(op)
            {
                case 1:
                ingresarEstudiante();
                break;
                case 2:
                buscarEstudiante();
                break;
                case 3:
                modificarEstudiante();
                break;
                case 4:
                eliminarEstudiante();
                break;
                case 5:
                mostrarEstudiante();
                break;
                case 6:
                vista.mostrarInformacion("\nHasta pronto");
                break;
                default:
                vista.mostrarInformacion("\nError: Opción no válida");
            }
        }while(op!=6);
    }
    
    /**
     * Se hace el metodo ingresar estudiante, aqui se la pide al usuario que digite los datos de cada estudiante
     */
    public void ingresarEstudiante()
    {
        String nombre = "" , apellido = "", fechaNacimiento = "", correoPersonal = "", correoInstitucional = "", programa = "";
        long numeroCelular = 0, numeroTelefonico = 0;
        vista.mostrarInformacion("\nIngresar estudiante");
        nombre = vista.leerDatoString("Ingresar nombres:\n");
        apellido = vista.leerDatoString("Ingresar apellidos:\n");
        fechaNacimiento = vista.leerDatoString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
        correoInstitucional = vista.leerDatoString("Ingresar correo institucional:\n");
        correoPersonal = vista.leerDatoString("Ingresar correo personal:\n");
        numeroCelular = vista.leerDatoLong("Ingresar número de celular:\n");
        numeroTelefonico = vista.leerDatoLong("Ingresar número fijo:\n");
        programa = vista.leerDatoString("Ingresar programa:\n");
        /* se envia los datos al metodo  agregarVehiculo de la clase Estudiante DAO*/
        if(estudiante.getEstudianteDAO().agregarEstudiante(nombre, apellido,
        fechaNacimiento, correoInstitucional, correoPersonal, 
        numeroCelular, 
        numeroTelefonico, programa, estudiante.getEstudiante(), 
        estudiante.getFile()))
        {
            vista.mostrarInformacion("Se agregó el estudiante\n");
        }
        else
        {
            vista.mostrarInformacion("Se agregó el estudiante\n");
        }

    }

    /**
     * Se realiza la clase buscar estudiante, este metodo se hace filtrando el correo institucional, cuando se encuentra se muestra 
     * la informacion del estudiante buscado, en caso que no dice que el estudiante no se encuentra registrado
     */
    public void buscarEstudiante()
    {
        String correoInstitucional = "";
        vista.mostrarInformacion("\nBuscar estudiante");
        correoInstitucional = vista.leerDatoString("Ingresar correo institucional:\n");
        vista.mostrarInformacion("Información del estudiante");
        Estudiante rta = estudiante.getEstudianteDAO().buscarEstudiante(correoInstitucional, estudiante.getEstudiante()) ;       
        if(rta != null)
        {
            vista.mostrarInformacion(rta.toString());
        }
        else
        {
            vista.mostrarInformacion("El estudiante no se encuentra registrado\n");
        }
    }

    /**
     * Se realiza la clase modificar estudiante, este metodo se hace filtrando el correo institucional, cuando se encuentra se 
     * pide el correo personal, los numeros de celular y telefonico y el programa academico,
     * en caso que no dice que el estudiante no se encuentra registrado 
     */
    public void modificarEstudiante()
    {
        String nombre = "" , apellido = "", fechaNacimiento = "", correoPersonal = "", correoInstitucional = "", programa = "";
        long numeroCelular = 0, numeroTelefonico = 0;
        vista.mostrarInformacion("\nModificar estudiante");
        correoInstitucional = vista.leerDatoString("Ingresar correo institucional:\n");
        Estudiante rta = estudiante.getEstudianteDAO().buscarEstudiante(correoInstitucional, estudiante.getEstudiante()) ;       
        if(rta != null)
        {
            nombre = rta.getNombre();
            apellido = rta.getApellido();
            fechaNacimiento = rta.getFechaNacimiento();
            correoInstitucional = rta.getCorreoInstitucional();
            correoPersonal = vista.leerDatoString("Ingresar correo personal:\n");
            numeroCelular = vista.leerDatoLong("Ingresar número de celular:\n");
            numeroTelefonico = vista.leerDatoLong("Ingresar número fijo:\n");
            programa = vista.leerDatoString("Ingresar programa:\n");
            estudiante.getEstudianteDAO().eliminarEstudiante(correoInstitucional, estudiante.getEstudiante(), estudiante.getFile());
            estudiante.getEstudianteDAO().agregarEstudiante(nombre, apellido, fechaNacimiento, correoInstitucional, correoPersonal, numeroCelular, numeroTelefonico, programa, estudiante.getEstudiante(), estudiante.getFile());
            vista.mostrarInformacion("Se modificó el estudiante\n");
        }
        else
        {
            vista.mostrarInformacion("El estudiante no se encuentra registrado \n");
        }
    }

    /**
     * Se realiza la clase eliminar estudiante, este metodo se hace filtrando el correo institucional, cuando se encuentra se
     * elimina al estudiente
     */
    public void eliminarEstudiante()
    {
        String correoInstitucional = "";
        vista.mostrarInformacion("\nEliminar estudiante");
        correoInstitucional = vista.leerDatoString("Ingresar correo institucional:\n");
        if(estudiante.getEstudianteDAO().eliminarEstudiante(correoInstitucional, estudiante.getEstudiante(), estudiante.getFile()))
        {
            vista.mostrarInformacion("Se eliminó el estudiante\n");
        }
        else
        {
            vista.mostrarInformacion("El estudiante no se encuentra \n");
        }
    }

    /**
     * Se realiza la clase mostrar estudiante, en donde se puede ver todo el directorio de los estudiante.
     */
    public void mostrarEstudiante()
    {
        vista.mostrarInformacion("\nEl directorio de los estudiantes\n");
        vista.mostrarInformacion(estudiante.getEstudianteDAO().verEstudiante(estudiante.getFile()));
    }
}