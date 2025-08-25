Europa — Robot Navigation (Take-Home)

A small navigation module for NASA’s Europa mission. The surface is a rectangular grid; each robot starts at (x, y, heading) and executes a string of commands:

L → turn left 90°

R → turn right 90°

M → move forward one grid cell (if the move stays on the plateau)

Robots execute sequentially; print each robot’s final position as x y D.


**How to build & run**
* Prerequisites:
  * maven
  * Java 8+ (java -version)



**Build**
* mvn -q clean package


**Run**
* java -jar target/com.github.abhinax4991-1.0-SNAPSHOT.jar


**Design overview**
* Direction (enum) — N,E,S,W each with (dx,dy) and turnLeft()/turnRight().
* Instruction (enum) — parses L/R/M to typed commands.
* Plateau — upper-right bounds, isInside(x,y).
* Robot — state (x,y,dir) and execute(Instruction, Plateau).
* Main — parses stdin, runs each robot sequentially, prints final states exactly as x y D.


**Assumptions & validation**
* Start positions must be within the plateau; headings must be one of N,E,S,W.
* Instruction strings may contain only L,R,M.
* Boundary policy: a move that would leave the plateau is ignored (robot stays put).