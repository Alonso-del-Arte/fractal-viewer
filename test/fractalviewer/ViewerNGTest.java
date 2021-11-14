/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalviewer;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Alonso del Arte
 */
public class ViewerNGTest {
    
    /**
     * Test of makeMenuItem method, of class Viewer.
     */
    @Test
    public void testMakeMenuItem() {
        System.out.println("makeMenuItem");
        String menuItemText = "";
        String accessibleDescription = "";
        String actionCommand = "";
        KeyStroke accelerator = null;
        Viewer instance = new ViewerImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.makeMenuItem(menuItemText, accessibleDescription, actionCommand, accelerator);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lostOwnership method, of class Viewer.
     */
    @Test
    public void testLostOwnership() {
        System.out.println("lostOwnership");
        Clipboard clipboard = null;
        Transferable contents = null;
        Viewer instance = new ViewerImpl();
        instance.lostOwnership(clipboard, contents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ViewerImpl extends Viewer {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
