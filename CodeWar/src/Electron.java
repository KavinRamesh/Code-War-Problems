public class Electron  {
    public static String convert(int num) {
        if (num == 0) {
            return "";
        }
        else {
            return convert(num/2) + (num % 2);
        }
    }
    public static String findBalance(int num)  {
        if(num == 0)  {
            return "";
        }
        int count1 = 0;
        int count0 = 0;
        String result = "";
        for(int i = 0; i < convert(num).length();i++)  {
            if(convert(num).substring(i, i+1).equals("1"))  {
                count1++;
            } else {
                count0++;
            }
        }
        if(count1 > count0)  {
            result = "HEAVY";
        } else if(count1 == count0)  {
            result = "BALANCED";
        } else {
            result = "LIGHT";
        }
        return num + " " + result;
    }
    public static void main(String[] args)  {
        System.out.println(findBalance(5));
        System.out.println(findBalance(8));
        System.out.println(findBalance(10));
        System.out.println(findBalance(17));
        System.out.println(findBalance(316));
        System.out.println(findBalance(632));
        System.out.println(findBalance(987654321));
        System.out.println(findBalance(65536));
        System.out.println(findBalance(8675309));
        System.out.println(findBalance(0));
    }
}