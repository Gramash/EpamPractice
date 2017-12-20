package animuigra.cards;

import animuigra.BasicCardStates;
import animuigra.EvolveCardInterface;

public class WickedFairyCard extends CardTemplate implements BasicCardStates, EvolveCardInterface {

    public WickedFairyCard() {
        super(6, 6, "Wicked Fairy Carabosse");

    }

    @Override
    public int getHealthPoints() {
        return health;
    }

    @Override
    public int getAttackPoints() {
        return attack;
    }

    @Override
    public BasicCardStates evolveCard() {
        System.out.println("\nEvolving " + name + " : health = " + health + " attack= " + attack);
        health += 2;
        attack += 2;
        System.out.println(name + " has been evolved, new stats are: attack = " + attack + " health = " + health);
        return this;
    }

    @Override
    public BasicCardStates basicCardStats() {
        System.out.println("Wicked Fairy: attack = " + attack + " health = " + health);
        return this;
    }

}
