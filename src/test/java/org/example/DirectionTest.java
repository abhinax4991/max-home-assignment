package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {
    @Test
    public void turnRightCyclesClockwise() {
        assertEquals(Direction.E, Direction.N.turnRight());
        assertEquals(Direction.S, Direction.E.turnRight());
        assertEquals(Direction.W, Direction.S.turnRight());
        assertEquals(Direction.N, Direction.W.turnRight());
    }
    @Test public void turnLeftCyclesCounterClockwise() {
        assertEquals(Direction.W, Direction.N.turnLeft());
        assertEquals(Direction.S, Direction.W.turnLeft());
        assertEquals(Direction.E, Direction.S.turnLeft());
        assertEquals(Direction.N, Direction.E.turnLeft());
    }
}
