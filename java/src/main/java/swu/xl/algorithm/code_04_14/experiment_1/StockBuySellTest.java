package swu.xl.algorithm.code_04_14.experiment_1;

public class StockBuySellTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int[] prices =  {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};		
		int bound = 10000;
		int arrayLengthStep = 100000;
		int trialNumber = 20;

		for(int i=1;i<=trialNumber;i++) {
			
			int[] prices = generateRandomNumbers(i*arrayLengthStep, bound);
			
			long startTimeBF = System.currentTimeMillis();
			int[] answerBruteForce = StockBuySell.getByBruteForce(prices);
			long endTimeBF = System.currentTimeMillis();	
			long BFTime = endTimeBF - startTimeBF;

//			long startTimeDC = System.currentTimeMillis();
//			int[] answerDivideConquer = StockBuySell.getByDivideConquer(prices);
//			long endTimeDC = System.currentTimeMillis();
//			long DCTime = endTimeDC - startTimeDC;

			long startTimeDP = System.currentTimeMillis();
			int[] answerDP = StockBuySell.getByDynamicProgramming(prices);
			long endTimeDP = System.currentTimeMillis();
			long DPTime = endTimeDP - startTimeDP;

			if(answerBruteForce[0] != answerDP[0])
				System.out.println("wrong!");
			
			System.out.println("length: " + i*arrayLengthStep + "; brute force time: " + BFTime + "; dynamic programming time: " + DPTime);
						
		}
	}

	static private int[] generateRandomNumbers(int len, int bound) { 
		int [] a = new int[len];
		for(int i=0; i<len; i++) {
			a[i] = new java.util.Random().nextInt(bound);
		}	
		return a;
	}	

}
