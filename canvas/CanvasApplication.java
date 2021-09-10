package canvas;

import java.util.Scanner;

import canvas.exception.InvalidAlignment;
import canvas.exception.InvalidCanvasDimensions;
import canvas.exception.InvalidInputException;
import canvas.exception.NoCanvasException;
import canvas.exception.OutOfCanvasException;

class CanvasApplication {
	public static void main(String[] args) {

		Canvas c = null;
		Scanner sc = new Scanner(System.in);
		String command;
		
		// regex pattern for allowed set of commands
		final String AllowedCommands = "[BCLRQ]";

		while (true) {
			System.out.print("enter command: ");
			if (sc.hasNext(AllowedCommands)) {
				command = sc.next();
				if (command.equals("C")) {  //canvas creation command

					try {
						c = createCanvas(sc);
					} catch (InvalidCanvasDimensions | InvalidInputException e) {
						System.out.println("Exception message: " + e.getMessage());
					}

				} else if (command.equals("L")) { // line draw command

					try {
						drawLine(sc, c);
					} catch (NoCanvasException | InvalidInputException e) {
						System.out.println("Exception message: " + e.getMessage());
					}

				} else if (command.equals("R")) { // rectangle draw command

					try {
						drawRectangle(sc, c);
					} catch (NoCanvasException | InvalidInputException e) {
						System.out.println("Exception message: " + e.getMessage());
					}

				} else if (command.equals("B")) { // Color paint command

					try {
						paintCanvas(sc, c);
					} catch (NoCanvasException | InvalidInputException e) {
						System.out.println("Exception message: " + e.getMessage());
					}

				} else if (command.equals("Q")) {
					break;
				}
			} else { // invalid commands handling
				try {
					throw new InvalidInputException("Only Valid Commands [B,C,L,R,Q] are allowed");
				} catch (InvalidInputException e) {
					System.out.println("Exception message: " + e.getMessage());
				}
			}
			sc.nextLine();
		}
		;

		sc.close();
		System.out.println("Program Ends");

	}

	static Canvas createCanvas(Scanner sc) throws InvalidCanvasDimensions, InvalidInputException {
        
		// input validation 
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("width should be integer.");
		}
		int width = sc.nextInt();
		while (!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("height should be integer.");
		}
		int height = sc.nextInt();
		
		if (width <= 0 || height <= 0) {
			throw new InvalidCanvasDimensions("Both width and height should be positive integer");
		}
		
		// creation
		System.out.println("Creating Canvas");
		return new Canvas(width, height);

	}

	static void drawLine(Scanner sc, Canvas c) throws NoCanvasException, InvalidInputException {
        
		// input validation
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("First Point's x coordinate should be integer.");
		}
		int x1 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("First Point's y coordinate should be integer.");
		}
		int y1 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Second Point's x coordinate should be integer.");
		}
		int x2 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Second Point's y coordinate should be integer.");
		}
		int y2 = sc.nextInt();

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		
		// draw line
		System.out.println("Drawing Line");
		try {
			c.createLine(x1, y1, x2, y2);
		} catch (InvalidAlignment | OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}

	static void drawRectangle(Scanner sc, Canvas c) throws NoCanvasException, InvalidInputException {
        
		// input validation
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("First Point's x coordinate should be integer.");
		}
		int x1 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("First Point's y coordinate should be integer.");
		}
		int y1 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Second Point's x coordinate should be integer.");
		}
		int x2 = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Second Point's y coordinate should be integer.");
		}
		int y2 = sc.nextInt();

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		
		// draw rectangle
		System.out.println("Drawing Rectangle");
		try {
			c.createRectangle(x1, y1, x2, y2);
		} catch (InvalidAlignment | OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}

	static void paintCanvas(Scanner sc, Canvas c) throws NoCanvasException, InvalidInputException {
        
		// input validation
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Point's x coordinate should be integer.");
		}
		int x = sc.nextInt();
		
		while(!sc.hasNextInt()) {
			sc.next();
			throw new InvalidInputException("Point's y coordinate should be integer.");
		}
		int y = sc.nextInt();
		
		char newColour = sc.next().charAt(0);

		if (c == null) {
			throw new NoCanvasException("Please create canvas first");
		}
		
		// paint canvas
		System.out.println("Painting Canvas");
		try {
			c.colour(x, y, newColour);
		} catch (OutOfCanvasException e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}
}