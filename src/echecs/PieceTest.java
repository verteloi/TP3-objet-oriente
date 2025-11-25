package echecs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    Pion p1;
    Tour t1;
    Fou f1;
    Cavalier c1;
    Roi r1;
    Reine q1;

    @BeforeEach
    void setUp() {
        p1 = new Pion(Piece.Couleur.NOIR);
        t1 = new Tour(Piece.Couleur.NOIR);
        f1 = new Fou(Piece.Couleur.BLANC);
        c1 = new Cavalier(Piece.Couleur.BLANC);
        r1 = new Roi(Piece.Couleur.NOIR);
        q1 = new Reine(Piece.Couleur.BLANC);
    }

    @Test
    void testPionTrue() {
        assertTrue(p1.estValide(new Position(3, 3), new Position(4, 3)));
    }

    @Test
    void testPionFalse() {
        assertFalse(p1.estValide(new Position(3, 3), new Position(6, 3)));
    }

    @Test
    void testTourTrue() {
        assertTrue(t1.estValide(new Position(1, 1), new Position(1, 5)));
    }

    @Test
    void testTourFalse() {
        assertFalse(t1.estValide(new Position(1, 1), new Position(3, 3)));
    }

    @Test
    void testFouTrue() {
        assertTrue(f1.estValide(new Position(5, 2), new Position(2, 5)));
    }

    @Test
    void testFouFalse() {
        assertFalse(f1.estValide(new Position(5, 2), new Position(5, 6)));
    }

    @Test
    void testCavalierTrue() {
        assertTrue(c1.estValide(new Position(3, 3), new Position(5, 4)));
    }

    @Test
    void testCavalierFalse() {
        assertFalse(c1.estValide(new Position(3, 3), new Position(4, 4)));
    }

    @Test
    void testRoiTrue() {
        assertTrue(r1.estValide(new Position(6, 6), new Position(5, 7)));
    }

    @Test
    void testRoiFalse() {
        assertFalse(r1.estValide(new Position(6, 6), new Position(6, 8)));
    }

    @Test
    void testReineTrue() {
        assertTrue(q1.estValide(new Position(4, 4), new Position(7, 7)));
    }

    @Test
    void testReineFalse() {
        assertFalse(q1.estValide(new Position(4, 4), new Position(5, 7)));
    }
}