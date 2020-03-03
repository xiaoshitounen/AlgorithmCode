package swu.xl.algorithm.code_03_03.experiment_3;

public class VersionControl {
    /**
     * API接口
     * @param version
     * @return
     */
    boolean isBadVersion(int version){
        if (version >= 4){
            return true;
        }

        return false;
    }
}
