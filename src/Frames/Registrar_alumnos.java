
package Frames;

import Clases.Conectar;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author USUARIO
 */
public final class Registrar_alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_alumnos
     */
    public Registrar_alumnos() {
        initComponents();
        
        TextPrompt nombre=new TextPrompt("Escribe nombrse",txtnombre);
        TextPrompt apellido=new TextPrompt("Escribe apellidos",txtapellidos);
        TextPrompt telefono=new TextPrompt("Escribe telefono",txttelefono);
        TextPrompt buscar=new TextPrompt("Escribe nombre",txtbuscar);
        
        this.setLocationRelativeTo(null);
        mostrartabla("");
        limpiar();
        cargarcombocurso(cmb_materia);
        txtid_alumno.setEnabled(false);
        txtcantidad.setEditable(false);
        cerrar();
        
        for(int i=0; i<=tabla_registro_alumnos.getRowCount();i++)
                    {
                        txtcantidad.setText(" "+i);
                    }
        
        
    }
    void limpiar(){
        
        txtid_alumno.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txttelefono.setText("");
        
        cmb_grado.setSelectedIndex(0);
        cmb_materia.setSelectedIndex(0);
               
    }
    void mostrartabla(String valor){
        
        DefaultTableModel modelo=new DefaultTableModel();
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Grado");
        modelo.addColumn("Telefono");
        modelo.addColumn("Materia");
        
        
        tabla_registro_alumnos.setModel(modelo);
        
        String sql="SELECT * FROM alumnos WHERE CONCAT (nombre,' ',apellido,' ',grado,' ',id_curso_asignado) LIKE '%"+valor+"%'";

        String datos[]=new String[6];
        
        Statement st;
        
        try {
                st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                while(rs.next()){
                    
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                
                    modelo.addRow(datos);
                }
                
                tabla_registro_alumnos.setModel(modelo);
                      
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al cargar alumnos");
        }
        
    }
    
    public void cargarcombocurso(JComboBox combodelcurso){
        
        try {
            String sql="SELECT nombre_curso FROM curso";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                
                combodelcurso.addItem(rs.getString("nombre_curso"));
                
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
    
    public void cerrar(){
        
        try {
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                addWindowListener(new WindowAdapter(){
                    
                    public void windowClosing(WindowEvent e){
                        
                        confirmarsalida();
                        
                    }
                    
                });
            
            
        } catch (Exception e) {
        }
        
    }
    public void confirmarsalida(){
        int valor=JOptionPane.showConfirmDialog
        (this,"¿Desea cerrar la aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valor==JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null,"Hasta Pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popborrar = new javax.swing.JPopupMenu();
        popeliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtid_alumno = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmb_grado = new javax.swing.JComboBox<>();
        cmb_materia = new javax.swing.JComboBox<>();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_alumnos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();

        popeliminar.setText("Borrar");
        popeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeliminarActionPerformed(evt);
            }
        });
        popborrar.add(popeliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setText("Registro de Alumnos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setText("Id alumnos:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Grado:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Materia:");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        cmb_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmb_materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione materia" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtid_alumno)
                    .addComponent(txtnombre)
                    .addComponent(txtapellidos)
                    .addComponent(txttelefono)
                    .addComponent(cmb_grado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_materia, 0, 186, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        tabla_registro_alumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_registro_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_alumnos);

        jLabel8.setText("Buscar:");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel9.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnagregar)
                        .addGap(27, 27, 27)
                        .addComponent(btnactualizar)
                        .addGap(26, 26, 26)
                        .addComponent(btnvolver))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidad))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnagregar)
                            .addComponent(btnactualizar)
                            .addComponent(btnvolver)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeliminarActionPerformed
        
        try {
                PreparedStatement ps=cn.prepareStatement("DELETE FROM alumnos WHERE id_alumno='"+txtid_alumno.getText()+"'");
                
                int respuesta=ps.executeUpdate();
                if (respuesta>0){
                   JOptionPane.showMessageDialog(null, "Alumno eliminaro");
                    limpiar();
                    mostrartabla("");
                    
                    for(int i=0; i<=tabla_registro_alumnos.getRowCount();i++)
                    {
                        txtcantidad.setText(" "+i);
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"No a seleccionado fila");
                }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al eliminar Alumno");
        }
        
     
        
        
        
    }//GEN-LAST:event_popeliminarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        
        String id_curso_asignado=cmb_materia.getSelectedItem().toString();
        String materia=(String) cmb_materia.getSelectedItem();
        String grado=(String) cmb_grado.getSelectedItem();
        
        try {
            if(txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacio");
            }
            else if(txtapellidos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo apellidos vacio");
            }
            else if(txttelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo telefono vacio");
            }
            else if(grado.equals("Seleccione grado")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un grado");
            }
            else if(materia.equals("Seleccione materia")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una materia");
            }
            
            else
            {
                
                PreparedStatement ps=cn.prepareStatement("INSERT INTO alumnos (nombre,apellido,grado,telefono,id_curso_asignado) VALUES (?,?,?,?,?)");
                
                ps.setString(1, txtnombre.getText());
                ps.setString(2, txtapellidos.getText());
                ps.setString(3, cmb_grado.getSelectedItem().toString());
                ps.setString(4, txttelefono.getText());
                ps.setString(5, id_curso_asignado);
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Alumno registrado con exito");
                mostrartabla("");
                limpiar();
                
                for(int i=0; i<=tabla_registro_alumnos.getRowCount();i++)
                    {
                        txtcantidad.setText(" "+i);
                    }
                
                
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Problema al gruardar alumno");
            
        }
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        
        //String id_curso_asignado=cmb_materia.getSelectedItem().toString();
        String materia=(String) cmb_materia.getSelectedItem();
        String grado=(String) cmb_grado.getSelectedItem();
        
        
         try {
             if(txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacio");
            }
            else if(txtapellidos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo apellidos vacio");
            }
            else if(txttelefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo telefono vacio");
            }
            else if(grado.equals("Seleccione grado")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un grado");
            }
            else if(materia.equals("Seleccione materia")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una materia");
            }
            else{
             PreparedStatement ps=cn.prepareStatement("UPDATE alumnos SET nombre='"+txtnombre.getText()+"',apellido='"+txtapellidos.getText()+"',grado='"+cmb_grado.getSelectedItem().toString()+"',telefono='"+txttelefono.getText()+"',id_curso_asignado='"+cmb_materia.getSelectedItem().toString()+"' WHERE id_alumno='"+txtid_alumno.getText()+"'");
                
                int respuesta=ps.executeUpdate();
                
                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Alumno actualizado");
                    limpiar();
                    mostrartabla("");
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"No a seleccionado fila");
                }
            }  
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al actualizar alumno");
        }
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Principal principal=new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void tabla_registro_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_alumnosMouseClicked
        
        int fila=this.tabla_registro_alumnos.getSelectedRow();
        
        this.txtid_alumno.setText(this.tabla_registro_alumnos.getValueAt(fila,0).toString());
        this.txtnombre.setText(this.tabla_registro_alumnos.getValueAt(fila,1).toString());
        this.txtapellidos.setText(this.tabla_registro_alumnos.getValueAt(fila,2).toString());
        this.cmb_grado.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila,3).toString());
        this.txttelefono.setText(this.tabla_registro_alumnos.getValueAt(fila,4).toString());
        this.cmb_materia.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila,5).toString());
        
        
    }//GEN-LAST:event_tabla_registro_alumnosMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        
        mostrartabla(txtbuscar.getText());
        for(int i=0; i<=tabla_registro_alumnos.getRowCount();i++)
                    {
                        txtcantidad.setText(" "+i);
                    }
        
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
        
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
        
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        
        char c=evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
        
        
    }//GEN-LAST:event_txttelefonoKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
                new Registrar_alumnos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmb_grado;
    private javax.swing.JComboBox<String> cmb_materia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popborrar;
    private javax.swing.JMenuItem popeliminar;
    private javax.swing.JTable tabla_registro_alumnos;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtid_alumno;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
Conectar con=new Conectar();
    Connection cn=con.conexion();
}