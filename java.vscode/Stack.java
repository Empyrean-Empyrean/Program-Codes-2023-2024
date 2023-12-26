public class Stack {

    public int top = -1;
    public int size = 5;

    int stack[] = new int[5];

    public void push(int x) {
        if (top > size - 1 || top == size - 1) {
            System.out.println("Stack is full. 'Overflow!'");
        } else {
            top++;
            stack[top] = x;
            System.out.println("pushed " + x + " into the stack");
        }
    }

    public void pop() {
        if (top < -1 || top == -1) {
            System.out.println("underflow!");
        } else {
            System.out.println("popped item  is " + stack[top]);
            top--;
        }
    }

    public boolean isEmpty() {
        if (top > 0 || top == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void top() {
        if (isEmpty() == false) {
            System.out.println(stack[top]);
        }
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stc1 = new Stack();
        stc1.isEmpty();
        stc1.push(5);
        stc1.pop();
        stc1.push(10);
        stc1.push(11);
        stc1.push(12);
        stc1.push(15);
        stc1.push(1);
        stc1.push(19);
        stc1.pop();
        System.out.println("current item at the top of the stack is ");
        stc1.top();
        System.out.println("current size of the stack is " + stc1.size());
        System.out.println("Is the stack empty? ");
        System.out.println(stc1.isEmpty());
        stc1.pop();
        stc1.pop();
        stc1.pop();
        stc1.pop();
        stc1.pop();
        stc1.pop();
        stc1.top();
        System.out.println("current size of the stack is " + stc1.size());
        System.out.println("Is the stack empty? ");
        System.out.println(stc1.isEmpty());
    }
}
