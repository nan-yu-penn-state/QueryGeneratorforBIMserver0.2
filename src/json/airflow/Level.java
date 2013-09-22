/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json.airflow;

/**
 *
 * @author Nan Yu
 */
public class Level {
    private String name;
    private Double elevation;
    private Double height;

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
     * @return the height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Double height) {
        this.height = height;
    }
}
