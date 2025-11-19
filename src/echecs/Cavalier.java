package echecs;

public class Cavalier extends Piece{
    public Cavalier(Couleur couleur) {
        super(Type.CAVALIER, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
