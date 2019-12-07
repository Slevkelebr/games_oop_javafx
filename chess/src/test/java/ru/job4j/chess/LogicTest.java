package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenFigureIsWay() {
        Logic logic = new Logic();
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertFalse(result);
    }

    @Test
    public void whenFigureRemained() {
        Logic logic = new Logic();
        boolean result = logic.move(Cell.C1, Cell.C1);
        assertFalse(result);
    }

    @Test
    public void whenFigureIsWay1() {
        Logic logic = new Logic();
        boolean result = logic.move(Cell.C1, Cell.B1);
        assertFalse(result);
    }
}