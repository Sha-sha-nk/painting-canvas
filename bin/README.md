# painting-canvas
Painting Canvas

cd into painting-canvas dir

Compilation:
- javac -d "classes" canvas\exception\\*.java
- javac -d "classes" canvas\Canvas.java
- javac -d "classes" -classpath "classes" canvas\CanvasApplication.java

Excecution : 
run : java -classpath "classes" canvas.CanvasApplication

Dry Run:
```
enter command: TT
Exception message: Only Valid Commands [B,C,L,R,Q] are allowed
enter command: T
Exception message: Only Valid Commands [B,C,L,R,Q] are allowed
enter command: C e 4
Exception message: width should be integer.
enter command: C 20 e
Exception message: height should be integer.
enter command: C -1 0
Exception message: Both width and height should be positive integer
enter command: C 20 4
Creating Canvas
 --------------------
|                    |
|                    |
|                    |
|                    |
 --------------------
enter command: L e 1 1 1
Exception message: First Point's x coordinate should be integer.
enter command: L 1 e 1 1
Exception message: First Point's y coordinate should be integer.
enter command: L 1 1 e 1
Exception message: Second Point's x coordinate should be integer.
enter command: L 1 1 1 e
Exception message: Second Point's y coordinate should be integer.
enter command: L 1 1 202 202
Drawing Line
Exception message: Given line crosses out of canvas.
enter command: L 1 1 2 2
Drawing Line
Exception message: Only vertical and horizontal lines are allowed.
enter command: L 1 2 6 2
Drawing Line
 --------------------
|                    |
|xxxxx               |
|                    |
|                    |
 --------------------
enter command: L 6 3 6 4
Drawing Line
 --------------------
|                    |
|xxxxx               |
|    x               |
|    x               |
 --------------------
enter command: R e 1 1 1
Exception message: First Point's x coordinate should be integer.
enter command: R 1 e 1 1
Exception message: First Point's y coordinate should be integer.
enter command: R 1 1 e 1
Exception message: Second Point's x coordinate should be integer.
enter command: R 1 1 1 e
Exception message: Second Point's y coordinate should be integer.
enter command: R 1 1 202 202
Drawing Rectangle
Exception message: Given rectangle crosses out of canvas.
enter command: R 2 2 1 1
Drawing Rectangle
Exception message: Point (1,1) don't lie on lower right corner relative to Point (2,2).
enter command: R 14 1 18 3
Drawing Rectangle
 --------------------
|             xxxxx  |
|xxxxx        x   x  |
|    x        xxxxx  |
|    x               |
 --------------------
enter command: B e 3 o
Exception message: Point's x coordinate should be integer.
enter command: B 10 e o
Exception message: Point's y coordinate should be integer.
enter command: B 10 3 o
Painting Canvas
 --------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
 --------------------
enter command: B 1 4 e
Painting Canvas
 --------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|eeeeexoooooooxxxxxoo|
|eeeeexoooooooooooooo|
 --------------------
enter command: B 6 4 w
Painting Canvas
 --------------------
|oooooooooooooxxxxxoo|
|wwwwwwooooooox   xoo|
|eeeeewoooooooxxxxxoo|
|eeeeewoooooooooooooo|
 --------------------
enter command: Q
Program Ends
