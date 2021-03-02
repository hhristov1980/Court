package main.citizens;

import main.jurists.Layer;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Defendant extends Citizen{
    private HashSet<Layer> layers;

    public Defendant(String name, String address, int age) {
        super(name, address, age);
        layers = new HashSet<>();
    }

    public void addLayer(Layer l){
        layers.add(l);
    }


    @Override
    protected CitizenType validateType() {
        return CitizenType.DEFENDANT;
    }


    public HashSet<Layer> getLayers() {
        return layers;
    }
    public void answerQuestions(PrintStream ps){
        ps.println(getName()+" answer");
    }
}
