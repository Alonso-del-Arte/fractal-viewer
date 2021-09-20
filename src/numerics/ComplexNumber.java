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
 * that <i>i</i><sup>2</sup> = &minus;1.
 * @author Alonso del Arte
 */
public class ComplexNumber {
    
    private final double realPart, imagPart;
    
    @Override
    public String toString() {
        return this.realPart + " + " + this.imagPart + "i";
    }
    
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
    
    @Override
    public int hashCode() {
        return 0;
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
    
    public ComplexNumber plus(ComplexNumber addend) {
        double sumRe = this.realPart + addend.realPart;
        double sumIm = this.imagPart + addend.imagPart;
        return new ComplexNumber(sumRe, sumIm);
    }
    
    // TODO: Write tests for this
    public ComplexNumber negate() {
        return this;
    }
    
    // TODO: Write tests for this
    public ComplexNumber minus(ComplexNumber addend) {
        return this;
    }
    
    // TODO: Write tests for this
    public ComplexNumber times(ComplexNumber addend) {
        return this;
    }
    
    // TODO: Write tests for this
    public ComplexNumber divides(ComplexNumber addend) {
        return this;
    }
    
    public ComplexNumber(double re, double im) {
        this.realPart = re;
        this.imagPart = im;
    }
    
}
