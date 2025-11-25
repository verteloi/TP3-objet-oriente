package echecs;

public class Cavalier extends Piece{
    public Cavalier(Couleur couleur) {
        super(Type.CAVALIER, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (differenceLigne == 2 && differenceColonne == 1) {
            return true;
        } else if (differenceColonne == 2 && differenceLigne == 1) {
            return true;
        }

        return false;
    }
}
