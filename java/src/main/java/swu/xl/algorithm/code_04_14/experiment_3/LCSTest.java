package swu.xl.algorithm.code_04_14.experiment_3;

public class LCSTest {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		String str = LCS.getLCS(str1,str2);
		System.out.println(str);
	}

}
