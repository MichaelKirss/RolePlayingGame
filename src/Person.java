public class Person extends Gamers{
    int skill;
    int experience;
    int cash;
    public Person(String name, int health, int power, int skill, int experience, int cash){
        super(name, health, power);
        this.skill = skill;
        this.experience = experience;
        this.cash = cash;
    }

}
