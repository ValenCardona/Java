import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Menu extends JFrame implements ActionListener
{
    private JPanel pnlTitulo;
    private JPanel pnlOperacion;
    private JPanel pnlBotones;
    private JLabel lblTitulo;
    private JLabel lblnombre;
    private JLabel lblapellido;
    private JLabel lblfecha;
    private JLabel lblcorreoI;
    private JLabel lblcorreoP;
    private JLabel lblcelular;
    private JLabel lblfijo;
    private JLabel lblprograma;
    private JLabel lblConsu1; //correo insitucional
    private JLabel lblCantidadPrograma;
    private JTextField txtnombre;
    private JTextField txtapellido;
    private JTextField txtfecha;
    private JTextField txtcorreoI;
    private JTextField txtcorreoP;
    private JTextField txtcelular;
    private JTextField txtfijo;
    private JTextField txtprograma;
    private JTextField txtConsu1;
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnSalir;
    private JButton btnMostrar;
    private Container contenedor;
    Archivo archivo = new Archivo();
    Estudiante estudiante = new Estudiante();
    private int opcion, opcion1;
    private long numeroCelular;
    private long numeroTelefonico;
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        //definicion objetos panel del titulo
        this.pnlTitulo = new JPanel();
        this.lblTitulo = new JLabel("INSTITUTO LA FLORESTA");
        pnlTitulo.add(lblTitulo);
        //definicion panel de objetos de las operaciones
        this.pnlOperacion = new JPanel();
        this.pnlOperacion.setLayout(new GridLayout(9,1));
        this.lblnombre = new JLabel("Nombres ");
        this.txtnombre = new JTextField(20);
        this.lblapellido = new JLabel("Apellidos ");
        this.txtapellido = new JTextField(20);
        this.lblfecha = new JLabel("Fecha nacimiento");
        this.txtfecha = new JTextField(20);
        this.lblcorreoI = new JLabel("Correo institucional");
        this.txtcorreoI = new JTextField(20);
        this.lblcorreoP = new JLabel("Correo personal");
        this.txtcorreoP = new JTextField(20);
        this.lblcelular = new JLabel("Número celular");
        this.txtcelular = new JTextField(20);
        this.lblfijo = new JLabel("Numero fijo");
        this.txtfijo = new JTextField(20);
        this.lblprograma = new JLabel("Programa");
        this.txtprograma = new JTextField(20);
        this.lblConsu1 = new JLabel("Buscar estudiante por correo institucional");
        this.txtConsu1 = new JTextField(20);
        
        //adicionar objetos al panel transaccion
        pnlOperacion.add(lblnombre);
        pnlOperacion.add(txtnombre);
        pnlOperacion.add(lblapellido);
        pnlOperacion.add(txtapellido);
        pnlOperacion.add(lblfecha);
        pnlOperacion.add(txtfecha);
        pnlOperacion.add(lblcorreoI);
        pnlOperacion.add(txtcorreoI);
        pnlOperacion.add(lblcorreoP);
        pnlOperacion.add(txtcorreoP);
        pnlOperacion.add(lblcelular);
        pnlOperacion.add(txtcelular);
        pnlOperacion.add(lblfijo);
        pnlOperacion.add(txtfijo);
        pnlOperacion.add(lblprograma);
        pnlOperacion.add(txtprograma);
        pnlOperacion.add(lblConsu1);
        pnlOperacion.add(txtConsu1);
     
        //definicion panel de los botones
        this.pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(6,1));
        this.btnNuevo = new JButton("Limpiar");
        this.btnGuardar = new JButton("Guardar");
        this.btnConsultar = new JButton("Busqueda");
        this.btnActualizar = new JButton("Actualizar");
        this.btnEliminar = new JButton("Eliminar");
        //this.btnMostrar = new JButton("Mostrar");
        this.btnSalir = new JButton("Salir");
        //adicionar objetos al panel botones
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnConsultar);
        pnlBotones.add(btnActualizar);
        pnlBotones.add(btnEliminar);
        //pnlBotones.add(btnMostrar);
        pnlBotones.add(btnSalir);
        
        // suscribimos los botones a la accion que java considera mÃ¡s importante para ese componente
        btnNuevo.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        //btnMostrar.addActionListener(this);
        btnSalir.addActionListener(this);
        
        // el contenedor obtiene el frame donde ubica los objetos graficos
        this.contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(pnlTitulo, BorderLayout.NORTH);
        contenedor.add(pnlOperacion,BorderLayout.CENTER);
        contenedor.add(pnlBotones,BorderLayout.EAST);
        //sentencias menejo de la ventana
        //Archivo men = new archi();
        setTitle(archivo.result);
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) 
    {
        if(evento.getSource()==btnNuevo){
            Nuevo();

        }
        if(evento.getSource()==btnGuardar){
            Guardar();
        } 
        else    if(evento.getSource()==btnConsultar){
            BuscarCorreo();
        } 
        else    if(evento.getSource()==btnActualizar){
            Modificar();
        }     else    if(evento.getSource()==btnEliminar){
            Eliminar();
        } 
        /*else if(evento.getSource() == btnMostrar)
        {
            mostrar();
        }*/
        else if(evento.getSource()==btnSalir){
            System.exit(0);
        }

    }
    
    private void Nuevo() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtfecha.setText("");
        txtcorreoI.setText("");
        txtcorreoP.setText("");
        txtcelular.setText("");  
        txtfijo.setText("");
        txtprograma.setText("");
        txtConsu1.setText("");
        txtnombre.requestFocus();

    }
    
    private void Guardar()
    {
        Estudiante estudiante = new Estudiante();
        try {

            Statement comando=archivo.getConnection().createStatement();
            estudiante.setNombre(txtnombre.getText());
            estudiante.setApellido(txtapellido.getText());
            estudiante.setFechaNacimiento(txtfecha.getText());
            estudiante.setCorreoInstitucional(txtcorreoI.getText());
            estudiante.setCorreoPersonal(txtcorreoP.getText());
            try
            {
                // Se guarda el numero de celular del estudiante
                estudiante.setNumeroCelular(Long.parseLong(txtcelular.getText())); 
                  
            } 
            catch(Exception e)
            {
                numeroCelular = 0;
            }
            try
            {
               estudiante.setNumeroTelefonico(Long.parseLong(txtfijo.getText())); 
          
            } 
            catch(Exception e)
            {
                numeroTelefonico = 0;
            }
            estudiante.setPrograma(txtprograma.getText());

            comando.executeUpdate("insert into infoestudiantes(Nombres,Apellidos,FechaNacimiento, CorreoInstitucional, CorreoPersonal, NumeroCelular, NumeroFijo, ProgramaAcademico)values ('"
            +estudiante.getNombre() +"','"+estudiante.getApellido()+"','"+estudiante.getFechaNacimiento()+"','"+estudiante.getCorreoInstitucional()+
            "','" + estudiante.getCorreoPersonal()+"','"+estudiante.getNumeroCelular() + "','" + estudiante.getNumeroTelefonico() + "','" + estudiante.getPrograma()+"')");   
            setTitle("Se Registraron Los Datos");
            Nuevo(); 
        } catch(SQLException ex){
            setTitle(ex.toString());
        }
        Limpiarcampos();
    }
    
    private void BuscarCorreo()
    {
        Estudiante estudiante = new Estudiante();
        
        try {

            Statement comando=archivo.getConnection().createStatement();
            estudiante.setCorreoInstitucional(txtConsu1.getText());
            ResultSet registro = comando.executeQuery("select Nombres, Apellidos, FechaNacimiento, CorreoInstitucional, CorreoPersonal, NumeroCelular, NumeroFijo, ProgramaAcademico from infoestudiantes where CorreoInstitucional = '"+estudiante.getCorreoInstitucional()+"'"); 
           
            while (registro.next()) {
                String nombre =registro.getString("Nombres");
                txtnombre.setText(nombre);
                String apellido = registro.getString("Apellidos");
                txtapellido.setText(apellido);
                String fecha = registro.getString("FechaNacimiento");
                txtfecha.setText(fecha);
                String correoIns = registro.getString("CorreoInstitucional");
                txtcorreoI.setText(correoIns);
                String correoPer = registro.getString("CorreoPersonal");
                txtcorreoP.setText(correoPer);
                String numcel = (registro.getString("NumeroCelular"));
                txtcelular.setText(numcel);
                String numfijo = registro.getString("NumeroFijo");
                txtfijo.setText(numfijo);
                String programaAc = registro.getString("ProgramaAcademico");
                txtprograma.setText(programaAc);
                
            }
            
        } catch(SQLException ex){
            setTitle("El estudiante no se encuentra registrado");
            setTitle(ex.toString());
        }
        //Limpiarcampos();
    }
        
    private void Modificar()
    {
       Estudiante estudiante = new Estudiante();
       try {

            Statement comando=archivo.getConnection().createStatement();

            estudiante.setCorreoInstitucional(txtConsu1.getText());
            int cantidad = comando.executeUpdate("update infoestudiantes set CorreoPersonal='"
            +txtcorreoP.getText()+"',"+"NumeroCelular='"+Long.parseLong(txtcelular.getText())+"',"+"NumeroFijo='"+Long.parseLong(txtfijo.getText())
            +"',"+"ProgramaAcademico='"+txtprograma.getText()+"'"+"where CorreoInstitucional='" +txtcorreoI.getText()+"'");
            if (cantidad==1) {
                setTitle("Se modificó el estudiante");
            } else {
                setTitle("No se encuentra registrado el estudiante");
            }
             //comando.close();
        } catch(SQLException ex){
            setTitle(ex.toString());
        } 
        Limpiarcampos();
    }
    
    private void Eliminar()
    {
        Estudiante estudiante = new Estudiante();
        try {
            
            Statement comando=archivo.getConnection().createStatement();
            estudiante.setCorreoInstitucional(txtcorreoI.getText());
            int cantidad = comando.executeUpdate("delete from infoestudiantes where CorreoInstitucional= '" +estudiante.getCorreoInstitucional()+"'");
            if (cantidad==1) {

                setTitle("Se eliminó el estudiante");
            } else {
                setTitle("El estudiante no se encuentra registrado en el instituto");
            }

        } catch(SQLException ex){
            setTitle(ex.toString());
        }
        
    }
    private void mostrar()
    {
        Estudiante estudiante = new Estudiante();
        
        try {

            Statement comando=archivo.getConnection().createStatement();
            ResultSet registro = comando.executeQuery("SELECT * FROM infoestudiantes");
            while (registro.next()) {
                int cant = 0;
                txtnombre.setText(registro.getString("Nombres"));
                txtapellido.setText(registro.getString("Apellidos"));
                txtfecha.setText(registro.getString("FechaNacimiento"));
                txtcorreoI.setText(registro.getString("CorreoInstitucional"));
                txtcorreoP.setText(registro.getString("CorreoPersonal"));
                txtcelular.setText(registro.getString("NumeroCelular"));
                txtfijo.setText(registro.getString("NumeroFijo"));
                txtprograma.setText(registro.getString("ProgramaAcademico"));
                cant++;
                
            }

        } catch(SQLException ex){
            System.out.println(ex.toString());
        } 
        //Limpiarcampos();
    }
    private void Limpiarcampos()
    {
        txtnombre.setText("");
        txtapellido.setText("");
        txtfecha.setText("");
        txtcorreoI.setText("");
        txtcorreoP.setText("");
        txtcelular.setText("");  
        txtfijo.setText("");
        txtprograma.setText("");
        txtConsu1.setText("");

    }

    
}
