package ingredients;

import mainClasses.Money;
/**
 * Alfredo
 *--------
 * inherit from the Base sub class to be able to
 * to make the base of the pizza in this case it will be Alfredo.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Alfredo extends Base {
    public Alfredo(){
        super("Alfredo",new Money(1,75),160);
    }
}
