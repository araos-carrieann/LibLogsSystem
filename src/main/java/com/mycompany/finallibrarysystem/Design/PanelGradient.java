/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem.Design;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import javax.swing.JLayeredPane;

/**
 *
 * @author araos
 */
public class PanelGradient extends JLayeredPane {

    public static enum Gradient {
        HORIZONTAL, VERTICAL, ESQUINA_1, ESQUINA_2, ESQUINA_3, ESQUINA_4, CIRCULAR, CENTRAL, AQUA;

        private Gradient() {
        }
    }

    protected Gradient gradient = Gradient.HORIZONTAL;
    protected Color colorPrimary = Color.WHITE;
    protected Color colorSecondary = Color.WHITE;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Paint gp = getGradientePaint();
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(getForeground());
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.dispose();
        super.paintComponent(g);
    }

    private Paint getGradientePaint() {
        int x1;
        int x2 = getWidth();
        int y1;
        int y2 = getHeight();
        switch (this.gradient) {
            case HORIZONTAL:
                x1 = getWidth() / 2;
                y1 = 0;
                x2 = getWidth() / 2;
                y2 = getHeight();
                return new GradientPaint(x1, y1, this.colorPrimary, x2, y2, this.colorSecondary);
            case VERTICAL:
                x1 = 0;
                y1 = getHeight() / 2;
                x2 = getWidth();
                y2 = getHeight() / 2;
                return new GradientPaint(x1, y1, this.colorPrimary, x2, y2, this.colorSecondary);
            case ESQUINA_1:
                x1 = 0;
                y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.colorPrimary, this.colorSecondary});
            case ESQUINA_2:
                x1 = getWidth();
                y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.colorPrimary, this.colorSecondary});
            case ESQUINA_3:
                x1 = getWidth();
                y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.colorPrimary, this.colorSecondary});
            case ESQUINA_4:
                x1 = 0;
                y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.colorPrimary, this.colorSecondary});
            case CIRCULAR:
                x1 = getWidth() / 2;
                y1 = getHeight() / 2;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 0.5F}, new Color[]{this.colorPrimary, this.colorSecondary});
            case CENTRAL:
                x1 = getWidth() / 2;
                y1 = 0;
                x2 = getWidth() / 2;
                y2 = getHeight();
                return new LinearGradientPaint(x1, y1, x2, y2, new float[]{0.0F, 0.5F, 1.0F}, new Color[]{this.colorPrimary, this.colorSecondary, this.colorPrimary});
            case AQUA:
                return new LinearGradientPaint(0.0F, 0.0F, 0.0F, getHeight(), new float[]{0.0F, 0.3F, 0.5F, 1.0F}, new Color[]{this.colorPrimary.brighter().brighter(), this.colorPrimary.brighter(), this.colorSecondary.darker().darker(), this.colorSecondary.darker()});
        }
        return new GradientPaint(0.0F, 0.0F, this.colorPrimary, x2, y2, this.colorSecondary);
    }

    public Color getColorPrimary() {
        return this.colorPrimary;
    }

    public void setColorPrimary(Color colorPrimary) {
        this.colorPrimary = colorPrimary;
    }

    public Color getColorSecondary() {
        return this.colorSecondary;
    }

    public void setColorSecondary(Color colorSecondary) {
        this.colorSecondary = colorSecondary;
    }

    public Gradient getGradient() {
        return this.gradient;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

}
