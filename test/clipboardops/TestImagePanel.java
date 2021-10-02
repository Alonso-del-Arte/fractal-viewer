/*
 * Copyright (C) 2021 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package clipboardops;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * A simple JComponent that creates a window with a simple image for the purpose 
 * of testing {@link ImageSelection}.
 * @author Alonso del Arte
 */
public final class TestImagePanel extends JPanel {
    
    /**
     * The background color, a blue with a tinge of green. RGB: 0080FF.
     */
    public static final Color BACKGROUND_COLOR = new Color(33023);
    
    /**
     * A blue green or green blue. RGB: 40FFC0.
     */
    public static final Color MEDIUM_GREEN = new Color(4259776);
    
    /**
     * The height of this panel's paintable area. Does not include title bar, 
     * menu bar (if applicable), nor bottom frame border.
     */
    public static final int PANEL_HEIGHT = 300;
    
    /**
     * The width of this panel's paintable area. Does not include left or right 
     * frame borders.
     */
    public static final int PANEL_WIDTH = 400;
    
    private JFrame frame;
    
    /**
     * Paints a very simple image to the passed in <code>Graphics</code> object.
     * @param g The <code>Graphics</code> object to paint to.
     */
    @Override
    public void paintComponent(Graphics g) {
        int oneThirdHeight = PANEL_HEIGHT / 3;
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, PANEL_WIDTH, oneThirdHeight);
        g.setColor(MEDIUM_GREEN);
        int twoThirdsHeight = 2 * oneThirdHeight;
        g.fillRect(0, oneThirdHeight, PANEL_WIDTH, twoThirdsHeight);
        g.setColor(Color.BLACK);
        Font font = new Font(g.getFont().getFontName(), Font.PLAIN, 192);
        g.setFont(font);
        g.drawString("\u5CE0", 50, PANEL_HEIGHT - 50);
    }
    
    /**
     * Shows a panel with the test image painted on it.
     */
    private void showPanel() {
        this.frame = new JFrame("Test Image");
        this.frame.add(this);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    
    /**
     * Disposes of the frame containing this panel. It's probably a good idea to 
     * call this procedure in test tear down.
     */
    public void closePanel() {
        this.frame.dispose();
    }
    
    /**
     * Constructor. No arguments needed.
     */
    public TestImagePanel() {
        this.setBackground(BACKGROUND_COLOR);
        Dimension prefDim = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        this.setPreferredSize(prefDim);
        this.showPanel();
    }
    
}
