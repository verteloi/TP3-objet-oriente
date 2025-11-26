package echecs;

public class Reine extends Piece{
    public Reine(Couleur couleur) {
        super(Type.REINE, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (differenceLigne >= 1 && differenceColonne >= 1) {
            if (differenceLigne == differenceColonne) {
                    return true;
                }
            } else if (differenceLigne >= 1 && differenceColonne == 0) {
                return true;
            } else if (differenceColonne >= 1 && differenceLigne == 0) {
                return true;
            }
        return false;
    }

    // etapes:
    // check si le deplacement est valide selon la piece --> si oui
    //      si deplacement invalide -> false
    //  check si il y a deja une piece sur l'arrive
    //      si c'est une case de meme couleur -> invalide
    //      si c'est une case differente couleur -> valide


}
