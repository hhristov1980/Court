package main;

import main.citizens.Accuser;
import main.citizens.Defendant;
import main.court.Court;
import main.jurists.Judge;
import main.jurists.Layer;
import main.jurists.Prosecutor;
import main.util.Randomizer;

public class Demo {
    public static void main(String[] args) {
        Court court = new Court("IT Court");
        for (int i = 0; i<10; i++){
            String judgeName = "Judge "+(i+1);
            int yearsOfExperience = Randomizer.getRandomInt(5,20);
            int numberOfCases = Randomizer.getRandomInt(0,50);
            court.addJudge(new Judge(judgeName,yearsOfExperience,numberOfCases));
            String prosecutorName = "Prosecutor "+(i+1);
            yearsOfExperience = Randomizer.getRandomInt(10,20);
            numberOfCases = Randomizer.getRandomInt(0,50);
            court.addProsecutor(new Prosecutor(prosecutorName,yearsOfExperience,numberOfCases));
        }
        for (int i = 0; i<20; i++){
            String layerName = "Layer "+(i+1);
            int yearsOfExperience = Randomizer.getRandomInt(5,20);
            int numberOfCases = Randomizer.getRandomInt(0,50);
            court.addLayer(new Layer(layerName,yearsOfExperience,numberOfCases));
            String defendantName = "Defendant "+(i+1);
            String address  = "Sofia" + Randomizer.getRandomInt(5,20);
            int age = Randomizer.getRandomInt(18,80);
            court.addDefendant(new Defendant(defendantName,address,age));
            String accuserName = "Accuser "+(i+1);
            address  = "Sofia" + Randomizer.getRandomInt(5,20);
            age = Randomizer.getRandomInt(18,80);
            court.addAccuser(new Accuser(accuserName,address,age));
        }
        court.work();

    }
}
