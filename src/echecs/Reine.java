package echecs;

public class Reine extends Piece{
    public Reine(Couleur couleur) {
        super(Type.REINE, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (positionValide(arrivee)) {
            if (differenceLigne >= 1 && differenceColonne >= 1) {
                if (differenceLigne == differenceColonne) {
                    return true;
                }
            } else if (differenceLigne >= 1 && differenceColonne == 0) {
                return true;
            } else if (differenceColonne >= 1 && differenceLigne == 0) {
                return true;
            }
        }
        return false;
    }
}
