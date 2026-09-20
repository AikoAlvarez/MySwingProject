package com.customui.components;

import java.awt.*;
import javax.swing.*;

public class GradientPanel extends JPanel {
    private Color startColor = new Color (243, 244, 246);
    private Color endColor = new Color (229,231,235);
    private int cornerRadius = 0;

    public GradientPanel (){
        setOpaque(false);
    }

    // Constructor con parametros
    public GradientPanel (Color startColor, Color endColor, int cornerRadius){
        if (startColor != null) this.startColor = startColor;
        if (endColor != null) this.endColor = endColor;
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent (Graphics g){
        // limpiar la superficie
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();


        // si el componenete aun no se ha dibujado en pantalla
        if (width <= 0 || height <= 0) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // crear y aplicar el gradiente
        GradientPaint gp = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2.setPaint(gp);

        if (cornerRadius > 0) {
            g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        } else {
            g2.fillRect(0, 0, width, height);
        }

        g2.dispose();
    }


    // Getters y Setters
    public Color getStartColor() { return startColor; }
    public void setStartColor(Color startColor) { this.startColor = startColor; }

    public Color getEndColor() { return endColor; }
    public void setEndColor(Color endColor) { this.endColor = endColor; }

    public int getCornerRadius() { return cornerRadius; }
    public void setCornerRadius(int cornerRadius) { this.cornerRadius = cornerRadius; }
}
