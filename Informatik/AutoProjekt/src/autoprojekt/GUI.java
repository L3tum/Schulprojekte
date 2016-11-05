/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoprojekt;

import autoprojekt.Auto;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author tim.goeller
 */
public class GUI extends javax.swing.JFrame {

    DefaultListModel listModel;
    DefaultListModel haendlerListModel;
    Autohaendler haendler;
    Auto tempAuto;
    Auto haendlerTempAuto;
    
    /**
     * Creates new form GUI
     */
    public GUI(Autohaendler haendler) {
        initComponents();
        listModel = new DefaultListModel();
        this.haendlerListModel = new DefaultListModel();
        this.haendler = haendler;
        this.carListMarket.addListSelectionListener(new ListSelectionListener(
        
        ) {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(carListMarket.getSelectedIndex() != -1){
                   UpdateFields(); 
                   carList.setSelectedIndex(-1);
                }
                
                
            }
        });
        this.carList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(carList.getSelectedIndex() != -1){
                    UpdateFieldsHaendler();
                    carListMarket.setSelectedIndex(-1);
                }
            }
        });
        
        this.merchantMoneyLabel.setText("Kapital: " + haendler.GetKapital());
        this.merchantNameLabel.setText("Name: " + haendler.GetName());
        this.UpdateHaendlerList();
        this.UpdateMarketList();
        
    }
    
    public void UpdateFieldsHaendler(){
        haendlerTempAuto = haendler.GetAutos().get(carList.getSelectedIndex());
        this.carPowerLabel.setText("Leistung: " + String.valueOf(haendlerTempAuto.getLeistung()) + " PS");
        this.carColorLabel.setText("Farbe: " + haendlerTempAuto.getFarbe());
        this.carPriceLabel.setText("Preis: " + String.valueOf(haendlerTempAuto.getPreis()) + " €");
        this.carTypeLabel.setText("Typ: " + String.valueOf(haendlerTempAuto.getTyp()));
        this.carModleLabel.setText("Modell: " + haendlerTempAuto.getModell());
        this.carMarkeLabel1.setText("Marke: " + haendlerTempAuto.getMarke());
    }
    
    public void UpdateHaendlerList(){
        haendlerListModel.clear();
        for(Iterator<Auto> it = haendler.GetAutos().iterator(); it.hasNext();){
            haendlerListModel.addElement(it.next().getModell());
        }
        this.carList.setModel(haendlerListModel);
    }
    public void UpdateMarketList() {
        listModel.clear();
        for(Iterator<Auto> it = autoprojekt.AutoProjekt.carsMarket.iterator(); it.hasNext();) {
            listModel.addElement(it.next().getModell());
            
        }
        this.carListMarket.setModel(listModel);
    }

    public void UpdateFields(){
        tempAuto = AutoProjekt.carsMarket.get(carListMarket.getSelectedIndex());
        this.carPowerLabel.setText("Leistung: " + String.valueOf(tempAuto.getLeistung()) + " PS");
        this.carColorLabel.setText("Farbe: " + tempAuto.getFarbe());
        this.carPriceLabel.setText("Preis: " + String.valueOf(tempAuto.getPreis()) + " €");
        this.carTypeLabel.setText("Typ: " + String.valueOf(tempAuto.getTyp()));
        this.carModleLabel.setText("Modell: " + tempAuto.getModell());
        this.carMarkeLabel1.setText("Marke: " + tempAuto.getMarke());
        
    }
    public void ResetFields(){
        this.carPowerLabel.setText("Leistung: ");
        this.carColorLabel.setText("Farbe: ");
        this.carPriceLabel.setText("Preis: ");
        this.carTypeLabel.setText("Typ: ");
        this.carModleLabel.setText("Modell: ");
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
        carListMarket = new javax.swing.JList();
        sellCarButton = new javax.swing.JButton();
        buyCarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        carList = new javax.swing.JList();
        merchantMoneyLabel = new javax.swing.JLabel();
        merchantNameLabel = new javax.swing.JLabel();
        carTypeLabel = new javax.swing.JLabel();
        carPriceLabel = new javax.swing.JLabel();
        carColorLabel = new javax.swing.JLabel();
        carPowerLabel = new javax.swing.JLabel();
        carModleLabel = new javax.swing.JLabel();
        carMarkeLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carListMarket.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(carListMarket);

        sellCarButton.setText("Sell Car");
        sellCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellCarButtonActionPerformed(evt);
            }
        });

        buyCarButton.setText("Buy Car");
        buyCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyCarButtonActionPerformed(evt);
            }
        });

        carList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(carList);

        merchantMoneyLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        merchantMoneyLabel.setText("Kapital:");

        merchantNameLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        merchantNameLabel.setText("Name:");

        carTypeLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carTypeLabel.setText("Autotyp:");

        carPriceLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carPriceLabel.setText("Autopreis:");

        carColorLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carColorLabel.setText("Autofarbe:");

        carPowerLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carPowerLabel.setText("Leistung:");

        carModleLabel.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carModleLabel.setText("Modell:");

        carMarkeLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        carMarkeLabel1.setText("Marke:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sellCarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(buyCarButton)
                        .addGap(44, 44, 44))
                    .addComponent(carColorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carPowerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carModleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(merchantMoneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(merchantNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carMarkeLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(merchantNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(merchantMoneyLabel)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sellCarButton)
                            .addComponent(buyCarButton))
                        .addGap(18, 18, 18)
                        .addComponent(carTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carColorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carPowerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carModleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carMarkeLabel1)
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sellCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellCarButtonActionPerformed
        if(carList.getSelectedValue() != null){
            this.haendler.SellAuto(haendlerTempAuto);
            this.merchantMoneyLabel.setText("Kapital: " + haendler.GetKapital());
            AutoProjekt.carsMarket.add(haendlerTempAuto);
            this.ResetFields();
            this.UpdateHaendlerList();
            this.UpdateMarketList();
        }
    }//GEN-LAST:event_sellCarButtonActionPerformed

    private void buyCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyCarButtonActionPerformed
        if(carListMarket.getSelectedValue() != null) {
            this.haendler.BuyAuto(tempAuto);
            this.merchantMoneyLabel.setText("Kapital: " + haendler.GetKapital());
            AutoProjekt.carsMarket.remove(tempAuto);
            this.ResetFields();
            this.UpdateMarketList();
            this.UpdateHaendlerList();
        }
    }//GEN-LAST:event_buyCarButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyCarButton;
    private javax.swing.JLabel carColorLabel;
    private javax.swing.JList carList;
    private javax.swing.JList carListMarket;
    private javax.swing.JLabel carMarkeLabel1;
    private javax.swing.JLabel carModleLabel;
    private javax.swing.JLabel carPowerLabel;
    private javax.swing.JLabel carPriceLabel;
    private javax.swing.JLabel carTypeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel merchantMoneyLabel;
    private javax.swing.JLabel merchantNameLabel;
    private javax.swing.JButton sellCarButton;
    // End of variables declaration//GEN-END:variables
}