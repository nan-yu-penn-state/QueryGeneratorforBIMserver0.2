/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json.airflow;

import java.util.List;

/**
 *
 * @author Nan Yu
 */
public class Wall {

    private Double elevation;   //"elevation":1.5,
    private String name;    //"name":"North 1"
    private Double area;    //"area":36,
    private Double azimuth;     //"azimuth":0
    private List<String> zones; //"zones":["Zone 1"]

    /**
     * @return the elevation
     */
    public Double getElevation() {
        return elevation;
    }

    /**
     * @param elevation the elevation to set
     */
    public void setElevation(Double elevation) {
        this.elevation = elevation;
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
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the azimuth
     */
    public Double getAzimuth() {
        return azimuth;
    }

    /**
     * @param azimuth the azimuth to set
     */
    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    /**
     * @return the zones
     */
    public List<String> getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(List<String> zones) {
        this.zones = zones;
    }
}
