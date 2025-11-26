package echecs;

public class Echiquier {
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
            location[2][i].setPiece(new Pion(Couleur.NOIR));
        }

        for (int i = 0; i <= 7; i++) {
            location[6][i].setPiece(new Pion(Couleur.BLANC));
        }
    }

    public Case getCase(int rangee,int colonne) {
        return location[rangee][colonne];
    }
}
