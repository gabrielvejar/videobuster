/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ComboCategoria;
import controlador.RegistroControlador;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pelicula;
import modelo.Registro;

/**
 *
 * @author Gabriel
 */
public class ListarVista extends javax.swing.JFrame {
    private DefaultTableModel defaultTableModel;
    private Registro lisCon;
    private RegistroControlador regCon;
    
    
    
    
    /*
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer cantidad;
    private String tipo;
    private String sabor;
    private String marca;
    private boolean azucar;
    */
    /**
     * Creates new form Listar
     */
    public ListarVista() {
        initComponents();
        setLocationRelativeTo(this);
        grupoAzucar.add(radioAzucarSi);
        grupoAzucar.add(radioAzucarNo);
        
        
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("CODIGO");
        defaultTableModel.addColumn("PRECIO");
        defaultTableModel.addColumn("DESCRIPCION");
        defaultTableModel.addColumn("FORMATO 4K");
        defaultTableModel.addColumn("NOMBRE");
        jTable1.setModel(defaultTableModel);
        lisCon = new Registro();
        regCon= new RegistroControlador();
        lista();
        comboCategoria();
        
           
    }
    
    void comboCategoria(){
        try {
            ComboCategoria categorias = new ComboCategoria();
            
            ResultSet rst = categorias.listaCategoria();
            
            while (rst.next()){
                jComboCategoria.addItem(rst.getString(2));


                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }       
    
    void lista(){
        Object[] fila = new Object [5];
        while(defaultTableModel.getRowCount()>0)defaultTableModel.removeRow(0);
        
        ArrayList <Pelicula> semis =regCon.listar();
        
        
        Iterator <Pelicula> xx = semis.iterator();
        while(xx.hasNext()){
            Pelicula se=xx.next();
            
            
                fila[0]= se.getCodigo();
                fila[1]= se.getPrecio();
                fila[2]= se.getCategoria();
                fila[3]= se.getCuatroK();
                fila[4]= se.getNombre();
           

            defaultTableModel.addRow(fila);            
            
        }          
        jTable1.updateUI();          
    }
    
    void buscar(){
        
        try {
            Integer codigoBuscar = Integer.parseInt(jCodigoBuscar.getText());
            
            Object[] fila = new Object[5];
            while (defaultTableModel.getRowCount() > 0) {
                defaultTableModel.removeRow(0);
            }
            
            ArrayList<Pelicula> semis = regCon.listar(codigoBuscar);
            
        Iterator <Pelicula> xx = semis.iterator();
        while(xx.hasNext()){
            Pelicula se=xx.next();
            
            
                fila[0]= se.getCodigo();
                fila[1]= se.getPrecio();
                fila[2]= se.getCategoria();
                fila[3]= se.getCuatroK();
                fila[4]= se.getNombre();
                
                defaultTableModel.addRow(fila);                
                
            }            
            jTable1.updateUI();            
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo numerico a buscar", "Error", 0);
            jCodigoBuscar.setText(null);
            
        }
        
    }    
    
    void modificar(){
        boolean x=true;
        

        Integer codigo = Integer.parseInt(jCodigo.getText());

        
        String nombre=jNombre.getText();
        if (nombre.length()<3){
            x=false;
            JOptionPane.showMessageDialog(null, "El nombre de la película debe tener 3 caracteres como mínimo ");

        }
        
        
        Integer precio = null;
        try {
            precio = Integer.parseInt(jPrecio.getText());
            if (precio < 1000) {
                x = false;
                JOptionPane.showMessageDialog(null, "El precio de la película debe ser mayor a 1000");
                
            }
        } catch (NumberFormatException numberFormatException) {
            x = false;
            JOptionPane.showMessageDialog(null, "Ingrese precio en numeros");
        } catch (HeadlessException headlessException) {
        }
        
        
        String categoria=String.valueOf(jComboCategoria.getSelectedItem());
        String cuatroK="N";
        if (radioAzucarSi.isSelected()){
            cuatroK="S";
        }
        
        if (x) {
            Pelicula peli = new Pelicula(codigo, precio, categoria, cuatroK, nombre);
            /////////
            if (regCon.modificar(peli)) {
                JOptionPane.showMessageDialog(null, "Pelicula " + codigo + " modificada.");
                lista();
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoAzucar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCodigoBuscar = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCodigo = new javax.swing.JTextField();
        jNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        radioAzucarSi = new javax.swing.JRadioButton();
        radioAzucarNo = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar / Modificar Pelicula - VideoBuster");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jCodigoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoBuscarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jCodigo.setEditable(false);

        jLabel2.setText("CODIGO");

        jLabel3.setText("NOMBRE");

        jLabel5.setText("PRECIO");

        jLabel7.setText("CATEGORIA");

        jLabel10.setText("4K");

        radioAzucarSi.setSelected(true);
        radioAzucarSi.setText("SI");

        radioAzucarNo.setText("NO");

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioAzucarSi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioAzucarNo))
                                    .addComponent(jNombre))
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(radioAzucarSi)
                    .addComponent(radioAzucarNo))
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(357, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(958, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lista();
        jCodigoBuscar.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        buscar();
    }//GEN-LAST:event_buscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel modeloAlum = (DefaultTableModel) jTable1.getModel();
        jCodigo.setText(modeloAlum.getValueAt(jTable1.getSelectedRow(), 0)+"");
        jPrecio.setText(modeloAlum.getValueAt(jTable1.getSelectedRow(), 1)+"");
        jComboCategoria.setSelectedItem(modeloAlum.getValueAt(jTable1.getSelectedRow(), 2)+"");
        switch (modeloAlum.getValueAt(jTable1.getSelectedRow(), 3)+""){
            case "S":
                radioAzucarSi.setSelected(true);
                break;
            case "N":
                radioAzucarNo.setSelected(true);
        }
        jNombre.setText(modeloAlum.getValueAt(jTable1.getSelectedRow(), 4)+"");

        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione en la tabla la fila a modificar");
        } else {
            modificar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCodigoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_jCodigoBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.ButtonGroup grupoAzucar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JTextField jCodigoBuscar;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPrecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioAzucarNo;
    private javax.swing.JRadioButton radioAzucarSi;
    // End of variables declaration//GEN-END:variables
}
