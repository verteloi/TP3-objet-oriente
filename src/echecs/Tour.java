package echecs;

public class Tour extends Piece {
    public Tour(Piece.Couleur couleur) {
        super(Piece.Type.TOUR, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (positionValide(arrivee)) {
            if (differenceLigne >= 1 && differenceColonne == 0) {
                return true;
            } else if (differenceColonne >= 1 && differenceLigne == 0) {
                return true;
            }
        }
        return false;
    }
}
