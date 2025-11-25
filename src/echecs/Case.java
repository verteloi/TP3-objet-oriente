package echecs;

public class Case {
    private Piece piece;

    public Case (Piece piece) {
        this.piece = piece;
    }

    public Case() {

    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean caseOccupe() {
        return !(piece == null);
    }

    public boolean caseOccupe(Couleur couleur) {
        if(caseOccupe()) {
            return couleur == piece.getCouleur();
        }
        return false;
    }
}
