package canvas;

import java.util.Scanner;

import canvas.exception.InvalidAlignment;
import canvas.exception.NoCanvasException;
import canvas.exception.OutOfCanvasException;

class CanvasApplication {
	public static void main(String[] args) {

		Canvas c = null;
		Scanner sc = new Scanner(System.in);
		String command;

		do {
			System.out.print("enter command: ");
			command = sc.next();
			if (command.equals("C")) {

				c = createCanvas(sc);

			} else if (command.equals("L")) {

				try {
					drawLine(sc, c);
				} catch (NoCanvasException e) {
					System.out.println("Exception message: " + e.getMessage());
				}

			} else if (command.equals("R")) {

				try {
					drawRectangle(sc, c);
				} catch (NoCanvasException e) {
					System.out.println("Exception message: " + e.getMessage());
				}

			} else if (command.equals("B")) {

				try {
					paintCanvas(sc, c);
				} catch (NoCanvasException e) {
					System.out.println("Exception message: " + e.getMessage());
				}

			} else if (!command.equals("Q")) {
				System.out.println("Invalid command!");
			}

		} while (!command.equals("Q"));

		sc.close();
		System.out.println("Program Ends");

	}

	static Canvas createCanvas(Scanner sc) {

		int width = sc.nextInt();
		int height = sc.nextInt();
		System.out.println("Creating Canvas");
		return new Canvas(width, height);

	}

	static void drawLine(Scanner sc, Canvas c) throws NoCanvasException {

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		System.out.println("Drawing Line");
		try {
			c.createLine(x1, y1, x2, y2);
		} catch (InvalidAlignment | OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}

	static void drawRectangle(Scanner sc, Canvas c) throws NoCanvasException {

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		System.out.println("Drawing Rectangle");
		try {
			c.createRectangle(x1, y1, x2, y2);
		} catch (InvalidAlignment | OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}

	static void paintCanvas(Scanner sc, Canvas c) throws NoCanvasException {

		int x = sc.nextInt();
		int y = sc.nextInt();
		char newColour = sc.next().charAt(0);

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		System.out.println("Painting Canvas");
		try {
			c.colour(x, y, newColour);
		} catch (OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}
}