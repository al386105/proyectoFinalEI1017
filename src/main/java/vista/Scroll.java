package vista;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class Scroll {
    public Scroll (){ super(); }

    public JPanel ejecuta(Tabla tabla, JPanel panelIni, ListSelectionListener escuchadorTabla){
        JPanel panel = panelIni;

        //Se añade el escuchador de la tabla a la tabla
        ListSelectionModel listSelectionModel = tabla.getSelectionModel();
        listSelectionModel.addListSelectionListener(escuchadorTabla);

        //El scroll vertical se muestra cuando sea necesario:
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        return panel;
    }
}
