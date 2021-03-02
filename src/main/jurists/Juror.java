package main.jurists;

import java.util.Random;

public class Juror extends Jurist{
    public Juror(String name, int yearsOfExperience, int numberOfCases) {
        super(name, yearsOfExperience, numberOfCases);
    }

    @Override
    protected int validateYears(int yearsOfExperience) {
        if(yearsOfExperience>=0){
            return yearsOfExperience;
        }
        return 0;
    }

    @Override
    protected int validateCases(int numberOfCases) {
        if(numberOfCases>=0){
            return numberOfCases;
        }
        return 0;
    }

    @Override
    protected JuristPosition validatePosition() {
        return JuristPosition.JUROR;
    }

    public boolean vote(){
        return new Random().nextBoolean();
    }
}
