public class helpLibrary
{
    public static String roublesAndKopecks (double amountSum)
    {
        System.out.println(amountSum);
        String formatResult = Double.toString(amountSum);
        int indexDot = formatResult.indexOf(".");
        System.out.println(indexDot);

        String roubles = formatResult.substring(indexDot - 2, indexDot);
        System.out.println(roubles);
        String kopecks = formatResult.substring(indexDot+1, indexDot + 3);
        System.out.println(kopecks);
       /* if (formatResult.length() < 5)
        {
            formatResult = "0" + formatResult;
        }
        else if(formatResult.length() > 5)
        {
            formatResult = formatResult.substring(formatResult.length()-5, formatResult.length());
        }
        String roubles = formatResult.substring(0, 2);
        String kopecks = formatResult.substring(3, 5);
        System.out.println(formatResult);
        System.out.println(roubles + " " + kopecks); */
        return formatResult;
    }
}
