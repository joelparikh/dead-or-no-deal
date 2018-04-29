/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dealornodeal;

import java.util.ArrayList;

/**
 *
 * @author 333656254
 */
public class Game {

    Case [] cases = new Case [24];
    ArrayList<Double> money = new ArrayList<Double>();
    private int casePicked;
    private int roundCount = 0;
    private int yourCase;
    boolean [] moneyRemaining = new boolean [24]; 



    public Game () {
        money.add(.01);
        money.add(1.00);
        money.add(5.00);
        money.add(10.00);
        money.add(50.00);
        money.add(100.00);
        money.add(200.00);
        money.add(300.00);
        money.add(500.00);
        money.add(750.00);
        money.add(1000.00);
        money.add(5000.00);
        money.add(10000.00);
        money.add(25000.00);
        money.add(50000.00);
        money.add(75000.00);
        money.add(100000.00);
        money.add(200000.00);
        money.add(300000.00);
        money.add(400000.00);
        money.add(500000.00);
        money.add(25.00);
        money.add(750000.00);
        money.add(1000000.00);

        for(int i = 24; i > 0; i--) {
            int index = (int)(Math.random()*i);
            this.cases[24-i] = new Case(this.money.get(index));  
            money.remove(index);
        }
        
        for (int i = 0; i < 24; i++) {
            moneyRemaining[i] = true;
        }

    }
    
    public void pickCase (int pickCase) {
        this.casePicked = pickCase;
        moneyRemaining[pickCase] = false;
        this.roundCount++;
    }
    
    public void yourCase (int yourCase) {
      this.yourCase = yourCase;
      this.roundCount++;
    }
    
    public double getMoney () {
        return cases[this.casePicked].getMoney();
    }
    
    public double getMoney (int caseNum) {
        return cases[caseNum].getMoney();
    }
    
    public int getRound () {
        return this.roundCount;
    }
    
    public int getYourCase () {
      return this.yourCase;
    }
    
    public boolean getRemaining (int caseNum) {
        return moneyRemaining[caseNum];
    } 
    
    public double makeOffer() {
        double total = 0;
        int casesRemaining = 0;
        for (int i = 0; i < 24; i++) {
            if (getRemaining(i)) {
                total += getMoney(i);
                casesRemaining++;
            }
        }
        return total/casesRemaining;
    }
    
    public boolean isRemaining (double money) {
        for (int i = 0; i < 24; i++) {
            if (this.cases[i].getMoney() == money && this.moneyRemaining[i] == false) {
                    return false;
             }
         }
        return true;
        }
    
    public int caseRemaining() {
        int caseRemaining = 0;
        for (int i = 0; i < 24; i++) {
            if(moneyRemaining[i] && i != this.yourCase) {
                caseRemaining = i;
            }
        }
        return caseRemaining;
    }
    
    public void exchangeCase (int newCase) {
        this.yourCase = newCase;
    }
    }




