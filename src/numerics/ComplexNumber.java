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
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple 
 * Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package numerics;

/**
 * Immutable class to represent complex numbers. A complex number consists of a 
 * real part and an imaginary part: <i>a</i> + <i>bi</i>, where <i>a</i> and 
 * <i>b</i> are real numbers and <i>i</i> is the imaginary unit, the number such 
 * that <i>i</i><sup>2</sup> = &minus;1. The real part is represented by a 
 * 64-bit floating point number, likewise for the imaginary part divided by 
 * <i>i</i>.
 * @author Alonso del Arte
 */
public class ComplexNumber {
    
    private final double realPart, imagPart;
    
    @Override
    public String toString() {
        return this.realPart + " + " + this.imagPart + "i";
    }
    
    /**
     * Determines whether this <code>ComplexNumber</code> object is equal to 
     * some other object.
     * @param obj The object to compare for equality. Examples: 0.5 &minus; 
     * 0.2<i>i</i>, 0.5 + 14.134725141734695<i>i</i>, &minus;0.5 + 
     * 14.134725141734695<i>i</i>, a <code>LocalDate</code> object for today's 
     * date, and null.
     * @return True only if <code>obj</code> is an object of the same runtime 
     * class as this object and both the real and imaginary parts match. Suppose 
     * this object represents the complex number 0.5 + 
     * 14.134725141734695<i>i</i>. Then, of the examples, only for 0.5 + 
     * 14.134725141734695<i>i</i> would this function return true. It would 
     * return false for the others.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (this.realPart != other.realPart) {
            return false;
        }
        return this.imagPart == other.imagPart;
    }
    
    /**
     * Gives a hash code for this complex number. Unique hash codes are likely 
     * but not guaranteed.
     * @return A hash code based on narrowing conversions of the real and 
     * imaginary parts to 32-bit floating point numbers. For example, for 0.5 + 
     * 14.134725141734695<i>i</i>, this might be 1097476054.
     */
    @Override
    public int hashCode() {
        float intermediate = (float) this.realPart + (float) this.imagPart;
        return Float.floatToIntBits(intermediate);
    }
    
    // TODO: Write tests for this
    public double getRealPart() {
        return 0.0;
    }
    
    // TODO: Write tests for this
    public double getImaginaryPart() {
        return 0.0;
    }
    
    // TODO: Write tests for this
    public double abs() {
        return 0.0;
    }
    
    /**
     * Adds a complex number to this complex number. This operation is 
     * commutative.
     * @param addend The complex number to add. For example, 0.25 + 
     * 0.75<i>i</i>.
     * @return The sum of this this complex number and <code>addend</code>. In 
     * the example, if this number is 0.75 + 0.25<i>i</i>, the result would be 1 
     * + <i>i</i>.
     */
    public ComplexNumber plus(ComplexNumber addend) {
        double sumRe = this.realPart + addend.realPart;
        double sumIm = this.imagPart + addend.imagPart;
        return new ComplexNumber(sumRe, sumIm);
    }
    
    /**
     * Multiplies this complex number by &minus;1. Given <i>a</i> + <i>bi</i>, 
     * this function returns &minus;<i>a</i> &minus; <i>bi</i>.
     * @return This number multiplied by &minus;1. For example, if this number 
     * is 1.3 &minus; 2.5<i>i</i>, this function would return &minus;1.3 + 
     * 2.5<i>i</i>.
     */
    public ComplexNumber negate() {
        return new ComplexNumber(-this.realPart, -this.imagPart);
    }
    
    /**
     * Subtracts a complex number from this complex number. This operation is 
     * not commutative.
     * @param subtrahend The complex number to subtract. For example, 1.0 + 
     * @return The subtraction
     */
    public ComplexNumber minus(ComplexNumber subtrahend) {
        return this.plus(subtrahend.negate());
    }
    
    /**
     * Multiplies this complex number by another complex number. This operation 
     * is commutative.
     * @param multiplicand The complex number to multiply by. For example, 0.25 
     * + 0.75<i>i</i>.
     * @return The product of this complex number by <code>multiplicand</code>. 
     * For example, if this number is 0.75 + 0.25<i>i</i>, times the example 
     * given above, the result would be 0.0 + 0.625<i>i</i>.
     */
    public ComplexNumber times(ComplexNumber multiplicand) {
        double re = this.realPart * multiplicand.realPart - this.imagPart 
                * multiplicand.imagPart;
        double im = this.realPart * multiplicand.imagPart + this.imagPart 
                * multiplicand.realPart;
        return new ComplexNumber(re, im);
    }
    
    // TODO: Write tests for this
    public ComplexNumber divides(ComplexNumber divisor) {
        return this;
    }
    
    public ComplexNumber(double re, double im) {
        this.realPart = re;
        this.imagPart = im;
    }
    
}
