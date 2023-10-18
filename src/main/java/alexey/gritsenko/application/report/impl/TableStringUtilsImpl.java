package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.TableStringUtils;




public class TableStringUtilsImpl implements TableStringUtils {
    @Override
    public String[] createTableString(final String productNameValue,
                                      final int productNameColumnWidth,
                                      final String productCostValue,
                                      final int productCostColumnWidth) {
        //Разделяем каждое значение по длине не более ширины колонки; 2 - это отступы по одному символу справа и слева
        String[] nameValueSplit = splitString(productNameValue, productNameColumnWidth - 2);
        String[] costValueSplit = splitString(productCostValue, productCostColumnWidth - 2);
        //выбираем максимальное из двух колонок количество занимаемых строк
        int countLine = Math.max(nameValueSplit.length, costValueSplit.length);
        String[] resultArray = new String[countLine + 1];

        //формируем строку
        for (int i = 0; i < countLine; i++) {
            StringBuilder sb = new StringBuilder();
            if (nameValueSplit.length > i) {
                sb.append("* ")
                        .append(nameValueSplit[i])
                        .append(" ".repeat(productNameColumnWidth-nameValueSplit[i].length()-2))
                        .append(" * ");
            } else {
                sb.append("*").append(" ".repeat(productNameColumnWidth - 1)).append(" * ");
            }
            if (costValueSplit.length > i) {
                sb.append(costValueSplit[i])
                        .append(" ".repeat(productCostColumnWidth-costValueSplit[i].length()-2))
                        .append(" *");
            } else {
                sb.append(" ".repeat(productCostColumnWidth - 1)).append("*");
            }
            resultArray[i] = sb.toString();
        }
        resultArray[countLine] = "*".repeat(1 + productNameColumnWidth + 1 + productCostColumnWidth + 1);
        return resultArray;
    }
    public String[] concatenate(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c = new String[ aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    @Override
    public String costToString(String cost) {
       String[] digits = cost.split(",");
       String rub = wordEnding(digits[0],"рубль","рубля","рублей");
       String cents = wordEnding(digits[1],"копейка","копейки","копеек");
        return digits[0]+" "+rub+" "+digits[1]+" "+cents;
    }

    private String wordEnding(String word, String var1, String var2, String var3){
        if(word.length()>=2){
            if(word.charAt(word.length()-2)=='1'){
                return var3;
            }
        }
        char digit = word.charAt(word.length()-1);
        return switch (digit) {
            case '1' -> var1;
            case '2', '3', '4' -> var2;
            default -> var3;
        };
    }

    private String[] splitString(String value, int width) {
        return value.split("(?<=\\G.{" + width + "})");
    }

}