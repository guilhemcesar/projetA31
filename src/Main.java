public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Arbre b = new Arbre(2, new Arbre(1), new Arbre(4, new Arbre(3), new Arbre(5)));
        Arbre c = new Arbre(10, new Arbre(8), new Arbre(12));
        Arbre a = new Arbre(6, b, c);

    }
}
