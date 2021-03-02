package main.cases;

import main.citizens.Accuser;
import main.citizens.Defendant;
import main.citizens.Witness;
import main.jurists.Judge;
import main.jurists.Juror;
import main.jurists.Layer;
import main.util.Randomizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class Case {
    private static int uniqueId = 1;
    private CaseType type;
    private String caseId;
    private Judge judge;
    private Accusable accuser;
    private Defendant defendant;
    private int juryNumber;
    private HashSet<Juror> jury;
    private HashSet<Witness> witnesses;
    private boolean isGuilty;
    private ArrayList<Boolean> votes;
    private int sentenceLength;

    public Case(Judge judge, Accusable accuser, Defendant defendant){
        this.type = validateType();
        this.judge = judge;
        this.caseId = type+" "+uniqueId++;
        this.accuser = accuser;
        this.defendant = defendant;
        this.juryNumber = validateNumberJury();
        this.isGuilty = false;
        jury = new HashSet<>();
        witnesses = new HashSet<>();
        votes = new ArrayList<>();

        for(int i = 0; i<juryNumber; i++){
            String jurorName = "Juror "+(i+1);
            int yearsOfExperience = Randomizer.getRandomInt(5,20);
            int numberOfCases = Randomizer.getRandomInt(0,50);
            addJuror(new Juror(jurorName,yearsOfExperience,numberOfCases));
        }
        for(int i = 0; i<3; i++){
            String witnessName = "Witness "+(i+1);
            String address  = "Sofia" + Randomizer.getRandomInt(5,20);
            int age = Randomizer.getRandomInt(18,80);
            addWitness(new Witness(witnessName,address,age));
        }

    }

    public void addJuror(Juror j){
        jury.add(j);
    }
    public void addWitness(Witness w){
        witnesses.add(w);
    }

    protected abstract CaseType validateType();
    protected abstract int validateNumberJury();


    public void proceed(){
        File f = new File(LocalDate.now()+caseId+".txt");
        try(PrintStream ps = new PrintStream(f)){
            ps.println("Chronology of "+caseId);
            ps.println("Judge - Honorable "+judge.getName());
            if(type.equals(CaseType.CIVIL)){
                ps.println(accuser.getName() + " against "+ defendant.getName());
                ps.println("List of accuser layers:");
                for(Layer l: accuser.getLayers()){
                    ps.println(l.getName());
                }
            }
            else {
                ps.println("State against "+ defendant.getName());
                ps.println("Prosecutor: "+accuser.getName());
            }

            ps.println("List of defendant layers:");
            for(Layer l: defendant.getLayers()){
                ps.println(l.getName());
            }
            ps.println("List of jury:");
            for(Juror j: jury){
                ps.println(j.getName());
            }
            if(type.equals(CaseType.CIVIL)){
                for(Layer l: accuser.getLayers()){
                    l.askQuestions(ps,this);
                }
            }
            else {
                accuser.askQuestions(ps,this);
            }
            for(Layer l: defendant.getLayers()){
                l.askQuestions(ps,this);
            }
            juryVote(ps);
            judgeDecision(ps);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }

    private void juryVote(PrintStream ps){
        boolean vote;
        ps.println("Jury is voting: ");
        for(Juror j: jury){
            vote = j.vote();
            votes.add(vote);
            String text = (vote)? "Guilty":"Not Guilty";
            ps.println(j.getName()+" votes "+text);
        }
    }

    private void judgeDecision(PrintStream ps){
        int guiltyVotes = 0;
        for (Boolean b: votes){
            if(b){
                guiltyVotes++;
            }
        }
        if(guiltyVotes>juryNumber/2){
            isGuilty=true;
        }
        String text = (isGuilty)? "Guilty":"Not Guilty";
        ps.println("According to the jury, the defendant "+defendant.getName()+" is "+text);
        if(isGuilty){
            sentenceLength = Randomizer.getRandomInt(3,40);
            ps.println("Sentence: "+sentenceLength+" years in jail");
        }
    }

    public HashSet<Witness> getWitnesses() {
        return witnesses;
    }

    public Defendant getDefendant() {
        return defendant;
    }

    public enum CaseType{
        CIVIL, CRIMINAL
    }
}



