public class Arbre {

    int valeur;
    Arbre gauche;
    Arbre droite;

    Arbre(int i){
        valeur  = i;
    }

    Arbre(int i, Arbre g, Arbre d){
        valeur = i;
        gauche = g;
        droite = d;
    }

    int getValeur(){
        return valeur;
    }

    Arbre getSousArbreDroit(){
        return droite;
    }

    Arbre getSousArbreGauche(){
        return gauche;
    }

    void parcourPrefixe(){

        System.out.println(getValeur());             //Affichage valeurs
        if (getSousArbreGauche() != null)            //Controle branche existe
            getSousArbreGauche().parcourPrefixe();   //Appel recursivité
        if(getSousArbreDroit() != null)              //Controle branche existe
            getSousArbreDroit().parcourPrefixe();    //Appel recursivité
    }

    void parcourInfixe(){

        if (getSousArbreGauche() != null)             //Controle branche existe
            getSousArbreGauche().parcourInfixe();     //Appel recursivité
        System.out.println(getValeur());              //Affichage valeurs
        if(getSousArbreDroit() != null)               //Controle branche existe
            getSousArbreDroit().parcourInfixe();      //Appel recursivité
    }

    void parcourPostfixe(){

        if (getSousArbreGauche() != null)               //Controle branche existe
            getSousArbreGauche().parcourPostfixe();     //Appel recursivité
        if(getSousArbreDroit() != null)                 //Controle branche existe
            getSousArbreDroit().parcourPostfixe();      //Appel recursivité
        System.out.println(getValeur());                //Affichage valeurs
    }

    boolean arbresEgaux(Arbre a, Arbre b) {

        if ((a == null) && (b == null))                 //Controle branche existe
            return true;                                // return true car les 2 branches existent
        if ((a == null) && (b != null))                 //Controle branche existe
            return false;                               // return false car different
        if ((a != null) && (b == null))                 //Controle branche existe
            return false;                               // return false car different
        if (a.getValeur() != b.getValeur())             //Controle valeurs
            return false;                               // return false car different
        return (arbresEgaux(a.getSousArbreGauche(), b.getSousArbreGauche()) && arbresEgaux(a.getSousArbreDroit(), b.getSousArbreDroit()));
    }                                                   //Appel recursif pour traiter chacune des sous branches

    int hauteur(Arbre a) {
        if (a == null)
            return 0;                                   //Si l'arbre n'existe pas il a une hauteur de 0
        else
            return (1 + Math.max(hauteur(a.getSousArbreGauche()), hauteur(a.getSousArbreDroit())));
    }                                                   //parcour par recursivité de toutes les sous branches, le chemin le
                                                        //plus long est retenue grace à l'instruction max

    boolean estABR(Arbre a) {
        if (a == null)
            return true;
        if ((a.getSousArbreGauche() != null) && (a.getSousArbreGauche().getValeur() > a.getValeur()))
            return false;
        if ((a.getSousArbreDroit() != null) && (a.getValeur() > a.getSousArbreDroit().getValeur()))
            return false;
        return (estABR(a.getSousArbreGauche()) && estABR(a.getSousArbreDroit()));
    }

    void insertion(int value) {
        if (value == getValeur())
            return;  // la valeur est deja dans l'arbre
        if (value < getValeur()) {
            if (getSousArbreGauche() != null)
                getSousArbreGauche().insertion(value);
            else
                gauche = new Arbre(value);
        }
        if (value > getValeur()) {
            if (getSousArbreDroit() != null)
                getSousArbreDroit().insertion(value);
            else
                droite = new Arbre(value);
        }
    }

    boolean recherche(int value) {
        if (value == getValeur())
            return true;
        if ((value < getValeur()) && (getSousArbreGauche() != null))
            return (getSousArbreGauche().recherche(value));
        if ((value > getValeur()) && (getSousArbreDroit() != null))
            return (getSousArbreDroit().recherche(value));
        return false;
    }
}