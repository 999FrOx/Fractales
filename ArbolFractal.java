package Fractales;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class ArbolFractal extends JFrame {

    private int nivelDeRecursividad = 10; // Nivel de recursividad ajustable

    public ArbolFractal() {
        setTitle("Fractal - Árbol Fractal");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        // Dibujar el tronco inicial del árbol
        dibujarArbol(g, nivelDeRecursividad, 400, 700, -90, 120);
    }

    private void dibujarArbol(Graphics g, int nivel, int x1, int y1, double angulo, double longitud) {
        if (nivel == 0) {
            return;
        }

        // Calcular las nuevas coordenadas para la rama
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angulo)) * longitud);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angulo)) * longitud);

        // Dibujar la línea (rama)
        g.drawLine(x1, y1, x2, y2);

        // Recursivamente dibujar las ramas
        dibujarArbol(g, nivel - 1, x2, y2, angulo - 30, longitud * 0.7); // Rama izquierda
        dibujarArbol(g, nivel - 1, x2, y2, angulo + 30, longitud * 0.7); // Rama derecha
    }

    public static void main(String[] args) {
        new ArbolFractal();
    }
}

