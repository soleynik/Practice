package AMZN;

import java.util.Arrays;
import java.util.Comparator;

/*
1710. Maximum Units on a Truck

You are assigned to put some amount of boxes onto one truck.
You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.
 */
public class MaximumUnitsOnTruck {

    // O(nlogn) O(n)
    static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            }else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;
    }

    public static void main(String[] args) {

        // 8
        int[][] boxTypes1 = {{1,3},{2,2},{3,1}};
        int truckSize1 = 4;
        System.out.println(maximumUnits(boxTypes1,truckSize1));

        // 91
        int[][] boxTypes2 = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize2 = 10;
        System.out.println(maximumUnits(boxTypes2,truckSize2));

    }
}
