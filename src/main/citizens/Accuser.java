package main.citizens;

import main.cases.Accusable;
import main.cases.Case;
import main.jurists.Layer;

import java.io.PrintStream;
import java.util.HashSet;

public class Accuser extends Defendant implements Accusable {


    public Accuser(String name, String address, int age) {
        super(name, address, age);

    }

    @Override
    protected CitizenType validateType() {
        return CitizenType.ACCUSER;
    }


    @Override
    public void askQuestions(PrintStream ps, Case c) {
        ps.println("The layer of "+getName()+" is asking questions");
        for (int i = 0; i<3; i++){
            ps.println(getName()+" asked "+c.getDefendant().getName());
            c.getDefendant().answerQuestions(ps);
        }
        for(Witness w: c.getWitnesses()){
            for(int i = 0; i<2; i++) {
                ps.println(getName() + " asked " + w.getName());
                w.answerQuestions(ps);
            }
        }

    }

    @Override
    public HashSet<Layer> getLayers() {
        return super.getLayers();
    }
}
