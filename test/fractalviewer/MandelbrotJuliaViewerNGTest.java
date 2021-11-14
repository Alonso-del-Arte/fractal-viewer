/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalviewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import numerics.ComplexNumber;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Alonso del Arte
 */
public class MandelbrotJuliaViewerNGTest {
    
    public MandelbrotJuliaViewerNGTest() {
    }

    /**
     * Test of getTopLeftCorner method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testGetTopLeftCorner() {
        System.out.println("getTopLeftCorner");
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getTopLeftCorner();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentPoint method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testGetCurrentPoint() {
        System.out.println("getCurrentPoint");
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getCurrentPoint();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRelativeNumber method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testGetRelativeNumber() {
        System.out.println("getRelativeNumber");
        int x = 0;
        int y = 0;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getRelativeNumber(x, y);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumber method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        int x = 0;
        int y = 0;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getNumber(x, y);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseColor method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testChooseColor() {
        System.out.println("chooseColor");
        int iterationCount = 0;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        Color expResult = null;
        Color result = instance.chooseColor(iterationCount);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iteratePointJulia method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testIteratePointJulia() {
        System.out.println("iteratePointJulia");
        ComplexNumber c = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        Color expResult = null;
        Color result = instance.iteratePointJulia(c);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iteratePointMandel method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testIteratePointMandel() {
        System.out.println("iteratePointMandel");
        ComplexNumber c = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        Color expResult = null;
        Color result = instance.iteratePointMandel(c);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyReadoutsToClipboard method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testCopyReadoutsToClipboard() {
        System.out.println("copyReadoutsToClipboard");
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.copyReadoutsToClipboard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyDiagramToClipboard method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testCopyDiagramToClipboard() {
        System.out.println("copyDiagramToClipboard");
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.copyDiagramToClipboard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent ae = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.actionPerformed(ae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseClicked method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseClicked(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseEntered method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseEntered(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseExited method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseExited(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mousePressed(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseReleased method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseReleased(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseMoved method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseMoved() {
        System.out.println("mouseMoved");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseMoved(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseDragged method, of class MandelbrotJuliaViewer.
     */
    @Test
    public void testMouseDragged() {
        System.out.println("mouseDragged");
        MouseEvent me = null;
        MandelbrotJuliaViewer instance = new MandelbrotJuliaViewer();
        instance.mouseDragged(me);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
