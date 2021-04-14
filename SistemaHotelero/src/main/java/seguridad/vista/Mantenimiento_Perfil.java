
package seguridad.vista;
import java.io.File;
import seguridad.datos.PerfilDAO;
import seguridad.dominio.Perfil;
import java.sql.*;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
/**
 *
 * @author Nay Ale
 */
public class Mantenimiento_Perfil extends javax.swing.JInternalFrame {
    ButtonGroup RadiosGrupo;

    /**
     * Creates new form Mantenimiento_Perfil
     */
    public Mantenimiento_Perfil() {
        int CodigoAplicacion = 30;    //metodo para generar permisos
        initComponents();
        llenadodetablas();    // metodo para el llenado de la tabla con los datos automaticamente
        RadiosGrupo = new ButtonGroup();   // metodo de radio buton que es el grupo de radios que se utilizan en el estado Perfil
        RadiosGrupo.add(RBEP1);
        RadiosGrupo.add(RBEP0);
        RadiosGrupo.add(RBEPvacio);
        RBEPvacio.setVisible(false);
    }
        
        
public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos y radio boton
        txt_IdPerfil.setText("");
        txt_NombreP.setText("");
        txt_DescPerfil.setText("");
        RBEP1.setSelected(false);
        RBEP0.setSelected(false);
        Txtbuscar.setText("");
    }
public void buscarperfil(){    ///metodo para buscar un perfil ingresado y guardado a la base de datos
    Perfil perfilconsultar = new Perfil();
    PerfilDAO perfilDAO = new PerfilDAO();
    perfilconsultar.setPk_id_perfil((int)Integer.parseInt(Txtbuscar.getText().toString()));
    //-------------------------------------------------------------------
    perfilconsultar = perfilDAO.query(perfilconsultar);
    txt_IdPerfil.setText(String.valueOf(perfilconsultar.getPk_id_perfil()));
    txt_NombreP.setText(perfilconsultar.getNombre_perfil());
    txt_DescPerfil.setText(perfilconsultar.getDescripcion_perfil());
    //Busca el estado de perfil y lo compara para traerlo a la form de la base de datos
    if (perfilconsultar.getEstado_perfil()== 1) {
            RBEP1.setSelected(true);
        }
        if (perfilconsultar.getEstado_perfil()== 0) {
            RBEP0.setSelected(true);
        }
        if (perfilconsultar.getEstado_perfil() == 1) {
            RBEP1.setSelected(true);
        }
        if (perfilconsultar.getEstado_perfil() == 0) {
            RBEP0.setSelected(true);
        } 
}

public void llenadodetablas(){   // metodo de llenado de tablas automaticamente aparecen los datos guardados en bd y se despliega en automatico
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Perfil");
        modelo.addColumn("Nombre Perfil");
        modelo.addColumn("Dirección Perfil");
        modelo.addColumn("Estado Perfil");
        PerfilDAO perfilDAO = new PerfilDAO();
        List<Perfil> perfiles = perfilDAO.listar();
        TablaPerfil.setModel(modelo);
        String[] dato = new String[5];
        for (int i = 0; i < perfiles.size(); i++) {
            dato[0] = Integer.toString(perfiles.get(i).getPk_id_perfil());
            dato[1] = perfiles.get(i).getNombre_perfil();
            dato[2] = perfiles.get(i).getDescripcion_perfil();
            dato[3] = Integer.toString(perfiles.get(i).getEstado_perfil());   
            modelo.addRow(dato);
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGrupoEPerfil = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_IdPerfil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_NombreP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_DescPerfil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        RBEP1 = new javax.swing.JRadioButton();
        RBEP0 = new javax.swing.JRadioButton();
        RBEPvacio = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        Txtbuscar = new javax.swing.JTextField();
        btnAyuda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPerfil = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento Perfil");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Id Perfil:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Perfil:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion Perfil:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Estado Pefil:");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado Perfil"));

        botonGrupoEPerfil.add(RBEP1);
        RBEP1.setText("Habilitado");

        botonGrupoEPerfil.add(RBEP0);
        RBEP0.setText("Deshabilitado");

        botonGrupoEPerfil.add(RBEPvacio);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(RBEP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBEP0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBEPvacio)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(RBEP1)
                .addComponent(RBEP0)
                .addComponent(RBEPvacio))
        );

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 102));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 102));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 102));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 102));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAyuda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(0, 0, 102));
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_NombreP, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(txt_DescPerfil)
                            .addComponent(txt_IdPerfil, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(55, 55, 55)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnGuardar)
                            .addGap(46, 46, 46)
                            .addComponent(btnModificar)
                            .addGap(50, 50, 50)
                            .addComponent(btnEliminar)
                            .addGap(45, 45, 45)
                            .addComponent(btnBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_IdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_NombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_DescPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAyuda)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar)
                    .addComponent(Txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        TablaPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Perfil", "Nombre Perfil", "Descripcion", "Estado Perfil"
            }
        ));
        jScrollPane1.setViewportView(TablaPerfil);

        jLabel5.setText("Detalle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//metodo de guardar todos los datos que se ingresen a la base de datos
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Perfil perfilesInsertar = new Perfil();
        PerfilDAO perfilDAO = new PerfilDAO();
        if (    txt_IdPerfil.getText().length() != 0 &&
                txt_NombreP.getText().length() != 0 && 
                txt_DescPerfil.getText().length() != 0 && 
                RBEP1.isSelected() || 
                RBEP0.isSelected() ) {
        // Prueba insert
        perfilesInsertar.setPk_id_perfil((int) Integer.parseInt(txt_IdPerfil.getText()));
        perfilesInsertar.setNombre_perfil(txt_NombreP.getText());
        perfilesInsertar.setDescripcion_perfil(txt_DescPerfil.getText());      
        //btnEstadoPerf
        if (RBEP1.isSelected()) {
            perfilesInsertar.setEstado_perfil(1);
        }
        if (RBEP0.isSelected()) {
            perfilesInsertar.setEstado_perfil(0);
        }
        {
            JOptionPane.showMessageDialog(null, "Perfil registrado Exitosamente");
            RBEPvacio.setSelected(true);
            limpiar();
            perfilDAO.insert(perfilesInsertar);
        }           
        }
        llenadodetablas();
    }//GEN-LAST:event_btnGuardarActionPerformed
/// metodo que modifica los datos guardados en la bd
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        PerfilDAO perfilDAO = new PerfilDAO();
        Perfil perfilesModificar = new Perfil();
        //perfil a buscar
        //perfilesModificar.setPk_id_perfil(Integer.parseInt(Txtbuscar.getText()));
        //perfil modificar
        perfilesModificar.setPk_id_perfil(Integer.parseInt(txt_IdPerfil.getText()));
        perfilesModificar.setNombre_perfil(txt_NombreP.getText());
        perfilesModificar.setDescripcion_perfil(txt_DescPerfil.getText());
        // ESTADO PERFIL MODIFICAR
        if (RBEP1.isSelected()) {
        perfilesModificar.setEstado_perfil(1);
        }
        if (RBEP0.isSelected()) {
        perfilesModificar.setEstado_perfil(0);
        }        
        RBEPvacio.setSelected(true);
        perfilDAO.update(perfilesModificar);
        JOptionPane.showMessageDialog(null, "Perfil Modificado Exitosamente");
        llenadodetablas();
        limpiar();                 
    }//GEN-LAST:event_btnModificarActionPerformed
// metodo de elimiar los datos en la bd a elegir un perfil ya ingresado
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Perfil perfilEliminar = new Perfil();
        PerfilDAO perfilDAO = new PerfilDAO();
        //Prueba delete
        perfilEliminar.setPk_id_perfil(Integer.parseInt(txt_IdPerfil.getText()));
        perfilDAO.delete(perfilEliminar);
        JOptionPane.showMessageDialog(null, "Perfil Eliminado.");
        limpiar();
        llenadodetablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         buscarperfil();    //metodo que busca el perfil ingresado en la base de datos
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
     /// metodo para ejecutar la ayuda que es una guia para el mantenimiento perfil
        try {
            if ((new File("src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoPerfil.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoPerfil.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton RBEP0;
    public javax.swing.JRadioButton RBEP1;
    public javax.swing.JRadioButton RBEPvacio;
    public javax.swing.JTable TablaPerfil;
    private javax.swing.JTextField Txtbuscar;
    private javax.swing.ButtonGroup botonGrupoEPerfil;
    public javax.swing.JButton btnAyuda;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_DescPerfil;
    public javax.swing.JTextField txt_IdPerfil;
    public javax.swing.JTextField txt_NombreP;
    // End of variables declaration//GEN-END:variables
}
