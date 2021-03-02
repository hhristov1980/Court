package main.jurists;

import main.cases.Case;
import main.citizens.Witness;

import java.io.PrintStream;

public class Layer extends Jurist {
    public Layer(String name, int yearsOfExperience, int numberOfCases) {
        super(name, yearsOfExperience, numberOfCases);
    }

    @Override
    protected int validateYears(int yearsOfExperience) {
        if(yearsOfExperience>0){
            return yearsOfExperience;
        }
        return 1;
    }

    @Override
    protected int validateCases(int numberOfCases) {
        if(numberOfCases>=10){
            return numberOfCases;
        }
        return 10;
    }

    public void askQuestions(PrintStream ps, Case c) {
        ps.println("The layer of "+c.getDefendant().getName()+" is asking questions");
        for(Witness w: c.getWitnesses()){
            for(int i = 0; i<5; i++) {
                ps.println(getName() + " asked " + w.getName());
                w.answerQuestions(ps);
            }
        }

    }

    @Override
    protected JuristPosition validatePosition() {
        return JuristPosition.LAYER;
    }
}
