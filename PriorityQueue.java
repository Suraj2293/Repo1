import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
    private final List<List<T>> queueList;

    public PriorityQueue() {
        queueList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            queueList.add(new ArrayList<>());
        }
    }

    public void offer(T data, int priority) {
        if (priority < 0 || priority > 9) {
            System.out.println("Priority must be between 0 and 9");
            // OR throw exception
            // throw new IllegalArgumentException("Priority must be between 0 and 9");
            return;
        }
        queueList.get(priority).add(data);
    }

    public T take() {
        for (int i = 9; i >= 0; i--) {
            List<T> list = queueList.get(i);
            if (!list.isEmpty()) {
                return list.remove(0);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.offer("Adform", 0);
        pq.offer("World", 1);
        pq.offer("Welcome", 0);
        pq.offer("to", 1);
        pq.offer("Here", 2);
        pq.offer("!", 1);


        System.out.println(pq.take()); //Prints "Here"
        System.out.println(pq.take()); //Prints "World"
        System.out.println(pq.take()); //Prints "to"
        System.out.println(pq.take()); //Prints "!"
        System.out.println(pq.take()); //Prints "Adform"
        System.out.println(pq.take()); //Prints "Welcome"
    }
}
