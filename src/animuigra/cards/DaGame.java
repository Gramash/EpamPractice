package animuigra.cards;

import animuigra.BasicCardStates;
import animuigra.EvolveCardInterface;

public class DaGame {
    public static void main(String[] args) {
        AlbertCard albert = new AlbertCard();
        WickedFairyCard wickedFairyCarabosse = new WickedFairyCard();
        firstTurn(albert, wickedFairyCarabosse, 4);
        fight(albert,wickedFairyCarabosse);
    }

    static void firstTurn(CardTemplate yourCard, CardTemplate enemysCard, int turn) {
        System.out.println("The game's began! *Trying evolving*");
        BasicCardStates enemysCardStats = (BasicCardStates) enemysCard;
        BasicCardStates yourCardStats = (BasicCardStates) yourCard;
        if (turn >= 4) {
            System.out.println("It's trun " + turn + " now. You can evolve this turn! ");
            yourCardStats = ((EvolveCardInterface) yourCard).evolveCard();
//            enemysCardStats = ((EvolveCardInterface)enemysCard).evolveCard();

        } else {
            System.out.println("It's only turn " + turn + " now.");
            System.out.println("You can not evolve yet. Pull back the reins! *cards stats remain unchanged:*\n");
            yourCardStats = ((EvolveCardInterface) yourCard).basicCardStats();
            enemysCardStats = ((EvolveCardInterface)enemysCard).basicCardStats();
        }

    }
    static void fight (CardTemplate attackingCard, CardTemplate attackedCard) {
        System.out.println("\n" + attackingCard.name + " is attacking " + attackedCard.name);
        attackingCard.health = attackingCard.health - attackedCard.attack;
        attackedCard.health = attackedCard.health-attackingCard.attack;
        System.out.println(attackingCard.name + "'s stats are: attack = " + attackingCard.attack + ", health = " + attackingCard.health);
        System.out.println(attackedCard.name + "'s stats are: attack = " + attackedCard.attack + ", health = " + attackedCard.health);
        if (attackingCard.health <= 0) {
            System.out.println("You've lost your " + attackingCard.name + " card");
        }
        if (attackedCard.health <= 0) {
            System.out.println("You've lost your " + attackedCard.name + " card");
        }
    }

}
