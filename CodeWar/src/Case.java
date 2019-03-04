import java.util.Arrays;
public class Case  {
    public static String findIfCase(String[] existing, String[] poss)  {
        String result = "";
        int count = 0;
        for(int i = 0; i < poss.length; i++)  {
            for(int j = 0; j < existing.length; j++)  {
                if(poss[i].length() == existing[j].length())  {
                    for(int k = 0; k < poss[j].length();k++)  {
                        if(poss[j].indexOf(existing[j].substring(k, k+1)) > 0)  {
                            count++;
                        }
                    }
                }
            }
            if(count == poss[i].length())  {
                result += "YES " + poss[i] + "\n";
            } else {
                result += "NO" + poss[i] + "\n";
            }
        }
        return result;
    }
    public static boolean findIfAnagram(String one, String two)  {
        boolean result = false;
        String remove1 = one.replaceAll("\\s" , "");
        String remove2 = two.replaceAll("\\s" , "");
        if(remove1.length() == remove2.length())  {
            char[] first = remove1.toCharArray();
            char[] second = remove2.toCharArray();
            Arrays.sort(first);
            Arrays.sort(second);
            result = Arrays.equals(first, second);
        }
        //System.out.print(remove1 + "   -   " + remove2 + " ");
        return result;
    }
    public static String test(String[] existing, String[] poss)  {
        String result = "";
        int count = 0;
        for(int i = 0; i < existing.length; i++)  {
            for(int j = 0; j < poss.length; j++)  {
                //System.out.println(existing[i] + " - " + poss[j] + " - " + findIfAnagram(existing[i], poss[j]));
                if(findIfAnagram(existing[i], poss[j]))  {
                    count++;
                    break;
                } else {
                    count = 0;
                }
            }
            if(count == 0)  {
                result += "NO " + existing[i] + "\n";
            } else {
                result += "YES " + existing[i] + "\n";
            }
            //System.out.println();
        }
        return result;
    }
    public static void main(String[] args)  {
        String[] exis = {"PETER POTAMUS V THAT THING I SENT YOU", "PEOPLE VERSUS ROGERS AND DOO", "DOE ONE VS PROLOG PERSAUDERS"
                , "PEOPLE V FLINTSTONE"};
        String[] poss = {"POETS V FENNEL PILOT", "KRAMER V KRAMER", "PHOTOTYPESETTER V GIANT HUMAN SUIT", "DOE VS PROSPEROUS GOLDEN ERA"
                , "PEOPLE V SEBBEN"};
        System.out.println(test(exis, poss));
        System.out.println(findIfAnagram("DOE ONE VS PROLOG PERSAUDERS", "DOE VS PROSPEROUS GOLDEN ERA"));
    }
}