package canvas;

import canvas.exception.InvalidAlignment;
import canvas.exception.OutOfCanvasException;

class Canvas {
	private int width, height;
	private char[][] canvas;

	Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		this.canvas = new char[height][width];
		printCanvas();
	}

	public char[][] getCanvas() {
		return canvas;
	}

	private boolean isLineHorizontal(int y1, int y2) {
		return y1 == y2;
	}

	private boolean isLineVertical(int x1, int x2) {
		return x1 == x2;
	}
    
	// prints canvas current state
	private void printCanvas() {
		System.out.print(" ");
		for (int i = 0; i < width; i++)
			System.out.print("-");
		System.out.print("\n");

		for (int i = 0; i < height; i++) {
			System.out.print("|");
			for (int j = 0; j < width; j++) {
				System.out.print(canvas[i][j]);
			}
			System.out.print("|\n");
		}

		System.out.print(" ");
		for (int i = 0; i < width; i++)
			System.out.print("-");
		System.out.print("\n");
	}

	private boolean isPointWithinCanvas(int x, int y) {
		x--;
		y--;
		return x >= 0 && x < width && y >= 0 && y < height;
	}
    
	
	// paints current cell and make paint request to valid neighboring cells
	private void paintNeighbour(int x, int y, char prevColour, char newColour) {
		canvas[y][x] = newColour;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < 4; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			if (isPointWithinCanvas(new_x + 1, new_y + 1) && canvas[new_y][new_x] == prevColour) {
				paintNeighbour(new_x, new_y, prevColour, newColour);
			}
		}
	}

	public void createLine(int x1, int y1, int x2, int y2) throws OutOfCanvasException, InvalidAlignment {
		if (!isPointWithinCanvas(x1, y1) || !isPointWithinCanvas(x2, y2)) {
			throw new OutOfCanvasException("Given line crosses out of canvas.");
		}
		if (isLineHorizontal(y1, y2)) {
			if (x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			for (int i = x1; i <= x2; i++) {
				this.canvas[y1 - 1][i - 1] = 'x';
			}
		} else if (isLineVertical(x1, x2)) {
			if (y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			for (int i = y1; i <= y2; i++) {
				this.canvas[i - 1][x1 - 1] = 'x';
			}
		} else {
			throw new InvalidAlignment("Only vertical and horizontal lines are allowed.");
		}
		printCanvas();
	}

	public void createRectangle(int x1, int y1, int x2, int y2) throws OutOfCanvasException, InvalidAlignment {
		if (!isPointWithinCanvas(x1, y1) || !isPointWithinCanvas(x2, y2)) {
			throw new OutOfCanvasException("Given rectangle crosses out of canvas.");
		}
		if (x2 < x1 || y2 < y1) {
			throw new InvalidAlignment("Point (" + x2 + "," + y2
					+ ") don't lie on lower right corner relative to Point (" + x1 + "," + y1 + ").");
		}
		for (int i = x1; i <= x2; i++) {
			canvas[y1 - 1][i - 1] = 'x';
			canvas[y2 - 1][i - 1] = 'x';
		}
		for (int i = y1; i < y2; i++) {
			canvas[i][x1 - 1] = 'x';
			canvas[i][x2 - 1] = 'x';
		}
		printCanvas();
	}

	public void colour(int x, int y, char newColour) throws OutOfCanvasException {
		if (!isPointWithinCanvas(x, y)) {
			throw new OutOfCanvasException("Cannot paint, point lie outside canvas.");
		}
		char prevColour = canvas[y - 1][x - 1];
        
		// optimization to make paint request only if color is different than previous.
		if (prevColour != newColour) { 
			paintNeighbour(x - 1, y - 1, prevColour, newColour);
		}
		printCanvas();
	}
}