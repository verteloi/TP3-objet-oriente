package echecs;

public class Fou extends Piece{
    public Fou(Couleur couleur) {
        super(Type.FOU, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
