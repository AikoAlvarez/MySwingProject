package com.customui.components;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomTextField extends JTextField {
    private String placeholder = "";
    private Color borderColor = new Color(209, 213, 219);
    private Color focusColor = new Color(79, 70, 229);
    private Color currentBorderColor = borderColor;
    private final int cornerRadius = 12;

    private CustomTextField (String placeholder, int columns){
        super (columns);
        this.placeholder = placeholder;
        setOpaque(false);
        setFont (new Font("SansSerif", Font.PLAIN, 14));
        setForeground(new Color (31,41,55));

        // Bordes interiores 
        setBorder (new EmptyBorder (8,12,8,12));

        addFocusListener(new FocusListener(){
            @Override
            public void focusGained (FocusEvent e){
                currentBorderColor = focusColor;
                repaint ();
            }

            @Override
            public void focusLost (FocusEvent e){
                currentBorderColor = borderColor;
                repaint ();
            }
        });
    }

    @Override
    protected void paintComponent (Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // pintar fondo
        g2.setColor(Color.white);
        g2.fillRoundRect(0,0, getWidth()-1, getHeight()-1 , cornerRadius, cornerRadius);
    
        // linea de contorno dinamica
        g2.setColor(currentBorderColor);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
    
        g2.dispose();

        super.paintComponent(g);

        // placeholder cuando la linea de texto este vacia y sin foco
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D gPlaceholder = (Graphics2D) g.create();
            gPlaceholder.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gPlaceholder.setColor(new Color(156, 163, 175));
            gPlaceholder.setFont(getFont().deriveFont(Font.ITALIC));
            
            Insets insets = getInsets();
            FontMetrics fm = gPlaceholder.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            
            gPlaceholder.drawString(placeholder, insets.left, y);
            gPlaceholder.dispose();
        }
    }
}
