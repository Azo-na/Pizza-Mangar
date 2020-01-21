package ingredients;

import mainClasses.Money;
/**
 * Sausage
 *------------
 * inherit from the Meat sub class the type of meat the
 * person wants on there pizza in this case it will be Sausage.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Sausage extends Meat{
    public Sausage(){
        super("Sausage",new Money(1),200);
    }
}
