package swu.xl.algorithm.code_03_17.experiment_2;

import java.util.List;

public class PermutationTest {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<int[]> perms = Permutation.permute(nums);
        for(int[] perm : perms) {
            for(int element : perm)
                System.out.print(element + " ");
            System.out.println();
        }
    }

    //222017602053039许磊
}
