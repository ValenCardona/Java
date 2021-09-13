
/**
 * Clase Menu para crear el reto 2.
 * Autora: Valentina Cardona Ligarreto
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    // utilizando el objeto entrada obtendremos lo que el usuario ingrese por consola.
    Scanner entrada = new Scanner(System.in);
    // Creamos la lista en dónde serán almacenados los vehiculos:
    ArrayList<Estudiante> listadoEstudiante = new ArrayList<>();
    // Se crea el atributo opciuon para poder señalar la opcion que se desea realizar..
    private int opcion;

    public void opcionMenu()
    {
        // Le indicamos al usuario cuales son sus opciones:
        try { 
            Thread.sleep(1000); 
        } catch (InterruptedException e) { 

        }
        System.out.print("\n");
        System.out.println("INSTITUTO LA FLORESTA");
        System.out.println("Seleccione tarea a realizar:");
        System.out.println("1. Ingresar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Modificar estudiante");
        System.out.println("4. Eliminar Estudiante");
        System.out.println("5. Ver directorio de estudiantes");
        System.out.println("6. Salir");
        System.out.println("Opción");
        
        opcion = Integer.parseInt(entrada.nextLine());
        
        
    }
    
    public void menu()
    {
        do
        {
            opcionMenu();
            //Se utiliza el condicional Sitch/Case, para poder ingresar a cada una de las opciones del menu
            switch(opcion)
            {
               case 1: //Ingresar un estudiante
                   System.out.println("\nIngresar estudiante");
                   // Instanciamos un estudiante vacio (Sin atributos)
                   Estudiante estu = new Estudiante();
                   System.out.println("Ingresar nombres:\n");
                   // Obtenemos el nombre que el usuario escribió y la guardamos en el Estudiante.
                   estu.setNombre(entrada.nextLine());
                   System.out.println("Ingresar apellidos:\n");
                   // De la misma manera obtenemos el apellido del estudiante y se guarda.
                   estu.setApellido(entrada.nextLine());
                   System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
                   // Se guarda la fecha de nacimiento del estudiante.
                   estu.setFechaNacimiento(entrada.nextLine());
                   System.out.println("Ingresar correo institucional:\n");
                   // Se guarda el correo institucional del estudiante.
                   estu.setCorreoInstitucional(entrada.nextLine());
                   System.out.println("Ingresar correo personal:\n");
                   // Se guarda el correo personal del estudiante.
                   estu.setCorreoPersonal(entrada.nextLine());
                   System.out.println("Ingresar número de celular:\n");
                   // Se guarda el numero de celular del estudiante.
                   estu.setNumeroCelular(Long.parseLong(entrada.nextLine()));
                   System.out.println("Ingresar número fijo:\n"); 
                   // Se guarda el numero telefonico fijo del estudiante.
                   estu.setNumeroTelefonico(Long.parseLong(entrada.nextLine()));
                   System.out.println("Ingresar programa:\n");
                   // Se guarda el programa al que pertenece el estudiante.
                   estu.setPrograma(entrada.nextLine());
                   // Y lo guardamos en la lista de vehiculos utilizando el método de la lista .add(estu)
                   listadoEstudiante.add(estu);
                   // Le avisamos al usuario que el studiante ha sido agregado
                   System.out.println("Se agregó el estudiante\n");
                   break;
               case 2:
                   //Se genera la opción dos que es buscar un estudiante
                   System.out.println("\nBuscar estudiante");
                   // el for va a recorrer todos los elementos que estén almacenados en la lista.
                   System.out.println("Ingresar correo institucional:\n");
                   String correosInstitucional = entrada.nextLine();
                   for(int i = 0; i < listadoEstudiante.size(); i++) // listavehiculos.size() Permite ver cuantos elementos hay guardados.
                   { 
                     // Para obtener un elemento de la lista, utilizamos .get():
                    Estudiante estud =  listadoEstudiante.get(i); 
                    //En el siguiente if se muestra toda la informacion almacenada del estudiante a buscar
                    if (correosInstitucional.equals(estud.getCorreoInstitucional())) {
                        System.out.println("Información del estudiante");
                        System.out.println("Nombres: " + estud.getNombre());
                        System.out.println("Apellidos: " + estud.getApellido());
                        System.out.println("Fecha nacimiento: " + estud.getFechaNacimiento());
                        System.out.println("Correo institucional: " + estud.getCorreoInstitucional());
                        System.out.println("Correo personal: " + estud.getCorreoPersonal());
                        System.out.println("Número de teléfono celular: " + estud.getNumeroCelular());
                        System.out.println("Número de teléfono fijo: " + estud.getNumeroTelefonico());
                        System.out.println("Programa académico: " + estud.getPrograma()+"\n");
                    }
                   }
                   break;
               case 3:
                   //Se ingresa a la opcion 3 que es modificar los datos de un estudiante
                   System.out.println("\nModificar estudiante");
                   //Para poder buscar el estudiante al que se le desea modificar la informacion se pide el correo institucional para buscarlo y acceder a su información
                   System.out.println("Ingresar correo institucional:\n");
                   String correoInstitucional = entrada.nextLine();
                   /* de nuevo, en síntesis lo que sucede acá es que vamos a buscar cual de
                   todas los correos ingresador corresponde al que se busca, 
                   para así modificar el número celular, fijo y el programa.*/
                   for (int i = 0; i < listadoEstudiante.size(); i++) 
                   {
                       Estudiante estud = listadoEstudiante.get(i);
                       if ((correoInstitucional.equals(estud.getCorreoInstitucional())))
                       {
                        System.out.println("Ingresar correo personal:\n");
                        String correoPersonal = entrada.nextLine();
                        estud.setCorreoPersonal(correoPersonal);
                        
                        System.out.println("Ingresar número de celular:\n");
                        long celular = entrada.nextLong();
                        estud.setNumeroCelular(celular);
                        
                        System.out.println("Ingresar número fijo:");
                        long telefono = entrada.nextLong();
                        estud.setNumeroTelefonico(telefono);
                    
                        System.out.println("Ingresar programa:");
                        String programa = entrada.next();                    
                        estud.setPrograma(programa);  
                        entrada.nextLine();                    

                        System.out.println("Se modificó el estudiante\n");                  
                       }
                    }

                   break;
               case 4:
                   //Se ingresa a la opcion 4 para eliminar un estudiante
                   System.out.println("\nEliminar estudiante");
                   /*Para buscar el estudian que se desea eliminar
                    se pide ingresar el correo institucional*/
                   System.out.println("Ingresar correo institucional:\n");
                   correoInstitucional= entrada.nextLine();
                   
                   for (int i = 0; i < listadoEstudiante.size(); i++) 
                   {
                       Estudiante estud = listadoEstudiante.get(i);
                       // buscamos cual de los correos ingresados
                       //uario escribió:
                       if (correoInstitucional.equals(estud.getCorreoInstitucional())) 
                       {
                           // Eliminamos un elemento de la lista utilizando .remove()
                           listadoEstudiante.remove(i);
                           System.out.println("Se eliminó el estudiante\n");
                        }
                   }
                   break;
               case 5:
                   //Se ingresa a la opción 5 para observar a todo el directorio de estudiantes
                   System.out.println("\nEl directorio de los estudiantes\n");
                   for(int i = 0; i < listadoEstudiante.size(); i++)
                   { // listadoEstudiante.size() Permite ver cuantos elementos hay guardados.
                    // Para obtener un elemento de la lista, utilizamos .get():
                    Estudiante estud =  listadoEstudiante.get(i); 

                    System.out.println("Nombres:  " + estud.getNombre());
                    System.out.println("Apellidos: " + estud.getApellido());
                    System.out.println("Fecha nacimiento: " + estud.getFechaNacimiento());
                    System.out.println("Correo institucional: " + estud.getCorreoInstitucional());
                    System.out.println("Correo personal:  " + estud.getCorreoPersonal());
                    System.out.println("Número de teléfono celular: " + estud.getNumeroCelular());
                    System.out.println("Número de teléfono fijo: " + estud.getNumeroTelefonico());
                    System.out.println("Programa académico: " + estud.getPrograma());

                }
                   break;
               case 6:
                   //Se ingresa a la ultima opción para salir del programa y este arroja un ultimo mensaje.
                   System.out.println("\nHasta pronto");
                   System.exit(0);
                   break;
            }
        }while (opcion != 6);
    }
}
