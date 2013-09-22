/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.parser;

import java.util.ArrayList;
import java.util.List;
import json.airflow.AHS;

/**
 *
 * @author Nan Yu
 */
public class AirflowMissingInfo extends AirflowInfo {
    private List<AHS> ahsList = new ArrayList<AHS>();
    

    /**
     * @return the ahsList
     */
    public List<AHS> getAhsList() {
        return ahsList;
    }

    /**
     * @param ahsList the ahsList to set
     */
    public void setAhsList(List<AHS> ahsList) {
        this.ahsList = ahsList;
    }
}
