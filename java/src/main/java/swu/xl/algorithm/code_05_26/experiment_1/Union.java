package swu.xl.algorithm.code_05_26.experiment_1;

import java.util.HashMap;

/**
 * 并查集类
 * @param <T>
 */
public class Union<T> {
    HashMap<T,T> unionMap;

    public Union() {
        unionMap = new HashMap<>();
    }

    public void add(T s){
        unionMap.put(s,s);
    }

    public T find(T s){
        while (unionMap.get(s) != s){
            s = unionMap.get(s);
        }

        return s;
    }

    public void union(T s1,T s2){
        T u1 = find(s1);
        T u2 = find(s2);

        if (u1 != u2){
            unionMap.put(u2,u1);
        }
    }

    public boolean isSameUnion(T s1, T s2){
        return find(s1) == find(s2);
    }
}
