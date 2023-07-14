import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Vehiculo {
    private static ArrayList<nuevo> vehiculos = new ArrayList<>();
    private static int indice = 0;

    public Vehiculo(String marca, String modelo) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout());
        JPanel panelInferior = new JPanel(new FlowLayout());

        JLabel etiquetaMarca = new JLabel("Marca:");
        JTextField campoMarca = new JTextField(10);
        JLabel etiquetaModelo = new JLabel("Modelo:");
        JTextField campoModelo = new JTextField(10);

        JButton botonGuardar = new JButton("Guardar");
        JButton botonCargar = new JButton("Cargar");

        panelSuperior.add(etiquetaMarca);
        panelSuperior.add(campoMarca);
        panelSuperior.add(etiquetaModelo);
        panelSuperior.add(campoModelo);

        panelInferior.add(botonGuardar);
        panelInferior.add(botonCargar);

        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelInferior, BorderLayout.SOUTH);

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String marca = campoMarca.getText();
                String modelo = campoModelo.getText();
                nuevo vehiculo = new nuevo(marca, modelo);
                vehiculos.add(vehiculo);
                campoMarca.setText("");
                campoModelo.setText("");
                JOptionPane.showMessageDialog(null, "Vehículo guardado exitosamente");
            }
        });

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaNavegacion ventanaNavegacion = new VentanaNavegacion();
                ventanaNavegacion.mostrarVentana(vehiculos);
            }
        });

        frame.setSize(400, 120);
        frame.setVisible(true);
    }
}

