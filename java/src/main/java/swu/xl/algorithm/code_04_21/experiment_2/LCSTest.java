package swu.xl.algorithm.code_04_21.experiment_2;

public class LCSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		System.out.println(LCS.getLCSByTabulation(str1,str2));
		System.out.println(LCS.getLCSByMemoization(str1,str2));
	}
}
