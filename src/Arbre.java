class Arbre {

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


}
