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

    @Override
    public boolean cheminPossible(Position depart, Position arrivee, Echiquier echiquier) {
        if (depart.equals(arrivee)) return true;

        if (depart.getColonne() == arrivee.getColonne()) {
            int step = getDifferenceLigneAbs(depart, arrivee);
            int x = depart.getLigne() + step;

            while (x != arrivee.getLigne()) {
                if (echiquier.getCase(x, depart.getColonne()).getPiece() != null) {
                    return false;
                }
                x += step;
            }
            return true;
        }
        return false;
    }
}
