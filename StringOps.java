import java.util.Arrays;

public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("You are currently not testing any function :)\nPlease change the main method");
    }

    public static String capVowelsLowRest (String string) {
        String temp = "";
        for (int i = 0; i < string.length(); i++){
            switch (string.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    temp += (char)(string.charAt(i) - 32);
                    break;
                default:
                    if (string.charAt(i) > 64 && string.charAt(i) < 91){
                        temp += (char)(string.charAt(i) + 32);
                    } else {
                        temp += string.charAt(i);
                    }
                    break;
            }
        }
        return temp;
    }

    /**
     * This function takes as an input a string containing only letters, organized into words that are separated with a single space
     * The function returns a string in which the original string is modified according to three rules:
     *  1. The first word should be in lowercase.
     *  2. Every word should start with an uppercase letter, and all the remaining letters in the word should be lowercase.
     *  3. All the spaces should be removed.
     */
    public static String camelCase (String string) {
        String answer = "";
        for (int i = 0; i < string.length();i++){
            if (string.charAt(i) == ' ' && answer==""){ // removing spaces in the beginning of a sentence
                continue;
            }
            else if (string.charAt(i) == ' '){ // removing spaces in the rest of the sentence
                continue;
            }
            else if (answer == ""){ //special case, first letter of the sentence
                if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                    answer += (char)(string.charAt(i)+32);
                }
                else{
                    answer += string.charAt(i);
                }
            }
            else{
                if (string.charAt(i-1) == ' '){ // first letter of word
                    if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z'){
                        answer += (char)(string.charAt(i)-32);
                    }
                    else{
                        answer += string.charAt(i);
                    }
                }
                else{
                    if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                        answer += (char)(string.charAt(i)+32);
                    }
                    else{
                        answer += string.charAt(i);
                    }
                }
            }
        }
        return answer;
    }

    /**
     * This function receives two parameters: A string and a character.
     * The function returns an array containing all the indices in which the character appears in the string.
     * We assume that the given string is not empty, and that the given character appears in the string at least once.
     */
    public static int[] allIndexOf (String string, char chr) {
        int[] temp = new int[string.length()]; // temporary unefficent array
        int numOfCharAppearance = 0; // used to create efficent array length
        int tempIndex = 0;
        for (int i = 0; i < string.length();i++){
            if (string.charAt(i) == chr){
                numOfCharAppearance++;
                temp[tempIndex] += string.indexOf(chr, i);
                tempIndex++;
            }
        }
        int[] answer = new int[numOfCharAppearance];
        for (int i = 0; i < answer.length; i++){ 
            answer[i] = temp[i];
        }
        return answer;
    }
}
