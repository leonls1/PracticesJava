package model.businessLogic.entity.incidentStatePatterns;

import model.businessLogic.entity.Incident;

public interface State {
    
    void toStarted(Incident incident);
    
    void toInProgress(Incident incident);
    
    void toFinished(Incident incident);
}
