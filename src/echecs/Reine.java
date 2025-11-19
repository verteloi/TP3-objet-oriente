package echecs;

public class Reine extends Piece{
    public Reine(Couleur couleur) {
        super(Type.REINE, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
