package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.y - dest.y);
        Cell[] steps = new Cell[size];
        int deltaX = source.x - dest.x > 0 ? -1 : 1;
        int deltaY = source.y - dest.y > 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            int x = deltaX == -1 ? (source.x - index) + deltaX : (source.x + index) + deltaX;
            int y = deltaY == -1 ? (source.y - index) + deltaY : (source.y + index) + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    /**
     * Проверяем вдижется ли фигура по диагонили.
     *
     * @param source старт.
     * @param dest   финиш.
     * @return истина или ложь.
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean diagonal = false;
        if (source.x + source.y == dest.x + dest.y || source.x - dest.x == source.y - dest.y) {
            diagonal = true;
        }
        return diagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
