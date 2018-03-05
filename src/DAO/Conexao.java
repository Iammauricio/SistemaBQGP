package DAO;

import java.sql.*;
import javax.swing.*;

public class Conexao {
   
    public static Connection AbrirConexao(){
    
        Connection con = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/BQGP";
            con = DriverManager.getConnection(url,"root","");
        
        }
        
        catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "ERRO DURANTE A CONEXÃO COM O BANCO DE DADOS", "BQGP", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        
        }
        
        return con;
    
    }
    
    public static void FecharConexao (Connection con){
        
        try {
           
            con.close();
        
        }
        
        catch (Exception e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        
        }
    
    }
    
}

