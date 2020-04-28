package swu.xl.algorithm.code_04_28.experiment_2;

public class MatrixChainMultiplicationTest {

	public static void main(String[] args) {
		int[] matrix_size = {5,3,4,2,7,5};
		int minMultiplicaitonNum = MatrixChainMultiplication.getMinMultiplicationNum(matrix_size);
		System.out.println(minMultiplicaitonNum);
	}

}
