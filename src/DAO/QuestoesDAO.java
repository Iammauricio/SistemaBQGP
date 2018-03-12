package DAO;

import Modelo.Assunto;
import Modelo.Prova;
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
public  String Inserir_Questao (Questoes z){

String sql = "INSERT INTO questoes VALUES (0,?,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1,z.getAssunto());
    ps.setString(2,z.getQuestao());
    ps.setString(3,z.getA());
    ps.setString(4,z.getB()); 
    ps.setString(5,z.getC()); 
    ps.setString(6,z.getD()); 
    ps.setString(7,z.getE()); 
    ps.setString(8,z.getDisciplina());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}

    
    
// METODO DE CADASTRO  DE QUESTÃO  SUBJETIVA
public  String Inserir_Questao_Subjetiva (Questoes z){

String sql = "INSERT INTO questoes VALUES (0,?,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setString(1,z.getAssunto());
    ps.setString(2,z.getQuestao());
    ps.setString(3,"");
    ps.setString(4,""); 
    ps.setString(5,""); 
    ps.setString(6,""); 
    ps.setString(7,""); 
    ps.setString(8,z.getDisciplina());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}// END

    
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
            a.setDisciplina(rs.getString(9));
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
            a.setDisciplina(rs.getString(4));
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
   
     // criaÃ§Ã£o do metodo de pesquisa por id
   public List<Questoes> Pesquisar_Cod_Questoes( String cod){
   String sql = "SELECT * FROM questoes WHERE codigo = '"+cod+"'";
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
            a.setDisciplina(rs.getString(4));
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
            a.setDisciplina(rs.getString(4));   
            
            
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
    String sql = "UPDATE questoes SET Disciplina = ? , Assunto = ? ,Resposta = ? ,Questao = ? WHERE Codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    
    ps.setInt(5,a.getCod());
    ps.setString(2,a.getAssunto());
    ps.setString(4,a.getQuestao()); 
    ps.setString(1,a.getDisciplina());
    
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
            a.setDisciplina(rs.getString(4));
            
            
        lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
   
   // METODO PARA PESQUISAR A QUESTÃO PELA DISCIPLINA
   public List<Questoes> Consulta_Disciplina_Questoes( String nome){
   String sql = "SELECT * FROM questoes WHERE Disciplina = '"+ nome +"'";
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
            a.setDisciplina(rs.getString(9));        
            
            
        lista.add(a);
  
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }// END
   
   
   // METODO PARA PESQUISAR A QUESTÃO PELO ASSUNTO
   public List<Questoes> Consulta_Assunto_Questoes( String nome){
   String sql = "SELECT * FROM questoes WHERE Assunto = '"+ nome +"'";
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
            a.setDisciplina(rs.getString(9));        
            
            
        lista.add(a);
  
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }// END
   
   
   
   // METODO PARA PESQUISAR A QUESTÃO PELO ASSUNTO E A DISCIPLINA AO MESMO TEMPO
   public List<Questoes> Dupla_Consulta_Questoes( String disciplina, String assunto){
   String sql = "SELECT * FROM questoes WHERE Assunto = '"+ assunto +"' AND Disciplina = '"+disciplina+"'";
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
            a.setDisciplina(rs.getString(9));        
            
            
        lista.add(a);
  
   }
   return lista;
   }else{
   
   return null;}
   
   }catch( Exception ex){
   return null;
   }
   }// END
   
   public String Excluir_Questoes(Questoes a){
   String sql = "DELETE FROM questoes WHERE codigo = ? ";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setInt(1,a.getCod());
    
   
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
            a.setDisciplina(rs.getString(4));
            
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
   
   ////SELECT * FROM  `prova` JOIN `questoes` WHERE id = '3' AND prova.Codigo = questoes.Codigo
    
   
   
   
     // TESTE
   public List<Questoes> Duplo( String nome){
   String sql = " SELECT * FROM  `prova` JOIN `questoes` WHERE id = '"+nome+"' AND prova.Codigo = questoes.Codigo";
   List<Questoes> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Questoes a = new Questoes();
           //SELECT * FROM  `prova` JOIN `questoes` WHERE id = '3' AND prova.Codigo = questoes.Codigo
            
            a.setAssunto(rs.getString(4));
            a.setQuestao(rs.getString(5));
            a.setA(rs.getString(6));
            a.setB(rs.getString(7));
            a.setC(rs.getString(8));
            a.setD(rs.getString(9));
            a.setE(rs.getString(10));
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
   
}
   
   
