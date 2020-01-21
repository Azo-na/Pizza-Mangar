package ingredients;

import mainClasses.Money;

import java.awt.*;

/**
 * Vegetable
 *--------
 * inherit from the ingredient super class to be able to
 * make a new Vegetable. When it does this it gives the super class
 * a new description, coast, and calories of the ingredient but a Vegetable
 * can be have different colors so we add a Color class to take this into account
 *
 * @author Dagem Lakew
 */
public class Vegetable extends Ingredient {

    private Color vegetableColor;

    public Vegetable(String desc, Money m, int cal) {
        super(desc, m, cal);
    }

    public Vegetable(String desc, Money m, int cal, Color color) {
        super(desc, m, cal);
        vegetableColor = color;
    }

    public void setVegetableColor(Color vegetableColor) {
        this.vegetableColor = vegetableColor;
    }

    public Color getVegetableColor() {
        return vegetableColor;
    }

    @Override
    public String toString() {
        return vegetableColor +" " +super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vegetable)){
            return false;
        }

        Vegetable that = (Vegetable) obj;

        if (vegetableColor.equals(that.vegetableColor)){
            return super.equals(obj);
        }

        return false;
    }
}
