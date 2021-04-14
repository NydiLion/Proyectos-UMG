/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.datos.BancoDAO;
import Finanzas.dominio.Banco;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nay Ale
 */
public class Mantenimiento_Banco extends javax.swing.JInternalFrame {

    /**
     * Creates new form Mantenimiento_Banco
     */
    public Mantenimiento_Banco() {
        initComponents();
        llenadodetablas();    // metodo para el llenado de la tabla con los datos automaticamente
    }
  public void limpiar() {   //metodo de Limpiar automaticamente las cajas de textos y radio boton
        txt_CodigoBanco.setText("");
        txt_NombreBanco.setText("");
        txt_ClaveBanco.setText("");
        txt_TelefonoBanco.setText("");
        txt_Buscar.setText("");
    }
  public void buscarbanco(){    ///metodo para buscar un perfil ingresado y guardado a la base de datos
    Banco bancoconsultar = new Banco();
    BancoDAO bancoDAO = new BancoDAO();
    bancoconsultar.setCodigo_Banco((txt_Buscar.getText().toString()));
    //-------------------------------------------------------------------
    bancoconsultar = bancoDAO.query(bancoconsultar);
    txt_CodigoBanco.setText((bancoconsultar.getCodigo_Banco()));
    txt_NombreBanco.setText(bancoconsultar.getNombre_Banco());
    txt_ClaveBanco.setText(bancoconsultar.getClave_Banco());
    txt_TelefonoBanco.setText(bancoconsultar.getTelefono_Banco());
  }
  public void llenadodetablas(){   // metodo de llenado de tablas automaticamente aparecen los datos guardados en bd y se despliega en automatico
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Banco");
        modelo.addColumn("Nombre Banco");
        modelo.addColumn("Clave Banco");
        modelo.addColumn("Telefono Banco");
        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> bancos = bancoDAO.listar();
        Tabla_Banco.setModel(modelo);
        String[] dato = new String[5];
        for (int i = 0; i < bancos.size(); i++) {
            dato[0] = bancos.get(i).getCodigo_Banco();
            dato[1] = bancos.get(i).getNombre_Banco();
            dato[2] = bancos.get(i).getClave_Banco();
            dato[3] = bancos.get(i).getTelefono_Banco();   
            modelo.addRow(dato);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_ClaveBanco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_CodigoBanco = new javax.swing.JTextField();
        txt_NombreBanco = new javax.swing.JTextField();
        Boton_Guardar = new javax.swing.JButton();
        Boton_Modificar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();
        Boton_Buscar = new javax.swing.JButton();
        Boton_Ayuda = new javax.swing.JButton();
        txt_Buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_TelefonoBanco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Banco = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento_Banco");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Codigo Banco:");

        jLabel2.setText("Nombre Banco:");

        jLabel3.setText("Clave Banco:");

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

        jLabel4.setText("Telefono Banco:");

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Boton_Ayuda)
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(107, 107, 107)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TelefonoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ClaveBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_CodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_NombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_ClaveBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_TelefonoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Boton_Ayuda)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Guardar)
                    .addComponent(Boton_Modificar)
                    .addComponent(Boton_Eliminar)
                    .addComponent(Boton_Buscar)
                    .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        Tabla_Banco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Banco", "Nombre Banco", "Clave Banco", "Telefono Banco"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Banco);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_GuardarActionPerformed
     Banco bancosInsertar = new Banco();
     BancoDAO bancoDAO = new BancoDAO();
        // Prueba insert
        bancosInsertar.setCodigo_Banco(txt_CodigoBanco.getText());
        bancosInsertar.setNombre_Banco(txt_NombreBanco.getText());
        bancosInsertar.setClave_Banco(txt_ClaveBanco.getText()); 
        bancosInsertar.setTelefono_Banco(txt_TelefonoBanco.getText());
        {
            JOptionPane.showMessageDialog(null, "Banco registrado Exitosamente"); 
            limpiar();
            bancoDAO.insert(bancosInsertar);
        }                  
        llenadodetablas();
    }//GEN-LAST:event_Boton_GuardarActionPerformed

    private void Boton_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ModificarActionPerformed
        BancoDAO bancoDAO = new BancoDAO();
        Banco bancosModificar = new Banco();
        //BANCO modificar
        bancosModificar.setCodigo_Banco(txt_CodigoBanco.getText());
        bancosModificar.setNombre_Banco(txt_NombreBanco.getText());
        bancosModificar.setClave_Banco(txt_ClaveBanco.getText()); 
        bancosModificar.setTelefono_Banco(txt_TelefonoBanco.getText());
        bancoDAO.update(bancosModificar);
        JOptionPane.showMessageDialog(null, "Banco Modificado Exitosamente");
        llenadodetablas();
        limpiar();            
    }//GEN-LAST:event_Boton_ModificarActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
        Banco bancoEliminar = new Banco();
        BancoDAO bancoDAO = new BancoDAO();
        //Prueba delete
        bancoEliminar.setCodigo_Banco(txt_CodigoBanco.getText());
        bancoDAO.delete(bancoEliminar);
        JOptionPane.showMessageDialog(null, "Banco Eliminado.");
        limpiar();
        llenadodetablas();
    }//GEN-LAST:event_Boton_EliminarActionPerformed

    private void Boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarActionPerformed
         buscarbanco();    //metodo que busca el BANCO ingresado en la base de datos
    }//GEN-LAST:event_Boton_BuscarActionPerformed

    private void Boton_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AyudaActionPerformed
        /// metodo para ejecutar la ayuda que es una guia para el mantenimiento BANCO
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
    private javax.swing.JTable Tabla_Banco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_ClaveBanco;
    private javax.swing.JTextField txt_CodigoBanco;
    private javax.swing.JTextField txt_NombreBanco;
    private javax.swing.JTextField txt_TelefonoBanco;
    // End of variables declaration//GEN-END:variables
}
