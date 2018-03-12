
package Visao.Consultar;

import DAO.AssuntoDAO;
import DAO.Conexao;
import DAO.DisciplinaDAO;
import DAO.QuestoesDAO;
import Modelo.Assunto;
import Modelo.Disciplina;
import Modelo.Questoes;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultarQuestoes extends javax.swing.JFrame {


    public ConsultarQuestoes() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("Consultar Questões");
        AtualizaCombo();
        AtualizaAssunto();
        Atualizar_Tabela();
        
        
    }

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
      
      private void Dupla_Busca(){
         // VERIFICAR SE OS DOIS COMBOX FORAM SELECIONADOS
         if(jComboBox1.getSelectedIndex() != 0 && jComboBox2.getSelectedIndex() != 0){
            
                String assunto = jComboBox2.getSelectedItem().toString();
                String disciplina = jComboBox1.getSelectedItem().toString();
                  
                Connection con = Conexao.AbrirConexao();
                QuestoesDAO bd = new  QuestoesDAO(con);

                 List< Questoes> lista = new ArrayList<>();

                 lista = bd.Dupla_Consulta_Questoes(disciplina,assunto);
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
        }else if(jComboBox1.getSelectedIndex() == 0 && jComboBox2.getSelectedIndex() == 0){
        Atualizar_Tabela();
        } else if(jComboBox1.getSelectedIndex() != 0 && jComboBox2.getSelectedIndex() == 0){
        
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
          Conexao.FecharConexao(con);} else if(jComboBox1.getSelectedIndex() == 0 && jComboBox2.getSelectedIndex() != 0){
          
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
          }
      }// END DO PRIVATE

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                {null, null, null, null}
            },
            new String [] {
                "ID", "Disciplina", "Assunto", "Questão"
            }
        ));
        tabela.getTableHeader().setResizingAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CONSULTA QUESTÕES");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DISCIPLINA");

        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      // PESQUISA POR DISCIPLINA
          Dupla_Busca();
          
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        // PESQUISA POR ASSUNTO
          Dupla_Busca();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
new Menu().setVisible(true);
dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarQuestoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
