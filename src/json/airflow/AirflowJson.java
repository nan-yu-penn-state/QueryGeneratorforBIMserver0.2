/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json.airflow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Nan Yu
 */
public class AirflowJson {
    private List<AHS> ahs = new ArrayList<AHS>();
    private List<Zone> zones = new ArrayList<Zone>();
    private List<Level> levels = new ArrayList<Level>();
    private List<Wall> walls = new ArrayList<Wall>();
    private String name;
    private String description;

    /**
     * @return the ahsList
     */
    public List<AHS> getAhs() {
        return ahs;
    }

    /**
     * @param ahsList the ahsList to set
     */
    public void setAhs(List<AHS> ahs) {
        this.ahs = ahs;
    }

    /**
     * @return the zones
     */
    public List<Zone> getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

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
     * @return the walls
     */
    public List<Wall> getWalls() {
        return walls;
    }

    /**
     * @param walls the walls to set
     */
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
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
