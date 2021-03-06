/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndminions;

import dndhoardmanager.Attacks;
import dndhoardmanager.Dice;

/**
 *
 * @author Ryan
 */
public class Badger extends Minions {
       
    public Badger()
    {
        super.hp=2;
        super.ac=2;
        super.name="Badger";
        super.combinations=new Attacks[]{};
    }
    
    public Badger(int wizlv, int proficiency, int acBoost)
    {
        setUp( wizlv,  proficiency,  acBoost);
    }
    
    @Override
    public void setUp(int wizlv, int proficiency, int acBoost)
    {
        super.hp=3;
        super.ac=10+acBoost;
        super.name="Badger";
        
        super.combinations=new Attacks[]
        {                                   //the different Attacks in Attack[] are the different combos that the creature could attack with on their turn, while diff attacks in Attack() will all be done consecutively
            new Attacks(
                new Dice[]{
                    new Dice(20,1,2)},
                new Dice[]{
                    new Dice(2,1,0)},
                new String[]{name + " Bite, Range 5ft"}),
        };
    }
    
    @Override
    /**
     * returns all of the attacks that the minion made, and each attack has 3 parts: attack roll, damage, and description (so things that get special stuff can do so)
     */
    public void decreaseHealth(int amount){super.hp-=amount;}
    @Override
    public boolean shouldRemove(){return(super.isDead());}
}
