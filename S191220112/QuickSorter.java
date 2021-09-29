package S191220112;

public class QuickSorter extends BubbleSorter {

    @Override
    public void sort() {
        quickSort(0, this.a.length - 1);
    }

    private void quickSort(int begin, int end) {
        if (begin < end) {
            int q = partition(begin, end);
            quickSort(begin, q - 1);
            quickSort(q + 1, end);
        }
    }

    private int partition(int begin, int end) {
        int pivot = a[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (a[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, end);
        return i + 1;
    }

}
