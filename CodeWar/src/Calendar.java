public class Calendar  {
    public static String printCalendar(String beginDay, int holiday)  {
        int[] days = new int[35];
        int i = 0;
        int dayNum = 1;
        int count = 0;
        int currentRow = 0;
        int currentColumn = 0;
        String result = "";
        if(beginDay.equals("Sunday"))  {
            i = 0;
        } else if(beginDay.equals("Monday"))  {
            i = 1;
        } else if(beginDay.equals("Tuesday"))  {
            i = 2;
        } else if(beginDay.equals("Wednesday"))  {
            i = 3;
        } else if(beginDay.equals("Thursday"))  {
            i = 4;
        } else if(beginDay.equals("Friday"))  {
            i = 5;
        } else if(beginDay.equals("Saturday"))  {
            i = 6;
        }
        for(int j = i; j < days.length; j++)  {
            days[j] = dayNum;
            dayNum++;
            if(days[j] > 31)  {
                days[j] = 0;
            } /*else if(days[j] == holiday)  {
                days[j] = 0;
            }*/
        }
        String space = "";
        System.out.println();
        result = "     SU " + "MO " + "TU " + "WE " + "TH " + "FR " + "SA ";
        for(int j = 0; j < days.length; j++)  {
            if(days[j] < 10)  {
                space = "  ";
            } else {
                space = " ";
            }
            if(j % 7 == 0)  {
                result += "\n";
                result += count + "    " + days[j] + space;
                count++;
            } else {

                result += days[j] + space;
            }
        }
        result+="\n\n" + "     0         1111111111";
        result += "\n" + "     01234567890123456789";
        count = -1;
        int x = 0;
        for(int j = 0; j < days.length; j++)  {
            if(days[j] < 10)  {
                x += 2;
            } else if(days[j] >= 10)  {
                x+= 3;
            }
            if(j % 7 == 0)  {
                count++;
                x = 0;
            }

            if(days[j] == holiday)  {
                currentRow = count;
                currentColumn = x;
                break;
            }
        }
        if(holiday < 10)  {
            return result + "\n\n" + beginDay + " " + holiday + ", " +  currentRow + " " + currentColumn;
        } else {
            return result + "\n\n" + beginDay + " " + holiday + ", " + currentRow + " " + currentColumn + " " + (currentColumn + 1);
        }
    }
    public static void main(String[] args)  {
        String beginDay = "Monday";
        System.out.println(printCalendar("Monday", 8));
        System.out.println(printCalendar("Monday", 17));
        System.out.println(printCalendar("Thursday", 1));
        System.out.println(printCalendar("Thursday", 24));
    }
}