public class Serialization  {
    public static String serialize(int start, int length)  {
        if(length == 0)  {
            return "";
        }
        String result = "";
        int total = 0;
        int next = start;
        int count = 0;
        for(int i = 0; i < length; i++)  {
            result += next;
            next++;
            count++;
            total = result.length();
        }
        String sNext = Integer.toString(next-1);
        String ifMore = result.substring(0, result.indexOf(sNext));
        while(total > length)  {

        }
        if(total > length){
            System.out.println(total + " " + length + " " + count);
            System.out.println(result);
            return start + " " + length + " " + result.substring(ifMore.length()-sNext.length() - 1, ifMore.length());
        }else {
            return start + " " + length + " " + result;
        }
    }
    public static boolean test()  {
        return serialize(0, 5).equals("0 5 4")
                && serialize(0, 11).equals("0 11 9")
                && serialize(3, 9).equals("3 9 10")
                && serialize(7, 18).equals("7 18 16")
                && serialize(98, 9).equals("98 9 100")
                && serialize(13, 1).equals("13 1 0")
                && serialize(8192, 1024).equals("8192 1024 8447")
                && serialize(256, 8192).equals("256 8192 2489")
                && serialize(0, 0).equals("");
    }
    public static void main(String[] args)  {
        System.out.println(serialize(256, 8192));
        System.out.println(test()?"good":"bad");
    }
}