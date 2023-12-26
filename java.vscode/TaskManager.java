class DoublyLinkedList {
    public class Node {
        TaskManager data;
        Node prev;
        Node next;

        public Node(TaskManager data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.title + " " + current.data.description + " " + current.data.duedate);
            current = current.next;
        }
    }

    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data.title + " " + current.data.description + " " + current.data.duedate);
            current = current.prev;
        }
    }

    public void insertAtBeginning(TaskManager data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtEnd(TaskManager data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void insertAtPosition(TaskManager data, int position) {
        Node temp = new Node(data);
        if (position == 1) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            int currPosition = 1;
            while (current != null && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            } else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }

    }

    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public void delete(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    void rearrangeTasks(Node node, Node prev, Node next) {
        if (prev != null) {
            prev.next = node;
        }
        if (next != null) {
            next.prev = node;
        }
        node.prev = prev;
        node.next = next;
        if (prev == null) {
            head = node;
        }
        if (next == null) {
            tail = node;
        }
    }

    void sortByDueDate() {
        Node currentNode;
        boolean swapped;

        if (head == null) return;

        do {
            currentNode = head;
            swapped = false;

            while (currentNode.next != null) {
                // Convert due dates to integers for comparison
                int dueDate1 = currentNode.data.duedate;
                int dueDate2 = currentNode.next.data.duedate;

                if (dueDate1 > dueDate2) {
                    // Swap nodes
                    Node temp = currentNode;
                    currentNode = currentNode.next;
                    rearrangeTasks(temp, temp.prev, currentNode.next);
                    swapped = true;
                } else {
                    currentNode = currentNode.next;
                }
            }
        } while (swapped);
    }
}

public class TaskManager {
    String title;
    String description;
    int duedate;
    double width, height, depth;

    TaskManager(TaskManager ob) {
        title = ob.title;
        description = ob.description;
        duedate = ob.duedate;
    }

    TaskManager(String t, String de, int d) {
        title = t;
        description = de;
        duedate = d;
    }

    public static void main(String[] args) {
        TaskManager task11 = new TaskManager("task1", "starting task1", 12102023);
        TaskManager task1 = new TaskManager(task11);
        TaskManager task21 = new TaskManager("Task2", "starting task2", 13102023);
        TaskManager task2 = new TaskManager(task21);
        TaskManager task31 = new TaskManager("Task3", "starting task3", 14102023);
        TaskManager task3 = new TaskManager(task31);
        TaskManager task41 = new TaskManager("Task4", "starting task4", 15102023);
        TaskManager task4 = new TaskManager(task41);
        DoublyLinkedList tasks = new DoublyLinkedList();
        tasks.insertAtBeginning(task1);
        tasks.insertAtEnd(task2);
        tasks.insertAtEnd(task3);
        tasks.insertAtEnd(task4);
        tasks.traverseForward();
        tasks.sortByDueDate();
    }
}