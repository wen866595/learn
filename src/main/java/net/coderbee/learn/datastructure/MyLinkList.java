package net.coderbee.learn.datastructure;

public class MyLinkList<T> {
    private Node<T> head;

    public int size() {
        int len = 0;
        Node<T> p = head;
        while ((p != null)) {
            p = p.next;
            len++;
        }
        return len;
    }

    public MyLinkList<T> appendTail(T v) {
        Node<T> newNode = new Node<T>(v);
        Node<T> tail = getTail();
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        return this;
    }

    private Node<T> getTail() {
        if (head == null) {
            return null;
        }

        Node<T> p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public MyLinkList<T> insertHead(T v) {
        if (head == null) {
            head = new Node(v);
        } else {
            head = new Node<>(v, head);
        }
        return this;
    }

    public MyLinkList<T> reverse() {
        Node<T> p = head;
        head = null;
        while (p != null) {
            insertHead(p.val);
            p = p.next;
        }
        return this;
    }

    public void deleteReverseN(int n) {
        if (n <= 0) {
            return;
        }
        int len = 0;

        Node<T> pn = null;
        Node<T> p = head;
        while (p != null) {
            len++;
            p = p.next;
            if (len > n) {
                if (pn == null) {
                    pn = head;
                } else {
                    pn = pn.next;
                }
            }
        }

        if (len == n) {
            head = head.next;
        } else if (len > n) {
            pn.next = pn.next.next;
        }
    }

    public Node<T> getMiddle() {
        Node<T> mid = head;
        int midIndex = 1;
        int len = 0;

        Node<T> p = head;
        while (p != null) {
            len++;
            p = p.next;
            if (midIndex < ((len + 1) / 2)) {
                midIndex = (len + 1) / 2;
                mid = mid.next;
            }
        }

        return mid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        Node<T> p = head;
        while (p != null) {
            sb.append(p.val).append(',');
            p = p.next;
        }
        if (sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append(']');
        }

        return sb.toString();
    }

    class Node<T> {
        T val;
        Node<T> next;

        Node(T v) {
            this.val = v;
        }

        Node(T v, Node<T> next) {
            this.val = v;
            this.next = next;
        }

        public String toString() {
            if (val == null) {
                return "null";
            } else {
                return val.toString();
            }
        }
    }

}
