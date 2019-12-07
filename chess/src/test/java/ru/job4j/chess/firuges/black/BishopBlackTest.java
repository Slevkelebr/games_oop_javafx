package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionThisPosition() {
        Cell position = Cell.A1;
        BishopBlack resultBishopPosition = new BishopBlack(position);
        Cell expectedBishopPosition = resultBishopPosition.position();
        assertSame(expectedBishopPosition, position);
    }

    @Test
    public void copyTest() {
        Cell position = Cell.A1;
        Cell positionDest = Cell.A7;
        BishopBlack resultBishopPosition = new BishopBlack(position);
        Figure newFigure = resultBishopPosition.copy(positionDest);
        Cell expectedPosition = newFigure.position();
        assertSame(expectedPosition, positionDest);
    }

    @Test
    public void wayTest() {
        BishopBlack BishopBlack = new BishopBlack(Cell.C1);
        Cell[] delta = BishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expectedDelta = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expectedDelta, delta);
    }
}