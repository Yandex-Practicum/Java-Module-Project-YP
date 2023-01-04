import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Purchase personPurchases = new Purchase();      //инициализация класса Purchase
        int PARAM_MIN_PEOPLE = 2;   //параметр - минимальное число людей

        short step=0;               //шаг выполнения
        boolean enPrgExit=false;    //выход

        Scanner consoleScanner = new Scanner(System.in);
        while( !enPrgExit ){
            switch(step)
            {
                case 0: //узнаем количество персон
                    boolean numPersonOK = false;
                    System.out.println("Здравствуйте!");
                    while( !numPersonOK ){
                        System.out.println("На какое количество участников будем делить счет?");
                        //проверяем на корректность ввода числа участников
                        boolean numInputTypeOK=false;
                        if ( consoleScanner.hasNextInt() ) {
                            personPurchases.numPeopleOfGroup = consoleScanner.nextInt();
                            numInputTypeOK  = true;
                        }
                        else
                        {
                            System.out.println("Введено не число!");
                            consoleScanner.nextLine();
                        }
                        //проверяем на корректность числа людей
                        if (numInputTypeOK) {
                            if (personPurchases.numPeopleOfGroup >= PARAM_MIN_PEOPLE) numPersonOK = true;   //введено корректное значение числа участников
                            else System.out.println("Нельзя разделить счет на " + personPurchases.numPeopleOfGroup + " участника(ов)." );
                        }
                    }
                    step = 1;   //завершили ввод числа участников
                break;
                case 1: //добавляю название и стоимость
                    boolean finishedCalc = false;
                    float productPrice = 0.0f;
                    String productName="";

                    while( !finishedCalc ){
                        boolean isInputNameOK = false;
                        System.out.println("Введите наименование товара:");
                        while( !isInputNameOK ){
                            if (consoleScanner.hasNext() ){
                                isInputNameOK = true;                   //введено корректное название продукта
                                productName = consoleScanner.next();    //наименование введенного продукта
                                consoleScanner.nextLine();
                            }
                            else
                            {
                                System.out.println("Не введено");
                                consoleScanner.nextLine();
                            }
                        }

                        System.out.println("Введите стоимость товара:");
                        boolean isInputPriceOK = false;
                        while( !isInputPriceOK){
                            if ( consoleScanner.hasNextFloat() ) {
                                productPrice = consoleScanner.nextFloat();          //стоимость введенного товара
                                if(productPrice >= 0.0f) isInputPriceOK  = true;    //введена корректная стоимость товара
                            }
                            if( !isInputPriceOK){
                                System.out.println("Введена некорректная стоимость товара! Введите еще раз");
                                consoleScanner.nextLine();
                            }
                            if( isInputPriceOK ){   //цена товара введена корректно

                                personPurchases.addNewProduct( productName, productPrice);      //добавляю имя продукта и цену
                                //проверка на выход из режима ввода продуктов
                                System.out.println("Желаете добавить еще товар? Для завершения введите \"Завершить\"");
                                String answerCheckFinishInput = consoleScanner.next().trim().toLowerCase();
                                if (    answerCheckFinishInput.equals("завершить")
                                    /*||  answerCheckFinishInput.equals("e")*/){
                                    finishedCalc = true;
                                }
                            }
                        }
                        if (finishedCalc) step = 2; //завершили ввод товаров и стоимости
                    }
                break;
                case 2: //вывожу результаты
                    float sumForPerson;

                    System.out.println("Добавленные товары:");
                    System.out.print( personPurchases.nameOfPurchases );    //вывод общей строки наименования товаров

                    if( personPurchases.numPeopleOfGroup > 0){
                        sumForPerson = personPurchases.sumOfPurchases / (float)personPurchases.numPeopleOfGroup ;    //сумма на каждого
                        System.out.print( String.format("Сумма на каждого: %.2f ", sumForPerson) ); //вывод суммы
                        System.out.println( createStrRub(sumForPerson) );           //добавка - рублей/рубля/рубль
                    }
                    else System.out.print( "Сумма не определена" ); //вывод суммы

                    System.out.print("Press any key for exit: ");
                    consoleScanner.next();   //пауза на ввод любого символа

                    enPrgExit=true;     //завершение выполнения цикла программы
                break;
                /*case 3:
                    for(int i=0;i<1000;i++) System.out.println( i+ " " + createStrRub((float) i) );
                    enPrgExit=true;
                    break;*/
            }
        }
        consoleScanner.close();
    }
    //----------------------------------------------------------------------------------------------
    // метод создания окончания суммы: x0,x5,x6,x7,x8,x9,x11 - рублей; 1-рубль; x2,x3,x4-рубля
    public static String createStrRub(float sumReal){
        int sumInt,sumInt100;

        String retString="";
        sumInt = (int) sumReal; //из float to int
        sumInt100 = sumInt % 100;
        //проверка на x11-x14 рублей
        if(  (sumInt100>=11 && sumInt100<=14)) retString="рублей";
        else{
            switch (sumInt % 10) {
                case 1:
                    retString = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    retString = "рубля";
                    break;
                default:
                    retString = "рублей";
                    break;
            }
        }
        return retString;
    }
}
//--------------------------------------------------------------------------------------------------
//описание класса Purchase
class Purchase {
    String nameOfPurchases;  //общая строка названий добавленных продуктов
    float sumOfPurchases;    //общая сумма добавленных продуктов
    int numPeopleOfGroup;    //число людей в группе

    //constructor
    Purchase( ){
        this.nameOfPurchases = "";
        this.sumOfPurchases = 0.0f;
        this.numPeopleOfGroup = 1;
    }
    //добавить новый продукт
    public void addNewProduct(String nameOfProduct, float valueOfProduct){
        nameOfPurchases = nameOfPurchases + nameOfProduct + "\n";
        sumOfPurchases += valueOfProduct;
    }
}
