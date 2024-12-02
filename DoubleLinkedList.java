
public class DoubleLinkedList<T> {
    
    // Atributos de la lista doblemente enlazada
    private DoubleNode<T> head; // Primer nodo de la lista
    private DoubleNode<T> tail; // Último nodo de la lista
    private int size;     // Tamaño de la lista

    // Constructor
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Método para añadir un elemento al final de la lista
    public boolean add(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (head == null) { // Si la lista está vacía
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Actualizar la referencia al último nodo
        }

        size++;
        return true;
    }

    // Método para obtener un elemento por índice
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "El índice está fuera de los límites de la lista"
            );
        }

        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            // Recorrer desde el principio hasta el índice deseado
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            // Recorrer desde el final hasta el índice deseado
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }

    // Método para remover un elemento por índice
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "El índice está fuera de los límites de la lista"
            );
        }

        DoubleNode<T> current;
        if (index == 0) {
            current = head;
            head = head.next; // Remover el primer nodo
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.prev; // Remover el último nodo
            if (tail != null) {
                tail.next = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                // Buscar el nodo en la primera mitad de la lista
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                // Buscar el nodo en la segunda mitad de la lista
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }

            // Conectar los nodos anterior y siguiente para eliminar el nodo
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return true;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }
}