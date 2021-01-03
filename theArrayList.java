import java.util.Arrays;

/**
 * The first part of the homework: theArrayL-like Interference
 * 
 * @author Deepali Juneja
 * @version 21 April 2020
 */
public class theArrayList {

    private Object[] theArrayL; 
    private int numberElem;// this represents the number of elements

    /**
     * Below, is the the first constructor, which takes in no values/arguments.
     */
    public theArrayList() {
        this.theArrayL = new Object[1]; // the original length is set to 1 here
        this.numberElem = this.theArrayL.length;
    }
    //checkpoint 1
    /**
     * Below, is the entire constructor which takes in values/arguments.
     * 
     * @param Ar 
     */
    public theArrayList(Object[] Ar) {
        if (Ar.length > 0) {// if the length is greater than 0, only then is an argument taken.
            this.theArrayL = new Object[Ar.length];
            this.numberElem = this.theArrayL.length;
            System.arraycopy(Ar, 0, this.theArrayL, 0, this.numberElem);
        } else {
            throw new IllegalArgumentException("the length isn't valid");
        }
    }
    //checkpoint 2
     /**
     * The purpose of this method is to add the object and chose its correct position at the index.
     * 
     * @param addObject   added object
     * @param indexPosition index position of where the object is added
     *
     */
    public void insert(Object addObject, int indexPosition) {
        if (addObject != null && indexPosition >= 0 && indexPosition < this.Arsize()) {
            
            if (this.numberElem == this.Arsize()) {
                this.theArrayL = Arrays.copyOf(this.theArrayL, this.Arsize() + 1);
            }
            System.arraycopy(this.theArrayL, indexPosition, this.theArrayL, indexPosition + 1, (this.Arsize() - 1) - indexPosition);
            this.theArrayL[indexPosition] = addObject;
        } else {
            throw new IllegalArgumentException("Not in bounds object");
        }
    }
    // checkpoint 3
    /**
     * The purpose of this method is to remove the object but return its value.
     * 
     * @param index   Position the index of the object to be removed
     * @return removeObj the object that is eventually removed
     * 
     */
    public Object remove(int indexPosition) {
        Object removeObj = -1;
        if (indexPosition >= 0 && indexPosition < this.Arsize()) {
            removeObj = this.theArrayL[indexPosition];
            this.numberElem--;
            System.arraycopy(this.theArrayL, indexPosition + 1, this.theArrayL, indexPosition, this.numberElem - indexPosition);
        } else {
            throw new IllegalArgumentException("Out of bounds");
        }
        return removeObj;
    }
     //checkppoint 4
    /**
     * The purpose of the method is to provide the size of theArrayL.
     * 
     * @return
     */
    public int Arsize() {
        return this.theArrayL.length;
    }
    //  checkpoint 5
    /**
     * The purpose of this method is to get/take the object at the specified index position
     * 
     * @param indexPosition
     * @return whichever object is in that specific location
     */
    public Object get(int indexPosition) {
        Object ret = -1;
        if (indexPosition >= 0 && indexPosition < this.Arsize()) {
            ret = this.theArrayL[indexPosition];
        }
        return ret;
    }
    //checkpoint 6
    /**
     * The purpose of this method to evaluate if the theArrayL is empty or not
     * 
     * @return true of false 
     */
    public boolean evalEmpty() {
        boolean output= false;
        if (this.Arsize() > 0) {
            for (Object check : theArrayL) {
                if (check== null) {
                    output = true;
                    break;
                } else {
                    output = false;
                }
            }
        } else {
            output = false;
        }
        return output;
    }
     //checkpoint 7
    /**
     * The method's purpose is to provide the index position.
     * 
     * @param returnObject the object whose index is returned
     * @return
     * 
     *
     */
    public int indexOf(Object returnObject) {
        int indexPosition = -1;
        for (int i = 0; i < this.Arsize(); i++) {
            if (this.theArrayL[i] == returnObject) {
                indexPosition = i;
                break;
            }
        }
        return indexPosition;
    }
     //checkpoint 8
    /**
     * The purpose of this method is to evaluate if 2 theArrayLs are equal or not to each other.
     * 
     * @param othertheArrayL 
     * @return true or false
     */
    public boolean equals(theArrayList othertheArrayL) {
        boolean output = false;
        if (this.Arsize() == othertheArrayL.Arsize()) {
            for (int i = 0; i < this.Arsize(); i++) {
                if (this.get(i) == othertheArrayL.get(i)) {
                    output = true;
                } else {
                    output = false;
                }
            }
        } else {
            output = false;
        }
        return output;
    }
     //checkpoint 9
    /**
     * The purpose of this last method is to produce an output string.
     */
    @Override
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < this.numberElem; i++) {
            if (this.theArrayL[i] != null) {
                output += this.theArrayL[i] + " ";
            }
        }
        output += "]";
        return output;
        //final checkpoint
    }
}