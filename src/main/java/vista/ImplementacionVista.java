package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.tarea.Tarea;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;


public class ImplementacionVista implements InformaVista, InterrogaVista{
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
                controlador.importarDatos();
                panel.cargarDatosTabla();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                controlador.exportarDatos();
                System.exit(0);
            }
        });
    }



    @Override
    public Panel getPanel() {
        return this.panel;
    }

    @Override
    public String getFiltroPrioridad() {
        return this.panel.getFiltroPrioridad();
    }

    @Override
    public String getFiltroCompletado() {
        return this.panel.getFiltroCompletado();
    }

    @Override
    public String getTitulo() {
        return this.panel.getTitulo();
    }

    @Override
    public String getDescripcion() {
        return this.panel.getDescripcion();
    }

    @Override
    public String getPrioridad() {
        return this.panel.getPrioridad();
    }

    @Override
    public void aplicarFiltros(Collection<Tarea> tareas){
        this.panel.aplicarFiltros(tareas);
    }

    @Override
    public boolean getCompletado() {
        return this.panel.getCompletado();
    }

    @Override
    public int getCodigo() {
        return this.panel.getCodigo();
    }

}
