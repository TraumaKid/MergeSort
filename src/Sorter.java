public class Sorter {
    public static int[] mergeSort(int[] array, int left, int right) {
        // Base case
        if (left >= right) {
            int[] newArr = new int[0];
            newArr[0] = array[left];
            return newArr;
        }

        // Divide
        int mid = (right + left) / 2;
        int[] leftHalf = new int[mid - left];
        int[] rightHalf = new int[right - (mid + 1)];

        mergeSort(leftHalf, 0, leftHalf.length);
        mergeSort(rightHalf, 0, rightHalf.length);

        



        return leftHalf;
    }

    public static int[] merge(int[] one, int[] two) {
        
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 2, 3, 1, 5};

        
    }
}