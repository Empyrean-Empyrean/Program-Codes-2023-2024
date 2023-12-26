public class deque {
    int arr[];
    int front, rear;

    deque(int len) {
        arr = new int[len];
        front = rear = -1;
    }

    void insertRear(int num) {
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

    void insertFront(int num) {
        if (rear == arr.length - 1 && front == 0) {
            System.out.println("Queue is full");
        } else if (front > 1 || front == 1) {
            front--;
            arr[front] = num;
            System.out.println("entered " + num + " to queue");
        } else {
            System.out.println("element cannot be added");
        }
    }

    int deleteFront() {
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

    int deleteRear() {
        if (rear == -1) {
            System.out.println("queue is empty");
            return -1;
        } else if (front == rear) {
            int val = arr[front];
            front = rear = -1;
            System.out.println("deleted " + val + " from queue");
            return val;
        } else {
            int val1 = arr[rear];
            rear--;
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
        deque deque1 = new deque(5);
        deque1.insertFront(1);
        deque1.insertFront(2);
        deque1.insertRear(5);
        deque1.insertRear(3);
        deque1.insertRear(2);
        deque1.deleteRear();
        deque1.deleteFront();
        deque1.insertFront(1);
    }
}
