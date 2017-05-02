package math.matrix;

public class MatrixMain {

	public static void main(String[] args) throws Exception {
		
		int vector1[] = {1,2,3};
		
		int vector2[] = {3,2,1};
		
		int vector_length = vector1.length;
		
		if (vector_length != vector2.length){
			throw new Exception("length don't match");
		}
		
		int result[] = new int[vector_length];
		
		for(int i = 0; i<vector_length; i++){
			result[i] = vector1[i] * vector2[i];
		}
		
		for(int i = 0; i<vector_length; i++){
			System.out.print(result[i] + " ");
		}

	}

}
