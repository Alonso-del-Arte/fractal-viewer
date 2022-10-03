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
package fractalviewer;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Alonso del Arte
 */
public class ViewerNGTest {
    
    // TODO: Delete menuItemsMatch() function after next commit
    private static boolean menuItemsMatch(JMenuItem menuItemA, 
            JMenuItem menuItemB) {
        return menuItemA.getText().equals(menuItemB.getText()) 
                && menuItemA.getAccessibleContext().getAccessibleDescription()
                        .equals(menuItemB.getAccessibleContext()
                                .getAccessibleDescription()) 
                && menuItemA.getActionCommand()
                        .equals(menuItemB.getActionCommand()) 
                && menuItemA.getAccelerator().equals(menuItemB.getAccelerator()) 
                && Arrays.equals(menuItemA.getActionListeners(), 
                        menuItemB.getActionListeners());
    }
    
    private static void assertMenuItemsMatch(JMenuItem actual, 
            JMenuItem expected) {
        assertEquals(actual.getText(), expected.getText(), 
                "Menu texts should match");
        assertEquals(actual.getAccessibleContext().getAccessibleDescription(), 
                expected.getAccessibleContext().getAccessibleDescription(), 
                "Accessible descriptions should match");
        assertEquals(actual.getActionCommand(), expected.getActionCommand(), 
                "Action commands should match");
        assertEquals(actual.getAccelerator(), expected.getAccelerator(), 
                "Accelerators should match");
        assertEquals(actual.getActionListeners(), expected.getActionListeners(), 
                "Arrays of action listeners should match");
    }
    
    /**
     * Test of makeMenuItem method, of class Viewer.
     */
    @Test
    public void testMakeMenuItem() {
        System.out.println("makeMenuItem");
        String menuItemText = "Example command";
        String accDescr = "Example command for testing purposes";
        String actionCommand = "example";
        KeyStroke accelerator = KeyStroke.getKeyStroke('X');
        Viewer instance = new ViewerImpl();
        JMenuItem expected = new JMenuItem(menuItemText);
        expected.getAccessibleContext().setAccessibleDescription(accDescr);
        expected.setActionCommand(actionCommand);
        expected.setAccelerator(accelerator);
        expected.addActionListener(instance);
        JMenuItem actual = instance.makeMenuItem(menuItemText, accDescr, 
                actionCommand, accelerator);
        assertMenuItemsMatch(actual, expected);
    }

    /**
     * Test of lostOwnership method, of class Viewer.
     */
    @Test
    public void testLostOwnership() {
        System.out.println("lostOwnership");
//        Clipboard clipboard = null;
//        Transferable contents = null;
//        Viewer instance = new ViewerImpl();
//        instance.lostOwnership(clipboard, contents);
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
