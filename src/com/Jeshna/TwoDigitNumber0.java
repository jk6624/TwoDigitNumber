package com.Jeshna;
/**
* @author JeshnaKanduri
* @date 11/06/2024
* Methods review part 2
* Custom class dealing with only two digit numbers
*/
public class TwoDigitNumber0 {
	
	/**
	 * Instance variables for ones and tens of type byte
	 */
	private byte ones, tens;
		
		/**
		 * Default constructor setting the instance variables to 0 if input is received
		 */
		public TwoDigitNumber0() {
			this.ones = 0;
			this.tens = 0;
		}
		
	//setting instance variables - the overide(input constructor)
		/**
		 * Overloaded constructor taking input for the instances and establishing limits through invariances
		 * @param tens Byte instance variable representing the tens value
		 * @param ones Byte instance variable representing the ones value
		 */
		public TwoDigitNumber0(byte tens, byte ones) {
			this.ones = ones;
			this.tens = tens;
		
			//above 9 invariance
			if(ones > 9) {
				this.ones = 9;
			}
			if(tens > 9) {
				this.tens = 9;
			}
			
			//below 0 invariance
			if(ones < 0) {
				this.ones = 0;
			}
			if(tens < 0) {
				this.tens = 0;
			}
		}
	
		/**
		 * Accesor(getter) method to reterive ones
		 * @return Value of ones
		 */
		public byte getOnes() {
			return this.ones;
		
		}
		/**
		 * Accesor(getter) method to reterive tens
		 * @return Value of tens
		 */
		public byte getTens() {
			return this.tens;
		}
		
	
		/**
		 * Mutator (setter) method setting ones and establishing limits through invariances
		 * @param ones Value of ones
		 */
		public void setOnes(byte ones) {
			this.ones = ones;
			//above 9 invariance
			if(ones > 9) {
				this.ones = 9;
			}
			//below 0 invariance
			if(ones < 0) {
				this.ones = 0;
			}
		}
		
		/**
		 * Mutator (setter) method setting tens and establishing limits through invariances
		 * @param tens Value of tens
		 */
		public void setTens(byte tens) {
			this.tens = tens;
			//above 9 invariance
			if(tens > 9) {
				this.tens = 9;
			}
			//below 0 invariance
			if(tens < 0) {
				this.tens = 0;
			}
		}
		/**
		 * Output method displaying values of tens and ones as a String
		 * @return Values of tens and ones as a String
		 */
		public String toString() {
			return this.tens + "" + this.ones;
		}
		
		/**
		 * Adds new ones and tens objects of type TwoDigitNumber0 to current ones and tens TwoDigitNumber0 objects
		 * @param o New TwoDigitNumber0 ones and tens
		 */
		public void add(TwoDigitNumber0 o) {
			this.ones = (byte) (this.ones + o.ones);
			this.tens = (byte) (this.tens + o.tens);
			if(this.tens == 11) { // this what causes a hundreds place value
				this.tens = (byte)(this.tens - 10);
				// 50 + 60 = 110 - the tens is a (5+6) is creating the 11
				// therefore subtract 10 from the tens 11 (5+6) results in 1
				// invariance ensures results is not of greater than 1 in the hundreds places
				// highest number allowed is 99 to add/subtract
				// 99 + 99 = 198 - hundreds is "1"
			}
			byte sum = (byte) (this.ones + this.tens);
		}
	
		/**
		 * Subtracts new ones and tens objects of type TwoDigitNumber0 from current ones and tens TwoDigitNumber0 objects
		 * @param o New TwoDigitNumber0 ones and tens
		 */
		public void subtract(TwoDigitNumber0 o) {
			this.ones = (byte) (this.ones - o.ones);
			if(this.ones < o.tens) {
				this.ones = 0;
			}
			this.tens = (byte) (this.tens - o.tens);
			if(this.tens < o.tens) {
				this.tens = 0;
			}
			// if first number is less than second, it causes negative number
			// ex 3-8 = -5
			
			byte difference  = (byte) (this.ones - this.tens);
		}
		
		/**
		 * Checks if the resulting byte after addition or subtraction is even or odd
		 * @return Boolean value displaying if result is even or not
		 */
		public boolean isEven() {
			if ((this.ones  + this.tens) % 2 != 0 || (this.ones  - this.tens) % 2 != 0) {
				return false;
			}
			else{
				return true;
			}
		}
		
		/**
		 * Multiplys new ones and tens objects of type TwoDigitNumber0 with current ones and tens TwoDigitNumber0 objects
		 * @param o New TwoDigitNumber0 ones and tens
		 */
		public void mult(TwoDigitNumber0 o) {
			// Only care about the last part of the expansion
			byte tensPart = (byte) (this.tens * o.ones + this.ones * o.tens);
			byte onesPart = (byte) (this.ones * o.ones);
			// If the ones part of the expansion is greater than 10
			// Move the tens portion onto the tens part of the expansion
			if (onesPart > 9) {
				byte leftOver = (byte) (onesPart / 10);
				tensPart += leftOver;
				onesPart %= 10;
			}
			// If the tens part of the expansion is greater than 10, drop the last digit
			if (tensPart > 9) {
				tensPart %= 10;
			}
			this.tens = tensPart;
			this.ones = onesPart;
		}
	}