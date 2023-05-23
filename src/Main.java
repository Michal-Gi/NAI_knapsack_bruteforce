import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] weights = {3, 1, 6, 10, 1, 4, 9, 1, 7, 2, 6, 1, 6, 2, 2, 4, 8, 1, 7, 3, 6, 2, 9, 5, 3, 3, 4, 7, 3, 5, 30, 50};
        int[] values = {7, 4, 9, 18, 9, 15, 4, 2, 6, 13, 18, 12, 12, 16, 19, 19, 10, 16, 14, 3, 14, 4, 15, 7, 5, 10, 10, 13, 19, 9, 8, 5};
        int size = weights.length;
        int W_max = 75;

        List<Integer> bestSubset = new ArrayList<>();
        int bestValue = 0;
        int theWeight = 0;

        // Generate all possible subsets
        long totalSubsets = (long) Math.pow(2, size);
        for (long subset = 0; subset < totalSubsets; subset++) {
            List<Integer> currentSubset = new ArrayList<>();
            int currentWeight = 0;
            int currentValue = 0;

            // Check each element's inclusion in the subset
            for (int i = 0; i < size; i++) {
                if ((subset & (1 << i)) != 0) {
                    currentSubset.add(i);
                    currentWeight += weights[i];
                    currentValue += values[i];
                }
            }

            // Update the best subset if it has higher value and satisfies the weight constraint
//            System.out.println("currently considered combination: "+subset);
//            System.out.println("weight: "+currentWeight + " value: "+currentValue);
            if (currentValue > bestValue && currentWeight <= W_max) {
                bestSubset = currentSubset;
                bestValue = currentValue;
                theWeight = currentWeight;
            }
        }

        // Print the best subset and its total value
        System.out.println("Best Subset: " + bestSubset);
        System.out.println("Total Value: " + bestValue);
        System.out.println("Total Weight: " + theWeight);
        int[] vector = new int[size];
        for (Integer integer : bestSubset)
            vector[integer] = 1;
        System.out.print("vector representation: [");
        System.out.print(vector[0]);
        for(int i = 1; i<vector.length; i++)
            System.out.print(", "+vector[i]);
        System.out.println("]");
    }


}
