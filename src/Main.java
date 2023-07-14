import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class nuevo {
    private String marca;
    private String modelo;

    public nuevo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
class VentanaNavegacion {
    private ArrayList<nuevo> vehiculos;
    private int indice = 0;

    public void mostrarVentana(ArrayList<nuevo> vehiculos) {
        this.vehiculos = vehiculos;

        JFrame frame = new JFrame("Ventana de Navegación");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout());
        JPanel panelInferior = new JPanel(new FlowLayout());

        JLabel etiquetaMarca = new JLabel("Marca: ");
        JLabel etiquetaModelo = new JLabel("Modelo: ");

        JLabel etiquetaMarcaValor = new JLabel();
        JLabel etiquetaModeloValor = new JLabel();

        JButton botonAtras = new JButton("Atrás");
        JButton botonAdelante = new JButton("Adelante");

        panelSuperior.add(etiquetaMarca);
        panelSuperior.add(etiquetaMarcaValor);
        panelSuperior.add(etiquetaModelo);
        panelSuperior.add(etiquetaModeloValor);

        panelInferior.add(botonAtras);
        panelInferior.add(botonAdelante);

        mostrarVehiculoActual(etiquetaMarcaValor, etiquetaModeloValor);

        frame.add(panelSuperior, BorderLayout.CENTER);
        frame.add(panelInferior, BorderLayout.SOUTH);

        botonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indice > 0) {
                    indice--;
                    mostrarVehiculoActual(etiquetaMarcaValor, etiquetaModeloValor);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay más vehículos");
                }
            }
        });

        botonAdelante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indice < vehiculos.size() - 1) {
                    indice++;
                    mostrarVehiculoActual(etiquetaMarcaValor, etiquetaModeloValor);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay más vehículos");
                }
            }
        });

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void mostrarVehiculoActual(JLabel etiquetaMarcaValor, JLabel etiquetaModeloValor) {
        nuevo vehiculo = vehiculos.get(indice);
        etiquetaMarcaValor.setText(vehiculo.getMarca());
        etiquetaModeloValor.setText(vehiculo.getModelo());
    }
}

