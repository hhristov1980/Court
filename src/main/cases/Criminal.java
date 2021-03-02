package main.cases;

import main.citizens.Defendant;
import main.jurists.Judge;

public class Criminal extends Case{
    public Criminal(Judge judge, Accusable accuser, Defendant defendant) {
        super(judge, accuser, defendant);
    }

    @Override
    protected CaseType validateType() {
        return CaseType.CRIMINAL;
    }

    @Override
    protected int validateNumberJury() {
        return 13;
    }
}
