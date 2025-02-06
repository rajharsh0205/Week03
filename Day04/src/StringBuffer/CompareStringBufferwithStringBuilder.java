package StringBuffer;

public class CompareStringBufferwithStringBuilder {
    public static void main(String[] args) {
        int iteration = 1000000;
        //string to append
        String str = "Harsh";

        //Measuring time for StringBuffer
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();
        for(int i=0; i<iteration; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime-startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime);

        //Measuring time for StringBuilder
        StringBuilder sbb = new StringBuilder();
        startTime = System.nanoTime();
        for(int i=0; i<iteration; i++) {
            sbb.append(str);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime-startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime);
    }
}
