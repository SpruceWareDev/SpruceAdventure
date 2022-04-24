package com.spruce.adventure.ui.font;

import java.awt.*;

public class FontRenderer {

    public static void drawString(Graphics g, String text, int x, int y, Color c, Font font){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(c);
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public static void drawCenteredString(Graphics g, String text, int x, int y, Color c, Font font){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(c);
        g.setFont(font);

        FontMetrics fm = g.getFontMetrics(font);
        int renderX = x - fm.stringWidth(text) / 2;
        int renderY = (y - fm.getHeight() / 2) + fm.getAscent();
        g.drawString(text, renderX, renderY);
    }
}
