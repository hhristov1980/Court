package main.jurists;

public class Judge extends Jurist{
    public Judge(String name, int yearsOfExperience, int numberOfCases) {
        super(name, yearsOfExperience, numberOfCases);
    }

    @Override
    protected int validateYears(int yearsOfExperience) {
        if(yearsOfExperience>=5){
            return yearsOfExperience;
        }
        return 5;
    }

    @Override
    protected int validateCases(int numberOfCases) {
        if(numberOfCases>0){
            return numberOfCases;
        }
        return 5;
    }

    @Override
    protected JuristPosition validatePosition() {
        return JuristPosition.JUDGE;
    }
}
