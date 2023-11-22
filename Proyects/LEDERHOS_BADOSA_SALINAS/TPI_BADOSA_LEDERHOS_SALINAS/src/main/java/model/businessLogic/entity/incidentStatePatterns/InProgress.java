package model.businessLogic.entity.incidentStatePatterns;

import model.businessLogic.entity.Incident;

public class InProgress implements State {
    public InProgress(){

    }

    public void toStarted(Incident incident) {
            System.out.println("This is not possible");
    }

    public void toInProgress(Incident incident) {
        System.out.println("It's already in progresss");
    }

    public void toFinished(Incident incident) {
            incident.setState(new Finished());
    }
}
