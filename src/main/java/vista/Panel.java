package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.TareaNoExistenteException;
import modelo.tarea.Prioridad;
import modelo.tarea.Tarea;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;

public class Panel extends JPanel implements InterrogaVista{
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private ModeloTabla modeloTabla;
    private Tabla tabla;

    public Panel(){
        super();
        creaPanel();
    }

    public void setModelo(InterrogaModelo modelo) { this.modelo = modelo; }

    public void setControlador(Controlador controlador) { this.controlador = controlador; }

    public void setVista(InformaVista vista) { this.vista = vista; }

    private void creaPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Escuchador de los botones:
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String comando = actionEvent.getActionCommand();
                if(comando.equals("nuevo")) {
                    controlador.anadirCliente();
                }
                else if (comando.equals("actualiza")){
                    //WTF
                }
                else if (comando.equals("borra")){
                    try{
                        controlador.borrarCliente();
                    } catch (TareaNoExistenteException exception){
                        vista.accionDenegada(exception.getMessage());
                    }
                }
                else {
                    //WTFx2 comando.equals("aplicarFiltros"))
                }

            }
        };
        //SECCION FILTROS

        JPanel jPanelSeccionArriba = new JPanel();
        jPanelSeccionArriba.setLayout(new BoxLayout(jPanelSeccionArriba, BoxLayout.X_AXIS));


        //Prioridad
        JRadioButton alta = new JRadioButton("Alta");
        //Alomejor interesa establecer a los botones un SetActionComand:
        alta.setActionCommand("ALTA");
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton baja = new JRadioButton("Baja");
        JRadioButton todas = new JRadioButton("Todas", true);

        JPanel jPanelPrioridad = new JPanel();
        jPanelPrioridad.setLayout(new BoxLayout(jPanelPrioridad, BoxLayout.PAGE_AXIS));
        jPanelPrioridad.add(new JLabel("Prioridad"));
        jPanelPrioridad.add(alta);
        jPanelPrioridad.add(normal);
        jPanelPrioridad.add(baja);
        jPanelPrioridad.add(todas);

        ButtonGroup grupoPrioridad = new ButtonGroup();
        grupoPrioridad.add(alta);
        grupoPrioridad.add(normal);
        grupoPrioridad.add(baja);
        grupoPrioridad.add(todas);

        jPanelSeccionArriba.add(jPanelPrioridad);

        //Completadas
        JRadioButton completada = new JRadioButton("Completada");
        JRadioButton noCompletada = new JRadioButton("No completada");
        JRadioButton todas2 = new JRadioButton("Todas", true);

        JPanel jPanelCompletadas = new JPanel();
        jPanelCompletadas.setLayout(new BoxLayout(jPanelCompletadas, BoxLayout.PAGE_AXIS));
        jPanelCompletadas.add(new JLabel("Completadas"));
        jPanelCompletadas.add(completada);
        jPanelCompletadas.add(noCompletada);
        jPanelCompletadas.add(todas2);

        ButtonGroup grupoCompletadas = new ButtonGroup();
        grupoCompletadas.add(completada);
        grupoCompletadas.add(noCompletada);
        grupoCompletadas.add(todas2);


        jPanelSeccionArriba.add(jPanelCompletadas);

        //Botón filtra:
        JButton aplicarFiltros = new JButton("Aplicar filtros");
        aplicarFiltros.setActionCommand("aplicarFiltros");

        jPanelSeccionArriba.add(aplicarFiltros);

        this.add(jPanelSeccionArriba);


        //SECCION LISTA DE TAREAS

        JPanel jPanelSeccionMedia = new JPanel();
        jPanelSeccionMedia.setLayout(new BoxLayout(jPanelSeccionMedia, BoxLayout.X_AXIS));



        String[] columnas = {"Tarea","Descripcion", "Terminada", "Prioridad"};
        //TODO: ESTO HABRA QUE CAMBIARLO CUANDO SE HAGA MVC:
        Tarea llamarDentista = new Tarea("Llamar al dentista", "Pedir cita para limpieza bucal", Prioridad.ALTA, true);
        Tarea irDentista = new Tarea("Ir al dentista", "Limpieza bucal a las 16 30", Prioridad.ALTA, false);
        Tarea estudiar = new Tarea("Estudiar", "Estudiar programacion", Prioridad.ALTA, false);
        Tarea entrenar = new Tarea("Entrenar", "Ir al gimnasio", Prioridad.NORMAL, true);
        Tarea listarCompra = new Tarea("Listar Compra", "Hacer lista de la compra", Prioridad.NORMAL, false);
        Tarea hacerCompra = new Tarea("Comprar", "Ir a comprar", Prioridad.BAJA, true);
        Tarea hacerCompra2 = new Tarea("Comprar", "Comprar mas", Prioridad.BAJA, false);
        Collection<Tarea> tareas = new LinkedList<>();
        tareas.add(llamarDentista);
        tareas.add(irDentista);
        tareas.add(estudiar);
        tareas.add(entrenar);
//        tareas.add(listarCompra);
//        tareas.add(hacerCompra);
//        tareas.add(hacerCompra2);
        modeloTabla = new ModeloTabla(columnas, tareas);
        tabla = new Tabla(modeloTabla);

        //crea el escuchador de la tabla
        ListSelectionListener escuchadorTabla = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //si se ejecuta este metodo porque se da al boton de actualizar
                //y no se selecciona ninguna fila
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if(lsm.getMinSelectionIndex() == -1) return;

                if (!e.getValueIsAdjusting()) {
                    int fila = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                    //TODO: Aqui estaria muy bien obtener el codigo
                    String titulo = (String) modeloTabla.getValueAt(fila, 0);
                    //datosFactura(codTabla);
                }
            }
        };

        jPanelSeccionMedia.add(tabla);
        Scroll scroll = new Scroll();
        jPanelSeccionMedia = scroll.ejecuta(tabla, jPanelSeccionMedia, escuchadorTabla);
        this.add(jPanelSeccionMedia);


        //SECCION DETALLE DE LA TAREA
        JPanel jPanelseccionBaja = new JPanel();
        jPanelseccionBaja.setLayout(new BoxLayout(jPanelseccionBaja, BoxLayout.Y_AXIS));

        //Titulo:

        JPanel titulo = new JPanel();
        titulo.setLayout(new BoxLayout(titulo, BoxLayout.X_AXIS));

        titulo.add(new JLabel("Título: "));
        titulo.add(new JTextField("Volver a mirar las estrellas. "));

        jPanelseccionBaja.add(titulo);

        //Descripcion:
        JPanel descripcion = new JPanel();
        descripcion.setLayout(new BoxLayout(descripcion, BoxLayout.X_AXIS));

        descripcion.add(new JLabel("Descripcion: "));
        descripcion.add(new JTextArea(5, 1));

        jPanelseccionBaja.add(descripcion);

        //Estado
        JCheckBox completado = new JCheckBox("Completada");

        jPanelseccionBaja.add(completado);

        //Prioridad
        JPanel prioridad = new JPanel();
        prioridad.setLayout(new BoxLayout(prioridad, BoxLayout.X_AXIS));

        JRadioButton alta2 = new JRadioButton("Alta");
        JRadioButton normal2 = new JRadioButton("Normal");
        JRadioButton baja2 = new JRadioButton("Baja", true);

        prioridad.add(alta2);
        prioridad.add(normal2);
        prioridad.add(baja2);

        ButtonGroup grupoPrioridad2 = new ButtonGroup();
        grupoPrioridad2.add(alta2);
        grupoPrioridad2.add(normal2);
        grupoPrioridad2.add(baja2);

        jPanelseccionBaja.add(prioridad);

        //Botones:
        JPanel botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

        JButton jButtonNuevo = new JButton("Nuevo");
        jButtonNuevo.setActionCommand("nuevo");
        JButton jButtonActualiza = new JButton("Actualiza");
        jButtonActualiza.setActionCommand("actualiza");
        JButton jButtonBorra = new JButton("Borra");
        jButtonBorra.setActionCommand("borra");

        botones.add(jButtonNuevo);
        botones.add(jButtonActualiza);
        botones.add(jButtonBorra);

        jPanelseccionBaja.add(botones);

        this.add(jPanelseccionBaja);

    }


    @Override
    public Panel getPanel() {
        return this;
    }

    @Override
    public String getTitulo() {
        return null ;
    }

    @Override
    public String getDescripcion() {
        return null;
    }

    @Override
    public Prioridad getPrioridad() {
        return null;
    }

    @Override
    public boolean getCompletado() {
        return false;
    }

    @Override
    public int getCodigo() {
        return 0;
    }
}
