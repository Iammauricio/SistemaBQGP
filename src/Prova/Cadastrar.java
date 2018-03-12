package Prova;

import DAO.AssuntoDAO;
import DAO.Conexao;
import DAO.DisciplinaDAO;
import DAO.ProvaDAO;
import DAO.QuestoesDAO;
import Modelo.Assunto;
import Modelo.Disciplina;
import Modelo.Prova;
import Modelo.Questoes;
import Principal.Menu;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cadastrar extends javax.swing.JFrame {
VerProva CodigoDaProva;
    public Cadastrar() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("Gerar Prova");
        AtualizaCombo();
        AtualizaAssunto();
        Atualizar_Tabela();
        Id_Prova();
       
        
    }
         // METODO PARA PUXAR O ID DA PROVA
     public  void Id_Prova(){
        Connection con = Conexao.AbrirConexao();
        ProvaDAO sql = new ProvaDAO(con);
        List<Prova> lista = new ArrayList<>();
       
        lista = sql.Proximo_Id();
        
        for (Prova b : lista){
          String  id_prova = Integer.toString(b.getProximo_Id()+1);
          jTextField2.setText(id_prova);
        }
       
        Conexao.FecharConexao(con);
     }// END
    
    
     // METODO PARA LISTAR AS DISCIPLINAS NO COMBOBOX
     private void AtualizaCombo(){
         
        Connection con = Conexao.AbrirConexao();
        DisciplinaDAO sql = new DisciplinaDAO(con);
        List<Disciplina> lista = new ArrayList<>();
       
        lista = sql.ListarComboDisciplina();
        
        for (Disciplina b : lista){
            jComboBox1.addItem(b.getNome());
        }
       
        Conexao.FecharConexao(con);
     }// END
     
     
     // METODO PARA LISTAR OS ASSUNTOS NO COMBOBOX
     private void AtualizaAssunto(){
        Connection con = Conexao.AbrirConexao();
        AssuntoDAO sql = new AssuntoDAO(con);
        List<Assunto> lista = new ArrayList<>();
       
        lista = sql.ListarComboAssunto();
        
        for (Assunto b : lista){
           jComboBox2.addItem(b.getAssunto());
        }
       
        Conexao.FecharConexao(con);
     }// END

     
        //METODO PARA LISTAR TODAS AS QUESTOES
      public void Atualizar_Tabela(){
           Connection con = Conexao.AbrirConexao();
         QuestoesDAO bd = new  QuestoesDAO(con);

          List< Questoes> lista = new ArrayList<>();

          lista = bd.ListarQuestao();
          DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();

          while(tbm.getRowCount() > 0){
          tbm.removeRow(0);
          }
          int i = 0;
          for( Questoes tab : lista){
          tbm.addRow(new String[i]);
         tabela.setValueAt(tab.getCod(), i,0);
          tabela.setValueAt(tab.getDisciplina(), i,1);
          tabela.setValueAt(tab.getAssunto(), i,2);
          tabela.setValueAt(tab.getQuestao(), i,3);
          i++;
          }
          Conexao.FecharConexao(con);
      }
      // METODO PARA MOSTRAR TODAS AS QUESTÕES
      private void Mostrar_Todos(){
      if(jComboBox2.getSelectedIndex() == 0){
          Atualizar_Tabela();
      }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("GERAR PROVA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("ID DA PROVA");

        jTextField2.setEditable(false);
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Disciplina", "Assunto", "Questão"
            }
        ));
        tabela.getTableHeader().setResizingAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ASSUNTO");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR DISCIPLINA" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR ASSUNTO" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("SALVAR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DISCIPLINA");

        jButton2.setText("+ ADICIONAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("VER PROVA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ID DA QUESTÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     int cod = Integer.parseInt(jTextField2.getText());
      
        Connection con = Conexao.AbrirConexao();
        ProvaDAO sql = new ProvaDAO(con);
        Prova a = new Prova();
        a.setCodigo(cod);
        sql.Cancelar_Prova(a);
        Conexao.FecharConexao(con);
     
       new Menu().setVisible(true);
       dispose();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
               
        String nome = jComboBox1.getSelectedItem().toString();
        Connection con = Conexao.AbrirConexao();
         QuestoesDAO bd = new  QuestoesDAO(con);
 
             
          List< Questoes> lista = new ArrayList<>();

          lista = bd.Consulta_Disciplina_Questoes(nome);
          DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();

          while(tbm.getRowCount() > 0){
          tbm.removeRow(0);
          }
          int i = 0;
          for( Questoes tab : lista){
          tbm.addRow(new String[i]);
         tabela.setValueAt(tab.getCod(), i,0);
          tabela.setValueAt(tab.getDisciplina(), i,1);
          tabela.setValueAt(tab.getAssunto(), i,2);
          tabela.setValueAt(tab.getQuestao(), i,3);
          i++;
          }
          Conexao.FecharConexao(con);
      jComboBox1.disable();
      jComboBox1.setBackground(Color.BLACK);
 JOptionPane.showMessageDialog(null,"Só é possivel selecionar a Disciplina uma vez !","BQGP",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
  
        String nome = jComboBox2.getSelectedItem().toString();
        Connection con = Conexao.AbrirConexao();
         QuestoesDAO bd = new  QuestoesDAO(con);

          List< Questoes> lista = new ArrayList<>();

          lista = bd.Consulta_Assunto_Questoes(nome);
          DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();

          while(tbm.getRowCount() > 0){
          tbm.removeRow(0);
          }
          int i = 0;
          for( Questoes tab : lista){
          tbm.addRow(new String[i]);
         tabela.setValueAt(tab.getCod(), i,0);
          tabela.setValueAt(tab.getDisciplina(), i,1);
          tabela.setValueAt(tab.getAssunto(), i,2);
          tabela.setValueAt(tab.getQuestao(), i,3);
          i++;
          }
          
          Conexao.FecharConexao(con);
     Mostrar_Todos();


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

// METODO PARA PEGAR A COLUNA E A LINHA DA TABELA   
int linha = tabela.getSelectedRow();
Object um =  tabela.getValueAt(linha, 0);

jTextField1.setText(""+um);
String cod = jTextField1.getText();


    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

              
        String cod_prova  = jTextField2.getText();
       String cod_questao  = jTextField1.getText();
        
        if(cod_questao.equals("")){
            
            JOptionPane.showMessageDialog(null,"Nenhum campo pode estar vazio", "BQGP", JOptionPane.WARNING_MESSAGE);

        }else{
            int cod = Integer.parseInt(cod_questao);
            int codpv = Integer.parseInt(cod_prova);
           
            Connection con = Conexao.AbrirConexao();
            ProvaDAO sql = new ProvaDAO(con);
           if(sql.Testar_Questao(cod,codpv) == true){
           Prova a = new  Prova(); 
            
            a.setCodigo_questao(cod);
            a.setCodigo(codpv);
            
            sql.Inserir_Prova(a);
            Conexao.FecharConexao(con);
            
            jTextField1.setText("");

            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso", "BQGP", JOptionPane.INFORMATION_MESSAGE);

           }else{
           JOptionPane.showMessageDialog(null,"A questão selecionada já está na prova", "BQGP", JOptionPane.INFORMATION_MESSAGE);
           }
            
        }  

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
// METODO PARA ENVIAR O VALOR DE UM VARIAVEL PARA OUTRO FRAME      
 if(CodigoDaProva == null){
  CodigoDaProva = new VerProva();
  CodigoDaProva.setVisible(true);
  CodigoDaProva.receber(jTextField2.getText());
  
 }else{
 CodigoDaProva.setVisible(true);
 CodigoDaProva.setState(VerProva.NORMAL);
 CodigoDaProva.receber(jTextField2.getText());
 
}
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastrar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
