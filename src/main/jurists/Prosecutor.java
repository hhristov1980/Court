package main.jurists;

import main.cases.Accusable;
import main.cases.Case;
import main.citizens.Witness;

import java.io.PrintStream;
import java.util.HashSet;

public class Prosecutor extends Jurist implements Accusable {
    public Prosecutor(String name, int yearsOfExperience, int numberOfCases) {
        super(name, yearsOfExperience, numberOfCases);
    }

    @Override
    protected int validateYears(int yearsOfExperience) {
        if(yearsOfExperience>=10){
            return yearsOfExperience;
        }
        return 10;
    }

    @Override
    protected int validateCases(int numberOfCases) {
        if(numberOfCases>0){
            return numberOfCases;
        }
        return 10;
    }

    @Override
    protected JuristPosition validatePosition() {
        return JuristPosition.PROSECUTOR;
    }


    @Override
    public void askQuestions(PrintStream ps, Case c) {
        ps.println("The "+getPosition()+" is asking questions");
        for (int i = 0; i<5; i++){
            ps.println(getName()+" asked "+c.getDefendant().getName());
            c.getDefendant().answerQuestions(ps);
        }
        for(Witness w: c.getWitnesses()){
            for(int i = 0; i<5; i++) {
                ps.println(getName() + " asked " + w.getName());
                w.answerQuestions(ps);
            }
        }
    }

    @Override
    public HashSet<Layer> getLayers() {
        return null;
    }

    @Override
    public void addLayer(Layer l) {

    }
}
