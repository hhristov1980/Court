package main.court;

import main.cases.Accusable;
import main.cases.Case;
import main.cases.Civil;
import main.cases.Criminal;
import main.citizens.Accuser;
import main.citizens.Citizen;
import main.citizens.Defendant;
import main.jurists.Judge;
import main.jurists.Layer;
import main.jurists.Prosecutor;
import main.util.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Court {
    private String name;
    private HashSet<Judge> judges;
    private HashSet<Prosecutor> prosecutors;
    private HashSet<Layer> layers;
    private HashSet<Case> cases;
    private HashSet<Defendant> defendants;
    private HashSet<Accuser> accusers;

    public Court(String name){
        if(name.length()>0){
            this.name = name;
        }
        judges = new HashSet<>();
        prosecutors = new HashSet<>();
        layers = new HashSet<>();
        cases = new HashSet<>();
        defendants = new HashSet<>();
        accusers = new HashSet<>();
    }

    public void addJudge(Judge j){
        judges.add(j);
    }

    public void addProsecutor(Prosecutor p){
        prosecutors.add(p);
    }

    public void addLayer(Layer l){
        layers.add(l);
    }
    public void addDefendant(Defendant d){
        defendants.add(d);
    }
    public void addAccuser(Accuser a){
        accusers.add(a);
    }


    public void work(){
        ArrayList<Judge> freeJudges = new ArrayList<>();
        freeJudges.addAll(judges);
        ArrayList<Prosecutor> freeProsecutors = new ArrayList<>();
        freeProsecutors.addAll(prosecutors);
        ArrayList<Layer> freelayers = new ArrayList<>();
        freelayers.addAll(layers);
        ArrayList<Defendant> freeDefendants = new ArrayList<>();
        freeDefendants.addAll(defendants);
        ArrayList<Accuser> freeAccusers = new ArrayList<>();
        freeAccusers.addAll(accusers);
        for(int i = 0; i<6; i++){
            Judge judge = freeJudges.remove(Randomizer.getRandomInt(0,freeJudges.size()-1));
            Defendant defendant = freeDefendants.remove(Randomizer.getRandomInt(0,freeDefendants.size()-1));
            Layer layer = freelayers.remove(Randomizer.getRandomInt(0,freelayers.size()-1));
            defendant.addLayer(layer);
            Case.CaseType type = new Random().nextBoolean()? Case.CaseType.CIVIL: Case.CaseType.CRIMINAL;
            switch (type){
                case CRIMINAL:
                    Accusable prosecutor = freeProsecutors.remove(Randomizer.getRandomInt(0,freeProsecutors.size()-1));
                    cases.add(new Criminal(judge,prosecutor,defendant));
                    break;
                case CIVIL:
                    Accusable accuser = freeAccusers.remove(Randomizer.getRandomInt(0,freeAccusers.size()-1));
                    layer = freelayers.remove(Randomizer.getRandomInt(0,freelayers.size()-1));
                    accuser.addLayer(layer);
                    cases.add(new Civil(judge,accuser,defendant));
                    break;
            }
        }
        for(Case c: cases){
            c.proceed();
        }

    }



}
