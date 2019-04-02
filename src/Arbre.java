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

        System.out.println(getValeur());
        if (getSousArbreGauche() != null)
            getSousArbreGauche().parcourPrefixe();
        if(getSousArbreDroit() != null)
            getSousArbreDroit().parcourPrefixe();
    }

    void parcourInfixe(){

        if (getSousArbreGauche() != null)
            getSousArbreGauche().parcourInfixe();
        System.out.println(getValeur());
        if(getSousArbreDroit() != null)
            getSousArbreDroit().parcourInfixe();
    }

    void parcourPostfixe(){

        if (getSousArbreGauche() != null)
            getSousArbreGauche().parcourPostfixe();
        if(getSousArbreDroit() != null)
            getSousArbreDroit().parcourPostfixe();
        System.out.println(getValeur());
    }

    boolean arbresEgaux(Arbre a, Arbre b) {

        if ((a == null) && (b == null))
            return true;
        if ((a == null) && (b != null))
            return false;
        if ((a != null) && (b == null))
            return false;
        if (a.getValeur() != b.getValeur())
            return false;
        return (arbresEgaux(a.getSousArbreGauche(), b.getSousArbreGauche()) && arbresEgaux(a.getSousArbreDroit(), b.getSousArbreDroit()));
    }

    int hauteur(Arbre a) {
        if (a == null)
            return 0;
        else
            return (1 + Math.max(hauteur(a.getSousArbreGauche()), hauteur(a.getSousArbreDroit())));
    }

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