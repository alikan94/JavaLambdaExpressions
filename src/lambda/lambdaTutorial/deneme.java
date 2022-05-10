package lambda.lambdaTutorial;

import java.util.Arrays;

public class deneme {
    public static void main(String[] args) {
        String my_input = "improrer";
        System.out.println(returnDuplicates(my_input));
        int[] nums = {1,2,3};
        return;
    }

    public int returnMax(int[] nums) {

        int max =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                max=nums[i];
            }
        }
        return max;

    }

    public static String returnDuplicates(String my_input) {


        String output = "";

        OUTTER:
        for (int i = 0; i < my_input.length(); i++) {
            INNER:
            for (int j = 1; j < my_input.length(); j++) {
                if (my_input.charAt(i) == my_input.charAt(j)) {
                    output += my_input.charAt(i);
                    break OUTTER;
                }
            }
        }

        return output;

    }


}
