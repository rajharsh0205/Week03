package StringBuffer;

public class ConcatenateStrings {
    // Method to concatenate an array of strings
    public static String concatenate(String[] inputStr) {
        // Using StringBuffer to efficiently concatenate strings
        StringBuffer result = new StringBuffer();

        // Iterating over each string in the input array
        for(String str : inputStr) {
            result.append(str); // Appending the string to result
        }

        // Converting StringBuffer to a regular string and returning it
        return result.toString();
    }

    public static void main(String[] args) {
        // Initializing an array of strings
        String[] input = {"Harsh", "Romi", "Shivam", "Babu"};

        // Calling concatenate method and storing the result
        String output = concatenate(input);

        // Printing the concatenated string
        System.out.println("Concatenated Strings: " + output);
    }
}
