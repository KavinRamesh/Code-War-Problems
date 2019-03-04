import java.util.ArrayList;
public class Magnanimous  {
    public static boolean findIfPrime(int input) {
        if(input == 1)  {
            return false;
        }
        for(int i=2;i<input/2 + 1;i++) {
            if(input%i==0)
                return false;
        }
        return true;
    }
    public static String findIfPrimeString(int input) {
        if(input == 1)  {
            return "not prime";
        }
        for(int i=2;i<input/2 + 1;i++) {
            if(input%i==0)
                return "not prime";
        }
        return "prime";
    }
    public static String findIfMagnanimous(int input)  {
        if(input == 0)  {
            return "";
        }
        String test = Integer.toString(input);
        int first = 0;
        int second = 0;
        int total = first+second;
        String result = "";
        for(int i = 1; i < input - 1; i++)  {
            first = Integer.parseInt(test.substring(0, i));
            if(first == input)  {
                break;
            }
            second = Integer.parseInt(test.substring(i));
            total = first+second;
            System.out.println(first + " + " + second + " is " + findIfPrimeString(total));
            if(findIfPrime(total))  {
                result = "MAGNANIMOUS";
            } else {
                result = "PETTY";
                break;
            }
        }
        return input + " " + result;
    }
    public static void main(String[] args)  {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(40427);
        nums.add(819);
        nums.add(101);
        nums.add(109);
        nums.add(2000221);
        nums.add(4063);
        nums.add(10);
        nums.add(98);
        nums.add(0);
        for(int i = 0; i < nums.size(); i++) {
            System.out.println(findIfMagnanimous(nums.get(i)) + "\n");
        }
    }
}