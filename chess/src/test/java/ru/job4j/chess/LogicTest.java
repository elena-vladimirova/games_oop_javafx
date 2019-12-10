package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveThenMoved() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        assertThat(true, is(logic.move(Cell.C1, Cell.E3)));
    }

    @Test
    public void whenMoveThenErr() {
        Figure bishopBlackFirst = new BishopBlack(Cell.C1);
        Figure bishopBlackSecond = new BishopBlack(Cell.D2);
        Logic logic = new Logic();
        logic.add(bishopBlackFirst);
        logic.add(bishopBlackSecond);
        assertThat(false, is(logic.move(Cell.C1, Cell.E3)));
    }
}
