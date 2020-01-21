package mainClasses;

import ingredients.Ingredient;
import shapes.Circle;
import shapes.Shape;
import timeStamp.Date;
import timeStamp.TimeStamp;

import java.text.DecimalFormat;


public class Pizza implements PizzaComparable{
    private final TimeStamp dateMade;
    private Fraction NumberOfPieces;
    private Money AmountOfPizza;
    private int Calories;
    private Shape myShape;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Pizza() {
        AmountOfPizza = new Money((int)Math.round(Math.random()*40+4),(int)Math.round(Math.random()*1001));
        Calories = (int)Math.round(Math.random()*1001);
        NumberOfPieces = new Fraction(1,1);
		dateMade = new TimeStamp( PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime() );
		myShape = new Circle((int)Math.round(Math.random()*1001),(int)Math.round(Math.random()*1001));
	}

	public Date getMadeDate() {
	    return new Date(dateMade);
	}

    public void setRemainingFraction(Fraction amount) {
        NumberOfPieces = new Fraction(amount);
    }

    public Fraction getRemainingFraction() {
        return new Fraction(NumberOfPieces);
    }

    public Money getCost() {
        return new Money(AmountOfPizza);
    }

    public int getCalories() {
        return Calories;
    }

    public Shape getShape()	{ return (Shape) myShape.clone();}
    public void	setShape(Shape s) {myShape = (Shape)s.clone();}

    public double getRemainingArea(){
	    return (myShape.getArea()*NumberOfPieces.numerator)/NumberOfPieces.getDenominator();
    }

    public void eatSomePizza(Fraction amt){
        if (getRemainingFraction().getNumerator() > 0) {
            if (getRemainingFraction().getDenominator() == amt.getDenominator()) {
                setRemainingFraction(new Fraction(amt.getNumerator() - getRemainingFraction().getNumerator(), amt.getDenominator()));
            } else {
                double newDenominator = amt.getDenominator() * getRemainingFraction().getDenominator();
                double newNumerator = amt.getNumerator() * getRemainingFraction().getDenominator();
                double newNumerator2 = amt.getDenominator() * getRemainingFraction().getNumerator();
                newNumerator = newNumerator2-newNumerator;
                setRemainingFraction(new Fraction(newNumerator, newDenominator));
            }
        }
        else if (getRemainingFraction().getNumerator() < 0 || getRemainingFraction().getDenominator() < 0){
            throw new PizzaException("Negative fraction");
        }
        else {
            throw new PizzaException("Out of this pizza");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Pizza has a price: " +AmountOfPizza +" and calories: " +Calories +" Fraction remaining: " +getRemainingFraction() +" and area left: " +df.format(getRemainingArea()) +" and shape: " +myShape;
    }

    @Override
    public int compareTo(Object o) {
	    if (o == null || !(o instanceof Pizza)){
	        return -1;
        }

	    Pizza that = (Pizza)o;
	    return this.getCost().compareTo(that.getCost());
    }

    @Override
    public int compareToBySize(Object o) {
        if (o == null || !(o instanceof Pizza)){
            return -1;
        }

        Pizza that = (Pizza)o;
        if (this.getRemainingArea() < that.getRemainingArea()){
            return -1;
        }
        else if (this.getRemainingArea() == that.getRemainingArea()){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int compareToByCalories(Object o) {
        if (o == null || !(o instanceof Pizza)){
            return -1;
        }

        Pizza that = (Pizza)o;
        if (this.getCalories() < that.getCalories()){
            return -1;
        }
        else if (this.getCalories() == that.getCalories()){
            return 0;
        }
        else {
            return 1;
        }
    }
}
