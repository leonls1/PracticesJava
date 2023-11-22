package model.businessLogic.entity.incidentStatePatterns;

import model.businessLogic.entity.Incident;

public class Started implements State {
     public Started(){

     }
    public void toStarted(Incident incident) {
        System.out.println("It's already started");

    }
    public void toInProgress(Incident incident) {
         incident.setState(new InProgress());
    }

    public void toFinished(Incident incident) {
            System.out.println("This is not possible");
    }
}
