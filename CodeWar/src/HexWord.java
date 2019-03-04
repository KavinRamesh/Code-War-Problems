public class HexWord  {
    public static String printHex(String[] input)  {
        String space = "";
        String result = "";
        for(int i = 0; i < input.length;i++)  {
            input[i] = input[i].replaceAll("", " ");
        }
        for(int i = input.length/2; i >= 0; i--)  {

            for(int j = i; j >= 0; j--)  {
                space += " ";
            }
            result += space + input[5-i] + "\n";
            space = "";
        }
        int count = 0;
        for(int i = 1; i < input.length/2 + 1; i++)  {
            count++;
            space += " ";
            for(int j = 0; j < i; j++)  {
                space += " ";
            }
            result += space + input[5+count] + "\n";
            space = "";

        }

        return result;
    }
    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
    public static String[] rot(String[] input) {
        String[] hex1= new String[11];
        hex1[0] = "LIPMOC";
        hex1[1] = "ERPORYA";
        hex1[2] = "XAOBJACT";
        hex1[3] = "RELIPMOCN";
        hex1[4] = "SIERRORETY";
        hex1[5] = "CYPMORYJXOS";
        hex1[6] = "SNYGOGBLER";
        hex1[7] = "UTRRCOMPU";
        hex1[8] = "NARERROW";
        hex1[9] = "MXGICPU";
        hex1[10]= "LSJNXA";
        //CYAMORGORPA
        input = hex1;
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<input.length; i++) {
            sb.setLength(0);
            for(int j=0; j<input[i].length(); j++) {
                System.out.println("\tinput[j] = "+ input[j]);
                System.out.println("\ti="+i+",j="+j);
                sb.append(input[j].charAt(i));
            }
            System.out.println("sb = " +sb.toString());
        }
        return null;
    }
    public static String[] rotateHex(String[] input)  {
        String[] rotated = new String[input.length];
        String[] second = new String[input.length];
        String[] secrot = new String[input.length];
        int lastRow = input.length-1;
        int k = 0;
        int count = 0;
        int x = 6;
        int rows = 6;
        int current = 0;
        int currentk = 0;
        int numRow = 10;
        second[0] = input[10];
        second[1] = input[9];
        second[2] = input[8];
        second[3] = input[7];
        second[4] = input[6];
        second[5] = input[5];
        second[6] = input[4];
        second[7] = input[3];
        second[8] = input[2];
        second[9] = input[1];
        second[10] = input[0];
        for(int i = 0; i < second.length; i++)  {
            second[i] = reverse(second[i]);
        }
        rotated[0] = input[0].substring(0,1);
        rotated[1] = input[0].substring(1,2);
        rotated[2] = input[0].substring(2,3);
        rotated[3] = input[0].substring(3,4);
        rotated[4] = input[0].substring(4,5);
        rotated[5] = input[0].substring(5,6);
        for(int i = 1; i <= numRow/2; i++)  {
            rotated[0] += input[i].substring(0, 1);
            for(int a = 1; a <= 6; a++)  {
                current = a;
                if(a <= 5)  {
                    rotated[i] += input[a].substring(i, i+1);
                } else {
                    currentk = k;
                    for(int j = rows - x; j > 0; j--)  {
                        k++;

                    }
                    if(k > 0)  {
                        for(int z = k; z > 0 ; z--)  {
                            rotated[i] += input[a].substring(k, k+1);
                            k--;
                            a++;
                        }
                    } else {
                        rotated[i] += input[a].substring(k, k+1);
                    }
                    x--;
                    k = 0;
                    a = current;
                }
            }
        }
        rotated[2] += input[7].substring(0,1);
        rotated[3] += input[8].substring(0,1);
        rotated[4] += input[9].substring(0,1);
        rotated[5] += input[lastRow].substring(0,1);
        lastRow = input.length-1;
        k = 0;
        count = 0;
        x = 6;
        rows = 6;
        current = 0;
        currentk = 0;
        numRow = 10;
        secrot[0] = second[0].substring(0,1);
        secrot[1] = second[0].substring(1,2);
        secrot[2] = second[0].substring(2,3);
        secrot[3] = second[0].substring(3,4);
        secrot[4] = second[0].substring(4,5);
        secrot[5] = second[0].substring(5,6);
        for(int i = 1; i <= numRow/2; i++)  {
            secrot[0] += second[i].substring(0, 1);
            for(int a = 1; a <= 6; a++)  {
                current = a;
                if(a <= 5)  {
                    secrot[i] += second[a].substring(i, i+1);
                } else {
                    for(int j = rows - x; j > 0; j--)  {
                        k++;
                    }
                    if(k > 0)  {
                        for(int z = k; z > 0 ; z--)  {
                            secrot[i] += second[a].substring(k, k+1);
                            k--;
                            a++;
                        }
                    } else {
                        secrot[i] += second[a].substring(k, k+1);
                    }
                    x--;
                    k = 0;
                    a = current;
                }
            }
        }
        secrot[2] += second[7].substring(0,1);
        secrot[3] += second[8].substring(0,1);
        secrot[4] += second[9].substring(0,1);
        secrot[5] += second[lastRow].substring(0,1);
        rotated[6] = secrot[4];
        rotated[7] = secrot[3];
        rotated[8] = secrot[2];
        rotated[9] = secrot[1];
        rotated[10] = secrot[0];
        for(int i = 0; i < 6; i++)  {
            rotated[i] = reverse(rotated[i]);
        }
        return rotated;
    }
    public static String[] findWordsInHex(String[] hex, String[] words)  {
        String result = "";
        String before = "";
        String after = "";
        String total = "";
        int count = 0;
        int firstrow = -1;
        int secondrow = -1;
        String[] res = hex;
        for(int i = 0; i < hex.length; i++)  {
            hex[i] = hex[i].replaceAll(" ", "");
        }
        for(int i = 0; i < hex.length; i++)  {
            for(int j = 0; j < words.length; j++)  {
                if(hex[i].indexOf(words[j]) >= 0)  {

                    for(int k = 0; k < hex[i].substring(0, hex[i].indexOf(words[j])).length(); k++)  {
                        before += ".";
                    }
                    for(int k = 0; k < hex[i].substring(hex[i].indexOf(words[j]) + words[j].length()).length(); k++)  {
                        after += ".";
                    }
                    res[i] = before + words[j] + after;
                } else if(hex[i].indexOf(reverse(words[j])) >= 0)  {
                    for(int k = 0; k < hex[i].substring(0, hex[i].indexOf(reverse(words[j]))).length(); k++)  {
                        before += ".";
                    }
                    for(int k = 0; k < hex[i].substring(hex[i].indexOf(reverse(words[j])) + reverse(words[j]).length()).length(); k++)  {
                        after += ".";
                    }
                    res[i] = before + reverse(words[j]) + after;
                } else {
                    count++;
                }
                before = "";
                after = "";
            }
            if(count == 5)  {
                for(int j = 0; j < hex[i].length(); j++)  {
                    total += ".";
                }
                hex[i] = total;
            }
            count = 0;
            total = "";
        }
        return res;
    }
    public static String[] printBack1(String[] hex)  {
        return rotateHex(rotateHex(rotateHex(rotateHex(rotateHex(hex)))));
    }
    public static String[] printBack2(String[] hex)  {
        return rotateHex(rotateHex(rotateHex(rotateHex(hex))));
    }
    public static String[] combineTwo(String[] hex1, String[] hex2)  {
        String[] result = new String[hex1.length];
        for(int i = 0; i < result.length; i++)  {
            result[i] = " ";
        }
        for(int i = 0; i < result.length; i++)  {
            for(int j = 0; j < hex1[i].length(); j++)  {
                if(hex1[i].substring(j, j+1).equals(hex2[i].substring(j,j+1)))  {
                    result[i] += hex1[i].substring(j, j+1);
                } else if(hex1[i].substring(j, j+1).equals("."))  {
                    result[i] += hex2[i].substring(j, j+1);
                } else if(hex2[i].substring(j, j+1).equals("."))  {
                    result[i] += hex1[i].substring(j, j+1);
                }
            }
        }
        for(int i = 0; i < result.length; i++)  {
            result[i] = result[i].substring(1);
        }
        /*for(int i = 0; i < result.length; i++)  {
            result[i] = result[i].replaceAll(" ", "");
        }*/
        return result;
    }
    public static void main(String[] args)  {
        String[] hex1= new String[11];
        hex1[0] = "LIPMOC";
        hex1[1] = "ERPORYA";
        hex1[2] = "XAOBJACT";
        hex1[3] = "RELIPMOCN";
        hex1[4] = "SIERRORETY";
        hex1[5] = "CYPMORYJXOS";
        hex1[6] = "SNYGOGBLER";
        hex1[7] = "UTRRCOMPU";
        hex1[8] = "NARERROW";
        hex1[9] = "MXGICPU";
        hex1[10]= "LSJNXA";
        String[] words = {"PROGRAM", "COMPILER", "ERROR", "SYNTAX", "OBJECT"};
        String[] hex2 = new String[hex1.length];
        String[] hex3 = new String[hex2.length];
        hex2 = rotateHex(hex1);
        hex3 = rotateHex(hex2);
        String[] newHex1 = findWordsInHex(hex1, words);
        String[] newHex2 = printBack1(findWordsInHex(hex2, words));
        String[] newHex3 = printBack2(findWordsInHex(hex3, words));
        /*System.out.println(printHex(hex1));
        System.out.println(printHex(hex2));
        System.out.println(printHex(hex3));
        System.out.println(printHex(findWordsInHex(hex1,words)));
        System.out.println(printHex(findWordsInHex(hex2,words)));
        System.out.println(printHex(findWordsInHex(hex3,words)));
        System.out.println(printHex(newHex1));
        System.out.println(printHex(newHex2));
        System.out.println(printHex(newHex3));*/
        String[] com12 = combineTwo(newHex1, newHex2);
        String[] com123 = combineTwo(com12, newHex3);
        System.out.println(com12);
        for(int i = 0; i < com123.length; i++)  {
            com123[i] = com123[i].replaceAll(" ","");
        }
        System.out.println(printHex(com123));
    }
}