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
    public Object getValueAt(int row, int column) {
        //Aqui hago que me devue
        switch (column){
            case 0:
                return datos.get(row).getTitulo();
            case 1:
                return datos.get(row).getDescripcion();
            case 2:
                return datos.get(row).completada();
            case 3:
                return datos.get(row).getPrioridad().getDescripcion();
        }
        return null;

    }

    @Override
    public String getColumnName(int column) {return nombreColumnas[column]; }
}
