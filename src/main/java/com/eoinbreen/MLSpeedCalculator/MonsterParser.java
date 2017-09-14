package com.eoinbreen.MLSpeedCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonsterParser {

	private static final Logger log = LoggerFactory.getLogger(MonsterParser.class);

	 
	

	public String  parseMonsters(String monster) {

		//String [] monsters = {"Samael_the_Plague_Carrier", "Flamerion"};
	
		//for (int i = 0; i < monsters.length; i++) {
		monster=monster.replace(' ','_');

		String monsterUrl = "http://monster-wiki.com/monster/";
		String result = "";
		
		monsterUrl = monsterUrl + monster;
		log.info("url to parse == " + monsterUrl);

		try {
			URL url = new URL(monsterUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			boolean startParsing = false;
			while ((s = in.readLine()) != null) {
                if(s.equals("<div class=\"responsive-monster-2nd-column\">")){
                	startParsing = true;
                }
                if(startParsing){
                	result+="--------------------------" +s;
                }
            }
        }catch(Exception e){
            log.error("error parsing from website", e);
        }
    //}
		return result;
    }
}
