/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clipboardops;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Alonso del Arte
 */
public class ImageSelectionNGTest {
    
    public ImageSelectionNGTest() {
    }

    /**
     * Test of getTransferDataFlavors method, of class ImageSelection.
     */
    @Test
    public void testGetTransferDataFlavors() {
        System.out.println("getTransferDataFlavors");
        ImageSelection instance = null;
        DataFlavor[] expResult = null;
        DataFlavor[] result = instance.getTransferDataFlavors();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDataFlavorSupported method, of class ImageSelection.
     */
    @Test
    public void testIsDataFlavorSupported() {
        System.out.println("isDataFlavorSupported");
        DataFlavor flavor = null;
        ImageSelection instance = null;
        boolean expResult = false;
        boolean result = instance.isDataFlavorSupported(flavor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransferData method, of class ImageSelection.
     */
    @Test
    public void testGetTransferData() throws Exception {
        System.out.println("getTransferData");
        DataFlavor flavor = null;
        ImageSelection instance = null;
        Object expResult = null;
        Object result = instance.getTransferData(flavor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lostOwnership method, of class ImageSelection.
     */
    @Test
    public void testLostOwnership() {
        System.out.println("lostOwnership");
        Clipboard clipboard = null;
        Transferable contents = null;
        ImageSelection instance = null;
        instance.lostOwnership(clipboard, contents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasOwnership method, of class ImageSelection.
     */
    @Test
    public void testHasOwnership() {
        System.out.println("hasOwnership");
        ImageSelection instance = null;
        boolean expResult = false;
        boolean result = instance.hasOwnership();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
