public class helpLibrary
{
    public static String roublesAndKopecks (double amountSum)
    {
        String formatResult = Double.toString(amountSum);
        int indexDot = formatResult.indexOf(".");
        formatResult = formatResult.substring(indexDot - 2, indexDot + 3);;
        return formatResult;
    }


    public static String moneyOut(String moneyString)
    {
        String roublesStr = moneyString.substring(0, 2);
        String kopecksStr = moneyString.substring(3, 5);
        int roubles = Integer.parseInt(roublesStr);
        String outRoubles = "Ру";

            if (roubles >= 11 && roubles < 20)
            {
               outRoubles += "блей";
               return(outRoubles);
            }
            else
            {
                roublesStr = roublesStr.substring(1, 2);
                roubles = Integer.parseInt(roublesStr);
                switch(roubles)
                {
                    case 1:
                      outRoubles += "бль";
                      break;
                    case 2:
                        outRoubles += "бля";
                        break;
                    case 3:
                        outRoubles += "бля";
                        break;
                    case 4:
                        outRoubles += "бля";
                        break;
                    case 5:
                        outRoubles += "блей";
                        break;
                    case 6:
                        outRoubles += "блей";
                        break;
                    case 7:
                        outRoubles += "блей";
                        break;
                    case 8:
                        outRoubles += "блей";
                        break;
                    case 9:
                        outRoubles += "блей";
                        break;

                }

                return (outRoubles);
            }
        }





    }



