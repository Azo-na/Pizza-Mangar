package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;

/**
 * Ingredient
 *-------------
 * This class holds all of the ingredients and what each ingredients need
 * to have to be classified as a ingredient fot the pizza
 * which is the coast of it the amount of calories and what
 * it is a description
 *
 * @author Dagem Lakew
 */
public abstract class Ingredient implements Comparable {
	private Money coast;
	private String description;
	private int calories;
	
	public Ingredient(String desc, Money m, int cal) {
		throw new RuntimeException("Ingredients not done");
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setCoast(Money coast) {
		this.coast = new Money(coast);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public Money getCoast() {
		return new Money(coast);
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Description: " +description +" Coast: " +coast +" Calories: " +calories;
	}

	@Override
	public int compareTo(Object o) {
		if (o == null || !(o instanceof Ingredient)){
			return -1;
		}

		Ingredient that = (Ingredient) o;

		return coast.compareTo(that.coast);
	}
	

}
