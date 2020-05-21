package swu.xl.algorithm.code_05_19.experiment_1;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoding {
    public static HashMap<String,String> getCodes(String[] chars, double[] frequency){
        //优先队列
        PriorityQueue<Node> nodes = new PriorityQueue<>();

        //加入数据
        for (int i = 0; i < chars.length; i++) {
            nodes.add(new Node(chars[i],frequency[i]));
        }

        //构建哈弗曼树
        while (nodes.size() > 1){
            //每一次弹出两个frequency最小的node
            Node left = nodes.poll();
            Node right = nodes.poll();

            //将合成的新的node加入优先队列
            nodes.add(new Node(left,right));
        }

        //输出数据
        HashMap<String,String> huffman_codes = new HashMap<>();
        traverse(nodes.poll(),"",huffman_codes);
        return huffman_codes;
    }

    //递归得到结果
    private static void traverse(Node node, String str, HashMap<String, String> huffman_codes) {
        if (node.leftChild == null){
            huffman_codes.put(node.chr,str);
        }else {
            traverse(node.leftChild,str+"0",huffman_codes);
            traverse(node.rightChild,str+"1",huffman_codes);
        }
    }

    public static void main(String[] args) {
        String[] chars = {"a","b","c","d","e","f"};
        double[] frequency = {0.45,0.13,0.12,0.16,0.09,0.05};

        HashMap<String, String> codes = getCodes(chars, frequency);
        Set<String> keys = codes.keySet();
        for (String key : keys) {
            System.out.println(key+" "+codes.get(key));
        }
    }
}
