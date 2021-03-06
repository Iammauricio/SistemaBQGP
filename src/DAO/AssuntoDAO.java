package DAO;

import Modelo.Assunto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssuntoDAO extends ExecuteSQL{
   
 public AssuntoDAO(Connection con){
        super(con);}

// inserir os dados no banco
public  String Inserir_Assunto(Assunto a){

String sql = "INSERT INTO assunto VALUES (0,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
   
    ps.setString(1,a.getAssunto());
    ps.setString(2,a.getDisciplina());
            
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
    
// puxar as informaÃ§Ãµes do banco de dados
public List<Assunto>  ListarAssunto(){
    
    String sql = "SELECT codigo,assunto,disciplina FROM assunto";
    List<Assunto> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Assunto a = new Assunto();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
            
            
          
            
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
    // 
   public List<Assunto> Pesquisar_Disciplina_Assunto( String nome){
   String sql = "SELECT * FROM assunto WHERE Disciplina LIKE '%"+nome+"%'";
   List<Assunto> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Assunto a = new Assunto();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
   }// END
   
    
    // metodo de verificaÃ§Ã£o se existe com ID igual
    public boolean Testar_Assunto(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM assunto WHERE codigo = "+cod+"";
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

    public List<Assunto> CapturarAssunto(int cod){
    String sql = "SELECT *  FROM assunto WHERE codigo = "+cod+"";
    List<Assunto> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Assunto a = new Assunto();
    
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
            
            
            
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
    
    public String Alterar_Assunto( Assunto a){
    String sql = "UPDATE assunto SET Disciplina = ? , Assunto = ?  WHERE Codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(3,a.getCod());
    ps.setString(2,a.getAssunto());
    ps.setString(1,a.getDisciplina());
    
    
      if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Assunto> ListarComboAssunto(){
   String sql = "SELECT * FROM assunto ORDER BY Assunto";
   List<Assunto> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Assunto a = new Assunto();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
                        
   
   
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Assunto> ConsultaCodigoAssunto( String nome){
   String sql = "SELECT codigo FROM assunto WHERE nome = '"+ nome +"'";
   List<Assunto> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Assunto a = new Assunto();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
            
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Assunto(Assunto a){
   String sql = "DELETE FROM assunto WHERE  Assunto = ? AND Disciplina = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setString(1,a.getAssunto());
    ps.setString(2,a.getDisciplina());
    
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   //METODO PARA PROXIMO ID
   public List<Assunto> ProximoAssunto(){
   String sql = "SELECT MAX(codigo) FROM `assunto`";
   List<Assunto> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Assunto a = new Assunto ();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setDisciplina(rs.getString(3));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
   
}
    

    

