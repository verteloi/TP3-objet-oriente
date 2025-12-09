package echecs;

public class Echiquier implements MethodesEchiquier {
    private Case[][] location;

    public Echiquier() {
        location = new Case[8][8];
        for(int i = 0; i <= 7; i++) {
            for(int j = 0; j <= 7; j++) {
                location[i][j] = new Case();
            }
        }
    }

    public void debuter() {
        location[0][0].setPiece(new Tour(Couleur.NOIR));
        location[0][1].setPiece(new Cavalier(Couleur.NOIR));
        location[0][2].setPiece(new Fou(Couleur.NOIR));
        location[0][3].setPiece(new Reine(Couleur.NOIR));
        location[0][4].setPiece(new Roi(Couleur.NOIR));
        location[0][5].setPiece(new Fou(Couleur.NOIR));
        location[0][6].setPiece(new Cavalier(Couleur.NOIR));
        location[0][7].setPiece(new Tour(Couleur.NOIR));

        location[7][0].setPiece(new Tour(Couleur.BLANC));
        location[7][1].setPiece(new Cavalier(Couleur.BLANC));
        location[7][2].setPiece(new Fou(Couleur.BLANC));
        location[7][3].setPiece(new Reine(Couleur.BLANC));
        location[7][4].setPiece(new Roi(Couleur.BLANC));
        location[7][5].setPiece(new Fou(Couleur.BLANC));
        location[7][6].setPiece(new Cavalier(Couleur.BLANC));
        location[7][7].setPiece(new Tour(Couleur.BLANC));

        for (int i = 0; i <= 7; i++) {
            location[1][i].setPiece(new Pion(Couleur.NOIR));
        }

        for (int i = 0; i <= 7; i++) {
            location[6][i].setPiece(new Pion(Couleur.BLANC));
        }
    }

    public Case getCase(int rangee,int colonne) {
        return location[rangee][colonne];
    }

    public Piece getPiece(Position positionActuelle) {
        int ligne = positionActuelle.getLigne();
        int colonne = positionActuelle.getColonne();
        return location[ligne][colonne].getPiece();
    }

    public boolean cheminPossible(Position depart, Position arrivee) {
        Piece pieceDepart = location[depart.getLigne()][depart.getColonne()].getPiece();
        Piece pieceArrivee = location[arrivee.getLigne()][arrivee.getColonne()].getPiece();
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();

        int pasLigne;
        if (diffLigne == 0) {
            pasLigne = 0;
        } else if (diffLigne > 0) {
            pasLigne = 1;
        } else {
            pasLigne = -1;
        }

        int pasColonne;
        if (diffColonne == 0) {
            pasColonne = 0;
        } else if (diffColonne > 0) {
            pasColonne = 1;
        } else {
            pasColonne = -1;
        }

        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()) {
            return true;
        }

        if (!pieceDepart.estValide(depart, arrivee)) {
            return false;
        }

        if (pieceArrivee != null) {
            if (pieceDepart.getCouleur() == pieceArrivee.getCouleur()) {
                return false;
            }
        }

        switch(pieceDepart.getType()) {
            case ROI:
                return true;
            case CAVALIER:
                return true;
            case TOUR:
                int nbPasTour = diffLigne + diffColonne;
                for (int i = 1; i < nbPasTour; i++) {
                    int posCouranteLigne = depart.getLigne() + (i * pasLigne);
                    int posCouranteColonne = depart.getColonne() + (i * pasColonne);

                    Position positionCourante = new Position(posCouranteLigne, posCouranteColonne);

                    if (getPiece(positionCourante) != null) {
                        return false;
                    }
                }
                return true;

            case FOU:
                int nbPasFou = diffLigne;

                for (int i = 1; i < nbPasFou; i++) {
                    int posCouranteLigne = depart.getLigne() + (i * pasLigne);
                    int posCouranteColonne = depart.getColonne() + (i * pasColonne);

                    Position positionCourante = new Position(posCouranteLigne, posCouranteColonne);

                    if (getPiece(positionCourante) != null) {
                        return false;
                    }
                }
                return true;

            case REINE:
                int nbPasReine;
                if (Math.abs(diffLigne) > Math.abs(diffColonne)) {
                    nbPasReine = Math.abs(diffLigne);
                } else {
                    nbPasReine = Math.abs(diffColonne);
                }

                for (int i = 1; i < nbPasReine; i++) {
                    int posCouranteLigne = depart.getLigne() + (i * pasLigne);
                    int posCouranteColonne = depart.getColonne() + (i * pasColonne);

                    Position positionCourante = new Position(posCouranteLigne, posCouranteColonne);

                    if (getPiece(positionCourante) != null) {
                        return false;
                    }
                }
                return true;

            case PION:
                if (pieceDepart.getCouleur() == Couleur.NOIR) {
                    if (diffLigne < 0) {
                        return false;
                    }
                }
                else if (pieceDepart.getCouleur() == Couleur.BLANC) {
                    if (diffLigne > 0) {
                        return false;
                    }
                }

                if (diffColonne != 0) {
                    return captureParUnPionPossible(depart, arrivee);
                } else {
                    if (pieceArrivee != null) {
                        return false;
                    }

                    if (diffLigne == 2) {
                        int unPasDirection = depart.getLigne() + pasLigne;
                        Position positionMilieu = new Position(unPasDirection, depart.getColonne());

                        if (getPiece(positionMilieu) != null) {
                            return false;
                        }
                    }
                    return true;
                }
        }
        return false;
    }

    public boolean captureParUnPionPossible(Position depart, Position arrivee) {
        Piece pieceDepart = getPiece(depart);
        Piece pieceArrivee = getPiece(arrivee);
        int diffLigne = arrivee.getLigne() - depart.getLigne();

        if (pieceArrivee == null) {
            return false;
        }

        if (pieceDepart.getCouleur() == Couleur.NOIR && diffLigne < 0) {
            return false;
        }

        if (pieceDepart.getCouleur() == Couleur.BLANC && diffLigne > 0) {
            return false;
        }

        if (pieceDepart.getCouleur() != pieceArrivee.getCouleur()) {
            return true;
        }
        return false;
    }


    public String toString() {
        String temp = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(getCase(i,j).getPiece() != null) {
                    temp += "[" + getCase(i,j).getPiece().toString() + "]";
                } else {
                    temp += "[    ]";
                }
            }
            temp += "\n";
        }
        return temp;
    }
}