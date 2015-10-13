/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.menus.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import restaurant.menus.controllers.EditMenuController;

/**
 *
 * @author Nicolas
 */
public class EditMenuWindow extends javax.swing.JDialog implements EditMenuController.EditMenuWindow {

    private EditMenuController controller;
    private Map<String, List<String>> addedDishesModel;

    /**
     * Creates new form EditMenuWindow
     */
    public EditMenuWindow(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorForName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceField = new restaurant.menus.views.UserControls.PriceJSpinner(0.0f,0.0f,9999.99f);
        errorForPrice = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedDishes = new javax.swing.JTextArea();
        errorForDishes = new javax.swing.JLabel();
        dishTypes = new javax.swing.JComboBox();
        dishes = new javax.swing.JComboBox();
        addDishButton = new javax.swing.JButton();

        setTitle("Editer un menu");
        setMinimumSize(new java.awt.Dimension(800, 350));

        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom :");

        errorForName.setForeground(new java.awt.Color(200, 0, 0));
        errorForName.setText("test");

        jLabel2.setText("Price :");

        /*
        priceField.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(100.0f), Float.valueOf(5.0f)));
        */

        errorForPrice.setForeground(new java.awt.Color(200, 0, 0));
        errorForPrice.setText("test");

        save.setText("Sauver");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        addedDishes.setColumns(20);
        addedDishes.setRows(5);
        jScrollPane1.setViewportView(addedDishes);

        errorForDishes.setForeground(new java.awt.Color(200, 0, 0));
        errorForDishes.setText("test");

        addDishButton.setText("Ajouter");
        addDishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDishButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorForName, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dishTypes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(errorForPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(37, 37, 37))
                                    .addComponent(dishes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addDishButton)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(errorForDishes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(cancel)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorForName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorForPrice))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dishTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDishButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorForDishes)
                        .addGap(74, 74, 74)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        controller.saveEvent();
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        controller.cancelEvent();
    }//GEN-LAST:event_cancelActionPerformed

    private void addDishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDishButtonActionPerformed
        String key = (String)dishTypes.getSelectedItem();
        if (addedDishesModel.get(key) == null) {
            addedDishesModel.put(key, new ArrayList<>());
        }
        addedDishesModel.get(key).add((String) dishes.getSelectedItem());
        setDishes(addedDishesModel);
    }//GEN-LAST:event_addDishButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDishButton;
    private javax.swing.JTextArea addedDishes;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox dishTypes;
    private javax.swing.JComboBox dishes;
    private javax.swing.JLabel errorForDishes;
    private javax.swing.JLabel errorForName;
    private javax.swing.JLabel errorForPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    /*
    private javax.swing.JSpinner priceField;
    */
    private restaurant.menus.views.UserControls.PriceJSpinner priceField;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setController(EditMenuController controller) {
        this.controller = controller;
    }

    @Override
    public void setErrorForName(String value) {
        this.errorForName.setText(value);
        this.errorForName.setVisible(value.trim().length() > 0);
    }

    @Override
    public void setPrice(float value) {
        priceField.setValue(value);
    }

    @Override
    public float getPrice() {
        return Float.parseFloat(priceField.toString());
    }

    @Override
    public void setErrorForPrice(String value) {
        this.errorForPrice.setText(value);
        this.errorForPrice.setVisible(value.trim().length() > 0);
    }

    @Override
    public Map<String, List<String>> getDishes() {
        return addedDishesModel;
    }

    @Override
    public void setDishes(Map<String, List<String>> etapes) {
        addedDishesModel = etapes;
        StringBuilder sb = new StringBuilder();
        List<String> dishPerType;
        
        for (String dishKey : etapes.keySet()) {                    // foreach, la clé depuis le set
            if ((dishPerType = etapes.get(dishKey)).size() > 0) {   // si le nombre d'entré pour un type de met du menu est > 0
                sb.append(dishKey).append("\r\n");                 // on ajoute la clé(rubrique)
                
                for (String aDish : dishPerType) {                  // parcours de tous les dishs de la rubrique
                    sb.append('\t').append(aDish).append("\r\n");   // on ajoute le dish sélectionné
                }
            }
        }
        addedDishes.setText(sb.toString());                         // mise en place d'une chaine formatée dans le composant graphique
    }
    
    @Override
    public String getName(){
        return nameField.getText();
    }

    @Override
    public void setErrorForDishes(String value) {
        this.errorForDishes.setText(value);
        this.errorForDishes.setVisible(value.trim().length() > 0);
    }

    @Override
    public void setDishTypes(List<String> dishTypes) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        dishTypes.stream().forEach(s -> model.addElement(s));
        this.dishTypes.setModel(model);
    }
    
    @Override
    public void setDishTypes(String[] dishTypes) {
        this.dishTypes.setModel(new DefaultComboBoxModel<>(dishTypes));
    }

    @Override
    public void setDishList(List<String> dishList) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        dishList.stream().forEach(s -> model.addElement(s));
        this.dishes.setModel(model);
    }
}
