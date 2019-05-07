package com.mariano.planets.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animate {

    public static void main(String[] args) {
        new Animate();
    }

    public Animate() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new SwordPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SwordPane extends JPanel {

        private double angle = 0;

        public SwordPane() {

            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 10;
                    if (angle > 360) {
                        angle -= 360;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            int width = 2;
            int height = 2;

            return new Dimension(width * 2, height * 2);
        }

        protected Point getSwordHandlePoint() {

            int radius = 272; // This is the height of the character...

            int x = Math.round(getWidth() / 2);
            int y = Math.round(getHeight() / 2);

            double rads = Math.toRadians(angle - 180); // Make 0 point out to the right...
            // If you add sword.getWidth, you might be able to change the above...
            int fullLength = Math.round((radius / 2f)) - 2;

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * fullLength));
            int yPosy = Math.round((float) (y - Math.sin(rads) * fullLength));

            return new Point(xPosy, yPosy);

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            int x = 5;
            int y = 8;
            Rectangle tangle = new Rectangle(0, 0, 50, 50);
//g2d.translate(centerX, centerY);
            g2d.rotate(Math.toRadians(angle), 20, 22);
            g2d.draw(tangle);

            g2d.dispose();

        }
    }
}

