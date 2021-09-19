/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerics;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the ComplexNumber class.
 * @author Alonso del Arte
 */
public class ComplexNumberNGTest {
    
    /**
     * Test of the toString function, of the ComplexNumber class.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber number = new ComplexNumber(re, im);
        String expected = re + "+" + im + "i";
        String actual = number.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testReferentialEquality() {
        double re = -0.5 + Math.random();
        double im = -0.5 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        assertEquals(someNumber, someNumber);
    }
    
    @Test
    public void testNotEqualsNull() {
        ComplexNumber zero = new ComplexNumber(0.0, 0.0);
        String msg = "The number " + zero.toString() 
                + " should not be the same as null";
        assertNotEquals(null, zero, msg);
    }
    
    @Test
    public void testNotEqualsDiffClass() {
        double re = -0.5 + Math.random();
        double im = -0.5 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        BigDecimal obj = BigDecimal.valueOf(re * re + im * im);
        String msg = "The number " + someNumber.toString() 
                + " should not be equal to " + obj.toString();
        assertNotEquals(obj, someNumber, msg);
    }
    
    @Test
    public void testNotEqualsDiffRe() {
        double re = Math.random();
        double im = Math.random();
        ComplexNumber numberA = new ComplexNumber(re, im);
        ComplexNumber numberB = new ComplexNumber(re * 1.7 + 2.5, im);
        String msg = numberA.toString() + " should not be equal to " 
                + numberB.toString();
        assertNotEquals(numberA, numberB, msg);
    }
    
    @Test
    public void testNotEqualsDiffIm() {
        double re = Math.random();
        double im = Math.random();
        ComplexNumber numberA = new ComplexNumber(re, im);
        ComplexNumber numberB = new ComplexNumber(re, im * 2.5 + 1.3);
        String msg = numberA.toString() + " should not be equal to " 
                + numberB.toString();
        assertNotEquals(numberA, numberB, msg);
    }
    
    @Test
    public void testEquals() {
        double re = Math.random();
        double im = Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        ComplexNumber sameNumber = new ComplexNumber(re, im);
        assertEquals(someNumber, sameNumber);
    }
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HashSet<ComplexNumber> numbers = new HashSet<>();
        HashSet<Integer> hashes = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            double re = i * Math.random();
            double im = i * Math.random();
            ComplexNumber number = new ComplexNumber(re, im);
            numbers.add(number);
            hashes.add(number.hashCode());
        }
        String msg = "Sets of complex numbers, hash codes should be same size";
        assertEquals(hashes.size(), numbers.size(), msg);
    }

    /**
     * Test of plus method, of class ComplexNumber.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        ComplexNumber addend = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
//        ComplexNumber result = instance.plus(addend);
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class ComplexNumber.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        ComplexNumber addend = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
//        ComplexNumber result = instance.minus(addend);
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class ComplexNumber.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        ComplexNumber addend = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
//        ComplexNumber result = instance.times(addend);
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divides method, of class ComplexNumber.
     */
    @Test
    public void testDivides() {
        System.out.println("divides");
        ComplexNumber addend = null;
        ComplexNumber instance = null;
        ComplexNumber expResult = null;
//        ComplexNumber result = instance.divides(addend);
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
