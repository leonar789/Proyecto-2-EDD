/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;


import clases.App;
import clases.Cliente;

import estructuras.ListaDoble;
import estructuras.NodoDoble;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jose Gabriel
 */

//se gestionan los parametros de inicio de simulación
public class Reservas extends javax.swing.JPanel {
    
    /**
     * Creates new form Iniciar_Simulacion
     */
    
    String pattern;
    DecimalFormat myFormatter;
    public Reservas() {
        initComponents();
        pattern= "###,###,###";
        myFormatter = new DecimalFormat(pattern);
        myFormatter = new DecimalFormat(pattern,DecimalFormatSymbols.getInstance(Locale.GERMANY));
    }
    
    
    

    //permite cargar los datos de la tabla desde una lista
    public void cargarTabla(ListaDoble lista){
        
        
        DefaultTableModel modelot=(DefaultTableModel)tablaReservas.getModel();
        for (int i = 0; i < tablaReservas.getRowCount(); i++) {
        modelot.removeRow(i);
        i-=1;
        }
        NodoDoble aux=lista.getFirstNodo();
        
        while (aux!=null){
            Object[] fila = new Object[9];
            fila[0]=myFormatter.format(((Cliente)aux.get()).getCedula());
            fila[1]=((Cliente)aux.get()).getNombre();
            fila[2]=((Cliente)aux.get()).getApellido();
            fila[3]=((Cliente)aux.get()).getEmail();
            fila[4]=((Cliente)aux.get()).getGenero();
            fila[5]=((Cliente)aux.get()).getTipoHabitacion();
            fila[6]=((Cliente)aux.get()).getCelular();
            fila[7]=((Cliente)aux.get()).getFechaLlegada();
            fila[8]=((Cliente)aux.get()).getFechaSalida();
            aux=aux.nNext();
            modelot.addRow(fila);
        }
        tablaReservas.setModel(modelot);

        tablaReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tCedula = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        checkIn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        restaurarTabla = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Correo", "Género", "Tipo Hab.", "Celular", "Entrada", "Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaReservas);
        if (tablaReservas.getColumnModel().getColumnCount() > 0) {
            tablaReservas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaReservas.getColumnModel().getColumn(1).setPreferredWidth(60);
            tablaReservas.getColumnModel().getColumn(2).setPreferredWidth(60);
            tablaReservas.getColumnModel().getColumn(3).setPreferredWidth(145);
            tablaReservas.getColumnModel().getColumn(4).setPreferredWidth(60);
            tablaReservas.getColumnModel().getColumn(5).setPreferredWidth(40);
            tablaReservas.getColumnModel().getColumn(6).setPreferredWidth(60);
            tablaReservas.getColumnModel().getColumn(7).setPreferredWidth(40);
            tablaReservas.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservas");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel2.setText("Navegación");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel3.setText("C.I");

        tCedula.setBackground(new java.awt.Color(255, 255, 255));
        tCedula.setForeground(new java.awt.Color(0, 0, 0));
        tCedula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tCedula.setToolTipText("");
        tCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCedulaActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(tCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar))
                    .addComponent(jLabel2))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel4.setText("Check In");

        checkIn.setText("Registrar Entrada");
        checkIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(checkIn)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkIn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setText("Restaurar");

        restaurarTabla.setText("Ver Tabla Completa");
        restaurarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(restaurarTabla)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restaurarTabla)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCedulaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try{
            
            int cedula=Integer.parseInt(tCedula.getText());
            if (cedula<=0){
                JOptionPane.showInternalMessageDialog(null, "Debes ingresar solo números positivos", "Ingreso inválido", JOptionPane.ERROR_MESSAGE);

            }
            else{
                ListaDoble nLista= new ListaDoble();
                Cliente c=(Cliente)App.reservas.buscar(cedula, App.reservas.getRaiz());
                if (c==null){
                    JOptionPane.showInternalMessageDialog(null, "No hay ningun cliente con la cédula "+myFormatter.format(cedula), "No Encontrado", JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    nLista.append(c);
                    this.cargarTabla(nLista);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, "Por favor ingrese solo números en el recuadro. Sin ningún separador. Ej:29651228", "Ingreso inválido", JOptionPane.ERROR_MESSAGE);

        }
        
       
       
       
        
    }//GEN-LAST:event_buscarActionPerformed

    private void checkInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInActionPerformed
        DefaultTableModel modelot=(DefaultTableModel)tablaReservas.getModel();        
        int a = tablaReservas.getSelectedRow();
        
 
        if(a<0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla para realizar Cheack Out");
        }else{
            Number numero = null;
            try {
                numero = myFormatter.parse((String)modelot.getValueAt(a, 0));
            } catch (ParseException ex) {
                Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
            }
            int cedula = numero.intValue();
            if (App.checkIn(cedula)){
                modelot.removeRow(a);
            }
            
            
        }
    }//GEN-LAST:event_checkInActionPerformed

    private void restaurarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarTablaActionPerformed
        this.cargarTabla(App.listaReservas);
    }//GEN-LAST:event_restaurarTablaActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton checkIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton restaurarTabla;
    private javax.swing.JTextField tCedula;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
