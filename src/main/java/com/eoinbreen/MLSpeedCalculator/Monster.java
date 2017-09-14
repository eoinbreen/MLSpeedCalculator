package com.eoinbreen.MLSpeedCalculator;

import org.springframework.util.StringUtils;

public class Monster {
	
    private String name;
    private int speed;
    private String spdstr;
    private MonsterParser mp;
    private String stats;

    public Monster(String name) {
    	mp=new MonsterParser();
        this.name = name;
        stats=mp.parseMonsters(name);
        spdstr=stats.substring(stats.indexOf("SPEED")+51 , stats.indexOf("SPEED") + 56);
        //StringUtils.remove(spdstr, '_');
        spdstr=removeChr(spdstr, ',');
        speed=Integer.parseInt(spdstr);
        
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
    
    public static String removeChr(String str, char x){
        StringBuilder strBuilder = new StringBuilder();
        char[] rmString = str.toCharArray();
        for(int i=0; i<rmString.length; i++){
            if(rmString[i] == x){

            } else {
                strBuilder.append(rmString[i]);
            }
        }
        return strBuilder.toString();
    }
}
