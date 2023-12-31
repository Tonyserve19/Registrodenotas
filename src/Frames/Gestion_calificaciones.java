package Frames;

import Clases.Conectar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public final class Gestion_calificaciones extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_calificaciones
     */
    public Gestion_calificaciones() {
        initComponents();
        setLocationRelativeTo(null);
        mostrartabla("");
    }
    
    void mostrartabla(String valor){
        
        DefaultTableModel modelo=new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Ciclo");
        modelo.addColumn("Materia");
        modelo.addColumn("Promedio");
        
        tabla_gestion_calificaciones.setModel(modelo);
        
        String sql="SELECT alumnos.nombre AS nombre,"
                +"alumnos.apellido AS apellido,"
                +"alumnos.grado AS grado,"
                +"alumnos.id_curso_asignado AS curso,"
                +" AVG(notas.calificacion) AS totalcalificacion"
                +" FROM alumnos"
                +" INNER JOIN notas"
                +" ON alumnos.id_alumno=notas.id_alumno_nota"
                +" GROUP BY alumnos.id_alumno";
        
        String datos[]=new String[5];
        
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
                    
                    modelo.addRow(datos);
                }
                
                tabla_gestion_calificaciones.setModel(modelo);
                
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error en el inner join");
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

        btnimprimir = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_gestion_calificaciones = new javax.swing.JTable();
        lblinfo_alumno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        tabla_gestion_calificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_gestion_calificaciones);

        lblinfo_alumno.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblinfo_alumno.setText("Promedios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblinfo_alumno)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnvolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnimprimir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblinfo_alumno)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnimprimir)
                    .addComponent(btnvolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Principal principal=new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        Document documento=new Document();
        Calendar cal=Calendar.getInstance();
        Date fecha=new Date(cal.getTimeInMillis());
        SimpleDateFormat formato=new SimpleDateFormat("dd/m/yyyy");
        String verfecha=formato.format(fecha);
        
        try {
                String ruta=System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/"+"CALIFICACIONES"+".pdf"));
            
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial",20,Font.BOLD,BaseColor.BLACK));
            parrafo.add("CALIFICACIONES. \n \n");
            
            Paragraph poner_fecha=new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.add("Fecha: "+verfecha+" \n \n");
            
            documento.open();
            documento.add(parrafo);
            documento.add(poner_fecha);
            
            PdfPTable tablaalumno=new PdfPTable(5);
            
            tablaalumno.addCell("Nombre");
            tablaalumno.addCell("Apellido");
            tablaalumno.addCell("Grado");
            tablaalumno.addCell("Materia");
            tablaalumno.addCell("Promedio");
            
            try {
                PreparedStatement ps=cn.prepareStatement("SELECT alumnos.nombre,"
                        +"alumnos.apellido,"
                        +"alumnos.grado,"
                        +"alumnos.id_curso_asignado,"
                        +" AVG(notas.calificacion) AS totalcalificacion"
                        +" FROM alumnos"
                        +" INNER JOIN notas"
                        +" ON alumnos.id_alumno=notas.id_alumno_nota"
                        +" GROUP BY alumnos.id_alumno");
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    do {
                        tablaalumno.addCell(rs.getString("alumnos.nombre"));
                        tablaalumno.addCell(rs.getString("alumnos.apellido"));
                        tablaalumno.addCell(rs.getString("alumnos.grado"));
                        tablaalumno.addCell(rs.getString("alumnos.id_curso_asignado"));
                        tablaalumno.addCell(rs.getString("totalcalificacion"));
                    } while (rs.next());
                            {
                    documento.add(tablaalumno);
                }
                    
                }
                
                
            } catch (SQLException e) {
                 System.err.println("Error al obtenerdatos del alumno"+e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null,"Documento Creado con exito");
            
            
        } catch (DocumentException | IOException e) {
            System.err.println("Error en el PDF o en la ruta"+e);
            JOptionPane.showMessageDialog(null,"Error al generar PDF");
        }
        
    }//GEN-LAST:event_btnimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
                new Gestion_calificaciones().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnvolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblinfo_alumno;
    private javax.swing.JTable tabla_gestion_calificaciones;
    // End of variables declaration//GEN-END:variables
Conectar con=new Conectar();
    Connection cn=con.conexion();


}
