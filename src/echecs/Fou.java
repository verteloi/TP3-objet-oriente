package echecs;

public class Fou extends Piece{
    public Fou(Couleur couleur) {
        super(Type.FOU, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        int differenceLigne = Math.abs(arrivee.getLigne() - depart.getLigne());
        int differenceColonne = Math.abs(arrivee.getColonne() - depart.getColonne());

        if (differenceLigne == differenceColonne) {
            return true;
        }
        return false;
    }
}
