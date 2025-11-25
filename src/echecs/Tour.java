package echecs;

public class Tour extends Piece {
    public Tour(Couleur couleur) {
        super(Piece.Type.TOUR, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (differenceLigne >= 1 && differenceColonne == 0) {
            return true;
        } else if (differenceColonne >= 1 && differenceLigne == 0) {
            return true;
        }
        return false;
    }
}
