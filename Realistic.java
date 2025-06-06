import java.util.Arrays; // from printing array

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
            }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         */
       // HW Part 1
       /*The first loop count starts at 0 and will increase by 1 every time the loop runs. The loop will continue while the current element index is positioned before the 
       smallest index location. These elements will be stored in the temp array excluding the smallest number.
       
       The second loop starts at the next index position (on the right side) of the smallest index. The loop will continue to run if it is within bounds of the array.
       Everything to the right of the smallest element will be stored in the temp array, shifting one index before its original location, after the smallest element has been removed.*/
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        /*
         * Same result with a while loop
         * 
         * int temp_index = 0;
         * int arr_index = 0;
         * while (arr_index < arr.length) {
         *   if (arr_index != smallest_index) {
         *     temporary[temp_index] = arr[arr_index];
         *     temp_index++;
         *   }
         *   arr_index++;
         * }
         */

        arr = temporary; // array shorted by 1 (removing smallest elem)
        return result; // smallest element
        
    } // method getSmallest

    //HW PT2
    public static void add(int value){ //beign with this header for the add method
    int[] increase = new int[arr.length + 1]; //create a new array with one more element to the original array length.

    for (int i = 0; i < arr.length; i++) { //loop counter starts at 0 and will increase by 1 every time the loop runs. The loop will continue to run if it is within bounds of the array.
            increase[i] = arr[i];//Store the elements from the original array into the new array.
        }// end of for loop

     increase[increase.length-1] = value;  // give a value to the new added element and place it at the end of the array. 


     arr = increase; //Array is larger, showing the added element at the end.
    } // end of increase element method

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
                add (22); //Add the number 22 to the array it should appear at the end.
        System.out.printf("\nArray after adding an element: %s\n\n",
                Arrays.toString(arr));
    } // method main

} // class Realistic