import java.util.LinkedList;
import java.util.Queue;

/**
 * @author trinapal
 */
public class StackInQueue {
    public static void main(String[] args) {
        StackInQueue s = new StackInQueue();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
        s.remove();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());

    }


    // two queues

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();



    private int size() {
        return q1.size();
    }

    private int top() {
       if(q1.isEmpty())
           return -1;
       while(q1.size() != 1){
           q2.add(q1.peek());
           q1.remove();

       }
       //last pushed item
        int temp = q1.peek();
       q1.remove();
       q2.add(temp);

       //swap names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    private void remove() {
        if(q1.isEmpty()){
            return;
        }

        /// Leave one element in q1 and
        //        // push others in q2.


        while(q1.size() != 1){
            q2.add(q1.peek());
            q1.remove();
        }

        //pop the last element from q1
        q1.remove();

        //swap the names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 =q;
    }

    private void add(int item) {
        q1.add(item);
    }

}
