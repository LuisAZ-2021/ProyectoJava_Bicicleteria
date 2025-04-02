/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Bicicleta;
import modelo.Utilidades;
import vista.VentanaPrograma;

/**
 *
 * @author Luis
 */
public class ControladorPrograma implements ActionListener {

    //Atributos
    private VentanaPrograma ventanaPrograma;
    private Bicicleta bicicleta;
    private ArrayList<Bicicleta> listaBicicleta;

    //Constructor
    public ControladorPrograma() {
        ventanaPrograma = new VentanaPrograma();
        ventanaPrograma.setLocationRelativeTo(ventanaPrograma);
        ventanaPrograma.setVisible(true);
        ventanaPrograma.setActionListener(this);

        listaBicicleta = new ArrayList<>();
        listaBicicleta = Utilidades.leerArchivo();
        ventanaPrograma.mostrarListaBicicletaTabla(listaBicicleta);
        ventanaPrograma.ajustarColumnasTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Guardar":
                //Obtener una Bicicleta
                bicicleta = ventanaPrograma.obtenerObjetoBicicleta();
                if (bicicleta != null) {
                    //Limpiamos los campos
                    ventanaPrograma.limpiarCampos();
                    //Mensaje de confirmacion
                    JOptionPane.showMessageDialog(ventanaPrograma, "Bicicleta cargada correctamente...");
                    listaBicicleta = Utilidades.agregarBicicletaALista(listaBicicleta, bicicleta);
                    ventanaPrograma.addAListaBicicleta(bicicleta);
                    Utilidades.escribirEnArchivo(listaBicicleta);
                }
                break;
            case "Eliminar":
                listaBicicleta = Utilidades.eliminamosUnElemento(ventanaPrograma.eliminarFila());
                ventanaPrograma.limpiarCampos();
                break;
            case "Actualizar":
                //Obtenermos la Bicicleta a Actualizar
                bicicleta = ventanaPrograma.obtenerObjetoBicicleta();
                if (bicicleta != null) {
                    if (ventanaPrograma.filaAActualizar() != -1) {
                        Utilidades.actualizarUnElemento(ventanaPrograma.filaAActualizar(), bicicleta);
                        JOptionPane.showMessageDialog(null, "Actualizado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada.");
                    }
                    ventanaPrograma.limpiarCampos();
                    ventanaPrograma.limpiarTabla();
                    listaBicicleta = Utilidades.leerArchivo();
                    ventanaPrograma.mostrarListaBicicletaTabla(listaBicicleta);
                }

                break;
            case "Limpiar":
                //Limpiamos todos los campos
                ventanaPrograma.limpiarCampos();
                break;
            default:
                throw new AssertionError();
        }
    }

}
