package timeStamp;

/**
 * Date
 *------
 * Uses 3 ints to make a date with a format of month/day/year
 * it is going to be used to hold up the date when a pizza is made
 * or sold. It does this by taking a users input of what date they want
 * and i take it in and set the 3 global variables according to the users
 * input
 *
 * @author Dagem Lakew
 * @since 06/7/2019
 * @version 1.0
 */
public class Date implements Comparable{

	//holds the month
	private int month;
	//holds the day
	private int day;
	//holds the year
	private int year;

	/**
	 * Date
	 * -----
	 * sets a default month day and year
	 *
	 * PRE: NONE
	 * POST: NONE
	 */
	public Date(){
		this.month = 1;
		this.day = 1;
		this.year = 2014;
	}

	/**
	 * Date
	 * ----
	 * this takes in a int month and sets that month
	 *
	 * @param month: an int that is representing a month
	 *
	 * PRE: NONE
	 * POST: sets month
	 */
	public Date(int month){
		this.setMonth(month);
	}

	/**
	 * Date
	 * ----
	 * this takes in a month and day and sets them to
	 * the variable month and day respectively
	 *
	 * @param month: an int that is representing a month
	 * @param day: an int that is representing a day
	 *
	 * PRE: NONE
	 * POST: sets month and day
	 */
	public Date(int month, int day){
		this.setMonth(month);
		this.setDay(day);
	}

	/**
	 * Date
	 * -----
	 * this takes in a month, day, and year and sets them to
	 * the variable month, day, and year respectively
	 *
	 * @param month: an int that is representing a month
	 * @param day: an int that is representing a day
	 * @param year: an int that is representing a year
	 *
	 * PRE: NONE
	 * POST: sets month, day, and year
	 */
	public Date(int month, int day, int year){
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}

	/**
	 * Date
	 * -----
	 * this takes in a date object and sets the
	 * month, day, and year in the date object to the
	 * month, day, dan year variable
	 *
	 * @param date: a date object
	 *
	 * PRE: date isn't null
	 * POST: sets month and day
	 */
	public Date(Date date){
		this(date.month, date.day, date.year);
	}

	/**
	 * setMonth
	 * ----
	 * this takes in a int month and sets that month
	 *
	 * @param month: an int that is representing a month
	 *
	 * PRE: NONE
	 * POST: sets month
	 */
	public void setMonth(int month) {

		this.month = month;
	}

	/**
	 * setDay
	 * ----
	 * this takes in a int day and sets that day
	 *
	 * @param day: an int that is representing a day
	 *
	 * PRE: NONE
	 * POST: sets day
	 */
	public void setDay(int day) {
		this.day = day;

	}

	/**
	 * Date
	 * ----
	 * this takes in a int year and sets that year
	 *
	 * @param year: an int that is representing a year
	 *
	 * PRE: NONE
	 * POST: sets year
	 */
	public void setYear(int year) {
		this.year = year;

	}

	/**
	 * Date
	 * ----
	 * this takes in a int mont, day, and year and sets them to
	 * the variables month, day, and year respectively
	 *
	 * @param month: an int that is representing a month
	 * @param day: an int that is representing a day
	 * @param year: an int that is representing a year
	 *
	 * PRE: NONE
	 * POST: sets month, day, year
	 */
	public void setDate(int month, int day, int year) {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}

	/**
	 * getMonth
	 * ---------
	 * makes a new date object
	 * and returns its month
	 *
	 * @return : returns the month if the new date object
	 *
	 * PRE: NONE
	 * POST: returns the mont if the new date object
	 */
	public int getMonth() {
		Date other = new Date(this.month, this.day,this.year);
		return other.month;
	}

	/**
	 * getDay
	 * ---------
	 * makes a new date object
	 * and returns its day
	 *
	 * @return : returns the day if the new date object
	 *
	 * PRE: NONE
	 * POST: returns the day if the new date object
	 */
	public int getDay() {
		Date other = new Date(this.month, this.day,this.year);
		return other.day;
	}

	/**
	 * getYear
	 * ---------
	 * makes a new date object
	 * and returns its year
	 *
	 * @return : returns the year if the new date object
	 *
	 * PRE: NONE
	 * POST: returns the year if the new date object
	 */
	public int getYear() {
		Date other = new Date(this.month, this.day,this.year);
		return other.year;
	}


	/**
	 * toString
	 * ---------
	 * this returns a string of the month, day, and year combined
	 *
	 * @return : a string of the month, day, and year combined
	 *
	 * PRE: NONE
	 * POST: NONE
	 */
	@Override
	public String toString() {

		return this.month +"/" +this.day +"/" +this.year;

	}

	/**
	 * equals
	 *-------
	 * checks to see if the money are the same if so
	 * returns true
	 *
	 * @param other: this is an object the should be
	 *             from the date object
	 *
	 * PRE: NONE
	 * POST: returns true if money are equal
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof  Date)){
			return false;
		}

		Date that = (Date) other;

		if (that.day == this.day && that.month ==
				this.month && that.year == this.year ){
			return true;
		}

		return false;

	}

	@Override
	public int compareTo(Object o) {
		if (o == null || !(o instanceof  Date)){
			return -1;
		}

		Date that = (Date) o;

		if (that.getYear() < this.getYear()) {
			return -1;
		}
		else if (that.getYear() == this.getYear()) {
			if (that.getMonth() < this.getMonth()) {
				return -1;
			}
			else if (that.getMonth() == this.getMonth()) {
				// if this day is greater than that day
				if (that.getDay() < this.getDay()) {
					return -1;
				}
				else {
					return 0;
				}
			}
			else {
				return 1;
			}

		}
		else {
			return 1;
		}

	}

	
}
