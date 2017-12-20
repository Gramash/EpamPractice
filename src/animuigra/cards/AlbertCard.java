package animuigra.cards;

import animuigra.BasicCardStates;
import animuigra.EvolveCardInterface;

public class AlbertCard extends CardTemplate implements BasicCardStates, EvolveCardInterface{


    public AlbertCard() {
        super(5, 3, "Albert");
    }

    @Override
    public int getHealthPoints() {
        System.out.println("Albert health = " + health);
        return health;
    }

    @Override
    public int getAttackPoints() {
        System.out.println("Albert attack = " + attack);
        return attack;
    }

    @Override
    public BasicCardStates evolveCard() {
        System.out.println("Evloving Albert: health = " + health + " attack= " + attack);
        health += 2;
        attack += 2;
        System.out.println("Albert has been evolved, new stats are: attack = " + attack + " health = " + health);
        return this;
    }

    @Override
    public BasicCardStates basicCardStats() {
        System.out.println("Albert: attack = " + attack + " health = " + health);
        return this;
    }


  }
