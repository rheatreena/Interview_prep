import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author trinapal
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }

    private int capacity;

    LRUCache(int capacity){
       this.capacity = capacity;
        doubleque = new LinkedList<>();
        hashSet = new HashSet<>();
    }

    Deque<Integer> doubleque;
    HashSet<Integer> hashSet;
    private void refer(int item) {
        if(!hashSet.contains(item)){ //cache miss
            if(doubleque.size() == this.capacity){
                int last = doubleque.removeLast();
                hashSet.remove(last);
            }
        }else{
            //cache hit
            doubleque.remove(item);
        }
        doubleque.push(item);
        hashSet.add(item);
    }

    private void display() {
        Iterator iterator = doubleque.iterator();
        while(iterator.hasNext()){
            System.out.println(" " + iterator.next() + " ");
        }
    }

}
