package ingredients;

import mainClasses.Money;

import java.awt.*;
/**
 * Pepper
 *--------
 * inherit from the Vegetable sub class to pick out what type of Vegetable
 * the user wants on the pizza in this case its a pepper. When it does this it gives the sub class
 * a new description, coast, and calories of the ingredient but a Vegetable
 * can be have different colors so we add a Color class to take this into account
 *
 * @author Dagem Lakew
 */
public class Pepper extends Vegetable {

    public Pepper() {
        super("Pepper", new Money(1), 130,Color.green);
    }

    public Pepper(Color color) {
        super("Pepper", new Money(1), 130, color);
    }


}
