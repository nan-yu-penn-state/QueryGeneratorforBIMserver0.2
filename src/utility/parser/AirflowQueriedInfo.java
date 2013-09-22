/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.parser;

import java.util.ArrayList;
import java.util.List;
import json.airflow.Level;

/**
 *
 * @author Nan Yu
 */
public class AirflowQueriedInfo extends AirflowInfo {
    private List<Level> levels = new ArrayList<Level>();
    private String name;
    private String description;

    /**
     * @return the levels
     */
    public List<Level> getLevels() {
        return levels;
    }

    /**
     * @param levels the levels to set
     */
    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
