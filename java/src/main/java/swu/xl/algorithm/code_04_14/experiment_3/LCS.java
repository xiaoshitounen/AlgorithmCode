package swu.xl.algorithm.code_04_14.experiment_3;

public class LCS {
    /**
     * 求解最长共同子序列
     * @param str1
     * @param str2
     * @return
     */
    public static String getLCS(String str1, String str2) {
        //存储str1对应长度子字符串和str2对应长度子字符串最长共同子序列
        int[][] max_length = new int[str1.length()][str2.length()];
        //System.out.println(max_length.length);

        //初始化一些值
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < 1; j++) {
                max_length[i][j] = str1.charAt(i) == str2.charAt(j) ? 1 : 0;
                if (max_length[i][j] == 0 && i > 0){
                    max_length[i][j] = max_length[i-1][j];
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < str2.length(); j++) {
                max_length[i][j] = str1.charAt(i) == str2.charAt(j) ? 1 : 0;
                if (max_length[i][j] == 0 && j > 0){
                    max_length[i][j] = max_length[i][j-1];
                }
            }
        }

        //初始化其他位置的值
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                max_length[i][j] = str1.charAt(i) == str2.charAt(j) ? max_length[i-1][j-1]+1 : Math.max(max_length[i-1][j],max_length[i][j-1]);
            }
        }

        //输出测试
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                System.out.print(max_length[i][j]+" ");
            }
            System.out.println("");
        }

        //寻找最大的字符串
        int i = str1.length()-1;
        int j = str2.length()-1;
        int length = max_length[i][j];
        StringBuilder result = new StringBuilder();
        while (true){
            if (str1.indexOf(i) != str2.indexOf(j)){
                //找到是从那个位置继承的回溯过去
                if (max_length[i-1][j] == length){
                    i--;
                }else {
                    j--;
                }
            }else {
                //将相同的字符加入到结果中
                result.append(str1.charAt(i));

                //判断是否找完
                if (length == 1){
                    break;
                }

                //相同必定来自左上角，回溯回去
                i--;
                j--;

                //长度减少
                length--;
            }
        }

        return result.reverse().toString();
    }
}
