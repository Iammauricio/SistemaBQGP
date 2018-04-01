package DAO;

import Modelo.Assunto;
import Modelo.Professor;
import Modelo.Prova;
import Modelo.Questoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvaDAO  extends ExecuteSQL{
    
    public ProvaDAO(Connection con) {
        super(con);
    }


// INSERIR DADOS NA  TABELA
public  String Inserir_Prova(Prova a){

String sql = "INSERT INTO prova VALUES (?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
   
    ps.setInt(1,a.getCodigo());
    ps.setInt(2,a.getCodigo_questao());
            
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}// END 

    
 //METODO PARA  MOSTAR O PROXIMO ID
  public List<Prova> Proximo_Id(){
   String sql = "SELECT MAX(id) FROM `prova`";
   List<Prova> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Prova a = new Prova();
   a.setProximo_Id(rs.getInt(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }//END
  
   // METODO PARA VERIFICAR SE A QUESTAO SELECIONADA JÁ ESTA NA PROVA
    public boolean Testar_Questao(int cod, int codpv){
    boolean Resultado = true;
    try{
    String sql  = "SELECT * FROM prova WHERE Codigo = "+cod+" AND id = "+codpv+"";
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet  rs = ps.executeQuery();

    if( rs!= null){
        while(rs.next()){
        Resultado = false;
        }
    }
    }catch(SQLException ex){
    ex.getMessage();
    }
        return Resultado;
    }// END

   // METODO PARA APAGAR A PROVA CASO SEJA CANCELADO O CADASTRO
   public String Cancelar_Prova(Prova a){
   String sql = "DELETE FROM prova WHERE  id = ? ";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setInt(1,a.getCodigo());
    
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }// END
   
   
   
      
          
// puxar as informacoes do banco de dados
public List<Prova>  ListarProva(){
    
    String sql = "SELECT DISTINCT id , questoes.Disciplina FROM `prova` JOIN questoes WHERE prova.Codigo = questoes.Codigo";
    List<Prova> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Prova a = new Prova();
            a.setCodigo(rs.getInt(1));
            a.setDisciplina(rs.getString(2));
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
       
           
  
}
