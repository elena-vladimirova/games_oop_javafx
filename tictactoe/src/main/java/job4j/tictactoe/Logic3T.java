package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean checkLine(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
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

    public boolean checkTable(Predicate<Figure3T> predicate) {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (this.checkLine(predicate, i, 0, 0, 1)||
                this.checkLine(predicate, 0, i, 1, 0)){
                result = true;
                break;
            }
        }
        return  result||
                this.checkLine(predicate, 0, 0, 1, 1)||
                this.checkLine(predicate, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerX() {
        return checkTable(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return checkTable(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int x = 0; x < this.table.length; x++) {
            for (int y = 0; y < this.table.length; y++) {
                if (!this.table[x][y].hasMarkX() && !this.table[x][y].hasMarkO()){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
