package school.cesar.eta.unit;

public class Sorting {
    public static void bubbleSort(int[] sortArray) {
        int len = sortArray.length;
        for (int i = 0; i < len - 1; ++i) {

            for (int j = 0; j < len - i - 1; ++j) {

                if (sortArray[j + 1] < sortArray[j]) {

                    int swap = sortArray[j];
                    sortArray[j] = sortArray[j + 1];
                    sortArray[j + 1] = swap;

                }
            }
        }
    }
}
