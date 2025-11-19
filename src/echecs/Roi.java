package echecs;

public class Roi extends Piece{
    public Roi(Couleur couleur) {
        super(Type.ROI, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
