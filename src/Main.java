import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static Gamers player = null;
    private static Game battleScene = null;
    public static void main(String[] args) {
            br = new BufferedReader(new InputStreamReader(System.in));
            battleScene = new Game();
            System.out.println("Введите имя игрока:");
            //Далее ждем ввод от пользователя
            try {
                command(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    private static void command(String string) throws IOException {

        if (player == null) {
            player = new Person(
                    string, 100,20,20,0, 0, 0);
            System.out.println(String.format("Игрок %s ", player.getName()));

            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println(String.format("Сколько хотите потратить на поправку здоровья? У Вас %d золота",player.getGold()));
                System.out.println("Введите количество");
                try {

                    int countGolds = Integer.parseInt(br.readLine());
//                    System.out.println("Вы хотите потратить "+ countGolds);
                    Dealer.sells((Person) player, countGolds);
                    printNavigation();
                    command(br.readLine());

                }catch (NumberFormatException e){
                    System.out.println("Введено нечисловое значение. Попробуйте снова");
                    printNavigation();

                }
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }
    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! У игрока %d опыта и %d золота, а также  %d единиц здоровья.", player.getName(), player.getExperience(), player.getGold(), player.getHealth()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });

    }
    interface FightCallback {
        void fightWin();
        void fightLost();
    }
    private static Gamers createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblins(
                "Гоблин", 50,10,10,100, 20,15);
        else return new Skelets(
                "Скелет",25,20,20,100,10,10);
    }

}