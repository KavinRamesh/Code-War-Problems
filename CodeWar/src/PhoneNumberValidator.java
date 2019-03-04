public class PhoneNumberValidator {
    public static String check(String number)  {
        /*String firstn = number.substring(1,4);
        String secondn = number.substring(5, 8);
        String lastn = number.substring(9);*/
        String y = "your number ";
        if(number.length() == 13) {
            if(number.indexOf("(") == 0 && number.indexOf(")") == 4 && number.indexOf("-") == 8 ) {
                if(number.indexOf("(", 1) != -1 || number.indexOf(")", 5) != -1|| number.indexOf("-", 9) != -1
                        || number.indexOf("0") == 1 || number.indexOf("1") == 1 || number.indexOf("9", 1) == 2 || number.indexOf("-", 9) != -1
                        || number.indexOf("0", 4) == 5 || number.indexOf("1", 4) == 5) {
                    return number + " INVALID";
                }else if(number.substring(6, 7).equals("1") && number.substring(7, 8).equals("1")){
                    return number + " INVALID";
                } else {
                    return number + " VALID";
                }
            } else {
                return number + " INVALID";
            }
        } else {
            return number + " INVALID";
        }
    }
    public static void main(String[] args)  {
        String number = "(720)789-3192";
        System.out.println(check(number));

    }
}