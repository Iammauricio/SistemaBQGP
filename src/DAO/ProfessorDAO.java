package DAO;

import Modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProfessorDAO extends ExecuteSQL{
   
 public ProfessorDAO(Connection con){
        super(con);}

// inserir os dados no banco
public  String Inserir_Professor(Professor a){

String sql = "INSERT INTO professor VALUES (0,?,?,?,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getNome());
    ps.setInt(3,a.getCpf());
    ps.setInt(4,a.getSenha());
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
public List<Professor>  ListarProfessor(){
    
    String sql = "SELECT codigo,nome,rg,cpf,senha FROM professor";
    List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
          
            
            
            
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
     // criaÃ§Ã£o do metodo de pesquisa por nome
   public List<Professor> Pesquisar_Nome_Professor( String nome){
   String sql = "SELECT * FROM professor WHERE nome LIKE '%"+nome+"%'";
   List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
            
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
                        
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
   
     // criaÃ§Ã£o do metodo de pesquisa por id
   public List<Professor> Pesquisar_Cod_Professor( String cod){
   String sql = "SELECT * FROM professor WHERE codigo LIKE '%"+cod+"%'";
   List<Professor> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Professor a = new Professor();
           
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
            
            
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
    // metodo de verificaÃ§Ã£o se existe com ID igual
    public boolean Testar_Professor(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM professor WHERE codigo = "+cod+"";
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

    public List<Professor> CapturarProfessor(int cod){
    String sql = "SELECT *  FROM professor WHERE codigo = "+cod+"";
    List<Professor> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
    Professor a = new Professor();
    
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
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
    
    public String Alterar_Professor( Professor a){
    String sql = "UPDATE professor SET nome = ? , cpf = ? ,senha = ? WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getNome());
    ps.setInt(3,a.getCpf());
    ps.setInt(4,a.getSenha());
    
      if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Professor> ListarComboProfessor(){
   String sql = "SELECT nome FROM professor ORDER BY nome";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
   
   
   
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Professor> ConsultaCodigoProfessor( String nome){
   String sql = "SELECT codigo FROM professor WHERE nome = '"+ nome +"'";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Professor(Professor a){
   String sql = "DELETE FROM professor WHERE codigo = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
   ps.setInt(1,a.getCod());
    ps.setString(2,a.getNome());
    ps.setInt(3,a.getCpf());
    ps.setInt(4,a.getSenha());
    
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   //METODO PARA PROXIMO ID
   public List<Professor> ProximoProfessor(){
   String sql = "SELECT MAX(codigo) FROM `professor`";
   List<Professor> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Professor a = new Professor();
            a.setCod(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setCpf(rs.getInt(3));
            a.setSenha(rs.getInt(4));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
   
}
    

