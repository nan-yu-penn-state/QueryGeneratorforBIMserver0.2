/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import json.airflow.AHS;
import json.airflow.Wall;
import json.airflow.Zone;

/**
 *
 * @author Nan Yu
 */
public class AirflowInfo {
    private Map<String, Zone> zones = new HashMap<String, Zone>();
    private Map<String, Wall> walls = new HashMap<String, Wall>();

    /**
     * @return the zones
     */
    public Map<String, Zone> getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(Map<String, Zone> zones) {
        this.zones = zones;
    }

    /**
     * @return the walls
     */
    public Map<String, Wall> getWalls() {
        return walls;
    }

    /**
     * @param walls the walls to set
     */
    public void setWalls(Map<String, Wall> walls) {
        this.walls = walls;
    }
}
