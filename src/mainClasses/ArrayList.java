package mainClasses;

public class ArrayList<Pizza extends Comparable> {

    private Object[] list = new Object[2];
    //Keeps track of how much of the array i have used
    private int arrayLength = 0;

    /**
     * add
     * --------
     * This takes an an object and an int to add them
     * in to the Object[] called list
     * and it increase how big the array should be
     * Also if a person gives an arrayLength with a number already
     * in that arrayLength ot moves the array at the arrayLength to the
     * right one
     *
     *
     * @param input: takes in an Object type variable
     * @param index: takes an int variable
     *
     * PRE: NONE
     * POST: inserts objects in the object array called list
     */
    public void add(Pizza input, int index){

        if (this.list.length < arrayLength+1) copyAndIncreaseArray();
        arrayLength++;
        shiftRight(index);
        list[index] = input;

    }

    public void replace(Pizza input, int index){
        list[index] = input;
    }

    /**
     * remove
     * -------
     * This takes an arrayLength the user has decided and removes
     * it from the array and returns it also decreases the
     * size of the array
     *
     * @param index : Takes in an int to be used as an arrayLength
     * @return objectToRemove: returns an object that was removed
     *
     * PRE: NONE
     * POST:
     */
    public Pizza remove(int index){
        //This check to see if the array has
        //stuff inside of it
        if (this.arrayLength > 0) {
            //holds the object at the specified arrayLength
            //to return it later
            Pizza objectToRemove = (Pizza) this.list[index];

            //This moves all the objects in the array to the left one
            shiftLeft(index);

            this.arrayLength--;

            return objectToRemove;
        }
        else {
            throw new RuntimeException();
        }
    }

    /**
     * size
     * ------
     * this returns the size of the array
     *
     * @return arrayLength: returns the size of the array
     *
     * POST: NONE
     * PRE: NONE
     */
    public int size(){
        return this.arrayLength;
    }

    /**
     * toString
     * ------
     * returns the objects in the array as strings
     *
     * POST: NONE
     * PRE: NONE
     */
    public String toString(){
        String string = "[]";

        if (this.arrayLength > 1) {
            string = "[" + this.list[0] + ",";
            for (int i = 1; i < this.arrayLength; i++) {
                if (i != this.arrayLength - 1) {
                    string += this.list[i] + ",";
                } else {
                    string += this.list[i] + "]";
                }
            }
            return string;
        }
        else if (this.arrayLength > 0){
            string = "[" + this.list[0] + "]";
            return string;
        }
        else {
            return string;
        }
    }

    /**
     * equals
     * -------
     * Returns true or false depending if the two
     * list class are the same
     *
     * @param obj : takes in another class
     *                       that is the same is this one
     * @return : returns true if the
     *          classes are equal to each other
     *
     * PRE: Must be that same type of object
     *      Must have some elements in them
     * POST: NONE
     */
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ArrayList)){
            return false;
        }

        ArrayList otherArrayList = (ArrayList) obj;

        if (this.arrayLength != otherArrayList.arrayLength) {
            return false;
        }

        for (int i = 0; i < this.arrayLength; i++) {
            if (this.list[i].equals(otherArrayList.list[i])) {
                return false;
            }
        }

        return true;

    }

    /**
     * isEmpty
     * --------
     * Returns false or true depending on
     * if the array is empty
     *
     * @return : returns false if the array is empty
     *
     * PRE: NONE
     * POST: NONE
     */
    public boolean isEmpty(){
        if (size() > 0){
            return false;
        }

        return true;
    }

    /**
     *get
     *------
     * returns the object at a specified arrayLength or return negative one if the
     * arrayLength is out of bound
     *
     * @param index : an int that represents an arrayLength of the array
     * @return : returns the object at a specified arrayLength if the arrayLength
     *           is out of range then will return negative one
     *
     * PRE: NONE
     * POST: NONE
     */
    public Pizza get(int index) {
        if (size() < index){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " +size());
        }
        else {
            return (Pizza) this.list[index];
        }
    }

    /**
     *indexOf
     *--------
     * This takes in an object and sees if the object is in the array
     * if it is it returns it if not returns null
     *
     * @param input : an object we are supposed to
     *              find in the array
     * @return : returns the arrayLength of the object
     *           or negative one if not found
     *
     * PRE: NONE
     * POST: NONE
     */
    public int indexOf(Object input){
        for (int i = 0; i < this.arrayLength; i++){
            if (this.list[i] == input){
                return i;
            }
        }

        return -1;
    }

    /**
     * swap
     *-------
     * This will swap the two elements with each other
     * with the smallest one going to the right
     *
     * @param data : the array that has the elements to swap
     * @param first: one of the index needed to swap this is the larger number
     * @param last: one of the index needed to swap this is the smaller number
     *
     *PRE: NONE
     *POST: swaps two numbers in a array
     */
    public void swap(ArrayList<Pizza> data, int first, int last) {
        Pizza temp = data.get(first);
        data.replace(data.get(last),first);
        data.replace(temp,last);
    }

    /**
     * shiftLeft
     * ----------
     * these moves the list array to the left starting at some index
     *
     * @param index : where we start to move thing to the left
     *
     * PRE: NONE
     * POST: moves the list array to the left starting at some index
     */
    private void shiftLeft(int index){
        for (int i = index; i < arrayLength; i++){
            this.list[i] = this.list[i+1];
        }
    }

    /**
     * shiftRight
     * ----------
     * these moves the list array to the right starting at some index
     *
     * @param index : where we start to move thing to the right
     *
     * PRE: NONE
     * POST: moves the list array to the right starting at some index
     */
    private void shiftRight(int index){
        for (int i = arrayLength-1-1; i >= index; i-- ){
            this.list[i+1] = this.list[i];
        }
    }
    /**
     *copyAndIncreaseArray
     *--------
     * This copys the list array to a new
     * array and increases the new arrays size
     * and sets the new array back to the old array
     *
     * PRE: NONE
     * POST: NONE
     */
    private void copyAndIncreaseArray(){
        Object[] newList = new Object[this.arrayLength +3];
        for (int i = 0; i < this.arrayLength; i++){
            newList[i] = this.list[i];
        }

        this.list = newList;

    }
	
}
