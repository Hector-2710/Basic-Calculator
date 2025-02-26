package Interfaces;

import Dominio.Operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private JPanel calculadorapannel;
    private JButton dividirButton;
    private JButton sumarButton;
    private JButton multiplicarButton;
    private JButton restarButton;
    private JTextField num1;
    private JTextField num2;
    private JLabel resultado;

    public Calculadora() throws HeadlessException {
        setup();
    }

    public JPanel setup() {
        setTitle("Calculadora");  // Título de la ventana
        setSize(300, 300);         // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel principal
        calculadorapannel = new JPanel();
        calculadorapannel.setLayout(new GridLayout(5, 2, 10, 10)); // GridLayout para los componentes
        calculadorapannel.setBackground(new Color(240, 240, 240)); // Color de fondo

        // Inicialización de componentes
        num1 = new JTextField();
        num2 = new JTextField();
        resultado = new JLabel("Resultado: ");

        // Estilo para el texto y borde
        resultado.setFont(new Font("Arial", Font.BOLD, 16));
        resultado.setForeground(new Color(50, 50, 50)); // Color de texto gris oscuro

        // Estilo de los JTextFields
        num1.setFont(new Font("Arial", Font.PLAIN, 14));
        num1.setHorizontalAlignment(JTextField.CENTER);
        num2.setFont(new Font("Arial", Font.PLAIN, 14));
        num2.setHorizontalAlignment(JTextField.CENTER);

        // Botones con colores y fuentes personalizadas
        sumarButton = new JButton("Sumar");
        restarButton = new JButton("Restar");
        multiplicarButton = new JButton("Multiplicar");
        dividirButton = new JButton("Dividir");

        // Estilo de los botones
        botonEstilo(sumarButton);
        botonEstilo(restarButton);
        botonEstilo(multiplicarButton);
        botonEstilo(dividirButton);

        // Agregar los componentes al panel
        calculadorapannel.add(new JLabel("Número 1: "));
        calculadorapannel.add(num1);
        calculadorapannel.add(new JLabel("Número 2: "));
        calculadorapannel.add(num2);
        calculadorapannel.add(sumarButton);
        calculadorapannel.add(restarButton);
        calculadorapannel.add(multiplicarButton);
        calculadorapannel.add(dividirButton);
        calculadorapannel.add(resultado);

        // Agregar panel a la ventana
        add(calculadorapannel);

        // Acción de los botones
        sumarButton.addActionListener(this);
        restarButton.addActionListener(this);
        multiplicarButton.addActionListener(this);
        dividirButton.addActionListener(this);
        setVisible(true);
        return calculadorapannel;
    }

    // Método para dar estilo a los botones
    private void botonEstilo(JButton boton) {
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBackground(new Color(50, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int nur = Integer.parseInt(num1.getText());
        int ner = Integer.parseInt(num2.getText());

        if (e.getSource() == sumarButton) {
            resultado.setText("Resultado: " + Operaciones.sumar(nur, ner));
        } else if (e.getSource() == restarButton) {
            resultado.setText("Resultado: " + Operaciones.restar(nur, ner));
        } else if (e.getSource() == multiplicarButton) {
            resultado.setText("Resultado: " + Operaciones.multiplicar(nur, ner));
        } else if (e.getSource() == dividirButton) {
            // Validar división por cero
            if (ner != 0) {
                resultado.setText("Resultado: " + Operaciones.dividir(nur, ner));
            } else {
                resultado.setText("Error: División por cero");
            }
        }
    }}