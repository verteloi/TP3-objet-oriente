package echecs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    Pion pb1;

    @BeforeEach
    void setUp() {
        pb1 = new Pion(Piece.Couleur.NOIR);
    }

    @Test
    void estValide() {
        assertTrue(pb1.estValide(new Position(1, 2), new Position(2, 2)));
    }
}