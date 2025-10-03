public class Main {
    public static void main(String[] args) {
        InputUtils inputUtils = new InputUtils();
        Race race = new Race();

        Auto auto1 = new Auto(
                inputUtils.requestAutoName(Auto.CarNumbers.NUMBER1.getNum()),
                inputUtils.requestAutoSpeed()
        );

        Auto auto2 = new Auto(
                inputUtils.requestAutoName(Auto.CarNumbers.NUMBER2.getNum()),
                inputUtils.requestAutoSpeed()
        );

        Auto auto3 = new Auto(
                inputUtils.requestAutoName(Auto.CarNumbers.NUMBER3.getNum()),
                inputUtils.requestAutoSpeed()
        );

        Auto fastestCar = race.getFastestCar(auto1, auto2, auto3);

        System.out.println("Самая быстрая машина: " + fastestCar.name);
    }
}