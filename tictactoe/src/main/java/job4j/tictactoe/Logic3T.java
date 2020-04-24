package job4j.tictactoe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate) {
        boolean result = false;
        int countHor = 0;
        int countVer = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (predicate.test(table[i][j])) {
                    countHor++;
                }
                if (predicate.test(table[j][i])) {
                    countVer++;
                }
                if (i == j && predicate.test(table[i][j])) {
                    countDiagonal1++;
                }
                if (i + j == table.length - 1 && predicate.test(table[i][j])) {
                    countDiagonal2++;
                }
            }
            if (countHor == table.length
                    || countVer == table.length
                    || countDiagonal1 == table.length
                    || countDiagonal2 == table.length) {
                result = true;
                break;
            }
            countHor = 0;
            countVer = 0;
        }
        return result;
    }

    public boolean isWinnerX() {
        return fillBy(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return fillBy(Figure3T::hasMarkO);
    }

    /**
     * Вычисляем, есть ли свободные ячейки.
     *
     * @return Правда или ложь.
     */
    public boolean hasGap() {
        boolean rsl = true;
        int countX = 0;
        int countO = 0;
        for (Figure3T[] figure3TS : table) {
            for (Figure3T figure3T : figure3TS) {
                if (figure3T.hasMarkX()) {
                    countX++;
                }
                if (figure3T.hasMarkO()) {
                    countO++;
                }
            }
        }
        if (countX > 4 || countO > 4) {
            rsl = false;
        }
        return rsl;
    }
}
