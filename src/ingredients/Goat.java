package ingredients;

import mainClasses.Money;

/**
 * Goat
 *--------
 * inherit from the Cheese sub class to set what type of cheese to use
 * for the pizza in this case it will be Goat.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Goat extends Cheese{
    public Goat(){
        super("Goat",new Money(2),140);
    }
}
