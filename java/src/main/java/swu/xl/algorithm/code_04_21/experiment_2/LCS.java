package swu.xl.algorithm.code_04_21.experiment_2;

/**
 * 最长公共子序列
 */
public class LCS {
    /**
     * 表格法：自下向上
     * @param str1
     * @param str2
     * @return
     */
    public static String getLCSByTabulation(String str1, String str2) {
        //表格的行数和列数
        int row_num = str1.length();
        int col_num = str2.length();

        //表格的数据结构
        int[][] board = new int[row_num][col_num];

        //表格的第一行，第一列元素
        board[0][0] = (str1.charAt(0) == str2.charAt(0)) ? 1 : 0;

        //初始化第一列元素
        for (int i = 1; i < row_num; i++) {
            board[i][0] = (str1.charAt(i) == str2.charAt(0) || board[i-1][0] == 1) ? 1 : 0;
        }

        //初始化第一行元素
        for (int i = 1; i < col_num; i++) {
            board[i][0] = (str1.charAt(0) == str2.charAt(i) || board[0][i-1] == 1) ? 1 : 0;
        }

        //初始化表格其他位置的元素
        for (int i = 1; i < row_num; i++) {
            for (int j = 1; j < col_num; j++) {
                if (str1.charAt(i) == str2.charAt(j)){
                    board[i][j] = board[i-1][j-1] + 1;
                }else {
                    board[i][j] = Math.max(
                            board[i-1][j],
                            board[i][j-1]
                    );
                }
            }
        }

        //逆着找到一个最长字符串

        //模拟指针
        int i = row_num - 1;
        int j = col_num - 1;

        //存储找到的字符串
        StringBuilder lcs = new StringBuilder();

        //寻找
        while (i != 0 && j != 0){
            if (board[i][j] == board[i-1][j]){
                i--;
            }else if (board[i][j] == board[i][j-1]){
                j--;
            }else {
                lcs.insert(0, str1.charAt(i));
                i--;j--;
            }
        }
        lcs.insert(0, str1.charAt(i));

        return lcs.toString();
    }

    /**
     * 备忘录法：自上向下
     * @param str1
     * @param str2
     * @return
     */
    public static String getLCSByMemoization(String str1, String str2){
        //表格的行数和列数
        int row_num = str1.length();
        int col_num = str2.length();

        //表格的数据结构
        int[][] board = new int[row_num][col_num];

        //模拟指针
        int i = row_num - 1;
        int j = col_num - 1;

        //存储找到的字符串
        StringBuilder lcs= new StringBuilder();

        //逆着找
        while(i != 0 && j != 0){
            board[i][j] = getLCSByMemoization(board, str1, str2, i, j);
            board[i-1][j] = getLCSByMemoization(board, str1, str2, i-1, j);
            board[i][j-1] = getLCSByMemoization(board, str1, str2, i, j-1);

            if (board[i][j] == board[i-1][j]) {
                i--;
            } else if (board[i][j] == board[i][j-1]) {
                j--;
            } else {
                lcs.insert(0, str1.charAt(i));
                i--;j--;
            }
        }
        lcs.insert(0, str1.charAt(i));

        return lcs.toString();
    }

    //重载
    private static int getLCSByMemoization(int[][] board, String str1, String str2, int m, int n){
        if(m < 0 || n < 0) return 0;

        if(board[m][n] != 0){
            return board[m][n];
        }

        if(str1.charAt(m) == str2.charAt(n)){
            board[m][n] = 1 + getLCSByMemoization(board, str1,str2,m-1,n-1);
        }else{
            return Math.max(
                    getLCSByMemoization(board, str1,str2,m-1,n),
                    getLCSByMemoization(board, str1,str2,m,n-1)
            );
        }

        return board[m][n];
    }
}
