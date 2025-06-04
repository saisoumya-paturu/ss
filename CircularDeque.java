class MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            // Move front backward circularly
            front = (front - 1 + capacity) % capacity;
        }
        data[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            // Move rear forward circularly
            rear = (rear + 1) % capacity;
        }
        data[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;

        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return data[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
