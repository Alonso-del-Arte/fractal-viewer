/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        }return true;
//        final ComplexNumber other = (ComplexNumber) obj;
//        if (this.realPart != other.realPart) {
//            return false;
//        }
//        return this.imagPart == other.imagPart;
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
    
    // TODO: Write tests for this
    public ComplexNumber plus(ComplexNumber addend) {
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
