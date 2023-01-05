import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Purchase personPurchases = new Purchase();  //инициализация класса Purchase

        System.out.println("Здравствуйте!");
        //personPurchases.setMinPeopleOfGroup(2);   //указываю минимальное число людей в группе
        personPurchases.GetNumOfPersons();          //получаю число число людей в группе
        personPurchases.FindNamePriceProduct();     //заношу товары и стоимость, считаю стоимсть
        personPurchases.ShowResults();              //вывод результатов
    }
}
//--------------------------------------------------------------------------------------------------
//описание класса Purchase
class Purchase {
    String nameOfPurchases;             //общая строка названий добавленных продуктов
    String namePriceOfPurchases;        //общая строка названий + цена добавленных продуктов
    float sumOfPurchases;               //общая сумма добавленных продуктов
    int numPeopleOfGroup;               //число людей в группе
    int paramMinPeopleOfGroup;          //минимальное число людей в группе
    Scanner consoleScanner = new Scanner(System.in);

    //constructor
    Purchase( ){
        this.nameOfPurchases = "";      //имя товара
        this.namePriceOfPurchases = ""; //имя товара с указанием цены
        this.sumOfPurchases = 0.0f;     //стоимость товара
        this.numPeopleOfGroup = 1;      //число участников
        this.paramMinPeopleOfGroup = 2; //минимальное число участников
    }
    //добавить новый продукт
    public void addNewProduct(String nameOfProduct, float valueOfProduct){
        nameOfPurchases = nameOfPurchases + nameOfProduct + "\n";
        namePriceOfPurchases = namePriceOfPurchases +  nameOfProduct + String.format( " Цена:%.2fр.", valueOfProduct) + "\n";
        sumOfPurchases += valueOfProduct;
    }
    //установить минимальное число участников
    public void setMinPeopleOfGroup(int paramMinPeopleOfGroup){
        if(paramMinPeopleOfGroup >= 2) this.paramMinPeopleOfGroup = paramMinPeopleOfGroup;
    }
    //узнать количество людей в группе
    public void GetNumOfPersons(){
        boolean numPersonOK = false;
        while( !numPersonOK ){
            System.out.println("На какое количество участников будем делить счет?");
            //проверяем на корректность ввода числа участников
            boolean numInputTypeOK=false;
            if ( consoleScanner.hasNextInt() ) {
                numPeopleOfGroup = consoleScanner.nextInt();
                numInputTypeOK  = true;
            }
            else
            {
                System.out.println("Введено не число!");
                consoleScanner.nextLine();
            }
            //проверяем на корректность числа людей
            if (numInputTypeOK) {
                if (numPeopleOfGroup >= paramMinPeopleOfGroup) numPersonOK = true;   //введено корректное значение числа участников
                else System.out.println("Нельзя разделить счет на " + numPeopleOfGroup + " участника(ов)." );
            }
        }
    }
    //добавить продукты и стоимость
    public void FindNamePriceProduct(){
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
                    addNewProduct( productName, productPrice);      //добавляю имя продукта и цену
                    //проверка на выход из режима ввода продуктов
                    System.out.println("Желаете добавить еще товар? Для завершения введите \"Завершить\"");
                    String answerCheckFinishInput = consoleScanner.next().trim().toLowerCase();
                    if (    answerCheckFinishInput.equals("завершить")
                         //||  answerCheckFinishInput.equals("e")
                        ){
                        finishedCalc = true;
                    }
                }
            }
        }
    }
    //вывод результатов
    public void ShowResults(){
        float sumForPerson;

        System.out.println("Добавленные товары:");
        //System.out.print( personPurchases.nameOfPurchases );    //вывод общей строки наименования товаров
        System.out.print( namePriceOfPurchases ); //вывод общей строки наименования товаров + цена

        if( numPeopleOfGroup > 0){
            sumForPerson = sumOfPurchases / (float)numPeopleOfGroup ;    //сумма на каждого
            System.out.println( String.format("Общая сумма: %.2f ", sumOfPurchases) + createStrRub(sumOfPurchases) ); //вывод суммы
            System.out.println( String.format("Сумма на каждого: %.2f ", sumForPerson) + createStrRub(sumForPerson) ); //вывод суммы
        }
        else System.out.print( "Сумма не определена" ); //вывод суммы

        System.out.print("Press any key for exit: ");
        consoleScanner.next();   //пауза на ввод любого символа
    }
    // метод создания окончания суммы: x0,x5,x6,x7,x8,x9,x11 - рублей; 1-рубль; x2,x3,x4-рубля
    public static String createStrRub(float sumReal){
        int sumInt,sumInt100;

        String retString;
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
