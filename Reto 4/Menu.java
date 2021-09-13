import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu
{
    // instance variables - replace the example below with your own
    Scanner entrada = new Scanner(System.in);
    Archivo archivo = new Archivo();
    Estudiante estudiante = new Estudiante();
    private int opcion, opcion1;
    private long numeroCelular;
    private long numeroTelefonico;
    
    public void opcionMenu()
    {
        // Le indicamos al usuario cuales son sus opciones:
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 

        }
        System.out.println("INSTITUTO LA FLORESTA");
        System.out.println("Seleccione tarea a realizar:");
        System.out.println("1. Ingresar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Modificar estudiante");
        System.out.println("4. Eliminar Estudiante");
        System.out.println("5. Ver directorio de estudiantes");
        System.out.println("6. Salir");
        System.out.println("Opción:");
        
        opcion = Integer.parseInt(entrada.nextLine());
        
        
    }
    public void opcionMenu1()
    {
        // Le indicamos al usuario cuales son sus opciones:
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 

        }
        System.out.print("\n");
        System.out.println("Consultas");
        System.out.println("Seleccione consulta a realizar:");
        System.out.println("1. Buscar estudiante por correo electrónico");
        System.out.println("2. Buscar estudiante por apellidos");
        System.out.println("3. Buscar por programa");
        System.out.println("4. Buscar cantidad de estudiantes por programa");
        System.out.println("5. Buscar por fecha de nacimiento");
        System.out.println("6. Buscar por número de celular");
        System.out.println("Opción:");
        
        opcion1 = Integer.parseInt(entrada.nextLine());
        
        
    }
    public void menu()
    {
        do
        {
           opcionMenu();
           switch(opcion)
           {
               case 1:
                   ingresarEstudiante();
                   break;
               case 2:
                   opcionMenu1();
                   switch(opcion1)
                   {
                       case 1:
                           buscarCorreo();
                           break;
                       case 2:
                           buscarApellido();
                           break; 
                       case 3:
                           buscarPrograma();
                           break;    
                       case 4:
                           buscarCantPrograma();
                           break;
                       case 5:
                           buscarFecha();
                           break; 
                       case 6:
                           buscarCelular();
                           break; 
                   }
                   break;
               case 3:
                   modificar();                   
                   break;
               case 4:
                   eliminar();
                   break;
               case 5:
                   mostrar();
                   break;
               case 6:
                   System.out.println("Hasta Pronto\n");
                   break; 
           }
        }while (opcion != 6);
    }

    public void ingresarEstudiante()
    {
       System.out.println("\nIngresar estudiante");
       System.out.println("Ingresar nombres:\n");
       // Obtenemos el nombre que el usuario escribió y la guardamos en el Estudiante.
       estudiante.setNombre(entrada.nextLine());
       System.out.println("Ingresar apellidos:\n");
       // De la misma manera obtenemos el apellido del estudiante y se guarda.
       estudiante.setApellido(entrada.nextLine());
       System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
       // Se guarda la fecha de nacimiento del estudiante.
       estudiante.setFechaNacimiento(entrada.nextLine());
       System.out.println("Ingresar correo institucional:\n");
       // Se guarda el correo institucional del estudiante.
       estudiante.setCorreoInstitucional(entrada.nextLine());
       System.out.println("Ingresar correo personal:\n");
       // Se guarda el correo personal del estudiante.
       estudiante.setCorreoPersonal(entrada.nextLine());
       
       try
       {
          System.out.println("Ingresar número de celular:\n");
          // Se guarda el numero de celular del estudiante
          estudiante.setNumeroCelular(Long.parseLong(entrada.nextLine()));
          
       } 
       catch(Exception e)
       {
            numeroCelular = 0;
       }
       // Se guarda el numero telefonico fijo del estudiante.
       try
       {
          System.out.println("Ingresar número fijo:\n"); 
          estudiante.setNumeroTelefonico(Long.parseLong(entrada.nextLine()));
          
       } 
       catch(Exception e)
       {
            numeroTelefonico = 0;
       }
       // Se guarda el programa al que pertenece el estudiante.
       System.out.println("Ingresar programa:\n"); 
       estudiante.setPrograma(entrada.nextLine());
       // Y lo guardamos en la lista de vehiculos utilizando el método de la lista .add(estu)
       try {
            Statement comando=archivo.getConnection().createStatement();
            //System.out.println("Conectado!!"+archivo.getbd());
            comando.executeUpdate("insert into infoestudiantes(Nombres,Apellidos,FechaNacimiento, CorreoInstitucional, CorreoPersonal, NumeroCelular, NumeroFijo, ProgramaAcademico)values ('"
            +estudiante.getNombre() +"','"+estudiante.getApellido()+"','"+estudiante.getFechaNacimiento()+"','"+estudiante.getCorreoInstitucional()+
            "','" + estudiante.getCorreoPersonal()+"','"+estudiante.getNumeroCelular() + "','" + estudiante.getNumeroTelefonico() + "','" + estudiante.getPrograma()+"')");
            System.out.println("Se agregó el estudiante\n");

        } catch(SQLException ex){
            System.out.println(ex.toString());
        } 
       
    }
    
    public void buscarCorreo()
    {
        //Se genera la opción dos que es buscar un estudiante
        System.out.println("\n1.Buscar estudiante por correo institucional");
        System.out.println("Ingresar correo institucional:\n");
        estudiante.setCorreoInstitucional(entrada.next());
        entrada.nextLine();
        
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "select * from infoestudiantes where CorreoInstitucional = '"+estudiante.getCorreoInstitucional()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                String fechaNacimiento = registro.getString("FechaNacimiento");
                String correoInstitucional = registro.getString("CorreoInstitucional");
                String correoPersonal = registro.getString("CorreoPersonal");
                long numeroCelular = registro.getLong("NumeroCelular");
                long numeroTelefonico = registro.getLong("NumeroFijo");
                String programa = registro.getString("ProgramaAcademico");
                
                System.out.println("Información del estudiante");
                System.out.println("Nombres: " + nombre);
                System.out.println("Apellidos: " + apellido);
                System.out.println("Fecha nacimiento: " + fechaNacimiento);
                System.out.println("Correo institucional: " + correoInstitucional);
                System.out.println("Correo personal: " + correoPersonal);
                System.out.println("Número de teléfono celular: " + numeroCelular);
                System.out.println("Número de teléfono fijo: " + numeroTelefonico);
                System.out.println("Programa académico: " + programa+"\n");
            }

        } catch(SQLException ex){
            System.out.println("El estudiante no se encuentra registrado");
        }
    }
    
    public void buscarApellido()
    {
        //Se genera la opción dos que es buscar un estudiante
        System.out.println("\n2.Buscar estudiante por apellidos");
        System.out.println("Ingresar apellidos:\n");
        estudiante.setApellido(entrada.nextLine());
        
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "select * from infoestudiantes where Apellidos = '"+estudiante.getApellido()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                String fechaNacimiento = registro.getString("FechaNacimiento");
                String correoInstitucional = registro.getString("CorreoInstitucional");
                String correoPersonal = registro.getString("CorreoPersonal");
                long numeroCelular = registro.getLong("NumeroCelular");
                long numeroTelefonico = registro.getLong("NumeroFijo");
                String programa = registro.getString("ProgramaAcademico");
                
                System.out.println("Información del estudiante");
                System.out.println("Nombres: " + nombre);
                System.out.println("Apellidos: " + apellido);
                System.out.println("Fecha nacimiento: " + fechaNacimiento);
                System.out.println("Correo institucional: " + correoInstitucional);
                System.out.println("Correo personal: " + correoPersonal);
                System.out.println("Número de teléfono celular: " + numeroCelular);
                System.out.println("Número de teléfono fijo: " + numeroTelefonico);
                System.out.println("Programa académico: " + programa+"\n");
            }

        } catch(SQLException ex){
            System.out.println("El estudiante no se encuentra registrado");
        }
        
    }
    
    public void buscarPrograma()
    {
        //Se genera la opción dos que es buscar un estudiante
        System.out.println("\n3.Buscar por programa");
        System.out.println("Ingresar programa:\n");
        estudiante.setPrograma(entrada.next());
        entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "select Nombres,Apellidos from infoestudiantes where ProgramaAcademico = '"+estudiante.getPrograma()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                
                System.out.println(apellido + "\t" + nombre + "\n");
                
            }

        } catch(SQLException ex){
            System.out.println("El estudiante no se encuentra registrado");
        }
        
    }
    
    public void buscarCantPrograma()
    {
        //Se genera la opción dos que es buscar un estudiante
        System.out.println("\n4.Buscar cantidad de estudiantes por programa");
        System.out.println("Ingresar programa:\n");
        estudiante.setPrograma(entrada.nextLine());
        //entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "SELECT COUNT(*) As total from infoestudiantes where ProgramaAcademico ='"+estudiante.getPrograma()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                int cantidad = registro.getInt(1);
                System.out.println("Cantidad estudiantes " + estudiante.getPrograma() + ":" + cantidad + "\n");                
            }

        } catch(SQLException ex){
            //System.out.println(ex);
            System.out.println("No hay estudiantes registrados");
        }
        
    }
    
    public void buscarFecha()
    {
        System.out.println("\n5.Buscar estudiante por fecha de nacimiento");
        System.out.println("Ingresar fecha de nacimiento:\n");
        estudiante.setFechaNacimiento(entrada.next());
        entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "select * from infoestudiantes where FechaNacimiento = '"+estudiante.getFechaNacimiento()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                String fechaNacimiento = registro.getString("FechaNacimiento");
                String correoInstitucional = registro.getString("CorreoInstitucional");
                String correoPersonal = registro.getString("CorreoPersonal");
                long numeroCelular = registro.getLong("NumeroCelular");
                long numeroTelefonico = registro.getLong("NumeroFijo");
                String programa = registro.getString("ProgramaAcademico");
                
                System.out.println("Información del estudiante");
                System.out.println("Nombres: " + nombre);
                System.out.println("Apellidos: " + apellido);
                System.out.println("Fecha nacimiento: " + fechaNacimiento);
                System.out.println("Correo institucional: " + correoInstitucional);
                System.out.println("Correo personal: " + correoPersonal);
                System.out.println("Número de teléfono celular: " + numeroCelular);
                System.out.println("Número de teléfono fijo: " + numeroTelefonico);
                System.out.println("Programa académico: " + programa+"\n");
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        try { 
            Thread.sleep(5000); 
        } catch (InterruptedException e) { 

        }
    }
    
    public void buscarCelular()
    {
        System.out.println("\n6.Buscar estudiante por númer celular");
        System.out.println("Ingresar número celular:\n");
        estudiante.setNumeroCelular(entrada.nextLong());
        entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            String consulta = "select Nombres, Apellidos, ProgramaAcademico from infoestudiantes where NumeroCelular = '"+estudiante.getNumeroCelular()+"'"; 
            ResultSet registro = comando.executeQuery(consulta);
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                String programa = registro.getString("ProgramaAcademico");
                
                System.out.println(apellido + "\t" + nombre + "\t" + programa+"\n");
                
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        try { 
            Thread.sleep(5000); 
        } catch (InterruptedException e) { 

        }
    }
    public void eliminar()
    {
        System.out.println("\nEliminar estudiante");
        System.out.println("Ingrese el correo institucional:\n");
        estudiante.setCorreoInstitucional(entrada.next());
        entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            int cantidad = comando.executeUpdate("delete from infoestudiantes where CorreoInstitucional='"+estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {

                System.out.println("Se eliminó el estudiante \n");
            } else {
                System.out.println("El estudiante no se encuentra registrado en el instituto \n");
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void modificar()
    {
        System.out.println("\nModificar estudiante");
        System.out.println("Ingresar correo Institucional:\n");
        estudiante.setCorreoInstitucional(entrada.nextLine());
        System.out.println("Ingresar correo personal:\n");
        estudiante.setCorreoPersonal(entrada.next());
        System.out.println("Ingresar número de celular:\n");
        estudiante.setNumeroCelular(entrada.nextLong());
        System.out.println("Ingresar número fijo:\n");
        estudiante.setNumeroTelefonico(entrada.nextLong());
        System.out.println("Ingrese programa:\n");
        estudiante.setPrograma(entrada.next());
        entrada.nextLine();
        try {

            Statement comando=archivo.getConnection().createStatement();
            int cantidad = 
            comando.executeUpdate("update infoestudiantes set CorreoPersonal = '"
            + estudiante.getCorreoPersonal() + "',"+ "NumeroCelular = '" 
            + estudiante.getNumeroCelular() + "',"+ "NumeroFijo = '" 
            + estudiante.getNumeroTelefonico() + "'," 
            + "ProgramaAcademico = '" + estudiante.getPrograma() + "'"
            + "where CorreoInstitucional = '" 
            + estudiante.getCorreoInstitucional()+"'");
        
            if (cantidad==1) {
                System.out.println("Se modificó el estudiante \n");
            } else {
                System.out.println("No se encuentra registrado el estudiante");
            }
             comando.close();
        } catch(SQLException ex){
            System.out.println(ex.toString());
           
        }
    }
    
    public void mostrar()
    {
        System.out.println("\nEl directorio de los estudiantes");
        try {

            Statement comando=archivo.getConnection().createStatement();
            ResultSet registro = comando.executeQuery("SELECT * FROM infoestudiantes");
            while (registro.next()) {
                String nombre = registro.getString("Nombres");
                String apellido = registro.getString("Apellidos");
                String fechaNacimiento = registro.getString("FechaNacimiento");
                String correoInstitucional = registro.getString("CorreoInstitucional");
                String correoPersonal = registro.getString("CorreoPersonal");
                long numeroCelular = registro.getLong("NumeroCelular");
                long numeroTelefonico = registro.getLong("NumeroFijo");
                String programa = registro.getString("ProgramaAcademico");
                
                System.out.println("\n");
                System.out.println("Nombres: " + nombre);
                System.out.println("Apellidos: " + apellido);
                System.out.println("Fecha nacimiento: " + fechaNacimiento);
                System.out.println("Correo institucional: " + correoInstitucional);
                System.out.println("Correo personal: " + correoPersonal);
                System.out.println("Número de teléfono celular: " + numeroCelular);
                System.out.println("Número de teléfono fijo: " + numeroTelefonico);
                System.out.println("Programa académico: " + programa+"\n");
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
