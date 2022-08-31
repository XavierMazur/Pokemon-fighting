import java.util.Random;

// Abstract class that describes any Pokémon
public abstract class Pokemon {
    // Pokemon stats
    private String name;
    private Gender gender;
    private int level;
    private int health;
    private int  maxHealth;
    private double healthMultiplicator;
    private Type type;
    //TODO: ArrayList of attacks

    // Attributs for game mechanics
    private final int maxMulti = 25;
    private final int minMulti = -25;

    private static final Random RANDOM = new Random();

    public Pokemon(){}
    public Pokemon(String name, int level, Type type) {
        // Give a given name or use the class name (classic pokémon name)
        if (name.isEmpty())
            this.name = this.getClass().getSimpleName();
        else
            this.name = name;

        // Give basic info
        this.gender = getRandomGender();
        this.type = type;
        //TODO: Add exception
        this.level = level;

        // Give a slightly randomized health (Health = 4*Lvl + Multi)
        this.healthMultiplicator = getRandomizedMultiplicator();
        this.maxHealth = (int)Math.floor((this.level * 4) + ((this.level * 4) * healthMultiplicator));
        this.health = this.maxHealth;

    }

    // Get a random gender
    private Gender getRandomGender() {
        return Gender.values()[RANDOM.nextInt(Gender.values().length)];
    }

    // Get a randomized multiplicator (as a percentage, ex: 0.20)
    private double getRandomizedMultiplicator() {
        return (double) (RANDOM.nextInt((maxMulti - minMulti) + 1) + minMulti) / 100;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\nName: " + name
                + "\nGender: " + gender
                + "\nType: " + type
                + "\nLevel: " + level
                + "\nHealth: " + health + " / " + maxHealth
                + "\nHealth multiplicator: " + healthMultiplicator;
    }

    public enum Gender {
        FEMALE, MALE
    }

    public enum Type {
        FIRE, GRASS, WATER
    }
}
