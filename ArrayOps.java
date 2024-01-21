public class ArrayOps {
    public static void main(String[] args) {
        int[] array1 = {1,-1};
        System.out.println((isSorted(array1)));
    }
    /**
     * The function receive an array of integers values
     * The array must contain each integers between 0 <= x <= n | when n is the length of the array
     * Except for a single integer, the function returns that missing integer value.
     */
    public static int findMissingInt (int [] array) {
        int sequenceSum = 0;
        int arraySum = 0;
        // #feedback - you can have one loop and update sequenceSum and arraySum together.
        for(int i = 0; i <= array.length; i++){
            sequenceSum += i;
        }
        for(int i = 0; i < array.length; i++){
            arraySum += array[i];
        }
        // #feedback - you can just return the result of the subtraction directly. If it equals 0, that's what you will return :)
        int answer = sequenceSum - arraySum;
        if (answer == 0){
            return 0;
        }
        else{
            return answer;
        }
    }

    /**
     * This function takes an array of integers and returns the second largest number in the array.
     * The numbers in the array may appear more than once. We Assume that the array’s length is  >= 1.
     * If the number appears twice and it is the largest number, it is also the 2nd largest number. 
     */
    public static int secondMaxValue(int [] array) {
        // #feedback - we can't be sure the array contains 2 values, so you need to check it.
        int maxValue = Math.max(array[0], array[1]);
        int secondMaxValue = Math.min(array[0], array[1]);
        for (int i = 2; i < array.length;i++){
            if (array[i] > secondMaxValue){
                if (array[i]> maxValue){
                    secondMaxValue = maxValue;
                    maxValue = array[i];
                }
                else{
                    secondMaxValue = array[i];
                }
            }
        }
        return secondMaxValue;
    }

    /**
     * This function takes two arrays of integers, and returns true if both arrays contain the same numbers.
     * The number of occurrences of each number, and their order, are not important
     */
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        /*
         * We need to check that array1 is contained in array2 and the vice versa
         * If we found the integer in one of the arrays in the other, we can skip to the next number instead of continuing the search.
         * If we reached the end of the second array, and we didn't find the values, we know they do not contain the same numbers.
         */
        for(int i = 0; i < array1.length; i++){ 
            for(int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j]){
                    break;
                } 
                if (j == array2.length-1){
                    return false;
                }
            }
        }
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array1.length; j++){
                if (array2[i] == array1[j]){
                    break;
                } 
                if (j == array1.length-1){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This function takes an array of integers and checks if the array is sorted increasingly, from the minimum value to the maximum value.
     * Or decreasingly, from the maximum value to the minimum value.
     */
    public static boolean isSorted(int [] array) {
        /*
         * Extreme case, we need to take into consideration if there isn't a change in value in following neighboor integers
         * Example: {1, 1, 1,1,1,1,1,0,-1,-3,5}
         * so we need to find the index where there is a change in value
         * For efficency we should start checking for ascending or descending order from that specific index, instead from the beginning of the array
         */
        // #feedback - it's ok if the values are the same, you can just check >= or <=.
        int startIndex = 0;
        for(int i = 0; i < array.length-1; i++){
            if (array[i] != array[i+1]){
                startIndex=i;
                break;
            }
            if (i == (array.length-2)){
                return true;
            }
        }

        // #feedback - no need "?true : false", the "greater than" already returns a boolean value.
        boolean check = array[startIndex] > array[startIndex+1] ? true : false; // Is the array in ascending order or descending?
        for(int i = startIndex; i < array.length-1; i++){
            if (check == false){ // Ascending
                if (array[i+1] < array[i]){
                    return false;
                }
            } else {
                if (array[i+1] > array[i]){ // Descending
                    return false;
                }
            }
        }
        return true;
    }
}
