public class Team {
    public static int[] findSkill(String[] players)  {
        int[] result = new int[players.length];
        for(int i = 0; i < players.length; i++)  {
            result[i] = Integer.parseInt(players[i].substring(0, players[i].indexOf(" ")));
        }
        return result;
    }
    public static int findBiggest(int[] numbers)  {
        int biggest = 0;
        for(int i = 0; i < numbers.length; i++)  {
            if(biggest < numbers[i])  {
                biggest = numbers[i];
            }
        }
        return biggest;
    }
    public static int findIndexOfBiggest(int[] numbers)  {
        int biggest = 0;
        int index = 0;
        for(int i = 0; i < numbers.length; i++)  {
            if(biggest < numbers[i])  {
                biggest = numbers[i];
                index = i;
            }
        }
        return index;
    }
    public static int findBiggestConsecutive(int[] numbers)  {
        int resultSum = 0;
        for(int i = 0; i < numbers.length; i++)  {
            if(numbers[i] < 0)  {
                if(resultSum > findBiggest(numbers))  {
                    break;
                } else {
                    resultSum = 0;
                }
            } else {
                resultSum += numbers[i];
            }
        }
        if(resultSum < findBiggest(numbers))  {
            return findBiggest(numbers);
        } else {
            return resultSum;
        }
    }
    public static String findIndexOfBiggestConsecutive(int[] numbers)  {
        int resultSum = 0;
        String indexSum = "";
        for(int i = 0; i < numbers.length; i++)  {
            if(numbers[i] < 0)  {
                if(resultSum > findBiggest(numbers))  {
                    break;
                } else {
                    indexSum = "";
                }
            } else {
                indexSum += i + ", ";
            }
        }

        indexSum = indexSum.substring(indexSum.indexOf("0") + 1, indexSum.length()-2);

        return indexSum;

    }
    public static String firstChoice(String[] input)  {
        int[] skill = findSkill(input);
        String[] players = new String[input.length];
        for(int i = 0; i < players.length; i++)  {
            players[i] = input[i].substring(input[i].indexOf(" ") + 1);
        }
        if(findIndexOfBiggestConsecutive(skill).length() > 1)  {
            return players[Integer.parseInt(findIndexOfBiggestConsecutive(skill).substring(0, 1))] + " to "
                    + players[Integer.parseInt(findIndexOfBiggestConsecutive(skill).substring(findIndexOfBiggestConsecutive(skill).length()-1, findIndexOfBiggestConsecutive(skill).length()))];
        } else {
            return players[Integer.parseInt(findIndexOfBiggestConsecutive(skill).substring(0, 1))];
        }


    }
    public static void main(String[] args)  {
        String[] firstSet = {"10 Fenchurch", "-14 Colin", "2 Random Dent", "5 Zaphod Beeblebrox the Fourth", "3 Gag Halfrunt"};
        String[] secondSet = {"-4 Prostetnic Vogon Jeltz", "-1 Stavro Mueller"};
        String[] thirdSet = {"0 Zarniwoop", "-1 Rob McKenna", "0 Garkbit"};
        String[] fourthSet = {"6 Wonko the Sane", "11 Arthur Dent", "9 Ford Prefect", "-37 Lig Lury, Jr", "27 Zarquon"};
        String[] x = firstSet;
        System.out.println();
        System.out.print("SET : ");
        for(int i = 0; i < findSkill(x).length; i++)  {
            if(i != findSkill(x).length-1)  {
                System.out.print(findSkill(x)[i] + ", ");
            } else {
                System.out.println(findSkill(x)[i]);
            }
        }
        System.out.println("BIGGEST NUMBERS : " + findBiggest(findSkill(x)));
        System.out.println("INDEX OF BIGGEST NUMBER : " + findIndexOfBiggest(findSkill(x)));
        System.out.println("BIGGEST CONSECUTIVE SUM : " + findBiggestConsecutive(findSkill(x)));
        System.out.println("INDEXES OF BIGGEST CONSECUTIVE SUM : " + findIndexOfBiggestConsecutive(findSkill(x)));
        System.out.println("FIRST CHOICE : " + firstChoice(firstSet));
        System.out.println("FIRST CHOICE : " + firstChoice(thirdSet));
        System.out.println("FIRST CHOICE : " + firstChoice(fourthSet));
    }
}