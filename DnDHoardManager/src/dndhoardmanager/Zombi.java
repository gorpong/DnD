/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndhoardmanager;

import java.util.Random;

/**
 *
 * @author Ryan
 */
public class Zombi extends Minions {
    
     public Zombi()
    {
        super.hp=2;
        super.ac=2;
        super.name="Zombi";
        super.combinations=new Attacks[]{};
    }
    
    public Zombi(int wizlv, int proficiency, int acBoost)
    {
        this.setUp( wizlv,  proficiency,  acBoost);
    }
    
     @Override
    public void setUp(int wizlv, int proficiency, int acBoost)
    {
        super.hp=22+wizlv;
        super.ac=8+acBoost;
        super.name="Zombi";
        
        super.combinations=new Attacks[]
        {                                   //the different Attacks in Attack[] are the different combos that the creature could attack with on their turn, while diff attacks in Attack() will all be done consecutively
            new Attacks(
                new Dice[]{
                    new Dice(20,1,3)},
                new Dice[]{
                    new Dice(6,1,1+proficiency)},
                new String[]{name + " Slam, reach 5ft"}),
        };
    }
    
    @Override
    public void decreaseHealth(int amount)
    {
        super.hp-=amount;
        
        //Demand User to tell if died from radiant damage or Critical Hit, give return; if either are true
        
        if(super.hp<=0)
        {
            Random rand = new Random();
            super.hp=((rand.nextInt(20+1)>=(5+amount)) ? 1 : 0);
        }
    }
    @Override
    public boolean shouldRemove(){return(super.isDead());}
    
}