/*
 * Copyright (C) 2022 Alonso del Arte
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
    
    /**
     * Gives a textual representation of this complex number, using only ASCII 
     * characters.
     * @return The textual representation. For example, if this number is 125 
     * &minus; 7<i>i</i>, this would return "125.0 - 7.0i".
     */
    public String toASCIIString() {
        String intermediate = this.realPart + " + " + this.imagPart + "i";
        intermediate = intermediate.replace("+ -", "- ");
        return intermediate;
    }
    
    /**
     * Gives a textual representation of this complex number. Note that if 
     * either the real or imaginary part is negative, or if they both are, the 
     * proper minus sign character will be used in the output.
     * @return The textual representation. For example, if this number is 125 
     * &minus; 7<i>i</i>, this would return "125.0 &minus; 7.0i".
     */
    @Override
    public String toString() {
        return this.toASCIIString().replace("-", "\u2212");
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
     * return false for all the others, even the ones of the same runtime class 
     * for which the real part matches but the imaginary part does not, or the 
     * imaginary part matches but the real part does not.
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
     * Gives a hash code for this complex number. Unique hash codes during a 
     * given session are likely but not guaranteed. In particular, note that 
     * numbers with real parts that differ by less than 10<sup>&minus;45</sup> 
     * and/or imaginary parts that are similarly close might get the same hash 
     * code.
     * @return A hash code based on narrowing conversions of the real and 
     * imaginary parts to 32-bit floating point numbers. For example, for 0.5 + 
     * 14.134725141734695<i>i</i>, this might be 1097476054.
     */
    @Override
    public int hashCode() {
        float intermediate = (float) this.realPart + (float) this.imagPart;
        return Float.floatToIntBits(intermediate);
    }
    
    /**
     * Gets the real part of this complex number. For the example, suppose that 
     * this number is 0.5 + 14.134725141734695<i>i</i>.
     * @return The real part of this complex number. In the example, 0.5.
     */
    public double getRealPart() {
        return this.realPart;
    }
    
    /**
     * Gets the imaginary part of this complex number, divided by <i>i</i>. For 
     * the example, suppose that this number is 0.5 + 
     * 14.134725141734695<i>i</i>.
     * @return The imaginary part of this complex number, divided by <i>i</i>.  
     * In the example, 14.134725141734695.
     */
    public double getImaginaryPart() {
        return this.imagPart;
    }
    
    /**
     * Gives the norm of this complex number. The formula is <i>N</i>(<i>a</i> + 
     * <i>bi</i>) = <i>a</i><sup>2</sup> + <i>b</i><sup>2</sup>.
     * @return The norm. For example, if this number is &minus;2 + <i>i</i>, 
     * this function would return 5.0.
     */
    public double norm() {
        return this.realPart * this.realPart + this.imagPart * this.imagPart;
    }

    /**
     * Gives the absolute value of this complex number. The formula is 
     * abs(<i>a</i> + <i>bi</i>) = &radic;(<i>a</i><sup>2</sup> 
     * + <i>b</i><sup>2</sup>).
     * @return The absolute value. For example, if this number is &minus;2 + 
     * <i>i</i>, this function would return 2.23606797749979, a rational 
     * approximation of &radic;5.0.
     */
    public double abs() {
        return Math.sqrt(this.norm());
    }
    
    /**
     * Gives the complex conjugate of this number. Note that the conjugate is 
     * the same for a purely real number (meaning the imaginary part is 
     * 0.0<i>i</i>.
     * @return The conjugate. For example, if this number is 1.25 + 
     * 3.75<i>i</i>, this would return 1.25 &minus; 3.75<i>i</i>.
     */
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.realPart, -this.imagPart);
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
     * 2.5<i>i</i>.
     * @return The subtraction.
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
    
    /**
     * Divides this complex number by another. This is not a commutative 
     * operation.
     * @param divisor The number to divide by. For example, 6 + <i>i</i>.
     * @return The result of the division. Given the example above, if this 
     * number is 37.0 + 0.0<i>i</i>, the result would be 6 &minus; <i>i</i>.
     * @throws IllegalArgumentException If <code>divisor</code> is 0.0 + 
     * 0.0<i>i</i>.
     */
    public ComplexNumber divides(ComplexNumber divisor) {
        double norm = divisor.norm();
        if (norm == 0.0) {
            String excMsg = "Divisor 0 is not valid";
            throw new IllegalArgumentException(excMsg);
        }
        double re = this.realPart * divisor.realPart + this.imagPart 
                * divisor.imagPart;
        double im = this.imagPart * divisor.realPart - this.realPart 
                * divisor.imagPart;
        re /= norm;
        im /= norm;
        return new ComplexNumber(re, im);
    }
    
    public ComplexNumber(double re, double im) {
        if (!Double.isFinite(re) || !Double.isFinite(im)) {
            String excMsg = "Real part " + re + " and imaginary part " + im 
                    + "i is not a valid combination; both should be finite";
            throw new IllegalArgumentException(excMsg);
        }
        this.realPart = re;
        this.imagPart = im;
    }
    
}
