package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenPositionIsTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell cell = Cell.findBy(3, 3);
        assertThat(cell, is(bishopBlack.position()));
    }

    @Test
    public void whenCopyBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        Cell result = bishopBlack.copy(Cell.B3).position();
        Cell expected = Cell.findBy(1, 2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps =  bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(steps, is(expected));
    }

    @Test
    public void whenIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        boolean result = bishopBlack.isDiagonal(Cell.A8, Cell.C6);
        assertThat(result, is(true));
    }

    @Test
    public void whenISDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        boolean result = bishopBlack.isDiagonal(Cell.A8, Cell.A7);
        assertThat(result, is(false));
    }

    @Test
    public void whenG1toA7Way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        Cell[] steps =  bishopBlack.way(Cell.G1, Cell.A7);
        Cell[] expected = {Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertThat(steps, is(expected));
    }
}
