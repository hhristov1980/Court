package main.citizens;

import java.io.PrintStream;

public class Witness extends Citizen{
    public Witness(String name, String address, int age) {
        super(name, address, age);
    }

    @Override
    protected CitizenType validateType() {
        return CitizenType.WITNESS;
    }

    public void answerQuestions(PrintStream ps){
        ps.println(getName()+" answer");
    }
}
