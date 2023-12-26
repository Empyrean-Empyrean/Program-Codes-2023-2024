public class queue {
    int arr[];
    int front, rear;

    queue(int len) {
        arr = new int[len];
        front = rear = -1;
    }
   
    void enqueue(int num) {
        if (rear == arr.length - 1) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = rear = 0;
            arr[front] = num;
            System.out.println("entered " + num + " to queue");
        } else {
            rear++;
            arr[rear] = num;
            System.out.println("entered " + num + " to queue");
        }
    }

    int dequeue() {
        if (rear == -1) {
            System.out.println("queue is empty");
            return -1;
        } else if (front == rear) {
            int val = arr[front];
            front = rear = -1;
            System.out.println("deleted " + val + " from queue");
            return val;
        } else {
            int val1 = arr[front];
            front++;
            System.out.println("deleted " + val1 + " from queue");
            return val1;
        }
    }

    boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (front == arr.length - 1 && rear == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        queue queue1 = new queue(5);
        System.out.println(queue1.isFull());
        queue1.enqueue(1);
        queue1.enqueue(5);
        queue1.enqueue(3);
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        System.out.println(queue1.isEmpty());

    }

}
