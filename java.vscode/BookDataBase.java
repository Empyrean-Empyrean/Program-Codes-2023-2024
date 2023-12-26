import java.util.HashMap;
import java.util.Map;

public class HashTable {
    private Map<String, Object> hashTable = new HashMap<>();

    public void add(String key, Object value) {
        int hashValue = calculateHashValue(key);
        while (hashTable.containsKey(hashValue)) {
            hashValue++;
        }
        hashTable.put(hashValue, value);
    }

    public Object get(String key) {
        int hashValue = calculateHashValue(key);
        return hashTable.get(hashValue);
    }

    private int calculateHashValue(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i);
        }
        return hashValue % hashTable.size();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("book1", "red");
        hashTable.add("book2", "yellow");
        hashTable.add("book3", "book3");

        System.out.println(hashTable.get("book1")); // Output: red
        System.out.println(hashTable.get("book2")); // Output: yellow
        System.out.println(hashTable.get("book3")); // Output: book3
    }
}

