package main.cases;

import main.citizens.Accuser;
import main.citizens.Defendant;
import main.jurists.Judge;

public class Civil extends Case{
    public Civil(Judge judge, Accusable accuser, Defendant defendant) {
        super(judge, accuser, defendant);
    }

    @Override
    protected CaseType validateType() {
        return CaseType.CIVIL;
    }

    @Override
    protected int validateNumberJury() {
        return 3;
    }
}
