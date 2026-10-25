package DataStructure;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public LinkedList() {
        head = null;
        size = 0;
    }
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }else {
            Node<T> curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
         Node<T> newNode = new Node<>(data);
         newNode.next = head;
         head = newNode;
         size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) { 
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> curr = head;
        for (int i=0; i<index; i++) { curr = curr.next; }
        return curr.data;
    }

    public boolean remove(T data) {
        if (head == null) {
            throw new IndexOutOfBoundsException("DATA" + data);
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            if(curr.data.equals(data)) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void printList() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(0);
        list.printList(); // 0 -> 1 -> 2 -> 3 -> null

        list.remove(2);
        list.printList(); // 0 -> 1 -> 3 -> null

        System.out.println(list.get(1));
    }
}
