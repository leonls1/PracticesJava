package model.businessLogic.entity.incidentStatePatterns;

import model.businessLogic.entity.Incident;

public class Finished implements State{
    public Finished(){

    }
    public void toStarted(Incident incident) {
        System.out.println("This is not possible");
    }

    public void toInProgress(Incident incident) {
        System.out.println("This is not possible");
    }

    public void toFinished(Incident incident) {
        System.out.println("It's already finished");
    }
}
