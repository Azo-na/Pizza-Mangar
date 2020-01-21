package ingredients;

import mainClasses.Money;
/**
 * Meat
 *--------
 * inherit from the ingredient super class to be able to
 * make a new Meat. When it does this it gives the super class
 * a new description, coast, and calories of the ingredient
 *
 * @author Dagem Lakew
 */
public class Meat extends Ingredient {

    public Meat(String desc, Money m, int cal) {
        super(desc, m, cal);
    }

}
