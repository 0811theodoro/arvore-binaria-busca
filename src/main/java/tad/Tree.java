package tad;

public class Tree {
    private Node root;

    public void inserir(int valor) {
        inserir(this.root, valor);
    }

    public void inserir(Node node, int valor) {
        if (this.root == null) {
            this.root = new Node(valor);
        } else {
            if (valor < node.getValor()) {
                if (node.getEsquerda() != null) {
                    inserir(node.getEsquerda(), valor);
                } else {
                    
                    node.setEsquerda(new Node(valor));
                }
                
            } else if (valor > node.getValor()) {
                
                if (node.getDireita() != null) {
                    inserir(node.getDireita(), valor);
                } else {
                    
                    node.setDireita(new Node(valor));
                }
            }
        }
    }

    public Node remover(int valor) throws Exception {
        return remover(this.root, valor);
    }

    private Node remover(Node node, int valor) throws Exception {
        if (this.root == null) {
            throw new Exception("Árvore vazia");
        } else {
            if (valor < node.getValor()) {
                node.setEsquerda(remover(node.getEsquerda(), valor));
            } else if (valor > node.getValor()) {
                node.setDireita(remover(node.getDireita(), valor));
            } else if (node.getEsquerda() != null && node.getDireita() != null) {
                node.setValor(encontraMaximo(node.getEsquerda()).getValor());
                node.setEsquerda(removeMaximo(node.getEsquerda()));
            } else {
                node = (node.getEsquerda() != null) ? node.getEsquerda() : node.getDireita();
            }
            return node;
        }
    }

    private Node removeMaximo(Node node) {
        if (node == null) {
            System.out.println("ERRO");
        } else if (node.getDireita() != null) {
            node.setDireita(removeMaximo(node.getDireita()));
            return node;
        } else {
            return node.getEsquerda();
        }
        return null;
    }

    public Node encontraMaximo() {
        return encontraMaximo(this.root);
    }

    private static Node encontraMaximo(Node node) {
        if (node != null) {
            while (node.getDireita() != null) {
                node = node.getDireita();
            }
        }
        return node;
    }

    public int getValorRaiz() {
        return this.root.getValor();
    }
}