package vista;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class Tabla extends JTable {

    public Tabla(AbstractTableModel modelo){
        super(modelo);
        setAutoCreateRowSorter(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ajustarAnchoColumnas();

    }

    public void ajustarAnchoColumnas(){
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(80);
    }
}
