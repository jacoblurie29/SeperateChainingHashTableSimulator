import java.util.ArrayList;
import java.util.Locale;
/**
 * The following code stores the words in a string in a separate chaining hashtable
 * and rehashes when appropriate. The main HashTable array contains objects of HashTableEntries, these are objects
 * that contain an arraylist of words and their corresponding frequencies.
 *
 * @author Jacob Lurie
 * @version 1.3
 * @since 2021-11-12
 */

public class HashTableClass {


        public static void main(String[] args) {

            // Tests the wordCount method. String can replaced with any input.
            String test = "this is a test string that can be replace with any values that you want to put in";
            wordCount(test);

        }

        public static void wordCount(String input) {

            // Splits string into input words
            String[] inputWords = input.split("\\P{Alpha}+");
            for (int j = 0; j < inputWords.length; j++) {
                inputWords[j] = inputWords[j].toLowerCase(Locale.ROOT);
            }

            // Makes an array of hash table entries
            HashTableEntry[] HashTable = new HashTableEntry[10];

            // Parses through all values in HashTable
            for(int i = 0; i < inputWords.length; i++) {
                int HashCode = Math.abs(inputWords[i].hashCode()) % HashTable.length;

                // Checks for the number of cells with values present to calculate the load factor
                int numberOfNonEmptyCells = 0;
                for(int k = 0; k < HashTable.length; k++) {
                        if (!(HashTable[k] == null)) {
                            numberOfNonEmptyCells++;
                        }
                }

                // Load factor
                float loadFactor = (float) numberOfNonEmptyCells / HashTable.length;

                // Rehashes table
                if (loadFactor > 0.5) {
                    HashTable = rehash(HashTable, inputWords, i);
                }

                // Adds value to hash table using method in HashTableEntry
                if(HashTable[HashCode] == null) {
                    HashTable[HashCode] = new HashTableEntry();
                    HashTable[HashCode].addString(inputWords[i]);
                } else {
                    HashTable[HashCode].addString(inputWords[i]);
                }


            }

            // Loop prints out all of the values in the HashTable
            for(int i = 0; i < HashTable.length; i++) {

                if(HashTable[i] == null) {
                    System.out.println("Index: " + i + ". Chain #: null. Value: null. Frequency: null.");
                } else {
                    for(int w = 0; w < HashTable[i].getFrequencies().size(); w++) {
                        ArrayList<String> wordCount = HashTable[i].getWordValues();
                        ArrayList<Integer> frequencies = HashTable[i].getFrequencies();

                        System.out.println("Index: " + i + ". Chain #: " + w + ". Value: " + wordCount.get(w) + ". Frequency: " + frequencies.get(w));

                    }
                }
            }


        }

    // rehashes the table based on the original hash table with the input words
    public static HashTableEntry[] rehash(HashTableEntry[] original, String[] inputWords, int currentIndex) {

        // Size values
        int currentSize = original.length;
        int newSize = currentSize * 2;

        // New hash table
        HashTableEntry[] HashTable = new HashTableEntry[newSize];

        // Puts new values into new HashTable
        for(int i = 0; i < currentIndex; i++) {
            int HashCode = Math.abs(inputWords[i].hashCode()) % HashTable.length;
            if(HashTable[HashCode] == null) {
                HashTable[HashCode] = new HashTableEntry();
            }
            HashTable[HashCode].addString(inputWords[i]);
        }

        return HashTable;

    }


}
