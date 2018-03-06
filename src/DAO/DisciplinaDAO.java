
package DAO;

import Modelo.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaDAO extends ExecuteSQL{
    
    public DisciplinaDAO(Connection con) {
        super(con);
    }
    // inserir os dados no banco
public  String Inserir_Disciplina (Disciplina a){

String sql = "INSERT INTO Disciplina VALUES (0,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getArea());
    ps.setString(3,a.getNome());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    
// puxar as informacoes do banco de dados
public List<Disciplina>  ListarDisciplina(){
    
    String sql = "SELECT * FROM  disciplina";
    List<Disciplina> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Disciplina a = new Disciplina();
            
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
           
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}
     // criacao do metodo de pesquisa por nome
   public List<Disciplina> Pesquisar_Nome_Disciplina( String nome){
   String sql = "SELECT * FROM disciplina WHERE nome LIKE '%"+nome+"%'";
   List<Disciplina> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
               Disciplina a = new Disciplina();
           
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
            
            lista.add(a);
          }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
   
     // criacao do metodo de pesquisa por id
   public List<Disciplina> Pesquisar_Cod_Disciplina( String cod){
   String sql = "SELECT * FROM disciplina WHERE codigo LIKE '%"+cod+"%'";
   List<Disciplina> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
                Disciplina a = new Disciplina();
         
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
           
            lista.add(a);
        }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }
    // metodo de verificacao se existe com ID igual
    public boolean Testar_Disciplina(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM disciplina WHERE codigo = "+cod+"";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet  rs = ps.executeQuery();

if( rs!= null){
        while(rs.next()){
        Resultado = true;
        }
    }
    }catch(SQLException ex){
    ex.getMessage();
    }
        return Resultado;
    }

    public List<Disciplina> CapturarDisciplina(int cod){
    String sql = "SELECT *  FROM disciplina WHERE codigo = "+cod+"";
    List<Disciplina> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
            Disciplina a = new Disciplina();
    
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
           
            
            
        lista.add(a);

    }
    return lista;

    }else{
        return null;
    }
    }catch( SQLException ex ){
    return null;
    }

    }
    
    public String Alterar_Disciplina( Disciplina a){
    String sql = "UPDATE disciplina SET disciplina = ? , area = ? ,nome = ? ,resposta = ? WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getArea());
    ps.setString(3,a.getNome());
    
    
      if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Disciplina> ListarComboDisciplina(){
   String sql = "SELECT * FROM disciplina ORDER BY nome";
   List<Disciplina> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
            Disciplina a = new Disciplina();
           
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
           
            
            
        lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Disciplina> ConsultaCodigoDisciplina( String nome){
   String sql = "SELECT  FROM disciplina WHERE nome = '"+ nome +"'";
   List<Disciplina> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
     Disciplina a = new Disciplina();
    
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
            
            
        lista.add(a);
  
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Disciplina(Disciplina a){
   String sql = "DELETE FROM disciplina WHERE codigo = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getArea());
    ps.setString(3,a.getNome());
    
    
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   //METODO PARA PROXIMO ID
   public List<Disciplina> ProximoID(){
   String sql = "SELECT MAX(codigo) FROM `disciplina`";
   List<Disciplina> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
    Disciplina a = new Disciplina ();
            a.setCod(rs.getInt(1));
            a.setArea(rs.getString(2));
            a.setNome(rs.getString(3));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
   

}
