package org.example;

public class Solution {


    public static Integer numberOfChanges(String password) {

        //length of string
        Integer len = password.length();
        Integer count_A = 0;
        Integer count_a = 0;
        Integer count_1 = 0;
        Integer count_aaa = 0; //number of changes that need to be done so there won't be repeating characters
        Integer counter = 1;

        for (int i = 0; i < len; i++) {
            if ((password.charAt(i) >= 'A') && (password.charAt(i) <= 'Z')) {
                count_A++;
            }
            if ((password.charAt(i) >= 'a') && (password.charAt(i) <= 'z')) {
                count_a++;
            }
            if ((password.charAt(i) >= '0') && (password.charAt(i) <= '9')) {
                count_1++;
            }
            if (i > 0) {
                if (password.charAt(i) == password.charAt(i - 1)) {
                    counter++;
                }
                if (password.charAt(i) != password.charAt(i - 1) || i == len - 1) {
                    if (counter >= 3) {
                        count_aaa += counter / 3;
                    }
                    counter = 1;
                }
            }
        }

        int sum = 0;
        if (count_a == 0) {
            sum++;
        }
        if (count_A == 0) {
            sum++;
        }
        if (count_1 == 0) {
            sum++;
        }
        // sum is the number of elements missing,
        // (capital letter, simple letter or number)
        // so we just need to add 1 from every missing type

        if (len >= 6 && len <= 20) {
            //if the size of password is right, check the other criteria

            if (count_aaa == 0) {
                // because there are no groups of repeating characters,
                // and the size is right, there won't be any other changes
                return sum;
            }

            if (count_aaa > 0) {
                //to do the minimum changes, we can select the highest number of changes
                // that have to be done, either number of groups of repeating characters,
                // or the missing characters.
                return Math.max(count_aaa, sum);
            }

        }

        if (len < 6) {
            //if the password is too short

            if(count_aaa==0){
                // if there are no repeating characters
                // that means only the number of missing characters matters,
                // and getting the size right
                // the minimum changes to do that is the maximum between
                // the number of characters that need to be added to get to 6
                // and the number of missing characters that have to be added

                return Math.max(6-len, sum);
            }
            if(count_aaa==1){
                // in a size of less than 6, there could be
                // just one group of repeating characters with a max length of 5,
                // meaning for that to be fixed there needs to be done just one change,
                // plus the fixing for length, and missing characters

                return Math.max(7-len, sum+1);

            }

        }
        if (len > 20) {
            int diff=len-20;
            if(diff>count_aaa){
                return diff + sum;
            }else{
                return diff + Math.max(count_aaa-diff, sum);
            }

        }


        return sum;
    }


}
