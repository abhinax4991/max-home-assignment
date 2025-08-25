package org.example;

import java.util.*;

enum Instruction {
    L, R, M;

    static Instruction fromChar(char instruction) {
        switch (instruction) {
            case 'M':
                return M;
            case 'L':
                return L;
            case 'R':
                return R;
            default:
                throw new IllegalArgumentException("Unknown instruction: " + instruction);
        }
    }
}

enum Direction {
    N(0, 1), //NORTH
    S(0, -1), //SOUTH
    E(1, 0), //EAST
    W(-1, 0); //WEST

    final int dx;
    final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    Direction turnRight() {
        if (this == N) return E;
        else if (this == S) return W;
        else if (this == E) return S;
        else if (this == W) return N;
        return this;
    }

    Direction turnLeft() {
        if (this == N) return W;
        else if (this == S) return E;
        else if (this == E) return N;
        else if (this == W) return S;
        return this;
    }
}

class Plateau {
    private final int xMax;
    private final int yMax;

    Plateau(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean isInside(int xCurr, int yCurr) {
        return ((xCurr >= 0 && xCurr <= xMax) && (yCurr >= 0 && yCurr <= yMax));
    }
}

class Robot {
    private int x;
    private int y;

    private Direction direction;

    Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    void execute(Instruction instruction, Plateau plateau) {
        switch (instruction) {
            case L:
                direction = direction.turnLeft();
                break;
            case R:
                direction = direction.turnRight();
                break;
            case M:
                int xCurr = x + direction.dx;
                int yCurr = y + direction.dy;
                if (plateau.isInside(xCurr, yCurr)) {
                    x = xCurr;
                    y = yCurr;
                }
                break;
            default:
                throw new IllegalArgumentException("Unhandled instruction: " + instruction);
        }
    }

    String getCurrentPosition() {
        return x + " " + y + " " + direction.toString();
    }

}

public class Europa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xMax = sc.nextInt();
        int yMax = sc.nextInt();
        Plateau plateau = new Plateau(xMax, yMax);
        while (sc.hasNext()) {
            int xCurr = sc.nextInt();
            int yCurr = sc.nextInt();
            Direction direction = parseDirection(sc.next()); // "N", "E", "S", "W"
            String instructions = sc.next();
            Robot robot = new Robot(xCurr, yCurr, direction);
            for (char instruction : instructions.toCharArray()) {
                robot.execute(Instruction.fromChar(instruction), plateau);
            }
            System.out.println(robot.getCurrentPosition());
        }
        sc.close();
    }

    private static Direction parseDirection(String direction) {
        switch (direction.toUpperCase()) {
            case "N":
                return Direction.N;
            case "S":
                return Direction.S;
            case "E":
                return Direction.E;
            case "W":
                return Direction.W;
            default:
                throw new IllegalArgumentException("Unknown direction: " + direction);
        }
    }
}