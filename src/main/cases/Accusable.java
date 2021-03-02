package main.cases;

import main.jurists.Layer;

import java.io.PrintStream;
import java.util.HashSet;

public interface Accusable {

    public void askQuestions(PrintStream ps,Case c);
    public String getName();
    public HashSet<Layer> getLayers();
    public void addLayer(Layer l);
}
