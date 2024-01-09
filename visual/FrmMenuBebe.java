package visual;
import control.*;
import java.time.LocalDate;
import java.util.ArrayList;
import model.*;
import javax.swing.JOptionPane;

public class FrmMenuBebe extends javax.swing.JFrame {
    
    private ArrayList <Bebe> listas=new ArrayList<Bebe>();
    private AdmBebe admB = AdmBebe.getAdmBebe();

    public FrmMenuBebe() {
        initComponents();
    }

    FrmMenuBebe(FrmNuevoBebe aThis, boolean b) { }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mniMenu = new javax.swing.JMenu();
        mniRegistrar = new javax.swing.JMenuItem();
        mniListar = new javax.swing.JMenuItem();
        mniEditar = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();
        nmiOpciones = new javax.swing.JMenu();
        mniAutor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal Bebes");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("PRESENTACIÓN DEL PROYECTO FINAL");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("SISTEMA DE VACUNACIÓN DE INFANTES");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("=============================================================");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("REDISEÑO - Materia: IHM");
        jLabel6.setToolTipText("");

        mniMenu.setText("Menú");

        mniRegistrar.setText("Registrar bebe");
        mniRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistrarActionPerformed(evt);
            }
        });
        mniMenu.add(mniRegistrar);

        mniListar.setText("Presentar registros");
        mniListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListarActionPerformed(evt);
            }
        });
        mniMenu.add(mniListar);

        mniEditar.setText("Editar registros");
        mniEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditarActionPerformed(evt);
            }
        });
        mniMenu.add(mniEditar);

        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mniMenu.add(mniSalir);

        jMenuBar1.add(mniMenu);

        nmiOpciones.setText("Acerca de");

        mniAutor.setText("Autor");
        mniAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAutorActionPerformed(evt);
            }
        });
        nmiOpciones.add(mniAutor);

        jMenuBar1.add(nmiOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel6)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(22, 22, 22))
        );

        jLabel5.getAccessibleContext().setAccessibleName("__________________________________________________________________________");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistrarActionPerformed
        FrmNuevoBebe frm = new FrmNuevoBebe(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_mniRegistrarActionPerformed

    private void mniListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListarActionPerformed
        FrmListarBebe frm = new FrmListarBebe(this, true);
        if(admB.getListas().size()>0)
            frm.setVisible(true);
        else
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista.","ERROR",0);
    }//GEN-LAST:event_mniListarActionPerformed

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAutorActionPerformed
        JOptionPane.showMessageDialog(null, "Modificación por parte del grupo \nFecha actual: "+LocalDate.now(),"AUTOR",1);
    }//GEN-LAST:event_mniAutorActionPerformed

    private void mniEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditarActionPerformed
        FrmEditarBebe frm = new FrmEditarBebe(this, true);
        if(admB.getListas().size()>0)
            frm.setVisible(true);
        else
            JOptionPane.showMessageDialog(null, "No hay elementos por editar.","ERROR",0);
    }//GEN-LAST:event_mniEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniAutor;
    private javax.swing.JMenuItem mniEditar;
    private javax.swing.JMenuItem mniListar;
    private javax.swing.JMenu mniMenu;
    private javax.swing.JMenuItem mniRegistrar;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenu nmiOpciones;
    // End of variables declaration//GEN-END:variables
}
