import java.util.*;
public class MaxProductThree  {
    public static long findMaxProduct(int[] inputs)  {
        int[] problemSet = new int[inputs[0]];
        System.arraycopy(inputs, 1, problemSet, 0, inputs[0]);
        Arrays.sort(problemSet);
        long ans1 = problemSet[0] * problemSet[1] * problemSet[2];
        if (problemSet[inputs[0]-1] < 0 && problemSet[inputs[0]-2] < 0) {
            long ans2 = problemSet[0] * problemSet[inputs[0]-1] * problemSet[inputs[0]-2];
            if (ans2 > ans1) {
                return ans2;
            }
        }
        return ans1;
    }
    public static int findMaxProduct2(int[] inputs)  {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        for(int i = 1; i < inputs.length; i++)  {
            if(inputs[i]<=0)  {
                neg.add(inputs[i]);
            } else {
                pos.add(inputs[i]);
            }
        }
        Integer[] nextp = (Integer[]) pos.toArray(new Integer[0]);
        Integer[] nextn = (Integer[]) neg.toArray(new Integer[0]);
        Arrays.sort(nextp);
        Arrays.sort(nextn);
        int[] newp = new int[nextp.length];
        int[] newn = new int[nextn.length];
        for(int i=newp.length-1, j=-1; i >= 0; i--)  {
            newp[++j] = nextp[i];
        }
        for(int i=newn.length-1, j=0; i >= 0; i--)  {
            newn[j++] = nextn[i];
        }
        if(newp.length >= 3 && newn.length >= 2)  {
            if((newp[0]*newp[1]*newp[2]) > (newp[0] * nextn[0] * nextn[1]))  {
                return newp[0]*newp[1]*newp[2];
            }else {
                return newp[0] * nextn[0] * nextn[1];
            }
        } else if(newp.length >= 3)  {
            return newp[0]*newp[1]*newp[2];
        } else if(newp.length == 0) {
            return newn[0] * newn[1] * newn[2];
        } else {
            return 0;
        }
    }
    public static void main(String[] args)  {
        int[] input = {5, 5, -3, 2, 4, -1};
        int[] input2 = {7, 999, 2, 0, 834, 3, 1, 697};
        int[] input3 = {4, 2, 1, 0, -1};
        int[] input4 = {8, 5, 2, -3, 4, -4, 1, 0, -2};
        int[] input5 = {15, 89, -2, 2, 3, -4, 87, 1, -98, -6, -97, -1, 88, -3, -99, -5};
        int[] input6 = {6, 0, -1, -2, -3, -8, -9};
        int[] input7 = {8, -2, -5, -3, -7, -1, -4, -8, -6};
        System.out.println(findMaxProduct2(input) + "\n");
        System.out.println(findMaxProduct2(input2) + "\n");
        System.out.println(findMaxProduct2(input3) + "\n");
        System.out.println(findMaxProduct2(input4) + "\n");
        System.out.println(findMaxProduct2(input5) + "\n");
        System.out.println(findMaxProduct2(input6) + "\n");
        System.out.println(findMaxProduct2(input7) + "\n");
    }
}