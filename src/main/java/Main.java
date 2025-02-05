public class Main {
    public static void main(String[] args) {
        System.out.println("*-------------------------------------------------------------------------*");
        System.out.println(" Добро пожаловать на гонку '24 часа Ле-Мана!'");
        System.out.println(" Вам необходимо ввести название и скорость автомобиля (от 1 до 250 км/ч).");
        System.out.println(" В гонке будут соревноваться три участника.");
        System.out.println(" После чего мы узнаем победителя гонки!");
        System.out.println("*-------------------------------------------------------------------------*\n");

        CompetitorsCreation competitorsCreation = new CompetitorsCreation();
        competitorsCreation.inputCompetitors();
        new Race().printWinner(competitorsCreation.getCars());
    }
}
