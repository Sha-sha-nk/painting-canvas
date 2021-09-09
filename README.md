# painting-canvas
Painting Canvas

cd into painting-canvas dir

Compilation:
- javac -d "classes" canvas\exception\InvalidCanvasDimensions.java
- javac -d "classes" canvas\exception\OutOfCanvasException.java
- javac -d "classes" canvas\exception\NoCanvasException.java
- javac -d "classes" canvas\exception\InvalidAlignment.java
- javac -d "classes" canvas\Canvas.java
- javac -d "classes" -classpath "classes" canvas\CanvasApplication.java

Excecution : 
run : java -classpath "classes" canvas.CanvasApplication

Dry Run:
```
enter command: T
Invalid command!
enter command: B 1 2 r
Exception message: Please create canvas first
enter command: C 20 4
Creating Canvas
 --------------------
|                    |
|                    |
|                    |
|                    |
 --------------------
enter command: L 200 200 1 1
Drawing Line
Exception message: Given line crosses out of canvas.
enter command: L 1 1 2 2
Drawing Line
Exception message: Only vertical and horizontal lines are allowed.
enter command: L 1 2 6 2
Drawing Line
 --------------------
|                    |
|xxxxxx              |
|                    |
|                    |
 --------------------
enter command: L 6 3 6 4
Drawing Line
 --------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
 --------------------
enter command: R 200 200 1 1
Drawing Rectangle
Exception message: Given rectangle crosses out of canvas.
enter command: R 3 3 1 1
Drawing Rectangle
Exception message: Point (1,1) don't lie on lower right corner relative to Point (3,3).
enter command: R 14 1 18 3
Drawing Rectangle
 --------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
 --------------------
enter command: B 200 3 f
Painting Canvas
Exception message: Cannot paint, point lie outside canvas.
enter command: B 10 3 o
Painting Canvas
 --------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
 --------------------
enter command: Q
Program Ends
```
