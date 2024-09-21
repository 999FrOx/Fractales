package Fractales;

    import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

    public class Fractal extends JFrame {

        private int nivelDeRecursividad = 6;

        public Fractal() {
            setTitle("Fractal - Triángulo de Sierpinski");
            setSize(800, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // Establecer los puntos iniciales del triángulo
            int x1 = 400, y1 = 50;
            int x2 = 50, y2 = 700;
            int x3 = 750, y3 = 700;

            // Dibujar el fractal de forma recursiva
            dibujarFractal(g, nivelDeRecursividad, x1, y1, x2, y2, x3, y3);
        }

        private void dibujarFractal(Graphics g, int nivel, int x1, int y1, int x2, int y2, int x3, int y3) {
            if (nivel == 0) {
                // Dibujar un triángulo
                g.setColor(Color.RED);
                g.drawLine(x1, y1, x2, y2);
                g.drawLine(x2, y2, x3, y3);
                g.drawLine(x3, y3, x1, y1);
            } else {
                // Calcular los puntos medios de cada lado del triángulo
                int mx1 = (x1 + x2) / 2;
                int my1 = (y1 + y2) / 2;
                int mx2 = (x2 + x3) / 2;
                int my2 = (y2 + y3) / 2;
                int mx3 = (x3 + x1) / 2;
                int my3 = (y3 + y1) / 2;

                // Dibujar recursivamente triángulos más pequeños
                dibujarFractal(g, nivel - 1, x1, y1, mx1, my1, mx3, my3);
                dibujarFractal(g, nivel - 1, mx1, my1, x2, y2, mx2, my2);
                dibujarFractal(g, nivel - 1, mx3, my3, mx2, my2, x3, y3);
            }
        }

        public static void main(String[] args) {
            new Fractal();
        }
    }

