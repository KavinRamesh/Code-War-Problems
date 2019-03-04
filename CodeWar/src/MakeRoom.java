public class MakeRoom {
    public static String convertMoney(int gold, int silver, int bronze)  {
        //1 gold = 20 silver = 100 bronze
        //1 silver = 5 bronze
        int newG = gold;
        int newS = silver;
        int newB = bronze;
        int total = (newG * 100) + (newS * 5) + newB;
        System.out.println(newG + ", " + newS + ", " + newB + " = " + total);
        /*if(newS % 10 == 0 && newB % 50 == 0)  {
            newG += ((bronze - 50) / 5) + ((silver - 10) / 10);
            newS = 10;
            newB = 50;
        } else if(newS % 10 == 0 && newB > 50)  {
            newG += ((bronze - (bronze % 5)) / 5) + ((newS - 10)/10);
            newS = 10;
            newB = newB % 50;
        } else if(newS > 10 && newB % 50 == 0)  {
            newG += ((bronze - 50) / 50) + ((newS - (newS % 10)) / 10);
            newS = newS % 2
        }*/
        if(newB > 5 && newS > 20)  {
            if(bronze > 5)  {
                if(bronze % 5 == 0)  {
                    newS += (bronze - 5) / 5;
                    newB = 5;
                } else {
                    newS += (bronze - (bronze % 5)) / 5;
                    newB = bronze % 5;
                }
            }
            System.out.println(newG + ", " + newS + ", " + newB);
            if(newS > 20)  {
                if(newS % 20 == 0)  {
                    newG += (newS - 20) / 20;
                    newS = 20;
                } else {
                    newG += (newS - (newS % 20)) / 20;
                    newS = newS % 20;
                }
            }
        }
        total = (newG * 100) + (newS * 5) + newB;
        return newG + ", " + newS + ", " + newB + " = " + total;
    }


    public static void main(String[] args)  {
        System.out.println(convertMoney(500, 400, 300));
    }
}