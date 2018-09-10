package packingcases;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

//Helloo
public class Packing {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferReader.readLine());

        for (int tc=1; tc <= t; tc++) {
            String[] inputString = bufferReader.readLine().split("\\s+");
            int height = Integer.parseInt(inputString[0]);
            int n = Integer.parseInt(inputString[1]);

            //flag to track whether the structure can be built or not
            boolean canBuild = false;

            int len = 3*n;
            Box boxStack[] = new Box[len];
            int i=0;
            while (i<len-1) {
                String[] boxDesc = bufferReader.readLine().split("\\s+");
                int[] boxDimentions = new int[3];
                boxDimentions[0] = Integer.parseInt(boxDesc[0]);
                boxDimentions[1] = Integer.parseInt(boxDesc[1]);
                boxDimentions[2] = Integer.parseInt(boxDesc[2]);

                if (boxDimentions[0] >= height || boxDimentions[1] >= height || boxDimentions[2] >= height) {
                    canBuild = true;
                    break;
                }

                // Sort the dimensions where height>length>width
                Arrays.sort(boxDimentions);

                // Add the different boxes
                Box b1 = new Box(boxDimentions[0], boxDimentions[1], boxDimentions[2]);
                Box b2 = new Box(boxDimentions[1], Integer.min(boxDimentions[0], boxDimentions[2]), Integer.max(boxDimentions[0], boxDimentions[2]));
                Box b3 = new Box(boxDimentions[2], Integer.min(boxDimentions[0], boxDimentions[1]), Integer.max(boxDimentions[0], boxDimentions[1]));



                boxStack[i] = b1;
                boxStack[i+1] = b2;
                boxStack[i+2] = b3;
                i=i+3;
            }

            if (canBuild) {
                bufferWriter.write("Case #" + tc + ": yes\n");
            } else {
                Arrays.sort(boxStack, Collections.reverseOrder());
                int maxheight[] = new int[len];

                // Initialize the max height array
                for (i=0; i<len-1; i++) {
                    maxheight[i] = boxStack[i].height;
                }

                for (i = 1; ( i < len && !canBuild ) ; i++ ) {
                    for (int j = 0; j < i; j++) {
                        if ((boxStack[i].width < boxStack[j].width) && (boxStack[i].length < boxStack[j].length) && (maxheight[i] < maxheight[j] + boxStack[i].height)) {
                            maxheight[i] = maxheight[j] + boxStack[i].height;
                            if (maxheight[i] >= height) {
                                canBuild = true;
                                break;
                            }
                        }
                    }
                }

                if (canBuild) {
                    bufferWriter.write("Case #" + tc + ": yes\n");
                } else {
                    bufferWriter.write("Case #" + tc + ": no\n");
                }
            }
            bufferWriter.flush();


            if (tc != t) {
                bufferReader.readLine();
            }
        }
    }
}


