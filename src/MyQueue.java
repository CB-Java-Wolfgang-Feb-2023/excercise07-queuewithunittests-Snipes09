package Hausübung.excercise07_queueWithUnitTests;

public class MyQueue {
    private int size;
    private int[] queue;
    private int front, rear;

    public MyQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        rear = 0;
    }

    public MyQueue() {
        size = 10;
        queue = new int[size];
        front = 0;
        rear = 0;
    }

    // check if the queue is full
    public boolean isFull() {
        return size == front;
    }

    // check if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }

    // insert elements to the queue
    public void enqueue(int element) {
        if(isFull()) {
            queue = resize(queue);
        }
        queue[front] = element;
        front += 1;
    }

    // delete element from the queue
    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        int number = queue[rear];
        queue[rear] = 0;
        rear +=1;
        return number;
    }

    // get the capacity of the queue
    public int getCapacity() {
        return size;
    }

    private int[] resize(int [] oldQueue){
        size *= 2;
        int[] newQueue = new int[size];

        for (int i = rear; i < front; i++) {
            newQueue[i - rear] = oldQueue[i];
        }
        front = front - rear;
        rear = 0;

        return newQueue;
    }

    @Override
    public String toString() {
        StringBuilder queueAsString = new StringBuilder();

        for (int i = rear; i < front; i++) {
            queueAsString.append(queue[i]);
            if(i != front-1){
                queueAsString.append(", ");
            }
        }
        return queueAsString.toString();
    }
}
