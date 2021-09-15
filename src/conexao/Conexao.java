
package conexao;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Garcia
 */
public class Conexao {
    Connection conexao= null;
    private final String driver= "com.mysql.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/db_comercialtads";
    private final String usuario= "root";
    private final String senha="";
    
    public Connection getConnection(){
        
        try{
            Class.forName(driver);
            conexao= DriverManager.getConnection(url,usuario,senha);
              JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso");
        }catch(ClassNotFoundException drive){
            JOptionPane.showMessageDialog(null,"Driver não encontrado"+drive,"Driver error",JOptionPane.ERROR_MESSAGE);
        }catch( SQLException fonte){
            JOptionPane.showMessageDialog(null,"Fontes de dados não encontrado"+fonte,"Driver error",JOptionPane.ERROR_MESSAGE);
        }
        return conexao;  
    }
}
