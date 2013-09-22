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
public class Zone {
    private String name;
    private Double volume;
    private String level;
    private List<ReturnAir> returnAir;
    private List<SupplyAir> supplyAir;

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
     * @return the volume
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the returnAir
     */
    public List<ReturnAir> getReturnAir() {
        return returnAir;
    }

    /**
     * @param returnAir the returnAir to set
     */
    public void setReturnAir(List<ReturnAir> returnAir) {
        this.returnAir = returnAir;
    }

    /**
     * @return the supplyAir
     */
    public List<SupplyAir> getSupplyAir() {
        return supplyAir;
    }

    /**
     * @param supplyAir the supplyAir to set
     */
    public void setSupplyAir(List<SupplyAir> supplyAir) {
        this.supplyAir = supplyAir;
    }
}
