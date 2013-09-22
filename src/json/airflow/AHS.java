/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json.airflow;

/**
 *
 * @author Nan Yu
 */
public class AHS {
    private String name;
    private Double outdoorAirPercent;

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
     * @return the outdoorAirPercent
     */
    public Double getOutdoorAirPercent() {
        return outdoorAirPercent;
    }

    /**
     * @param outdoorAirPercent the outdoorAirPercent to set
     */
    public void setOutdoorAirPercent(Double outdoorAirPercent) {
        this.outdoorAirPercent = outdoorAirPercent;
    }
}
