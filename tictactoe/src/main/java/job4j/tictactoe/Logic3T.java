package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Метод fillBy проверяет последовательность Х и О.
     * @param predicate определяет поведение, проверям если на текущей позиции нужный элемент в последовательности.
     * @param startX координата начальной точки.
     * @param startY координата начальной точки.
     * @param deltaX определяет движение проверки по строке.
     * @param deltaY определяет движение првоерки по столбцу.
     * @return вернет true если в заданной последоваетльности есть элементы иначе false.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Метод isWinnerХ проверяет если выигрышная комбинация у Х(крестиков) по всем возможным направлениям.
     * @return вернет true если выигрышная комбинация есть иначе false.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) || // левая вертикаль
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) || // центральная вертикаль
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) || // правая вертикаль
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) || // верхняя горизонталь
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) || // центральная горизонталь
                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) || // нижняя вертикаль
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) || // диагональ сверху вниз
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1); // диагональ снизу вверх
    }

    /**
     * Метод isWinnerO проверяет если выигрышная комбинация у О(ноликов) по всем возможным направлениям.
     * @return вернет true если выигрышная комбинация есть иначе false.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) || // левая вертикаль
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) || // центральная вертикаль
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) || // правая вертикаль
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) || // верхняя горизонталь
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) || // центральная горизонталь
                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) || // нижняя вертикаль
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) || // диагональ сверху вниз
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1); // диагональ снизу вверх
    }

    /**
     * Метод hasGap проверяет есть ли на игровом поле пустые клетки.
     * @return false если пустых клеток нет иначе true.
     */
    public boolean hasGap() {
/*        boolean result = false;
        boolean X = Arrays.stream(table).flatMap(Arrays::stream).allMatch(Figure3T::hasMarkX);
        boolean O = Arrays.stream(table).flatMap(Arrays::stream).allMatch(Figure3T::hasMarkO);
        if (!X && !O) {
            result = true;
        }*/

        boolean result = false;
        for (int row = 0; row < this.table.length; row++) {
            for (int cell = 0; cell < this.table.length; cell++) {
                if (!this.table[row][cell].hasMarkX() && !this.table[row][cell].hasMarkO()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
