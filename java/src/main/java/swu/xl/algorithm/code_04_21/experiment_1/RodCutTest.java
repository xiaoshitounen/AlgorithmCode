package swu.xl.algorithm.code_04_21.experiment_1;

public class RodCutTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cut_value = {1, 4, 5, 7, 10, 17, 17, 20, 24, 30};
		int rod_length = 17;
		System.out.println(RodCut.getValueByTabulation(cut_value,rod_length));
		System.out.println(RodCut.getValueByMemoization(cut_value,rod_length));
	}
}
