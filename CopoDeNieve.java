package Fractales;
import javax.swing.JFrame;
import java.awt.Graphics;

public class CopoDeNieve extends JFrame {

    private int nivelDeRecursividad = 5; // Nivel de recursión ajustable

    public CopoDeNieve() {
        setTitle("Fractal - Copo de Nieve de Koch");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Coordenadas iniciales para el triángulo equilátero
        int x1 = 200, y1 = 300;
        int x2 = 600, y2 = 300;
        int x3 = 400, y3 = (int) (300 + (Math.sqrt(3) / 2 * (x2 - x1)));

        // Dibujar el fractal recursivamente
        dibujarKoch(g, nivelDeRecursividad, x1, y1, x2, y2);
        dibujarKoch(g, nivelDeRecursividad, x2, y2, x3, y3);
        dibujarKoch(g, nivelDeRecursividad, x3, y3, x1, y1);
    }

    private void dibujarKoch(Graphics g, int nivel, int x1, int y1, int x2, int y2) {
        if (nivel == 0) {
            // Dibujar línea base
            g.drawLine(x1, y1, x2, y2);
        } else {
            // Calcular los puntos intermedios
            int deltaX = (x2 - x1) / 3;
            int deltaY = (y2 - y1) / 3;

            int xA = x1 + deltaX;
            int yA = y1 + deltaY;

            int xB = x1 + 2 * deltaX;
            int yB = y1 + 2 * deltaY;

            // Punto superior que crea el pico del triángulo
            double angulo60 = Math.PI / 3;
            int xC = (int) ((xA + xB) / 2 + Math.sin(angulo60) * (yA - yB));
            int yC = (int) ((yA + yB) / 2 + Math.sin(angulo60) * (xB - xA));

            // Llamada recursiva para cada segmento
            dibujarKoch(g, nivel - 1, x1, y1, xA, yA);
            dibujarKoch(g, nivel - 1, xA, yA, xC, yC);
            dibujarKoch(g, nivel - 1, xC, yC, xB, yB);
            dibujarKoch(g, nivel - 1, xB, yB, x2, y2);
        }
    }

    public static void main(String[] args) {
        new CopoDeNieve();
    }
}
