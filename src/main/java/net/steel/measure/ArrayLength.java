package net.steel.measure;

import java.io.ByteArrayOutputStream;

public class ArrayLength {

    static int size = 1231434234;
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(size);
        int maxValue = (Integer.MAX_VALUE / 2) - 4;
        //Max Value: 1073741823
        //New Value: 2147483646
                  //-2147483646
        int newMax = maxValue <<1;

        System.out.println("Max Value: " + maxValue);
        System.out.println("New Value: " + newMax);

        while( bOutput.size() <= maxValue ) {
            // Gets the inputs from the user
            bOutput.write("h".getBytes());
        }
        byte b [] = bOutput.toByteArray();
        System.out.println("Array length: " + b.length);
        bOutput.write(b, 0, b.length);


    }
}
