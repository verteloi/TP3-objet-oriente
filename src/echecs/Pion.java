package echecs;

public class Pion extends Piece{
    public Pion(Couleur couleur) {
        super(Type.PION, couleur); //
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());
        if (getCouleur() == Couleur.NOIR) {
            if (arrivee.getLigne() > depart.getLigne()) {
                if (depart.getLigne() == 1) {
                    if (differenceLigne <= 2 && differenceColonne == 0) {
                        return true;
                    }
                }
                else if (differenceLigne == 1 && differenceColonne == 0) {
                    return true;
                }
            }
        } else {
            if (arrivee.getLigne() < depart.getLigne()) {
                if (depart.getLigne() == 6) {
                    if (differenceLigne <= 2 && differenceColonne == 0) {
                        return true;
                    }
                }
                else if (differenceLigne == 1 && differenceColonne == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
