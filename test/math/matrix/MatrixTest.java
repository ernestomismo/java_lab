package math.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testMultiplyMatrix() {
		System.out.println("Multiplication");
		System.out.println("--------------------");
        double[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        double[][] b = { { 4, 5, 6 }, { 7, 8, 9 }, { 0, 11, 53} };
        
        Matrix.multiply(a, b);
	}

}
