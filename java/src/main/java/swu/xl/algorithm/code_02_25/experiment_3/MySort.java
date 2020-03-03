package swu.xl.algorithm.code_02_25.experiment_3;

public class MySort {
    public static int[] selectionSort(int[] originalData){
        for (int i = 0; i < originalData.length-1; i++) {

            int min = originalData[i];

            for (int j = i+1; j < originalData.length; j++) {
                if(min > originalData[j]){
                    int temp = min;
                    min = originalData[j];
                    originalData[j] = temp;
                }
            }

            originalData[i] = min;
        }

        return originalData;
    }

    public static int[] mergeSort(int[] originalData){

        int[] temp = new int[originalData.length];

        sort(originalData, 0, originalData.length-1, temp);

        return originalData;
    }

    public static void sort(int[] originalData, int left, int right, int[] temp){
        if (left < right){
            int mid = (left+right) / 2;

            sort(originalData, left, mid, temp);
            sort(originalData, mid+1, right, temp);

            merge(originalData, left, right, mid, temp);
        }
    }

    public static void merge(int[] originalData, int left, int right, int mid, int[] temp){
        int i = left;
        int j = mid+1;
        int index = 0;

        while(i <= mid && j <= right){
            if(originalData[i] > originalData[j]){
                temp[index++] = originalData[j++];
            }else {
                temp[index++] = originalData[i++];
            }
        }

        while(i <= mid){
            temp[index++] = originalData[i++];
        }

        while (j <= right){
            temp[index++] = originalData[j++];
        }

        index = 0;
        while (left <= right){
            originalData[left++] = temp[index++];
        }
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < selectionSort(new int[]{2, 6, 4, 3, 1}).length; i++) {
//            System.out.print(selectionSort(new int[]{2,6,4,3,1})[i]+" ");
//        }
//
//        for (int i = 0; i < mergeSort(new int[]{2, 6, 4, 3, 1}).length; i++) {
//            System.out.print(mergeSort(new int[]{2,6,4,3,1})[i]+" ");
//        }
//    }
}
