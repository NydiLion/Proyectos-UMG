/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.datos.TipoPersonaDAO;
import Finanzas.dominio.TipoPersona;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nay Ale
 */
public class Mantenimiento_TipoPersona extends javax.swing.JInternalFrame {

    /**
     * Creates new form Mantenimiento_TipoPersona
     */
    public Mantenimiento_TipoPersona() {
        initComponents();
        llenadodetablas();
    }
         public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos 
        txt_CodigoTipoPersona.setText("");
        txt_NombreTipoPersona.setText("");
        txt_Buscar.setText("");
    }
  public void buscarTipoPersona(){    ///metodo para buscar moneda ingresada y guardada a la base de datos
    TipoPersona tipoPersonaconsultar = new TipoPersona();
    TipoPersonaDAO tipoPersonaDAO = new TipoPersonaDAO();
    tipoPersonaconsultar.setCodigo_TipoPersona((txt_Buscar.getText()));
    //-------------------------------------------------------------------
    tipoPersonaconsultar = tipoPersonaDAO.query(tipoPersonaconsultar);
    txt_CodigoTipoPersona.setText((tipoPersonaconsultar.getCodigo_TipoPersona()));
    txt_NombreTipoPersona.setText(tipoPersonaconsultar.getTipoPersona_Nombres());
     
  }
  public void llenadodetablas(){   // metodo de llenado de tablas automaticamente aparecen los datos guardados en bd y se despliega en automatico
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Tipo de Persona");
        modelo.addColumn("Nombre Tipo de Persona");
        TipoPersonaDAO tipoPersonaDAO = new TipoPersonaDAO();
        List<TipoPersona> tipoPersona = tipoPersonaDAO.listar();
        Tabla_TipoPersona.setModel(modelo);
        String[] dato = new String[3];
        for (int i = 0; i < tipoPersona.size(); i++) {
            dato[0] = tipoPersona.get(i).getCodigo_TipoPersona();
            dato[1] = tipoPersona.get(i).getTipoPersona_Nombres();  
            modelo.addRow(dato);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_CodigoTipoPersona = new javax.swing.JTextField();
        txt_NombreTipoPersona = new javax.swing.JTextField();
        Boton_Guardar = new javax.swing.JButton();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();
        Boton_Buscar = new javax.swing.JButton();
        Boton_Ayuda = new javax.swing.JButton();
        txt_Buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_TipoPersona = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento_TipoPersona");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Codigo Tipo de Persona:");

        jLabel2.setText("Nombre Tipo de Persona:");

        Boton_Guardar.setForeground(new java.awt.Color(0, 204, 204));
        Boton_Guardar.setText("Guardar");
        Boton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_GuardarActionPerformed(evt);
            }
        });

        Boton_Modificar.setForeground(new java.awt.Color(0, 204, 204));
        Boton_Modificar.setText("Modificar");
        Boton_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ModificarActionPerformed(evt);
            }
        });

        Boton_Eliminar.setForeground(new java.awt.Color(0, 204, 204));
        Boton_Eliminar.setText("Eliminar");
        Boton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminarActionPerformed(evt);
            }
        });

        Boton_Buscar.setForeground(new java.awt.Color(0, 204, 204));
        Boton_Buscar.setText("Buscar");
        Boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarActionPerformed(evt);
            }
        });

        Boton_Ayuda.setForeground(new java.awt.Color(0, 204, 204));
        Boton_Ayuda.setText("Ayuda");
        Boton_Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AyudaActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NombreTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodigoTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Boton_Guardar)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Modificar)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Buscar)
                        .addGap(38, 38, 38)
                        .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Boton_Ayuda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_CodigoTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_NombreTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(Boton_Ayuda)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Guardar)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Eliminar)
                    .addComponent(Boton_Buscar)
                    .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        Tabla_TipoPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Tipo de Persona", "Nombre Tipo de Persona"
            }
        ));
        jScrollPane1.setViewportView(Tabla_TipoPersona);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_GuardarActionPerformed
        TipoPersona tipoPersonaInsertar = new TipoPersona();
        TipoPersonaDAO tipoPersonaDAO = new TipoPersonaDAO();
        // Prueba insert
        tipoPersonaInsertar.setCodigo_TipoPersona(txt_CodigoTipoPersona.getText());
        tipoPersonaInsertar.setTipoPersona_Nombres(txt_NombreTipoPersona.getText());
        {
            JOptionPane.showMessageDialog(null, "Tipo Persona registrada Exitosamente"); 
            limpiar();
            tipoPersonaDAO.insert(tipoPersonaInsertar);
        }                  
        llenadodetablas();      
    }//GEN-LAST:event_Boton_GuardarActionPerformed

    private void Boton_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ModificarActionPerformed
        TipoPersonaDAO tipoPersonaDAO = new TipoPersonaDAO();
        TipoPersona tipoPersonaModificar = new TipoPersona();
        //MONEDA modificar
        tipoPersonaModificar.setCodigo_TipoPersona(txt_CodigoTipoPersona.getText());
        tipoPersonaModificar.setTipoPersona_Nombres(txt_NombreTipoPersona.getText());
        tipoPersonaDAO.update(tipoPersonaModificar);
        JOptionPane.showMessageDialog(null, "Tipo Persona Modificada Exitosamente");
        llenadodetablas();
        limpiar();
    }//GEN-LAST:event_Boton_ModificarActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
        TipoPersona tipoPersonaEliminar = new TipoPersona();
        TipoPersonaDAO tipoPersonaDAO = new TipoPersonaDAO();
        //Prueba delete
        tipoPersonaEliminar.setCodigo_TipoPersona(txt_CodigoTipoPersona.getText());
        tipoPersonaDAO.delete(tipoPersonaEliminar);
        JOptionPane.showMessageDialog(null, "Tipo Persona Eliminada.");
        limpiar();
        llenadodetablas();
    }//GEN-LAST:event_Boton_EliminarActionPerformed

    private void Boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarActionPerformed
        buscarTipoPersona();    //metodo que busca Tipo Persona ingresada en la base de datos
    }//GEN-LAST:event_Boton_BuscarActionPerformed

    private void Boton_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AyudaActionPerformed
        /// metodo para ejecutar la ayuda que es una guia para el mantenimiento Tipo Persona
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
    }//GEN-LAST:event_Boton_AyudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Ayuda;
    private javax.swing.JButton Boton_Buscar;
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Guardar;
    private javax.swing.JButton Boton_Modificar;
    private javax.swing.JTable Tabla_TipoPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_CodigoTipoPersona;
    private javax.swing.JTextField txt_NombreTipoPersona;
    // End of variables declaration//GEN-END:variables
}
