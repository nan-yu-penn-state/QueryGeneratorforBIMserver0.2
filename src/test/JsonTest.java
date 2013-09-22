/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utility.parser.AirflowQueriedInfo;

/**
 *
 * @author Nan Yu
 */
public class JsonTest {
    public static void main(String[] args){
        testParsingMissingInfo("C:\\Users\\yiyang\\Desktop\\test\\output\\Ver3.airflow.missing.json");
//        testParsingQueriesInfo("C:\\Users\\yiyang\\Desktop\\test\\output\\Ver3.airflow.queried.json");
    }
    
    public static void testParsingMissingInfo(String fileName){
        
        String json = readFileByLines(fileName);
        JSONObject obj=new JSONObject().fromObject(json);
        System.out.println("ahs: " + obj.get("ahs") + "!!!!!!!!!");
        AirflowJson airflowJson = (AirflowJson)JSONObject.toBean(obj, AirflowJson.class);
	
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
            zone.setReturnAir(returnAirList);
            
            zones.put(zone.getName(), zone);
        }
        
        List<Wall> wallJsonList = airflowJson.getWalls();
        Map<String, Wall> walls = new HashMap<String, Wall>();
        for(int i = 0; i < wallJsonList.size(); i ++){
            Wall wall = (Wall)JSONObject.toBean(JSONObject.fromObject(wallJsonList.get(i)), Wall.class);
            walls.put(wall.getName(), wall);
        }
        
        for(AHS ahs: ahsList){
            System.out.println(ahs.getName() + ": " + ahs.getOutdoorAirPercent());
        }
        for(String zoneName : zones.keySet()){
            System.out.println(zoneName + ": " + zones.get(zoneName).getReturnAir().get(0).getSystem());
        }
        for(String wallName : walls.keySet()){
            System.out.println(wallName + ": " + walls.get(wallName).getAzimuth());
        }
    }
    
    public static void testParsingQueriesInfo(String fileName){
        
        String json = readFileByLines(fileName);
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
        
//        List<Wall> wallJsonList = airflowJson.getWalls();
//        Map<String, Wall> walls = new HashMap<String, Wall>();
//        for(int i = 0; i < wallJsonList.size(); i ++){
//            Wall wall = (Wall)JSONObject.toBean(JSONObject.fromObject(wallJsonList.get(i)), Wall.class);
//            walls.put(wall.getName(), wall);
//        }
        
        for(String zoneName : zones.keySet()){
            System.out.println(zoneName + ": " + zones.get(zoneName).getVolume());
        }
        for(Level level: levelList){
            System.out.println(level.getName() + ": " + level.getElevation());
        }
//        for(String wallName : walls.keySet()){
//            System.out.println(wallName + ": " + walls.get(wallName).getZones().get(0));
//        }
        System.out.println(airflowJson.getName());
        System.out.println(airflowJson.getDescription());
        
        AirflowQueriedInfo airflowQueriedInfo = new AirflowQueriedInfo();
        airflowQueriedInfo.setZones(zones);
        airflowQueriedInfo.setLevels(levelList);
//        airflowQueriedInfo.setWalls(walls);
        
    }
    
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}
