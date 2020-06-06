package vista;

import modelo.tarea.Tarea;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;

public class ModeloTabla extends AbstractTableModel {
    final String nombreColumnas[];
    ArrayList<Tarea> datos;

    public ModeloTabla (final String[] nombreColumnas, final Collection<Tarea> coleccion) {
        super();
        this.nombreColumnas = nombreColumnas;
        this.datos = new ArrayList<>();
        this.datos.addAll(coleccion);
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Tarea getValueAt(int row, int column) {
        //Aqui hago que me devue
        return datos.get(row);

    }

    @Override
    public String getColumnName(int column) {return nombreColumnas[column]; }
}
