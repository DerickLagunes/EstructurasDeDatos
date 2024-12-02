public class UV_E1_Apellidos_Nombres {

    public static void main(String[] args) {
        //Arbol
        BinaryTree arbol = new BinaryTree();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);

        System.out.print("Recorrido In-Order: ");
        arbol.inOrder();
        System.out.println();

        System.out.print("Recorrido Pre-Order: ");
        arbol.preOrder();
        System.out.println();

        System.out.print("Recorrido Post-Order: ");
        arbol.postOrder();
        System.out.println();
    }
    
}
