package controlador;

import modelo.GestorTareas;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExportarDatos {
    public void guardarDatos(GestorTareas gestorTareas) {
        ObjectOutputStream oos = null;
        try {
            try {
                FileOutputStream fos = new FileOutputStream("AgendaTareas.bin");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(gestorTareas);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            } finally {
                oos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
