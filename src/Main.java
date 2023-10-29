public class Main {

    public static void main(String[] args) {
        System.out.println(reverseInteger(3294));
        System.out.println(encryptThis("Hello"));
        System.out.println((char)115); //testing ascii to char
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses){
        int count = 0;
        for (int i = 0; i < parentheses.length(); i++) {
            char e = parentheses.charAt(i);
            if (e == '(') {
                count++;
            } else if (e == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        if (count == 0){
            return true;
        }
        else return false;
    }


    // 2. reverseInteger
    public static String reverseInteger(int a){
        String iString = "" + a;
        String returnThing = "";
        for (int i = iString.length() - 1;i >= 0;i--){
            returnThing += iString.charAt(i);
        }
        return returnThing;
    }

    // 3. encryptThis

    public static String encryptThis(String str) {
        String[] words = str.split(" "); //.split to split message into individual words and dump into array
        StringBuilder returnThing = new StringBuilder();
        for (String word : words) { //iterate through every item in words array
            StringBuilder encryptedWord = new StringBuilder();
            if (!word.isEmpty()) { //in the case of an empty message we do not want to get string index out of bounds
                encryptedWord.append((int) word.charAt(0)); //appends first letter in ASCII int format
                if (word.length() > 1) {
                    encryptedWord.append(word.charAt(word.length() - 1)); //appends last char as second char
                }
                if (word.length() > 2) {
                    encryptedWord.append(word.substring(2, word.length() - 1)); //appends everything in between second and last char
                    encryptedWord.append(word.charAt(1)); //appends second char as last char
                }
            }
            returnThing.append(encryptedWord).append(" "); //space after every word
        }
        return returnThing.toString().trim(); //.trim to remove whitespace at the back
    }



    // 4. decipherThis
    public static String decipherThis(String str){
        String[] words = str.split(" ");
        StringBuilder returnThing = new StringBuilder();
        for (String word : words) {
            StringBuilder decryptedWord = new StringBuilder();
            if (!word.isEmpty()) {
                int firstCharASCII = Integer.parseInt(word.replaceAll("[^0-9]", "")); //Replaces all of not(^) numbers(0-9) with nothing("")
                decryptedWord.append((char) firstCharASCII); //narrowing cast ASCII back to char
                String remainingPart = word.replaceAll("[0-9]", ""); //Replaces all of numbers(0-9) with nothing(""), sets it to a string to start appending
                if (remainingPart.length() > 1) {
                    decryptedWord.append(remainingPart.charAt(remainingPart.length() - 1)); //appends last char as second char
                    decryptedWord.append(remainingPart.substring(1, remainingPart.length() - 1)); //appends everything in between
                    decryptedWord.append(remainingPart.charAt(0)); //appends second char (0 as first char already appended) as last char
                } else {
                    decryptedWord.append(remainingPart); //in the case of a 2 letter word
                }
            }
            returnThing.append(decryptedWord).append(" ");
        }
        return returnThing.toString().trim();
    }
}