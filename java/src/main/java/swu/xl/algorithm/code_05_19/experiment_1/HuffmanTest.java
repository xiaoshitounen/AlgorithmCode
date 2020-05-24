package swu.xl.algorithm.code_05_19.experiment_1;

import java.util.HashMap;

public class HuffmanTest {
    public static void main(String[] args) {
        String[] chars = {"a", "b", "c", "d", "e", "f"};
        double[] frequency = {0.45, 0.13, 0.12, 0.16, 0.09, 0.05};
        HashMap<String, String> huffman_codes = Huffman.getCodes(chars, frequency);
        System.out.print(huffman_codes);
    }
}
