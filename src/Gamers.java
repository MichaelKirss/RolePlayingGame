public abstract class Gamers implements Fighter {
    private String name;
    private int health;
    private int power;
    private int strength;
    private int dexterity;
    private int experience;
    private int gold;

    public Gamers(String name, int health, int power, int strength, int dexterity, int experience, int gold) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = experience;
        this.gold = gold;
    }

    @Override
    public int attack() {
        return getRandomValue();
    }

    private int getRandomValue() {
        int rnd = (int) (Math.random() * 30);
        System.out.println(rnd);
        return rnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {

        return String.format("%s здоровье:%d", name, health);
    }
}

