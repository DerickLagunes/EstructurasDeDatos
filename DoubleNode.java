
// Nodo que almacena datos, referencia al siguiente y al anterior nodo
public class DoubleNode<T> {
    T data;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}