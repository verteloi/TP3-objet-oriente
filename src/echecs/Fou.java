package echecs;

public class Fou extends Piece{
    public Fou(Couleur couleur) {
        super(Type.FOU, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (positionValide(arrivee)) {
            if (differenceLigne == differenceColonne) {
                return true;
            }
        }
        return false;
    }
}
