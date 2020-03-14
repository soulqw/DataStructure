package queue;

public class LoopQueue {
    int[] data;
    int head;
    int rear;

    public LoopQueue(int size) {
        this.data = new int[size];
        this.head = 0;
        this.rear = 0;
    }

    public void offer(int element) {
        data[rear] = element;
        rear = (rear + 1) % data.length;
    }

    public int poll() {
        int element = data[head];
        head = (head + 1) % data.length;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = head; i != rear; i = (i + 1) % data.length) {
            builder.append(data[i]).append(",");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(10);
        loopQueue.offer(2);
        loopQueue.offer(1);
        loopQueue.offer(1);
        loopQueue.offer(1);
        loopQueue.offer(4);
        int data = loopQueue.poll();
        System.out.print(data + "\n");
        System.out.println(loopQueue.toString());
    }

}
