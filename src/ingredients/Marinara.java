package ingredients;

import mainClasses.Money;
/**
 * Marinara
 *--------
 * inherit from the Base sub class to be able to
 * to make the base of the pizza in this case it will be Marinara.
 * When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Marinara extends Base{
    public Marinara(){
        super("Marinara",new Money(1,50),150);
    }
}
