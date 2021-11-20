import java.util.ArrayList;
/**
 * The following code is an object that carries the data for a SINGLE chain in a separate chaining hash table
 * Since words can have the same hash code, they are stored in the same chain with a frequency stored in a
 * related location.
 *
 * @author Jacob Lurie
 * @version 1.1
 * @since 2021-11-12
 */
public class HashTableEntry {

    private ArrayList<String> wordValues;
    private ArrayList<Integer> frequencies;


    /**
     * constructor creates ArrayLists for words and their frequencies
     */
    public HashTableEntry() {

        wordValues = new ArrayList<String>();
        frequencies = new ArrayList<Integer>();

    }

    /**
     * adds a string to the wordValues array list and sets appropriate frequency
     * @param s string to be added into chain
     */
    public void addString(String s) {

        // Check if exists and either increment frequency or add new value
        boolean exists = false;
        int indexOfExist = 0;

        for(int i = 0; i < wordValues.size(); i++) {
            if(wordValues.get(i).equals(s)) {
                exists = true;
                indexOfExist = i;
                break;
            }
        }

        // If it doesn't exist add value, if it does, increment frequency
        if(!exists) {
            wordValues.add(s);
            frequencies.add(1);
        } else {
            frequencies.set(indexOfExist, frequencies.get(indexOfExist) + 1);
        }

    }

    /**
     * getter for wordValues ArrayList
     * @return ArrayList of word values
     */
    public ArrayList<String> getWordValues() {
        return wordValues;
    }

    /**
     * getter for frequencies array list
     * @return ArrayList of frequencies for value in chain
     */
    public ArrayList<Integer> getFrequencies() {
        return frequencies;
    }



}
