package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {
    @Test
    public void executesSampleSequence1() {
        Plateau p = new Plateau(5, 5);
        Robot r = new Robot(1, 2, Direction.N);
        for (char c : "LMLMLMLMM".toCharArray()) {
            r.execute(Instruction.fromChar(c), p);
        }
        assertEquals("1 3 N", r.getCurrentPosition()); // expected from spec
    }
    @Test public void executesSampleSequence2() {
        Plateau p = new Plateau(5, 5);
        Robot r = new Robot(3, 3, Direction.E);
        for (char c : "MMRMMRMRRM".toCharArray()) {
            r.execute(Instruction.fromChar(c), p);
        }
        assertEquals("5 1 E", r.getCurrentPosition()); // expected from spec
    }
}
