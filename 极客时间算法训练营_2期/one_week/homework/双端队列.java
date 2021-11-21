package sf.极客时间算法训练营_2期.one_week.homework;

public class 双端队列 {

    class MyCircularDeque {

        private int size = 0;
        private int capacity = 0;
        private Node head;
        private Node tail;

        public MyCircularDeque(int k) {
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (size + 1 > capacity) {
                return false;
            }
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node node = new Node(value);
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size + 1 > capacity) {
                return false;
            }
            if (tail == null) {
                tail = new Node(value);
                head = tail;
            } else {
                Node node = new Node(value);
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return true;
            }
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return true;
            }
            Node prev = tail.prev;
            prev.next = null;
            tail.prev = null;
            tail = prev;
            size--;
            return true;
        }

        public int getFront() {
            if (head == null) {
                return -1;
            }
            return head.val;
        }

        public int getRear() {
            if (tail == null) {
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        class Node {
            public int val;
            public Node prev;
            public Node next;

            public Node(int v) {
                val = v;
            }
        }
    }
}
