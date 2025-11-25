package echecs;

public class Roi extends Piece{
    public Roi(Couleur couleur) {
        super(Type.ROI, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (positionValide(arrivee)) {
            if (differenceLigne <= 1 && differenceColonne <= 1) {
                return true;
            }
        }
        return false;
    }
}
