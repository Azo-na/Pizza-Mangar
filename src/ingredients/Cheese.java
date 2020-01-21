package ingredients;

import mainClasses.Money;

/**
 * Cheese
 *--------
 * inherit from the ingredient super class to be able to
 * make a new Cheese. When it does this it gives the super class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Cheese extends Ingredient {

	public Cheese(String desc, Money m, int cal) {
		super(desc, m, cal);
	}

}
