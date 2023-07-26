public class Dealer {
   static void sells (Person gamer, int money) {
       if (money <= gamer.getGold()){
           gamer.setGold(gamer.getGold() - money);
           gamer.setHealth(gamer.getHealth() + money);
           System.out.println(String.format("На лечение потрачено  %d золота. Ваш уровень здоровья   %d ",money, gamer.getHealth()));
       }else{
           System.out.println(String.format("Невозможно потратить %d золота если у Вас его %d ",money, gamer.getGold()));
       }
   }
}
