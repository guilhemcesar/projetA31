public class Main {

    public static void main(String[] args) {

//        System.out.println("Hello World!");

        Arbre b = new Arbre(2, new Arbre(1), new Arbre(4, new Arbre(3), new Arbre(5)));
        Arbre c = new Arbre(10, new Arbre(8), new Arbre(12));
        Arbre a = new Arbre(6, b, c);

        Arbre test = new Arbre(1);
//        System.out.println(test.gauche);
//        System.out.println(test.getSousArbreGauche());

//        a.parcourPostfixe();
//        a.parcourInfixe();
//        a.parcourPrefixe();

        Arbre d = new Arbre(10, new Arbre(8), new Arbre(12));

//        System.out.println( a.arbresEgaux(a, b));
//        System.out.println( a.arbresEgaux(c, d));

//        System.out.println(a.valeur);

//        System.out.println(a);

//        System.out.println(a.hauteur(a));

//        System.out.println(a.estABR());

//        a.insertion(5);

//        System.out.println(a.recherche(5));

        System.out.println(a.hauteur(a));
        System.out.println(a.hauteur());

    }
}
