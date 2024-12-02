public class UV_E2_Apellidos_Nombre {
    
    static int valorRaiz = 0;
    public static void main (String[] args){

        //Primero llenamos el árbol
        BinaryTree root = new BinaryTree();
        root.insert(50);
        root.insert(30);
        root.insert(70);
        root.insert(20);
        root.insert(40);
        root.insert(60);
        root.insert(80);

        valorRaiz = root.getData();
        //necesitamos una manera de saber si el arbol (root)
        // es Un Binary Search Tree (BST)
        System.out.println(isBST(root.root,20,80) ? 
                    "SI es BST" : "NO es BST");   
        
        
        root.root.right.left.data = -20;

        System.out.println(isBST(root.root,-20,80) ? 
                    "SI es BST" : "NO es BST");
        
    }

        
        
        
    // Recorrido in-order (izquierda, raíz, derecha)
    public static boolean isBST(BinaryTree.Node root, 
                                int min, int max) {
        return isBSTRecursive(root, min, max);
    }

    private static boolean isBSTRecursive(BinaryTree.Node node, int min, int max) {
        if (node == null) {
            return true; //LLegamos al final de la hoja
        }
        
        //Condición de paro adicional
        //para casos extraños
        if(node.data < min || node.data > max){
            System.out.println("Oye revisa tus valores");
            return false;
        }

        return isBSTRecursive(node.left, min, node.data -1) &&
            isBSTRecursive(node.right, node.data + 1, max);

    }

}
