package main.jurists;

import java.util.Objects;

public abstract class Jurist {
    private static int uniqueId = 1;
    private int juristId;
    private String name;
    private JuristPosition position;
    private int yearsOfExperience;
    private int numberOfCases;


    public Jurist(String name, int yearsOfExperience, int numberOfCases){
        if(name.length()>0){
            this.name = name;
        }
        this.position = validatePosition();
        this.yearsOfExperience = validateYears(yearsOfExperience);
        this.numberOfCases = validateCases(numberOfCases);
        juristId = uniqueId++;

    }

    public void increaseNumberOfCases(){
        numberOfCases++;
    }

    protected abstract int validateYears(int yearsOfExperience);
    protected abstract int validateCases(int numberOfCases);
    protected abstract JuristPosition validatePosition();

    public enum JuristPosition{
        JUDGE, JUROR, LAYER, PROSECUTOR
    }

    public String getName() {
        return name;
    }

    public JuristPosition getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jurist jurist = (Jurist) o;
        return juristId == jurist.juristId && yearsOfExperience == jurist.yearsOfExperience && numberOfCases == jurist.numberOfCases && name.equals(jurist.name) && position == jurist.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(juristId, name, position, yearsOfExperience, numberOfCases);
    }
}
