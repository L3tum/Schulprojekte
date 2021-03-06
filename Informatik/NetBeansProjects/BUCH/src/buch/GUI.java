/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buch;

import buch.Buchhaendler;
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
    Buchhaendler haendler;
    BUCH tempBuch;
    
    /**
     * Creates new form GUI
     */
    public GUI(Buchhaendler haendler) {
        initComponents();
        listModel = new DefaultListModel();
        this.haendler = haendler;
        this.buecherList.addListSelectionListener(new ListSelectionListener(
        
        ) {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(buecherList.getSelectedIndex() != -1){
                   UpdateFieldsHaendler(); 
                   buecherList.setSelectedIndex(-1);
                }
                
                
            }
        });
        this.UpdateMarketList();
        
    }
    
    public void UpdateFieldsHaendler(){
        tempBuch = haendler.buecher.get(buecherList.getSelectedIndex());
        this.titelL.setText(tempBuch.getTitel());
        this.autorL.setText(tempBuch.getAutor());
        this.ISBNL.setText(tempBuch.getISBN());
        this.kategorieL.setText(((Fachbuch)tempBuch).getKategorie());
        this.gattungL.setText(((fiktionalesBuch)tempBuch).getGattung());
        this.dauerL.setText(String.valueOf(((Hoerbuch)tempBuch).getDauer()));
        this.mediumL.setText(((Hoerbuch)tempBuch).getMedium());
        this.sprecherL.setText(((Hoerbuch)tempBuch).getSprecher());
        this.preisL.setText(String.valueOf(tempBuch.getPreis()));
        this.anzahlL.setText(String.valueOf(tempBuch.getAnzahl()));
    }
    
    public void UpdateMarketList() {
        listModel.clear();
        for(Iterator<BUCH> it = haendler.buecher.iterator(); it.hasNext();) {
            listModel.addElement(it.next().getTitel());
            
        }
        this.buecherList.setModel(listModel);
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
        buecherList = new javax.swing.JList();
        autorL = new javax.swing.JLabel();
        titelL = new javax.swing.JLabel();
        ISBNL = new javax.swing.JLabel();
        kategorieL = new javax.swing.JLabel();
        gattungL = new javax.swing.JLabel();
        dauerL = new javax.swing.JLabel();
        sprecherL = new javax.swing.JLabel();
        mediumL = new javax.swing.JLabel();
        anzahlL = new javax.swing.JLabel();
        preisL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buecherList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(buecherList);

        autorL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        autorL.setText("Autor:");

        titelL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        titelL.setText("Titel:");

        ISBNL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        ISBNL.setText("ISBN:");

        kategorieL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        kategorieL.setText("Kategorie:");

        gattungL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        gattungL.setText("Gattung:");

        dauerL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        dauerL.setText("Dauer:");

        sprecherL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        sprecherL.setText("Sprecher:");

        mediumL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        mediumL.setText("Medium:");

        anzahlL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        anzahlL.setText("Anzahl:");

        preisL.setFont(new java.awt.Font("Microsoft JhengHei", 3, 12)); // NOI18N
        preisL.setText("Preis:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titelL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(autorL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ISBNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kategorieL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gattungL, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addComponent(dauerL, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addComponent(sprecherL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mediumL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anzahlL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preisL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(titelL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autorL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ISBNL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategorieL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gattungL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dauerL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sprecherL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mediumL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preisL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anzahlL)
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ISBNL;
    private javax.swing.JLabel anzahlL;
    private javax.swing.JLabel autorL;
    private javax.swing.JList buecherList;
    private javax.swing.JLabel dauerL;
    private javax.swing.JLabel gattungL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kategorieL;
    private javax.swing.JLabel mediumL;
    private javax.swing.JLabel preisL;
    private javax.swing.JLabel sprecherL;
    private javax.swing.JLabel titelL;
    // End of variables declaration//GEN-END:variables
}
