/**
 * The following code tests the HashTableClass class and HashTableEntry class
 *
 * @author Jacob Lurie
 * @version 1.1
 * @since 2021-11-19
 */
public class HashTableTester {

    public static void main(String[] args) {

        // Tests the wordCount method. String can replaced with any input.
        String test = "this is a test string that can be replace with any values that you want to put in";
        HashTableClass table = new HashTableClass();
        table.createHashTable(test);

    }

}
