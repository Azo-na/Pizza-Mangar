package ingredients;

import mainClasses.Money;
/**
 * Base
 *--------
 * inherit from the ingredient super class to be able to
 * make a new Base. When it does this it gives the super class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Base extends Ingredient {

    public Base(String desc, Money m, int cal) {
        super(desc, m, cal);
    }

}
