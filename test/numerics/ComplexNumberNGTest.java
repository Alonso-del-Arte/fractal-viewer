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
package numerics;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the ComplexNumber class.
 * @author Alonso del Arte
 */
@Test
public class ComplexNumberNGTest {
    
    /**
     * Tolerance for floating point calculations.
     */
    private static final double TEST_DELTA = 0.00000001;
    
    /**
     * Test of the toASCIIString function, of the ComplexNumber class. Including 
     * spaces is highly recommended, but not necessary to pass this test.
     */
    public void testToASCIIString() {
        System.out.println("toASCIIString");
        double re = -1.0 + Math.random();
        double im = -1.0 + Math.random();
        ComplexNumber number = new ComplexNumber(re, im);
        String expected = re + im + "i";
        String actual = number.toASCIIString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the toString function, of the ComplexNumber class. Including 
     * spaces is highly recommended, but not necessary to pass this test.
     */
    public void testToString() {
        System.out.println("toString");
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber number = new ComplexNumber(re, im);
        String expected = re + "+" + im + "i";
        String actual = number.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    /**
     * Another test of the toString function, of the ComplexNumber class. If the 
     * real part is negative, it should have the "&minus;" character at the 
     * beginning. Including spaces is highly recommended, but not necessary to 
     * pass this test.
     */
    public void testToStringNegativeRealPart() {
        System.out.println("toString");
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber number = new ComplexNumber(-re, im);
        String expected = "\u2212" + re + "+" + im + "i";
        String actual = number.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    /**
     * Another test of the toString function, of the ComplexNumber class. If the 
     * imaginary part is negative, it should have the "&minus;" character 
     * between the real part and the imaginary part. There should be no plus 
     * sign between the real part and the imaginary part. Including spaces is 
     * highly recommended, but not necessary to pass this test.
     */
    public void testToStringNegativeImaginaryPart() {
        System.out.println("toString");
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber number = new ComplexNumber(re, -im);
        String expected = re + "\u2212" + im + "i";
        String actual = number.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    /**
     * Another test of the equals function, of the ComplexNumber class. A 
     * ComplexNumber object should be equal to itself.
     */
    public void testReferentialEquality() {
        double re = -0.5 + Math.random();
        double im = -0.5 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        assertEquals(someNumber, someNumber);
    }
    
    /**
     * Another test of the equals function, of the ComplexNumber class. A 
     * ComplexNumber object should not be equal to null.
     */
    public void testNotEqualsNull() {
        ComplexNumber zero = new ComplexNumber(0.0, 0.0);
        String msg = "The number " + zero.toString() 
                + " should not be the same as null";
        assertNotEquals(null, zero, msg);
    }
    
    /**
     * Another test of the equals function, of the ComplexNumber class. A 
     * ComplexNumber object should not be equal to an object of an unrelated 
     * class.
     */
    public void testNotEqualsDiffClass() {
        double re = -0.5 + Math.random();
        double im = -0.5 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        BigDecimal obj = BigDecimal.valueOf(re * re + im * im);
        String msg = "The number " + someNumber.toString() 
                + " should not be equal to " + obj.toString();
        assertNotEquals(obj, someNumber, msg);
    }
    
    /**
     * Another test of the equals function, of the ComplexNumber class. A 
     * complex number should not be equal to a complex number with a different 
     * real part.
     */
    public void testNotEqualsDiffRe() {
        double re = Math.random();
        double im = Math.random();
        ComplexNumber numberA = new ComplexNumber(re, im);
        ComplexNumber numberB = new ComplexNumber(re * 1.7 + 2.5, im);
        String msg = numberA.toString() + " should not be equal to " 
                + numberB.toString();
        assertNotEquals(numberA, numberB, msg);
    }
    
    /**
     * Another test of the equals function, of the ComplexNumber class. A 
     * complex number should not be equal to a complex number with a different 
     * imaginary part.
     */
    public void testNotEqualsDiffIm() {
        double re = Math.random();
        double im = Math.random();
        ComplexNumber numberA = new ComplexNumber(re, im);
        ComplexNumber numberB = new ComplexNumber(re, im * 2.5 + 1.3);
        String msg = numberA.toString() + " should not be equal to " 
                + numberB.toString();
        assertNotEquals(numberA, numberB, msg);
    }
    
    /**
     * Test of the equals function, of the ComplexNumber class.
     */
    public void testEquals() {
        System.out.println("equals");
        double re = Math.random();
        double im = Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        ComplexNumber sameNumber = new ComplexNumber(re, im);
        assertEquals(someNumber, sameNumber);
    }
    
    /**
     * Test of the hashCode function, of the ComplexNumber class.
     */
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
     * Test of the getRealPart function, of the ComplexNumber class.
     */
    public void testGetRealPart() {
        System.out.println("getRealPart");
        double expected = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(expected, im);
        double actual = someNumber.getRealPart();
        assertEquals(actual, expected, TEST_DELTA);
    }
    
    /**
     * Test of the getImaginaryPart function, of the ComplexNumber class.
     */
    public void testGetImaginaryPart() {
        System.out.println("getImaginaryPart");
        double re = 1.0 + Math.random();
        double expected = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, expected);
        double actual = someNumber.getImaginaryPart();
        assertEquals(actual, expected, TEST_DELTA);
    }

    /**
     * Test of the norm function, of the ComplexNumber class.
     */
    public void testNorm() {
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        double expected = re * re + im * im;
        double actual = someNumber.norm();
        assertEquals(actual, expected, TEST_DELTA);
    }
    
    /**
     * Test of the abs function, of the ComplexNumber class.
     */
    public void testAbs() {
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        double expected = Math.sqrt(re * re + im * im);
        double actual = someNumber.abs();
        assertEquals(actual, expected, TEST_DELTA);
    }
    
    public void testConjugate() {
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        ComplexNumber expected = new ComplexNumber(re, -im);
        ComplexNumber actual = someNumber.conjugate();
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the plus function, of the ComplexNumber class.
     */
    public void testPlus() {
        System.out.println("plus");
        double addendARe = -0.5 + Math.random();
        double addendAIm = -0.5 + Math.random();
        ComplexNumber addendA = new ComplexNumber(addendARe, addendAIm);
        double addendBRe = -0.5 + Math.random();
        double addendBIm = -0.5 + Math.random();
        ComplexNumber addendB = new ComplexNumber(addendBRe, addendBIm);
        double expRe = addendARe + addendBRe;
        double expIm = addendAIm + addendBIm;
        ComplexNumber expected = new ComplexNumber(expRe, expIm);
        ComplexNumber actual = addendA.plus(addendB);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the negate function, of the ComplexNumber class.
     */
    public void testNegate() {
        System.out.println("negate");
        double re = 1.0 + Math.random();
        double im = 1.0 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        ComplexNumber expected = new ComplexNumber(-re, -im);
        ComplexNumber actual = someNumber.negate();
        assertEquals(actual, expected);
    }

    /**
     * Test of the minus function, of the ComplexNumber class.
     */
    public void testMinus() {
        System.out.println("minus");
        double minuendRe = -0.5 + Math.random();
        double minuendIm = -0.5 + Math.random();
        ComplexNumber minuend = new ComplexNumber(minuendRe, minuendIm);
        double subtrahendRe = -0.5 + Math.random();
        double subtrahendIm = -0.5 + Math.random();
        ComplexNumber subtrahend = new ComplexNumber(subtrahendRe, 
                subtrahendIm);
        double expRe = minuendRe - subtrahendRe;
        double expIm = minuendIm - subtrahendIm;
        ComplexNumber expected = new ComplexNumber(expRe, expIm);
        ComplexNumber actual = minuend.minus(subtrahend);
        assertEquals(actual, expected);
    }

    /**
     * Test of the times function, of the ComplexNumber class.
     */
    public void testTimes() {
        System.out.println("times");
        double multiplicandARe = 1.0 + Math.random();
        double multiplicandAIm = 1.0 + Math.random();
        ComplexNumber multiplicandA = new ComplexNumber(multiplicandARe, 
                multiplicandAIm);
        double multiplicandBRe = 1.0 + Math.random();
        double multiplicandBIm = 1.0 + Math.random();
        ComplexNumber multiplicandB = new ComplexNumber(multiplicandBRe, 
                multiplicandBIm);
        double expRe = multiplicandARe * multiplicandBRe - multiplicandAIm 
                * multiplicandBIm;
        double expIm = multiplicandARe * multiplicandBIm + multiplicandAIm 
                * multiplicandBRe;
        ComplexNumber expected = new ComplexNumber(expRe, expIm);
        ComplexNumber actual = multiplicandA.times(multiplicandB);
        assertEquals(actual, expected);
    }
    
    /**
     * Another test of the divides function, of the ComplexNumber class. 
     * Dividing by zero should cause either ArithmeticException or 
     * IllegalArgumentException.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testDivisionByZero() {
        double re = -0.5 + Math.random();
        double im = -0.5 + Math.random();
        ComplexNumber someNumber = new ComplexNumber(re, im);
        ComplexNumber zero = new ComplexNumber(0.0, 0.0);
        ComplexNumber division = someNumber.divides(zero);
        System.out.println(someNumber.toString() + " divided by " 
                + zero.toString() + " is said to be " + division.toString());
    }

    /**
     * Test of the divides function, of the ComplexNumber class.
     */
    public void testDivides() {
        System.out.println("divides");
        double dividendRe = 1.0 + Math.random();
        double dividendIm = 1.0 + Math.random();
        ComplexNumber dividend = new ComplexNumber(dividendRe, dividendIm);
        double divisorRe = 1.0 + Math.random();
        double divisorIm = 1.0 + Math.random();
        ComplexNumber divisor = new ComplexNumber(divisorRe, divisorIm);
        double expNorm = divisorRe * divisorRe + divisorIm * divisorIm;
        double expRe = dividendRe * divisorRe + dividendIm * divisorIm;
        double expIm = dividendIm * divisorRe - dividendRe * divisorIm;
        expRe /= expNorm;
        expIm /= expNorm;
        ComplexNumber expected = new ComplexNumber(expRe, expIm);
        ComplexNumber actual = dividend.divides(divisor);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the constructor. The constructor should reject &minus;&infin; for 
     * the real part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsRealNegativeInfinity() {
        double re = Double.NEGATIVE_INFINITY;
        double im = Math.random();
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
    /**
     * Test of the constructor. The constructor should reject +&infin; for the 
     * real part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsRealPositiveInfinity() {
        double re = Double.POSITIVE_INFINITY;
        double im = Math.random();
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
    /**
     * Test of the constructor. The constructor should reject &minus;&infin; for 
     * the imaginary part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsImaginaryNegativeInfinity() {
        double re = Math.random();
        double im = Double.NEGATIVE_INFINITY;
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
    /**
     * Test of the constructor. The constructor should reject +&infin; for the 
     * imaginary part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsImaginaryPositiveInfinity() {
        double re = Math.random();
        double im = Double.POSITIVE_INFINITY;
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
    /**
     * Test of the constructor. The constructor should reject NaN for the real 
     * part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsRealNaN() {
        double re = Double.NaN;
        double im = Math.random();
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
    /**
     * Test of the constructor. The constructor should reject NaN for the 
     * imaginary part of the number.
     */
    @Test(expectedExceptions = {ArithmeticException.class, 
        IllegalArgumentException.class})
    public void testConstructorRejectsImaginaryNaN() {
        double re = Math.random();
        double im = Double.NaN;
        ComplexNumber badNumber = new ComplexNumber(re, im);
        System.out.println("Should not have been able to create " 
                + badNumber.toString());
    }
    
}
