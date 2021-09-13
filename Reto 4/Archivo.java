import java.sql.*;
public class Archivo
{
    static String bd = "estudiantes";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection conn = null;
    public String cadena1="Conectado a base de datos "; 
    public String result;

    /**
     * Constructor for objects of class Archivo
     */
    public Archivo()
    {
        try{
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexion
            conn = DriverManager.getConnection(url,login,password);
            if (conn!=null){

                result= cadena1.concat(bd);

            }
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }  
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Connection getConnection(){
        return conn;
    }
    public String getbd(){
        return this.result;
    }
}
