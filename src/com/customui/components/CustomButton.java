package com.customui.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class CustomButton extends JButton {

    private Color normalColor = new Color (79,70,229);
    private Color hoverColor = new Color (99, 102, 241);
    private Color pressColor = new Color (67,56,202);
    private Color currentColor = normalColor;
    private int cornerRadius = 15;

    public CustomButton (String text){
        super (text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.white);
        setFont (new Font ("SansSerif", Font.BOLD,14));
        setCursor (new Cursor (Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered (MouseEvent e){
                currentColor = hoverColor;
                repaint ();
            }

            @Override
            public void mouseExited (MouseEvent e){
                currentColor = normalColor;
                repaint ();
            }

            @Override
            public void mousePressed (MouseEvent e){
                currentColor = pressColor;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e){
                currentColor = normalColor;
                repaint ();
            }
        });
    }

    @Override
    protected void paintComponent (Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();

        // Suavizado de contorno para bordes mas suaves
        g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rellenar fondo con esquinas redondeadas
        g2.setColor (currentColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.dispose ();

        // Dibujar el texto estandar del boton arriba
        super.paintComponent(g);
    }

    // setters
    public void setNormalColor(Color color) { this.normalColor = color; this.currentColor = color; }
    public void setHoverColor(Color color) { this.hoverColor = color; }
    public void setPressColor(Color color) { this.pressColor = color; }
    public void setCurrentColor(Color color) { this.currentColor = color; }
    public void setCornerRadius(int cornerRadius) { this.cornerRadius = cornerRadius; }
}
