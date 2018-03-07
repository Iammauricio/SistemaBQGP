package DAO;

import Modelo.Assunto;
import Modelo.Questoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestoesDAO extends ExecuteSQL{
    
    public QuestoesDAO(Connection con) {
        super(con);
    }
    
    
// inserir os dados no banco
public  String Inserir_Questao (Questoes a){

String sql = "INSERT INTO questoes VALUES (0,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1,a.getAssunto());
    ps.setString(2,a.getQuestao());
    ps.setString(3,a.getResposta()); 
    ps.setString(4,a.getDisciplina());
    
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
public List<Questoes>  ListarQuestao(){
    
    String sql = "SELECT * FROM  questoes";
    List<Questoes> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Questoes a = new Questoes();
            
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));
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
   public List<Questoes> Pesquisar_Nome_Questoes( String nome){
   String sql = "SELECT * FROM questoes WHERE nome LIKE '%"+nome+"%'";
   List<Questoes> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
               Questoes a = new Questoes();
           
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));
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
   public List<Questoes> Pesquisar_Cod_Questoes( String cod){
   String sql = "SELECT * FROM questoes WHERE codigo LIKE '%"+cod+"%'";
   List<Questoes> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
                Questoes a = new Questoes();
         
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));
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
    public boolean Testar_Questoes(int cod){
    boolean Resultado = false;
    try{
    String sql  = "SELECT * FROM questoes WHERE codigo = "+cod+"";
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

    public List<Questoes> CapturarQuestoes(int cod){
    String sql = "SELECT *  FROM questoes WHERE codigo = "+cod+"";
    List<Questoes> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if( rs!= null){
    while(rs.next()){
            Questoes a = new Questoes();
    
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));   
            
            
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
    
    public String Alterar_Questoes( Questoes a){
    String sql = "UPDATE questoes SET disciplina = ? , assunto = ? ,resposta = ? ,resposta = ? WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getAssunto());
    ps.setString(3,a.getQuestao());
    ps.setString(4,a.getResposta()); 
    ps.setString(5,a.getDisciplina());
    
      if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   public List<Questoes> ListarComboQuestoes(){
   String sql = "SELECT * FROM questoes ORDER BY nome";
   List<Questoes> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
            Questoes a = new Questoes();
           
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));
            
            
        lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   
   public List<Questoes> ConsultaCodigoQuestoes( String nome){
   String sql = "SELECT  FROM questoes WHERE nome = '"+ nome +"'";
   List<Questoes> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Questoes a = new Questoes();
    
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));        
            
            
        lista.add(a);
  
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }
   
   public String Excluir_Questoes(Questoes a){
   String sql = "DELETE FROM questoes WHERE codigo = ? AND nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setInt(1,a.getCod());
    ps.setString(2,a.getAssunto());
    ps.setString(3,a.getQuestao());
    ps.setString(4,a.getResposta()); 
    ps.setString(5,a.getDisciplina());
    
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   
   //METODO PARA PROXIMO ID
   public List<Questoes> ProximoID(){
   String sql = "SELECT MAX(codigo) FROM `questoes`";
   List<Questoes> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
    Questoes a = new Questoes ();
            a.setCod(rs.getInt(1));
            a.setAssunto(rs.getString(2));
            a.setQuestao(rs.getString(3));
            a.setResposta(rs.getString(4));
            a.setDisciplina(rs.getString(5));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
   

}
