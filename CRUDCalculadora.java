import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDCalculadora
{
    private static final String URL = "jdbc:mysql://localhost:3306/Calculadora";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException
    {
        try{

            return DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (Exception error){

            System.out.println("Error de conexion con la BBDD: " + error);
            throw error;
        }
    }

    public static List<Operaciones> funcionGet() throws SQLException{

        String consulta = "SELECT * FROM Operaciones";
        List<Operaciones> listaOperaciones = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(consulta);//Prepara la consulta para la BBDD
            ResultSet resultadoSet = stmt.executeQuery();//Aqui se hace la consulta
        ){

            while (resultadoSet.next()){
                listaOperaciones.add(new Operaciones(resultadoSet.getInt("idOperacion"), resultadoSet.getString("operacion")));//Serializando el objeto
            }
            return listaOperaciones;

        }catch (Exception error){
            throw error;
        }
    }



    public static void main(String[] args) throws SQLException {
        getConnection();
        List<Operaciones> listaPrueba = new ArrayList<>();
        listaPrueba = funcionGet();
        for(Operaciones operacion:listaPrueba){

            System.out.println(operacion.toString());

        }
    }
}
