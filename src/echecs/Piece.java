package echecs;

import java.awt.geom.Point2D;

public abstract class Piece {
     public enum Type {
         PION,
         FOU,
         CAVALIER,
         TOUR,
         REINE,
         ROI
     }

     private Type type;
     private Couleur couleur;

     public Piece (Type type, Couleur couleur) {
         setType(type);
         setCouleur(couleur);
     }

     public Type getType () { return type; }
     public void setType (Type type) { this.type = type; }
     public Couleur getCouleur () { return couleur; }
     public void setCouleur (Couleur couleur) {
        if (couleur != Couleur.NOIR && couleur != Couleur.BLANC)
            throw new IllegalArgumentException("Couleur non-valide");
        this.couleur = couleur;
     }

     /**
     *méthode permettant de calculer la norme mathématique entre deux Positions
     * @param depart Position de départ
     * @param arrivee Position d'arrivée de la Pièce
     * @return la somme des carrés des distances
     *
     */
     public double norme (Position depart, Position arrivee) {
        return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
     }

     public boolean estSurEchiquier(Position depart, Position arrivee) {
         return depart.getColonne() >= 0 && depart.getColonne() <= 7 &&
                 depart.getLigne() >= 0 && depart.getLigne() <= 7 &&
                 arrivee.getColonne() >= 0 && arrivee.getColonne() <= 7 &&
                 arrivee.getLigne() >= 0 && arrivee.getLigne() <= 7;
     }

    public boolean estValide(Position depart, Position arrivee) {
        if (!estSurEchiquier(depart, arrivee)) {
            return false;
        }
        return estValideSpecifique(depart, arrivee);
    }

    protected abstract boolean estValideSpecifique (Position depart, Position arrivee);


    public boolean cheminPossible(Position depart, Position arrivee, Echiquier echiquier) {
        return false;
    }
}




