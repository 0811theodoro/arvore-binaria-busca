package tad;

public class Main {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();

        //            (30)
        tree.inserir(30);

        //            (30)
        //         (22)
        tree.inserir(22);

        //            (30)
        //         (22)
        //       (8)
        tree.inserir(8);

        //            (30)
        //         (22)
        //       (8)  (29)
        tree.inserir(29);

        //            (30)
        //         (22)  (62)
        //       (8) (29)
        tree.inserir(62);

        //              (30)
        //         (22)       (62)
        //       (8) (29)   (42)
        tree.inserir(42);

        //              (30)
        //         (22)       (62)
        //       (8) (29)   (42)
        //                 (31)
        tree.inserir(31);

        System.out.println("Máximo: " + tree.encontraMaximo().getValor()); // 62

        //              (30)
        //         (22)       (42)
        //       (8) (29)   (31)
        tree.remover(62);

        System.out.println("Máximo: " + tree.encontraMaximo().getValor()); // 42

        //              (29)
        //         (22)       (42)
        //       (8)        (31)
        tree.remover(30);

        System.out.println("Raiz:" + tree.getValorRaiz());
    }
}
