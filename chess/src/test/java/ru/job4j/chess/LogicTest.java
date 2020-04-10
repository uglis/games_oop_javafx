package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {
    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenMoveIsTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        boolean rsl = logic.move(Cell.A5, Cell.D2);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenMoveIsFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E1));
        logic.add(new BishopBlack(Cell.D2));
        boolean rsl = logic.move(Cell.E1, Cell.C3);
        assertThat(rsl, is(false));
    }
}