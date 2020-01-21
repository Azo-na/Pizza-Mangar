package mainClasses;

public class Money implements Comparable{

	//This keeps track of the dollars
	private int dollars;
	//This keeps track of the cents
	private int cents;

	/**
	 * Money
	 * ------
	 * takes in an int that represents dollars and
	 * checks to see if the int is equal or greater then zero
	 * if so then sets the int to the privet variable dollars
	 *
	 * @param dollars : this an int that represents dollars
	 *
	 * PRE: Dollars must be greater or equal to 0
	 * POST: sets the privet variable dollars
	 */
	public Money(int dollars){
		setDollars(dollars);
	}

	/**
	 * Money
	 * ------
	 * takes in an int that represents dollars and
	 * an int that represents cents and checks
	 * to see if the ints are equal or greater then zero
	 * if so then sets the int to the privet variable dollars
	 * if the int cents is greater then 99 then it will convert it
	 * to dollars and add it to the privet variable dollars
	 *
	 * @param dollars : this an int that represents dollars
	 * @param cents : this an int that represents cents
	 *
	 * PRE: Dollars and cents must be greater or equal to 0
	 * POST: sets the privet variable dollars and cents
	 */
	public Money(int dollars, int cents){
		setDollars(dollars);
		setCents(cents);
	}

	/**
	 * Money
	 * ------
	 * takes in an object that represents money and
	 * sets the the dollars and cents in the money object
	 * to the the privet variable dollars and
	 * cents respectively
	 *
	 * @param other : this an int that represents an amount of money
	 *
	 * PRE: other must not be null
	 * POST: sets the privet variable dollars and cents
	 */
	public Money(Money other){

		this(other.dollars, other.cents);
	}

	/**
	 * getDollars
	 * ---------
	 * makes a new money class and returns
	 * its privet variable dollars
	 *
	 * @return : the privet variable dollars
	 *
	 * PRE: NONE
	 * POST: returns privet variable dollars
	 */
	public int getDollars() {
		Money other = new Money(this.dollars, this.cents);
		return other.dollars;
	}

	/**
	 * getCents
	 * ---------
	 * makes a new money class and returns
	 * its privet variable cents
	 *
	 * @return : the privet variable cents
	 *
	 * PRE: NONE
	 * POST: returns privet variable cents
	 */
	public int getCents() {
		Money other = new Money(this.dollars, this.cents);
		return other.cents;
	}

	/**
	 * gteMoney
	 * ---------
	 * makes a new money class and returns
	 * its privet variable dollars and cents
	 * combined
	 *
	 * @return : returns privet variable dollars and cents
	 *           combined
	 *
	 * PRE: NONE
	 * POST: returns privet variable dollars and cents
	 *       combined
	 */
	public double getMoney(){
		if (this.cents >= 0 && this.cents <= 9) {
			Money other = new Money(this.dollars, this.cents);
			String fullAmount = other.dollars + "." + "0" + other.cents;
			return Double.parseDouble(fullAmount);
		}
		else {
			Money other = new Money(this.dollars, this.cents);
			String fullAmount = other.dollars + "." + other.cents;
			return Double.parseDouble(fullAmount);
		}
	}

	/**
	 * setDollars
	 * -----------
	 * takes in an int that represents dollars and
	 * checks to see if the int is equal or greater then zero
	 * if so then sets the int to the privet variable dollars
	 *
	 * @param dollars: this an int that represents dollars
	 *
	 * PRE: Dollars must be greater or equal to 0
	 * POST: sets the privet variable dollars
	 */
	public void setDollars(int dollars) {
		if (dollars >= 0) {
			this.dollars = dollars;
		}
		else {
			System.err.println("Dollars where less then 0");
		}
	}

	/**
	 * setCents
	 * -----------
	 * takes in an int that represents cents and
	 * checks to see if the int is equal or greater then zero
	 * if so then sets the int to the privet variable dollars
	 * if cents are greater then 99 then converts the cents into dollars
	 * and add it to dollars
	 *
	 * @param cents: this an int that represents dollars
	 *
	 * PRE: cents must be greater or equal to 0
	 * POST: sets the privet variable dollars
	 */
	public void setCents(int cents) {
		if (cents >= 0 && cents <= 99) {
			this.cents = cents;
		}
		else if (cents >= 0 ){
			while (cents > 99) {
				cents = cents - 100;
				this.dollars = this.dollars + 1;
				this.cents = cents;
			}
		}
		else {
			System.err.println("cents where less then 0");
		}
	}

	/**
	 * setMoney
	 * -----------
	 * takes in an object that represents money and
	 * sets the the dollars and cents in the money object
	 * to the the privet variable dollars and
	 * cents respectively
	 *
	 * @param dollars: this an int that represents dollars
	 * @param cents : this an int that represents cents
	 *
	 * PRE: NONE
	 * POST: sets the privet variable dollars and cents
	 */
	public void setMoney(int dollars, int cents){
		this.setDollars(dollars);
		this.setCents(cents);
	}

	/**
	 * add
	 *------
	 * adds the int dollars to the privet variable dollars
	 *
	 * @param dollars: this an int that represents dollars
	 *
	 * PRE: NONE
	 * POST: changes the privet variable dollars
	 */
	public void add(int dollars){
		this.setDollars(this.dollars+dollars);
	}

	/**
	 * add
	 *------
	 * adds the int dollars to the privet variable dollars
	 * and adds the int cents to the privet variable cents
	 *
	 * @param dollars: this an int that represents dollars
	 * @param cents: this an int that represents cents
	 *
	 * PRE: NONE
	 * POST: changes the privet variable dollars and cents
	 */
	public void add(int dollars, int cents){
		this.setDollars(this.dollars+dollars);
		this.setCents(this.cents+cents);
	}

	/**
	 * add
	 *------
	 * adds the int dollars in the money object
	 * to the privet variable dollars
	 * and adds the int cents in the money object
	 * to the privet variable cents
	 *
	 * @param other: this an object that represents money
	 *
	 * PRE: NONE
	 * POST: changes the privet variable dollars
	 */
	public void add(Money other){
		this.setDollars(this.dollars + other.dollars);
		this.setCents(this.cents + other.cents);
	}

	/**
	 * equals
	 *-------
	 * checks to see if the money are the same if so
	 * returns true
	 *
	 * @param obj: this is an object the should be
	 *             from the money object
	 *
	 * PRE: NONE
	 * POST: returns true if the moneys are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Money)){
			return false;
		}

		Money newMoney = (Money) obj;

		if (this.cents == newMoney.cents && this.dollars == newMoney.dollars){
			return true;
		}

		return false;
	}

	/**
	 * toString
	 * ---------
	 * this returns a string of the dollars and cents combined
	 *
	 * @return : a string of the dollars and cents combined
	 *
	 * PRE: NONE
	 * POST: NONE
	 */
	@Override
	public String toString() {
		if (this.cents >= 0 && this.cents <= 9) {
			return "$" + this.dollars + "." +"0"+ this.cents;
		}
		else {
			return "$" + this.dollars + "." + this.cents;
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o == null || !(o instanceof Money)){
			return -1;
		}

		Money newMoney = (Money) o;
		if (getMoney() < newMoney.getMoney()){
			return -1;
		}
		else if (getMoney() == newMoney.getMoney()){
			return 0;
		}
		else {
			return 1;
		}
	}

}
