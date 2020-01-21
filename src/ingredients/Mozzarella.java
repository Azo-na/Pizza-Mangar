package ingredients;

import mainClasses.Money;
/**
 * Goat
 *--------
 * inherit from the Cheese sub class to set what type of cheese to use
 * for the pizza in this case it will be Mozzarella.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Mozzarella extends Cheese{
    public Mozzarella(){
        super("Mozzarella",new Money(2,150),155);
    }
}
