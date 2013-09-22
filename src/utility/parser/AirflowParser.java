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
import json.airflow.AirflowJson;
import json.airflow.Flow;
import json.airflow.Level;
import json.airflow.ReturnAir;
import json.airflow.SupplyAir;
import json.airflow.Wall;
import json.airflow.Zone;
import net.sf.json.JSONObject;
import utility.FileOperator;

/**
 *
 * @author Nan Yu
 */
public class AirflowParser {
    
    public AirflowMissingInfo parseMissingPart(String fileName){
        AirflowMissingInfo airflowMissingInfo = new AirflowMissingInfo();
        FileOperator fileOperator = new FileOperator();
        
        String json = fileOperator.readFileByLines(fileName);
        JSONObject jsonObject =new JSONObject().fromObject(json);
        AirflowJson airflowJson = (AirflowJson)JSONObject.toBean(jsonObject, AirflowJson.class);
        
        List<AHS> ahsJsonList = airflowJson.getAhs();
        List<AHS> ahsList = new ArrayList<AHS>();
        for(int i = 0; i < ahsJsonList.size(); i ++){
            AHS ahs = (AHS)JSONObject.toBean(JSONObject.fromObject(ahsJsonList.get(i)), AHS.class);
            ahsList.add(ahs);
        }
        
        List<Zone> zoneJsonList = airflowJson.getZones();
        Map<String, Zone> zones = new HashMap<String, Zone>();
        for(int i = 0; i < zoneJsonList.size(); i ++){
            Zone zone = (Zone)JSONObject.toBean(JSONObject.fromObject(zoneJsonList.get(i)), Zone.class);
            List<ReturnAir> returnAirJsonList = zone.getReturnAir();
            List<ReturnAir> returnAirList = new ArrayList<ReturnAir>();
            for(int j = 0; j < returnAirJsonList.size(); j ++){
                ReturnAir returnAir = (ReturnAir)JSONObject.toBean(JSONObject.fromObject(returnAirJsonList.get(j)), ReturnAir.class);
                Flow flow = (Flow)JSONObject.toBean(JSONObject.fromObject(returnAir.getFlow()), Flow.class);
                returnAir.setFlow(flow);
                returnAirList.add(returnAir);
            }
            zone.setReturnAir(returnAirList);
            
            List<SupplyAir> supplyAirJsonList = zone.getSupplyAir();
            List<SupplyAir> supplyAirList = new ArrayList<SupplyAir>();
            for(int j = 0; j < supplyAirJsonList.size(); j ++){
                SupplyAir supplyAir = (SupplyAir)JSONObject.toBean(JSONObject.fromObject(supplyAirJsonList.get(j)), SupplyAir.class);
                Flow flow = (Flow)JSONObject.toBean(JSONObject.fromObject(supplyAir.getFlow()), Flow.class);
                supplyAir.setFlow(flow);
                supplyAirList.add(supplyAir);
            }
            zone.setSupplyAir(supplyAirList);
            
            zones.put(zone.getName(), zone);
        }
        
        List<Wall> wallJsonList = airflowJson.getWalls();
        Map<String, Wall> walls = new HashMap<String, Wall>();
        for(int i = 0; i < wallJsonList.size(); i ++){
            Wall wall = (Wall)JSONObject.toBean(JSONObject.fromObject(wallJsonList.get(i)), Wall.class);
            walls.put(wall.getName(), wall);
        }
        
        airflowMissingInfo.setAhsList(ahsList);
        airflowMissingInfo.setZones(zones);
        airflowMissingInfo.setWalls(walls);
        return airflowMissingInfo;
    }
    
    public AirflowQueriedInfo parseQueriedPart(String fileName){
        AirflowQueriedInfo airflowQueriedInfo = new AirflowQueriedInfo();
        FileOperator fileOperator = new FileOperator();
        
        String json = fileOperator.readFileByLines(fileName);
        System.out.println("fileName is " + fileName);
        System.out.println("json is:\n" + json);
        JSONObject jsonObject =new JSONObject().fromObject(json);
        AirflowJson airflowJson = (AirflowJson)JSONObject.toBean(jsonObject, AirflowJson.class);
        
        List<Zone> zoneJsonList = airflowJson.getZones();
        Map<String, Zone> zones = new HashMap<String, Zone>();
        for(int i = 0; i < zoneJsonList.size(); i ++){
            Zone zone = (Zone)JSONObject.toBean(JSONObject.fromObject(zoneJsonList.get(i)), Zone.class);
            zones.put(zone.getName(), zone);
        }
        
        List<Level> levelJsonList = airflowJson.getLevels();
        List<Level> levelList = new ArrayList<Level>();
        for(int i = 0; i < levelJsonList.size(); i ++){
            Level level = (Level)JSONObject.toBean(JSONObject.fromObject(levelJsonList.get(i)), Level.class);
            levelList.add(level);
        }
        
        List<Wall> wallJsonList = airflowJson.getWalls();
        Map<String, Wall> walls = new HashMap<String, Wall>();
        for(int i = 0; i < wallJsonList.size(); i ++){
            Wall wall = (Wall)JSONObject.toBean(JSONObject.fromObject(wallJsonList.get(i)), Wall.class);
            walls.put(wall.getName(), wall);
        }
       
        String name = airflowJson.getName();
        String description = airflowJson.getDescription();
        
        airflowQueriedInfo.setZones(zones);
        airflowQueriedInfo.setLevels(levelList);
        airflowQueriedInfo.setWalls(walls);
        airflowQueriedInfo.setName(name);
        airflowQueriedInfo.setDescription(description);
        return airflowQueriedInfo;
    }
    
    public static void main(String[] args){
        AirflowParser airflowParser = new AirflowParser();
        String fileName = "C:\\Users\\yiyang\\Desktop\\test\\output\\Ver3.airflow.missing.json";
        AirflowMissingInfo airflowMissingInfo = airflowParser.parseMissingPart(fileName);
        System.out.println(airflowMissingInfo.getAhsList());
        System.out.println(airflowMissingInfo.getZones());
        System.out.println(airflowMissingInfo.getWalls());
    }
    
}
