package canvas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import canvas.exception.InvalidAlignment;
import canvas.exception.OutOfCanvasException;

class CanvasTest {

	@Test
	void testColour() throws OutOfCanvasException {
		Canvas testCanvas = new Canvas(4, 4);
		char[][] expectedCanvas1 = { { 'c', 'c', 'c', 'c' }, { 'c', 'c', 'c', 'c' }, { 'c', 'c', 'c', 'c' },
				{ 'c', 'c', 'c', 'c' } };
		char[][] expectedCanvas2 = { { 'f', 'f', 'f', 'f' }, { 'f', 'f', 'f', 'f' }, { 'f', 'f', 'f', 'f' },
				{ 'f', 'f', 'f', 'f' } };
		testCanvas.colour(1, 1, 'c');
		assertArrayEquals(testCanvas.getCanvas(), expectedCanvas1);
		testCanvas.colour(1, 1, 'f');
		assertArrayEquals(testCanvas.getCanvas(), expectedCanvas2);
	}

	@Test
	void testColourThrowOutOfCanvasException() {
		Canvas testCanvas = new Canvas(4, 4);
		Exception exception = assertThrows(OutOfCanvasException.class, () -> testCanvas.colour(10, 10, 'c'));
		String expectedMessage = "Cannot paint, point lie outside canvas.";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testCreateLineThrowOutOfCanvasException() {
		Canvas testCanvas = new Canvas(4, 4);
		Exception exception = assertThrows(OutOfCanvasException.class, () -> testCanvas.createLine(1, 1, 1, 100));
		String expectedMessage = "Given line crosses out of canvas.";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testCreateLineThrowInvalidAlignmentException() {
		Canvas testCanvas = new Canvas(4, 4);
		Exception exception = assertThrows(InvalidAlignment.class, () -> testCanvas.createLine(1, 1, 2, 2));
		String expectedMessage = "Only vertical and horizontal lines are allowed.";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testCreateLineHorizontal() throws OutOfCanvasException, InvalidAlignment {
		Canvas testCanvas = new Canvas(4, 4);
		testCanvas.createLine(1, 2, 3, 2);
		char c = '\u0000';
		char[][] expectedCanvas = { { c, c, c, c }, { 'x', 'x', 'x', c }, { c, c, c, c }, { c, c, c, c } };
		assertArrayEquals(testCanvas.getCanvas(), expectedCanvas);
	}

	@Test
	void testCreateLineVertical() throws OutOfCanvasException, InvalidAlignment {
		Canvas testCanvas = new Canvas(4, 4);
		testCanvas.createLine(1, 4, 1, 1);
		char c = '\u0000';
		char[][] expectedCanvas = { { 'x', c, c, c }, { 'x', c, c, c }, { 'x', c, c, c }, { 'x', c, c, c } };
		assertArrayEquals(testCanvas.getCanvas(), expectedCanvas);
	}

	@Test
	void testCreateRectangleThrowOutOfCanvasException() {
		Canvas testCanvas = new Canvas(4, 4);
		Exception exception = assertThrows(OutOfCanvasException.class, () -> testCanvas.createRectangle(1, 1, 2, 100));
		String expectedMessage = "Given rectangle crosses out of canvas.";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testCreateRectangleThrowInvalidAlignmentException() {
		Canvas testCanvas = new Canvas(4, 4);
		Exception exception = assertThrows(InvalidAlignment.class, () -> testCanvas.createRectangle(3, 3, 1, 1));
		String expectedMessage = "Point (1,1) don't lie on lower right corner relative to Point (3,3).";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testCreateRectangle() throws OutOfCanvasException, InvalidAlignment {
		Canvas testCanvas = new Canvas(4, 4);
		testCanvas.createRectangle(1, 1, 3, 3);
		char c = '\u0000';
		char[][] expectedCanvas = { { 'x', 'x', 'x', c }, { 'x', c, 'x', c }, { 'x', 'x', 'x', c }, { c, c, c, c } };
		assertArrayEquals(testCanvas.getCanvas(), expectedCanvas);
	}

}
