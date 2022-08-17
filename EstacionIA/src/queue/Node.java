package queue;

public class Node<T> {
    private int G,F;
    private T data;
    private Node<T> next;

    public Node(int Gg, int Ff) {
        this.G = Gg; // distancia do filho até o atual
        this.F = Ff; // soma das distancias
    }

    public int getG() {
        return this.G;
    }

    public int getF() {
        return this.F;
    }

    public void setData(T d) {
        this.data = d;
    }

    public void setNext(Node<T> n) {
        this.next = n;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }


}