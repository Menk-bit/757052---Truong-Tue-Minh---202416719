package Lab03.OtherProjects.Lab01.NumericArray.src;





import java.util.Arrays;

public class NumericArray {
    public static void main(String[] args) {
        int[] my_array1 = {1789, 2035, 1899, 1456, 2013};
        
        System.out.println("Original array: " + Arrays.toString(my_array1));
        
        // Sort the array
        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));
        
        // Calculate sum
        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }
        
        // Calculate average
        double average = (double) sum / my_array1.length;
        
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);
    }
}