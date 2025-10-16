
import java.util.Arrays;

public class Sorter {
    public static int[] mergeSort(int[] array) {

        // Get left and right
        int left = 0;
        int right = array.length - 1;

        // Base case
        if (array.length <= 1) {
            int[] newArr = new int[1];
            newArr[0] = array[left];
            return newArr;
        }

        // Divide into two halves
        int mid = Math.floorDiv(array.length, 2);

        // Copy the values in each side
        int[] leftHalf = Arrays.copyOf(array, mid);

        int[] rightHalf = new int[(right - mid) + 1];
        for (int j = mid; j<right + 1; j++) {
            rightHalf[j - mid] = array[j];
        }


        // Recursively call the merge sort
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    // Merge two arrays together in a way that maintains order
    public static int[] merge(int[] firstHalf, int[] secondHalf) {
        // Results defined as an array with a length of the two halves combined
        int[] results = new int[firstHalf.length + secondHalf.length];

        // Index variables for both halves and the new array
        int i = 0;
        int j = 0;

        int k = 0;


        // Copy elements
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] > secondHalf[j]) {
                results[k++] = secondHalf[j++];
            } else {
                results[k++] = firstHalf[i++];
            }

        }

        // Copy any remaining elements from firstHalf
        while (i < firstHalf.length) {
            results[k++] = firstHalf[i++];
        }

        // Copy any remaining elements from secondHalf
        while (j < secondHalf.length) {
            results[k++] = secondHalf[j++];
        }

        return results;
    }


    // Parse string array
    public static int[] stringToArray(String arrString) {
        String filteredString = arrString.replace('[', ' ').replace(']', ' ').replaceAll(" ", ""); // Replace both the brackets and the newly created trailling spaces
        String[] stringValues = filteredString.split(",");

        int[] intValues = new int[stringValues.length];
        for (int i = 0; i<stringValues.length; i++) {
            intValues[i] = Integer.parseInt(stringValues[i]);
        }
        

        return intValues;
    }

    public static void main(String[] args) {
        // A command line util which doesn't allow improper input validating the input up until the array
        if (args.length != 2) {
            System.err.println("Unexpected usage! Proper usage post compile: java -d bin src/Sorter -sort '[1, 2, 3, 4]'");
            return;
        }

        String command = args[0];

        if (!command.equals("-sort")) {
            System.err.println("Unexpected command! Proper usage post compile: java -d bin src/Sorter -sort '[1, 2, 3, 4]'");
            return;
        }
        
        String arrayStr = args[1];
        if (!(arrayStr.startsWith("[") && arrayStr.endsWith("]"))) {
            System.err.println("Array must be enclosed in []! Proper usage post compile: java -d bin src/Sorter -sort '[1, 2, 3, 4]'");
            return;
        }

        // Parse the user string
        int[] userArr = stringToArray(arrayStr);
        
        // Sort the user string
        int[] sortedArr = mergeSort(userArr);

        // Print the sorted array to the user
        System.out.println("Un-Sorted: " + arrayStr);
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
        

        
    }
}