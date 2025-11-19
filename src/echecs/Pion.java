package echecs;

public class Pion extends Piece{
    public Pion(Couleur couleur) {
        super(Type.PION, couleur); // couleur
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (positionValide(arrivee)) {
            if (getCouleur() == Couleur.BLANC) {
                if (depart.getLigne() == 6) {
                    if ((arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getLigne() == depart.getLigne() - 2) && arrivee.getColonne() == depart.getColonne()) {
                        return true;
                    }
                } else if (arrivee.getLigne() == depart.getLigne() - 1 && arrivee.getColonne() == depart.getColonne()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (depart.getLigne() == 1) {
                    if ((arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() + 2) && arrivee.getColonne() == depart.getColonne()) {
                        return true;
                    }
                } else if (arrivee.getLigne() == depart.getLigne() + 1 && arrivee.getColonne() == depart.getColonne()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
