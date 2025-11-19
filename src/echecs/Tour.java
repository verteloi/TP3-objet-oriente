package echecs;

public class Tour extends Piece {
    public Tour(Piece.Couleur couleur) {
        super(Piece.Type.TOUR, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return false;
    }
}
