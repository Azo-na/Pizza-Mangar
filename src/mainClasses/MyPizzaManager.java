package mainClasses;

import java.util.Scanner;
import java.util.Stack;

/**
 * MyPizzaManager
 *----------------
 * This does most of the work for this pizza manager this
 * class has an ArrayList of Pizza which we use to sort by price, size, or calories
 * and we are able to add new pizzas to the array and display it to
 * if the user wants some type of pizza we have two different way of doing that to
 *
 * @author Dagem Lakew
 */
public class MyPizzaManager extends PizzaManager{
    private ArrayList<Pizza> listOfPizzas = new ArrayList<Pizza>();

    /**
     * addRandomPizza
     *------------------
     * adds a random pizza to the ArrayList
     * at the first index
     *
     *PRE: NONE
     *POST: adds a random pizza to the beginning of the list
     */
    @Override
    protected void addRandomPizza() {
        listOfPizzas.add(new Pizza(),0);
    }

    /**
     * displayAllPizzas
     *--------------------
     * prints out all the pizzas from the list
     *
     * PRE:NONE
     * POST:NONE
     */
    @Override
    protected void displayAllPizzas() {
        if (listOfPizzas.size() > 0) {
            for (int i = 0; i < listOfPizzas.size(); i++) {
                System.out.println(listOfPizzas.get(i));
            }
        }
    }

    /**
     * getNextChar
     *--------------
     * returns a char that represents what the user whats to
     * do when the menu pops up
     *
     * @return a char that represents what the users choice is for the menu
     *
     * PRE:
     * POST: return a char that represents what the users choice is for the menu
     */
    @Override
    protected char getNextChar() {

        Scanner letter = new Scanner(System.in);
        String whatToDo = letter.next();
        whatToDo = whatToDo.toUpperCase();
        return whatToDo.charAt(0);
    }

    /**
     * getNextInt
     *--------------
     * returns a int that represents a type of pizza he wants
     *
     * @return  returns a int that represents a type of pizza he wants
     *
     * PRE:
     * POST:  returns a int that represents a type of pizza he wants
     */
    protected int getNextInt() {

        Scanner number = new Scanner(System.in);
        return number.nextInt();

    }

    /**
     * eatSomePizza
     *-----------------
     * this ask the user for the pizza he wants to eat and how much of it
     * and it finds the pizza and subtracts the amount specified
     *
     * PRE: NONE
     * POST: NONE
     */
    @Override
    protected void eatSomePizza() {
        System.out.println("How much of the pizza do you want to eat and which pizza do you want to eat");
        System.out.println("index");
        Scanner indexWerePizzaIs = new Scanner(System.in);
        int index = indexWerePizzaIs.nextInt();
        System.out.println("numerator");
        Scanner topOfFraction = new Scanner(System.in);
        int numerator = topOfFraction.nextInt();
        System.out.println("denominator");
        Scanner bottomOfFraction = new Scanner(System.in);
        int denominator = bottomOfFraction.nextInt();

        Fraction amt = new Fraction(numerator,denominator);
        listOfPizzas.get(index).eatSomePizza(amt);
        if (listOfPizzas.get(index).getRemainingFraction().getNumerator() == 0 ||
                listOfPizzas.get(index).getRemainingFraction().getDenominator() == 0){
            listOfPizzas.remove(index);
        }

    }

    @Override
    protected void quickSortByCalories() {
        sortByCalories(listOfPizzas,0,listOfPizzas.size()-1);
    }

    /**
     * sortByCalories
     *-----------------
     * this recursively decides were the pointer will be at when
     * sort the array and calls it self again with the new pointers
     * @param data : the array that needs to be sorted
     * @param first: the left pointer in the array
     * @param last: the right pointer in the array
     */
    private void sortByCalories(ArrayList<Pizza> data, int first, int last){
        if (first < last)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partitionByCalories(data, first, last);

            // Recursively sort elements before
            // partition and after partition
            sortByCalories(data, first, pi-1);
            sortByCalories(data, pi+1, last);
        }
    }

    /**
     * partitionByCalories
     *------------
     * This does the swaps in the array with the left and right pointers
     * with it working by making the left pointer going left and the right pointer
     * going right it stops moving when the left pointer is greater then the pivot or
     * the right pointer is less then the pivot with the pivot being the first element
     * in the array. When they both stop then you check to see if the left pointer
     * is less then or equal to the right then you swap the two elements with the loop
     * stopping when the right and left pointer are less then 1 then it returns the left pointer
     *
     * @param data: the array being swapped
     * @param left: the left pointer in the array
     * @param right: the right pointer in the array
     * @return : the left pointer in the array
     *
     *PRE: NONE
     *POST: returns the left pointer
     */
    private int partitionByCalories(ArrayList<Pizza> data, int left, int right) {

        double pivot = data.get(right).getCalories();
        int i = (left-1); // index of smaller element
        for (int j = left; j < right; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (data.get(j).getCalories() >= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                data.swap(listOfPizzas,i,j);
            }
        }

        // swap arr[i] and arr[j]
        data.swap(listOfPizzas,i+1,right);
        return i+1;
    }


    @Override
    protected void quickSortByPrice() {
        sortByPrice(listOfPizzas,0,listOfPizzas.size()-1);
    }

    /**
     * sortByPrice
     *----------------
     * this recursively decides were the pointer will be at when
     * sort the array and calls it self again with the new pointers
     * @param data : the array that needs to be sorted
     * @param first: the left pointer in the array
     * @param last: the right pointer in the array
     */
    private void sortByPrice(ArrayList<Pizza> data, int first, int last){

        if (first < last)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partitionByPrice(data, first, last);

            // Recursively sort elements before
            // partition and after partition
            sortByPrice(data, first, pi-1);
            sortByPrice(data, pi+1, last);
        }
    }


    /**
     * partitionByPrice
     *------------
     * This does the swaps in the array with the left and right pointers
     * with it working by making the left pointer going left and the right pointer
     * going right it stops moving when the left pointer is greater then the pivot or
     * the right pointer is less then the pivot with the pivot being the first element
     * in the array. When they both stop then you check to see if the left pointer
     * is less then or equal to the right then you swap the two elements with the loop
     * stopping when the right and left pointer are less then 1 then it returns the left pointer
     *
     * @param data: the array being swapped
     * @param left: the left pointer in the array
     * @param right: the right pointer in the array
     * @return : the left pointer in the array
     *
     *PRE: NONE
     *POST: returns the left pointer
     */
    private int partitionByPrice(ArrayList<Pizza> data, int left, int right) {
        Money pivot = data.get(right).getCost();
        int i = (left-1); // index of smaller element
        for (int j = left; j < right; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (data.get(j).getCost().compareTo(pivot) > 0 || data.get(j).getCost().equals(pivot))
            {
                i++;

                // swap arr[i] and arr[j]
                data.swap(listOfPizzas,i,j);
            }
        }

        // swap arr[i] and arr[j]
        data.swap(listOfPizzas,i+1,right);
        return i+1;
    }


    @Override
    protected void quickSortBySize() {
        sortBySize(listOfPizzas,0,listOfPizzas.size()-1);
    }

    /**
     * sortBySize
     *-------------
     * this recursively decides were the pointer will be at when
     * sort the array and calls it self again with the new pointers
     * @param data : the array that needs to be sorted
     * @param first: the left pointer in the array
     * @param last: the right pointer in the array
     */
    private void sortBySize(ArrayList<Pizza> data, int first, int last){
        if (first < last)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partitionBySize(data, first, last);

            // Recursively sort elements before
            // partition and after partition
            sortBySize(data, first, pi-1);
            sortBySize(data, pi+1, last);
        }
    }

    /**
     * partitionByZie
     *------------
     * This does the swaps in the array with the left and right pointers
     * with it working by making the left pointer going left and the right pointer
     * going right it stops moving when the left pointer is greater then the pivot or
     * the right pointer is less then the pivot with the pivot being the first element
     * in the array. When they both stop then you check to see if the left pointer
     * is less then or equal to the right then you swap the two elements with the loop
     * stopping when the right and left pointer are less then 1 then it returns the left pointer
     *
     * @param data: the array being swapped
     * @param left: the left pointer in the array
     * @param right: the right pointer in the array
     * @return : the left pointer in the array
     *
     *PRE: NONE
     *POST: returns the left pointer
     */
    private int partitionBySize(ArrayList<Pizza> data, int left, int right) {

        double pivot = data.get(right).getRemainingArea();
        int i = (left-1); // index of smaller element
        for (int j = left; j < right; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (data.get(j).getRemainingArea() >= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                data.swap(listOfPizzas,i,j);
            }
        }

        // swap arr[i] and arr[j]
        data.swap(listOfPizzas,i+1,right);
        return i+1;
    }


    @Override
    protected int binarySearchByCalories(int cals) {
        quickSortByCalories();
        return binarySearch(cals,listOfPizzas,0,listOfPizzas.size()-1);

    }

    /**
     * binarySearch
     *---------------
     * looks through the list of pizzas to try to find the pizza and return were it is
     * in the list if not there then returns -1 to show tht its not here. it finds this
     * by moving the left or right pointer depending on if the middle point is greater or less then
     * the pointers
     * @param search : what needs to found
     * @param data : the list were we need to look for the pizza
     * @param start : beginning of the list
     * @param end : end of the list of the pizza
     * @return the index of the pizza if there if not then returns -1
     *
     * PRE: NONE
     * POST: return the index of the pizza if there if not then returns -1
     */
    private int binarySearch(int search, ArrayList<Pizza> data, int start, int end){
        if (end >= start) {
            int mid = start + (end - start) / 2;

            // If the element is present at the
            // middle itself
            if (data.get(mid).getCalories() == search)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (data.get(mid).getCalories() > search)
                return binarySearch(search, data, start, mid - 1);

            // Else the element can only be present
            // in right subarray
            return binarySearch(search, data, mid+1, end);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    /**
     * removeDayOldPizzas
     *---------------------
     * This finds pizzas that are a day old and
     * remove them form the list
     *
     * PRE: NOE
     * POST: removes day old pizzas from the list
     */
    @Override
    protected void removeDayOldPizzas() {
        for (int i = 0; i < listOfPizzas.size(); i++) {
            if (getCurrentDate().compareTo(listOfPizzas.get(i).getMadeDate()) > 0){
                listOfPizzas.remove(i);
            }
        }
    }

    @Override
    protected void reversePizzasWithStack() {
        Stack<Pizza> flip = new Stack<Pizza>();
        for (int i = 0; i < listOfPizzas.size(); i++){
            flip.push(listOfPizzas.get(i));
        }


        for (int j = 0; j < listOfPizzas.size(); j++){
            listOfPizzas.replace(flip.pop(),j);
        }
    }

    @Override
    protected int linearSearchByDay(int day) {
        return linearSearch(listOfPizzas, 0,listOfPizzas.size()-1,day);
    }

    /**
     * linearSearch
     *-----------------
     * looks through they list in a linear fashion which is by having a left and right pointer
     * and moving them one down each time until one of them is equal to the target day
     *
     * @param data list we are looking for
     * @param l left pointer that will move to the right
     * @param r right pointer that will move to the left
     * @param day target day we are looking for
     * @return the index of the pizza that matches the day given
     */
    private int linearSearch(ArrayList<Pizza> data, int l, int r, int day)
    {
        if (r < l)
            return -1;
        if (data.get(l).getMadeDate().getDay() == day)
            return l;
        if (data.get(r).getMadeDate().getDay() == day)
            return r;
        return linearSearch(data, l+1, r-1, day);
    }
}
