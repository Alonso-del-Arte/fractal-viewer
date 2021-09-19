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
package arithmetic;

/**
 * This interface indicates that the implementing concrete class provides the 
 * basic arithmetic operations for numbers represented by that class. The basic 
 * arithmetic operations are addition, subtraction, multiplication and division. 
 * Also includes negation and remainder.
 * <p>"Arithmeticable" is of course not a valid word of the English language, 
 * and it ought to be flagged as a misspelling every time it does not occur as a 
 * type identifier.</p>
 * <p>This interface is understood to operate in the usual commutative algebra, 
 * in which <i>a</i> + <i>b</i> = <i>b</i> + <i>a</i> and <i>ab</i> = 
 * <i>ba</i>.</p>
 * <p>In a computer algebra system like Wolfram Mathematica, it would be a given 
 * that any algebraic number can be added to, subtracted from, multiplied by or 
 * divided by any other algebraic number (except for division by zero).</p>
 * <p>However, given that the focus of this Java package is on algebraic 
 * integers, combined with the fact that infinitely many algebraic integers of 
 * degree 3 and higher have very complicated representations, and that algebraic 
 * integers of degree 4 and higher have not been conclusively classified, I 
 * consider it necessary to restrict arithmetic operations according to a type 
 * system.</p>
 * <p>If a class represents an algebraic integer that may be from one of many 
 * different rings, then it's possible that the result of an arithmetic 
 * operation involving numbers represented by two instances of the same class 
 * might be in a ring that the class can't represent. There may or may not be a 
 * class in this package than can represent the result.</p>
 * <p>At the same time, the arithmetic operations should have the same names in 
 * each class that they're implemented in. By implementing this interface, the 
 * classes uniformly have the basic arithmetic operations by the same names, as 
 * instance functions.</p>
 * <p>Also, classes that represent algebraic integers of degree 2 or higher 
 * should have no trouble representing the result of a basic arithmetic 
 * operation involving such a number and an integer from <b>Z</b> (an algebraic 
 * integer of degree 1), since the operation does not change the algebraic 
 * degree. Though how exactly that is implemented will of course depend on the 
 * implementing classes.</p>
 * <p>Therefore, this interface contains the basic operations for both operands 
 * being of type <code>T</code> and the result also of that type and for one 
 * operand being of type <code>T</code> and the other of type <code>int</code>, 
 * with the result being of type <code>T</code> even if it can be represented by 
 * <code>int</code>.</p>
 * <p>This interface contains default implementations. These are indicated in 
 * the pertinent documentation.</p>
 * @author Alonso del Arte
 * @param <T> Must implement the {@link AlgebraicInteger} interface.
 */
public interface Arithmeticable<T extends Arithmeticable<T>> {
    
    /**
     * Adds an algebraic integer of type <code>T</code> to this one. 
     * Implementations may include overflow checking, but are not required to.
     * <p>For the examples in the following explanations, suppose that this 
     * object is either &alpha; or &beta;, which are algebraic integers in the 
     * same ring, represented by <code>alpha</code> and <code>beta</code>, 
     * respectively, both instances of <code>T</code>.</p>
     * @param addend The algebraic integer to add. For example, either &alpha; 
     * or &beta;.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>. For the examples, this would be one of &alpha; + &beta, 
     * 2&alpha; or 2&beta;. Also, <code>alpha.plus(beta)</code> should give the 
     * same result as <code>beta.plus(alpha)</code>.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    T plus(T addend);
    
    /**
     * Adds an integer from <b>Z</b> to this algebraic integer. Implementations 
     * may include overflow checking, but are not required to.
     * @param addend The integer to add. For example, 7.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>, perhaps even if <code>addend</code> is 0. If this 
     * algebraic integer is &alpha; and <code>addend</code> is 7, the result 
     * should be 7 + &alpha;.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    T plus(int addend);
    
    /**
     * Multiplies this algebraic integer by &minus;1. A default implementation 
     * is provided, which relies on {@link #times(int)}. In some cases, it may 
     * be more efficient to override this default implementation so as to negate 
     * the pertinent primitive number fields one by one. There should be no 
     * overflows, except in a few extreme cases.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>. If this algebraic integer is &alpha;, the result should 
     * be &minus;&alpha;.
     * @throws ArithmeticException If an overflow or underflow occurs. That is 
     * extremely unlikely for this function.
     */
    default T negate() {
        return this.times(-1);
    }
    
    /**
     * Subtracts an algebraic integer of type <code>T</code> from this one. 
     * Implementations may include overflow checking, but are not required to.
     * <p>A default implementation is provided, it relies on {@link
     * #plus(Arithmeticable) plus(T)} and {@link #negate()}. It may be 
     * worthwhile to override if the operation is a simple matter of lining up 
     * the fields of this number to the fields of the subtrahend and subtracting 
     * one by one. It is not worth overriding if that requires repeating many 
     * lines from <code>plus()</code> and/or the creation of several 
     * intermediate result objects. For example, it may be worthwhile to 
     * override for complex numbers, it might not be worthwhile to override for 
     * purely real fractions.</p>
     * <p>For the examples in the following explanations, suppose that this 
     * object is either &alpha; or &beta;, which are algebraic integers in the 
     * same ring, represented by <code>alpha</code> and <code>beta</code>, 
     * respectively, both instances of <code>T</code>.</p>
     * @param subtrahend The algebraic integer to subtract. For example, either 
     * &alpha; or &beta;.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>. For the examples, this would be one of 0, &alpha; &minus; 
     * &beta; or &beta; &minus; &alpha;.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    default T minus(T subtrahend) {
        return this.plus(subtrahend.negate());
    }
    
    /**
     * Subtracts an integer of <b>Z</b> from this algebraic integer. 
     * Implementations may include overflow checking, but are not required to.
     * <p>A default implementation is provided, it relies on {@link
     * #plus(Arithmeticable) plus(T)}. It may be worthwhile to override if the 
     * operation is a simple matter of subtracting the integer from a single 
     * field of this object. This might be the case with complex numbers, in 
     * which case the integer is simply subtracted from the real part, and the 
     * imaginary part remains the same.</p>
     * @param subtrahend The integer to subtract. For example, 8.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>, perhaps even if <code>subtrahend</code> is 0. If this 
     * algebraic integer is &alpha; and <code>subtrahend</code> is 8, the result 
     * should be &alpha; &minus; 8.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    default T minus(int subtrahend) {
        return this.plus(-subtrahend);
    }
    
    /**
     * Multiplies this algebraic integer of type <code>T</code> by another of 
     * the same type. Implementations may include overflow checking, but are not 
     * required to.
     * <p>For the examples in the following explanations, suppose that this 
     * object is either &alpha; or &beta;, which are algebraic integers in the 
     * same ring, represented by <code>alpha</code> and <code>beta</code>, 
     * respectively, both instances of <code>T</code>.</p>
     * @param multiplicand The algebraic integer to multiply by. For example, 
     * either &alpha; or &beta;.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>. For the examples, this would be one of 
     * &alpha;<sup>2</sup>, &beta;<sup>2</sup> or &alpha;&beta;. Also, 
     * <code>alpha.times(beta)</code> should give the same result as 
     * <code>beta.times(alpha)</code>.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    T times(T multiplicand);
    
    /**
     * Multiplies this algebraic integer by an integer from <b>Z</b>. 
     * Implementations may include overflow checking, but are not required to.
     * @param multiplicand The integer to multiply by. For example, 9.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>, perhaps even if <code>multiplicand</code> is 1. For 
     * example, if this algebraic integer is &alpha; and 
     * <code>multiplicand</code> is 9, the result should be 9&alpha;.
     * @throws ArithmeticException If an overflow or underflow occurs.
     */
    T times(int multiplicand);
    
    /**
     * Divides this algebraic integer of type <code>T</code> by another of the 
     * same type. Implementations may include overflow checking, but are not 
     * required to.
     * <p>For the examples in the following explanations, suppose this object is 
     * &alpha;&beta;, where &alpha; and &beta; are distinct and coprime nonzero 
     * algebraic integers in the same ring, neither of them units, 
     * represented by <code>alpha</code> and <code>beta</code>, respectively, 
     * both instances of <code>T</code>.</p>
     * @param divisor The algebraic integer to divide by. For example, either 
     * &alpha; or &beta;.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>. For <sup>&alpha;&beta;</sup>&frasl;<sub>&alpha;</sub>, 
     * this would be &beta;, and for 
     * <sup>&alpha;&beta;</sup>&frasl;<sub>&beta;</sub>, this would be &alpha;.
     * @throws ArithmeticException This unchecked exception may be thrown if the 
     * divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but this one makes sense because 
     * it's the same exception that is thrown for trying to divide an integer in 
     * a primitive data type by 0.
     * @throws IllegalArgumentException This unchecked exception may be thrown 
     * if the divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but most other unchecked 
     * exceptions are not really applicable, and <code>RuntimeException</code> 
     * is too vague.
     * @throws ArithmeticException If an overflow or underflow occurs.
     * @throws NotDivisibleException If this algebraic integer is not divisible 
     * by the divisor, this checked exception should be thrown. However, this 
     * checked exception should <em>not</em> be thrown if the divisor is 0, 
     * since this exception suggests that it is possible to round the division 
     * to an usable algebraic integer; that's not the case when the divisor is 
     * 0. For example, suppose &alpha; + 1 is not a unit and it is coprime to 
     * &alpha;. Likewise suppose &beta; + 1 is not a unit either and is likewise 
     * coprime to &beta;. And of course also &alpha; &ne; 0 and &beta; &ne; 0.
     * Then this exception would be appropriate for 
     * <sup>(&alpha; + 1)</sup>&frasl;<sub>&alpha;</sub>, <sup>(&beta; + 
     * 1)</sup>&frasl;<sub>&beta;</sub>, <sup>&alpha;</sup>&frasl;<sub>(&alpha; 
     * + 1)</sub>, <sup>&beta;</sup>&frasl;<sub>(&beta; + 1)</sub>, since all 
     * those can be meaningfully rounded to 1. It would be inappropriate for 
     * <sup>&alpha;</sup>&frasl;<sub>0</sub>, 
     * <sup>&beta;</sup>&frasl;<sub>0</sub>, etc., because those can't be 
     * meaningfully rounded to any algebraic integer. But it would be 
     * appropriate for either <sup>&alpha;</sup>&frasl;<sub>&beta;</sub> or 
     * <sup>&beta;</sup>&frasl;<sub>&alpha;</sub>, given the stipulation that 
     * gcd(&alpha;, &beta;) = 1, though I don't know what algebraic integers 
     * those would round to. But that's kind of the point of having this 
     * exception.
     */
    T divides(T divisor) throws NotDivisibleException;
    
    /**
     * Divides this algebraic integer by an integer from <b>Z</b>. 
     * Implementations may include overflow checking, but are not required to.
     * <p>For the following explanations, suppose &alpha; is an algebraic 
     * integer of any degree whatsoever, not a unit, but coprime to 10.</p>
     * @param divisor The integer to divide by. For example, 10.
     * @return The result, ought to be a newly constructed instance of 
     * <code>T</code>, perhaps even if <code>divisor</code> is 1. For example, 
     * for <sup>(30 + 20&alpha;)</sup>&frasl;<sub>10</sub>, this would be 3 + 
     * 2&alpha;.
     * @throws ArithmeticException This unchecked exception may be thrown if the 
     * divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but this one makes sense because 
     * it's the same exception that is thrown for trying to divide an integer in 
     * a primitive data type by 0.
     * @throws IllegalArgumentException This unchecked exception may be thrown 
     * if the divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but most other unchecked 
     * exceptions are not really applicable, and <code>RuntimeException</code> 
     * is too vague.
     * @throws NotDivisibleException This checked exception should only be 
     * thrown if this algebraic integer is not divisible by <code>divisor</code> 
     * and <code>divisor != 0</code>, since this exception suggests that the  
     * division is an algebraic number that can be meaningfully rounded to an 
     * algebraic integer. For example, <sup>19&alpha;</sup>&frasl;<sub>10</sub> 
     * can be meaningfully rounded to 2&alpha;.
     */
    T divides(int divisor) throws NotDivisibleException;
    
    /**
     * Gives the remainder of dividing one algebraic integer of type 
     * <code>T</code> by another. The choice of quotients is up to the 
     * implementers. Using this function should never cause {@link 
     * NotDivisibleException}, but it may cause other exceptions.
     * <p>For the following explanations, suppose &alpha; and &beta; are 
     * algebraic integers in the same ring, both positive, purely real and with  
     * odd norm, and &alpha; = 1024&beta; + 1.</p>
     * @param divisor The algebraic number by which to divide this algebraic 
     * integer to obtain a remainder. For example, either &alpha; or &beta;.
     * @return The remainder of dividing this algebraic integer by the divisor. 
     * For example, &alpha; divided by &beta; is 1024 with a remainder of 1, so 
     * this function returns 1; &beta; divided by &alpha; is 0 with a remainder 
     * of &beta;, so this function returns &beta;.
     * @throws ArithmeticException This unchecked exception may be thrown if the 
     * divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but this one makes sense because 
     * it's the same exception that is thrown for trying to divide an integer in 
     * a primitive data type by 0.
     * @throws IllegalArgumentException This unchecked exception may be thrown 
     * if the divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but most other unchecked 
     * exceptions are not really applicable, and <code>RuntimeException</code> 
     * is too vague.
     */
    T mod(T divisor);
    
    /**
     * Gives the remainder of dividing an algebraic integer of type 
     * <code>T</code> by a regular integer. The choice of quotients is up to the 
     * implementers. Using this function should never cause {@link 
     * NotDivisibleException}, but it may cause other exceptions.
     * <p>For the following explanations, suppose &alpha; and &beta; are 
     * algebraic integers in the same ring, both positive, purely real and with  
     * odd norm, and &alpha; = 1024&beta; + 1.</p>
     * @param divisor The integer by which to divide this algebraic integer to 
     * obtain a remainder. For example, 1024.
     * @return The remainder of dividing this algebraic integer by the divisor. 
     * For example, &alpha; divided by 1024 is &beta; with a remainder of 1, so 
     * this function returns 1.
     * @throws ArithmeticException This unchecked exception may be thrown if the 
     * divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but this one makes sense because 
     * it's the same exception that is thrown for trying to divide an integer in 
     * a primitive data type by 0.
     * @throws IllegalArgumentException This unchecked exception may be thrown 
     * if the divisor is 0. Actually, this is just a suggestion. Any unchecked 
     * exception may be used for this purpose, but most other unchecked 
     * exceptions are not really applicable, and <code>RuntimeException</code> 
     * is too vague.
     */
    T mod(int divisor);
    
}
