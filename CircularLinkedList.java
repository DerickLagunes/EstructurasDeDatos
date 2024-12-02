
public class CircularLinkedList<T> {
    
    // Atributos de la lista enlazada circular
    private Node<T> head; // Primer nodo de la lista
    private Node<T> tail; // Último nodo de la lista (que apunta a head)
    private int size;     // Tamaño de la lista

    // Constructor
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Método para añadir un elemento al final de la lista
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) { // Si la lista está vacía
            head = newNode;
            tail = newNode;
            tail.next = head; // Cerrar el ciclo, apuntando al head
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Mantener la circularidad
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

        Node<T> current = head;
        // Recorrer hasta el índice deseado
        for (int i = 0; i < index; i++) {
            current = current.next;
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

        if (index == 0) {
            if (size == 1) {
                // Si solo hay un nodo, eliminarlo y reiniciar la lista
                head = null;
                tail = null;
            } else {
                head = head.next; // Mover la cabeza al siguiente nodo
                tail.next = head; // Mantener la circularidad
            }
        } else {
            Node<T> current = head;
            // Buscar el nodo anterior al que queremos eliminar
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // Saltar el nodo a eliminar
            current.next = current.next.next;

            // Si el nodo a eliminar es el último, actualizar tail
            if (index == size - 1) {
                tail = current;
            }
        }

        size--;
        return true;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }
}