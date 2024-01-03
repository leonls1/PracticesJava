package com.andrius.petclinic.helpers;

/**
 * Code created by Andrius on 2020-09-28
 */
public enum ScenePath {

    HOME("/view/dashboard.fxml"),
    VISITS("/view/visitDash.fxml"),
    VETS("/view/vetsDash.fxml"),
    PETS("/view/petDash.fxml"),
    SEARCH("/view/search.fxml"),
    ADD_PET("/view/addPet.fxml"),
    ADD_VET("/view/addVet.fxml"),
    ADD_VISIT("/view/addVisit.fxml"),
    LOGIN("/view/login.fxml")
    ;

    private final String path;

    private ScenePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
