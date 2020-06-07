package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImplementacionVista implements InformaVista{
    private Controlador controlador;
    private Panel panel;

    public ImplementacionVista(){
        super();
        this.panel = new Panel();
        this.panel.setVista(this);
    }

    public void setModelo(InterrogaModelo modelo){
        this.panel.setModelo(modelo);
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
        this.panel.setControlador(controlador);

    }

    @Override
    public void accionPermitida(String cadena){
        JOptionPane.showMessageDialog(null, cadena);
    }

    @Override
    public void accionDenegada(String cadena){
        JOptionPane.showMessageDialog(null, cadena,"Error", JOptionPane.WARNING_MESSAGE);
    }

    public void creaGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { ventanaPrincipal(); }
        });
    }

    private void ventanaPrincipal(){
        JFrame ventana = new JFrame("Mis tareas");
        ventana.add(this.panel);
        ventana.pack();
        ventana.setVisible(true);


        //Clase (interna) para importarDatos al abrir y exportarDatos al cerrar
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                //controlador.importarDatos();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //controlador.exportarDatosYSalir();
                System.exit(0);
            }
        });
    }
}
