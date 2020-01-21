package mainClasses;

/**
 *Fractions
 *--------------
 * Takes in the file and set the numerator and denominator
 * to the ones found in the file
 *
 * @author Dagem Lakew
 * @version 1.0
 * @since 2019-01-09
 */
public class Fraction implements Comparable{
	//Holds the numerator of the fraction
	public final double numerator;
	//Holds the denominator of the fraction
	private final double denominator;

	/**
	 *Fraction
	 *----------
	 * Sets the numerator to the user numerator and
	 * denominator to the user denominator
	 *
	 * @param userNumerator: the users fractions numerator
	 * @param userDenominator: the users fractions denominator
	 *
	 *PRE: NONE
	 *POST: sets the numerator and denominator
	 *      to the user numerator and denominator
	 */
	public Fraction(double userNumerator, double userDenominator){
		if (userDenominator != 0) {
			double gcd = Gcd(userNumerator,userDenominator);
			this.numerator = userNumerator/gcd;
			this.denominator = userDenominator/gcd;
		}
		else {
			this.numerator = 0;
			this.denominator = 1;
		}
	}

	public Fraction(Fraction otherFraction){
		numerator = otherFraction.numerator;
		denominator = otherFraction.denominator;
	}

	/**
	 * Fractions
	 * -----------
	 * Splits the fraction string into numerators and denominators
	 * and set them to the numerator and denominator variable in this class
	 *
	 * @param fractions: a string that is in a fraction format
	 *                 Example: 6/3
	 *
	 *PRE: The fraction need to be in this format number / number
	 *POST: Adds the fractions numerator and denominator
	 *     to the numerator and denominator in this class
	 */
	public Fraction(String fractions){
		//Help split the string into two strings at the / line
		String[] splitStrings = fractions.split("/");
		//Gets the greats common denominator
		double gcd = Gcd(Double.parseDouble(splitStrings[0]),
				Double.parseDouble(splitStrings[1]));
		if (Double.parseDouble(splitStrings[1]) != 0) {
			this.numerator = (Double.parseDouble(splitStrings[0]) / gcd);
			this.denominator = (Double.parseDouble(splitStrings[1]) / gcd);
		}
		else {
			this.numerator = 0;
			this.denominator = 1;
		}

	}

	/**
	 * getNumerator
	 * -------------
	 * returns the numerator
	 *
	 * @return : returns the numerator
	 *
	 * PRE: NONE
	 * POST: returns the numerator
	 */
	public double getNumerator() {
		return this.numerator;
	}

	/**
	 * getNumerator
	 * -------------
	 * returns the Denominator
	 *
	 * @return : returns the Denominator
	 *
	 * PRE: NONE
	 * POST: returns the Denominator
	 */
	public double getDenominator() {
		return this.denominator;
	}

	public double getFraction(){
		Fraction other = new Fraction(this.numerator, this.denominator);
		String fraction = other.denominator + "/" + other.numerator;
		return Double.parseDouble(fraction);
	}

	/**
	 * equals
	 * --------
	 * sees if two fraction are the same
	 * if so returns true
	 *
	 * @param obj : an object that should be a fraction
	 * @return : returns true or false depending if t
	 *          he two fractions are the same or not
	 *
	 *PRE: NONE
	 *POST: returns true or false depending if t
	 *      he two fractions are the same or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof  Fraction)){
			return false;
		}

		Fraction otherFraction = (Fraction) obj;

		if (otherFraction.numerator == this.numerator
				&& otherFraction.denominator == this.denominator){
			return true;
		}

		return false;
	}

	/**
	 * GCD
	 * ------
	 * Finds out what the greats common denominator
	 * is for a fraction
	 *
	 * @param numerator: the numerator of a fraction
	 * @param denominator: the denominator
	 * @return
	 */
	public double Gcd(double numerator, double denominator){
		if (denominator == 0){
			return numerator;
		}

		return Gcd(denominator, numerator%denominator);
	}

	@Override
	public int compareTo(Object o) {

		if ((o == null || !(o instanceof  Fraction))){
			return -1;
		}

		Fraction otherFraction = (Fraction) o;

		if (otherFraction.numerator < this.numerator
				&& otherFraction.denominator <= this.denominator){
			return -1;
		}

		else if (otherFraction.numerator == this.numerator
				&& otherFraction.denominator == this.denominator){
			return 0;
		}

		else {
			return 1;
		}

	}

	@Override
	public String toString() {
		return numerator +"/" +denominator;
	}
}
