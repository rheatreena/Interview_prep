import java.util.ArrayList;

/**
 * @author trinapal
 */
public class MapDetails {

    public static void main(String[] args) {
        // Creating the Map
        Map<Integer, String> map = new Map<Integer, String>();

        // Inserting elements
        map.insert(1, "Geeks");
        map.printMap();

        map.insert(2, "forGeeks");
        map.printMap();

        map.insert(3, "A");
        map.printMap();

        map.insert(4, "Computer");
        map.printMap();

        map.insert(5, "Portal");
        map.printMap();

        //Get element from Map
        int key = 4;
        String value = map.getValue(key);
        System.out.println("Value at key "+ key +" is: "+ value);
    }
}

class Map<K, V> {

    public V getValue(K key) {
        return null;
    }

    class MapNode<K,V> {
        K key;
        V value;
        MapNode<K, V> next;


        MapNode(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    int size;

    int numOfBuckets;

    final double DEFAULT_LOAD_FACTOR = 0.75;

    // The bucket array where
    // the nodes containing K-V pairs are stored
    ArrayList<MapNode<K, V> > buckets;

    public Map() {
        numOfBuckets = 5;

        buckets = new ArrayList<>(numOfBuckets);

        //initialize buckets to null

        for(int i =0; i< numOfBuckets; i++){
            buckets.add(null);
        }
        System.out.println("HashMap created");
        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numOfBuckets);
        System.out.println("Default Load Factor : " + DEFAULT_LOAD_FACTOR + "\n");
    }
    public void insert(K key, V value) {

        // Getting the index at which it needs to be inserted
        int bucketInd = getBucketInd(key);
        // The first node at that index
        MapNode<K, V> head = buckets.get(bucketInd);
        while(head != null){
            //if key is already present
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        // new node with the K and V
        MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
        // The head node at the index
        head = buckets.get(bucketInd);
        newElementNode.next = head;
        buckets.set(bucketInd, newElementNode);

        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");

        // Incrementing size
        // as new K-V pair is added to the map
        size++;

        // Load factor calculated
        double loadFactor = (1.0*size)/numOfBuckets;
        // If the load factor is > 0.75, rehashing is done
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            System.out.println(loadFactor + " is greater than " + DEFAULT_LOAD_FACTOR);
            System.out.println("Therefore Rehashing will be done.\n");

            // Rehash
           // rehashing();

            System.out.println("New Size of Map: " + numOfBuckets + "\n");
        }

        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numOfBuckets + "\n");
    }



    private void rehashing() {
    }

    private int getBucketInd(K key) {
        int hashcode = key.hashCode();
        return (hashcode%numOfBuckets);
    }

    public void printMap() {
    }
}