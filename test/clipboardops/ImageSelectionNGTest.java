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

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Tests of the ImageSelection class.
 * @author Alonso del Arte
 */
public class ImageSelectionNGTest {
    
    private BufferedImage image;
    
    private ImageSelection imgSel;
    
    private TestImagePanel imageWindow;
    
    private Clipboard systemClipboard;
    
    private void reportClipboardContents() {
        DataFlavor[] flavors = this.systemClipboard.getAvailableDataFlavors();
        System.out.print("The clipboard has the following data flavors: ");
        System.out.println(Arrays.toString(flavors));
        if (Arrays.stream(flavors)
                .anyMatch(x -> x.equals(DataFlavor.stringFlavor))) {
            try {
                String contents = (String) this.systemClipboard
                        .getData(DataFlavor.stringFlavor);
                System.out.println("\"" + contents + "\"");
            } catch (UnsupportedFlavorException ufe) {
                System.out.println("Somehow " 
                        + DataFlavor.stringFlavor.toString() 
                        + " is not supported");
                System.out.println("\"" + ufe.getMessage() + "\"");
            } catch (IOException ioe) {
                System.out.println("Unexpected IOException occurred");
                System.out.println("\"" + ioe.getMessage() + "\"");
            }
        }
    }
    
    /**
     * Queries the system clipboard prior to the tests, sets up an image to use 
     * in the tests.
     */
    @BeforeSuite
    public void setUpClass() {
        this.imageWindow = new TestImagePanel();
        this.systemClipboard = this.imageWindow.getToolkit()
                .getSystemClipboard();
        this.reportClipboardContents();
        String initMsg = "This message was placed by setUpClass()";
        StringSelection strSel = new StringSelection(initMsg);
        this.systemClipboard.setContents(strSel, strSel);
        this.image = new BufferedImage(TestImagePanel.PANEL_WIDTH, 
                TestImagePanel.PANEL_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = this.image.createGraphics();
        this.imageWindow.paint(g);
        this.imgSel = new ImageSelection(image);
    }
    
    @BeforeMethod
    public void setUp() {
        String preMsg = "This message was placed by setUp()";
        StringSelection strSel = new StringSelection(preMsg);
        this.systemClipboard.setContents(strSel, strSel);
    }
    
    /**
     * Test of the getTransferDataFlavors function, of the ImageSelection class.
     */
    @Test
    public void testGetTransferDataFlavors() {
        System.out.println("getTransferDataFlavors");
        DataFlavor[] expected = {DataFlavor.imageFlavor};
        DataFlavor[] actual = this.imgSel.getTransferDataFlavors();
        assertEquals(actual, expected);
    }

    /**
     * Test of the isDataFlavorSupported function, of the ImageSelection class.
     */
    @Test
    public void testIsDataFlavorSupported() {
        System.out.println("isDataFlavorSupported");
        String msg = DataFlavor.imageFlavor.toString() + " should be supported";
        assert this.imgSel.isDataFlavorSupported(DataFlavor.imageFlavor) : msg;
    }

    /**
     * Another test of the isDataFlavorSupported function, of the ImageSelection 
     * class.
     */
    @Test
    public void testDataFlavorIsNotSupported() {
        StringSelection strSel 
                = new StringSelection("Just for testing purposes");
        DataFlavor[] strSelFlavors = strSel.getTransferDataFlavors();
        for (DataFlavor flavor : strSelFlavors) {
            String msg = flavor.getHumanPresentableName() 
                    + " should not be supported by ImageSelection";
            assert !this.imgSel.isDataFlavorSupported(flavor) : msg;
        }
    }

    /**
     * Test of the getTransferData function, of the ImageSelection class.
     */
    @Test
    public void testGetTransferData() {
        System.out.println("getTransferData");
        Object data;
        try {
            data = imgSel.getTransferData(DataFlavor.imageFlavor);
            assertEquals(data, this.image);
        } catch (UnsupportedFlavorException ufe) {
            String msg = "Data test triggered UnsupportedFlavorException";
            System.out.println(msg);
            System.out.println("\"" + ufe.getMessage() + "\"");
            fail(msg);
        } catch (IOException ioe) {
            String msg = "testGetTransferData triggered IOException";
            System.out.println(msg);
            System.out.println("\"" + ioe.getMessage() + "\"");
            fail(msg);
        }
    }
    
    /**
     * Another test of the getTransferData function, of the ImageSelection 
     * class. The wrong data flavor should cause an exception.
     * @throws java.awt.datatransfer.UnsupportedFlavorException If this 
     * exception occurs, it should be caught by the TestNG test runner.
     * @throws java.io.IOException This exception should not occur for this 
     * test.
     */
    @Test(expectedExceptions = {UnsupportedFlavorException.class})
    public void testGetTransferDataRejectsWrongFlavor() 
            throws UnsupportedFlavorException, IOException {
        DataFlavor wrongFlavor = DataFlavor.allHtmlFlavor;
        Object data = this.imgSel.getTransferData(wrongFlavor);
        System.out.println("Should not have been able to retrieve " 
                + data.toString() + " with " 
                + wrongFlavor.getHumanPresentableName());
    }

    /**
     * Another test of the getTransferData function, of the ImageSelection 
     * class. Null for the data flavor should cause an exception.
     * @throws java.awt.datatransfer.UnsupportedFlavorException This exception 
     * should not occur for this test.
     * @throws java.io.IOException This exception should not occur for this 
     * test.
     */
    @Test(expectedExceptions = {NullPointerException.class})
    public void testGetTransferDataRejectsNull() 
            throws UnsupportedFlavorException, IOException {
        Object data = this.imgSel.getTransferData(null);
        System.out.println("Should not have been able to retrieve " 
                + data.toString() + " with null");
    }

    /**
     * Test of the lostOwnership procedure, of the ImageSelection class.
     */
    @Test
    public void testLostOwnership() {
        System.out.println("lostOwnership");
        Clipboard clipboard = null;
        Transferable contents = null;
        ImageSelection instance = null;
//        instance.lostOwnership(clipboard, contents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of the hasOwnership function, of the ImageSelection class.
     */
    @Test
    public void testHasOwnership() {
        System.out.println("hasOwnership");
        ImageSelection instance = null;
        boolean expResult = false;
//        boolean result = instance.hasOwnership();
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @AfterMethod
    public void tearDown() {
        this.reportClipboardContents();
    }
    
    @AfterSuite
    public void tearDownClass() {
        this.imageWindow.closePanel();
    }
    
}
