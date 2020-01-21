package ingredients;

import mainClasses.Money;

/**
 * Pepperoni
 *------------
 * inherit from the Meat sub class the type of meat the
 * person wants on there pizza in this case it will be Pepperoni.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Pepperoni extends Meat{
    public Pepperoni(){
        super("Pepperoni",new Money(1),190);
    }
}
