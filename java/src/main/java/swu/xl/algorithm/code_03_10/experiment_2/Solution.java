package swu.xl.algorithm.code_03_10.experiment_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * leetcode P118 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        //创建容器
        List<List<Integer>> triangle = new ArrayList<>();

        //numRows 0
        if (numRows == 0){
            return triangle;
        }

        //numRows 1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        //numRows 正常
        for (int i = 1; i < numRows; i++) {
            //添加容器
            triangle.add(new ArrayList<Integer>());

            //首
            triangle.get(i).add(1);

            //中间
            List<Integer> lastList = triangle.get(i - 1);
            for (int j = 1; j < lastList.size(); j++) {
                triangle.get(i).add(lastList.get(j-1) + lastList.get(j));
            }

            //尾
            triangle.get(i).add(1);
        }

        return triangle;
    }
}
