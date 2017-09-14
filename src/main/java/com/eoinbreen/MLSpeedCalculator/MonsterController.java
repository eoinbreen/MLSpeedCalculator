package com.eoinbreen.MLSpeedCalculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {

    private static final String template = "Hello, %s!";
    MonsterParser mp=new MonsterParser();
    

    @RequestMapping("/monster")
    public Monster monster(@RequestParam(value="name", defaultValue="Type a monsters name to see its stats") String name ) {
        return new Monster(name);
    }
    
    
}
/*public String monster(@RequestParam(value="name", defaultValue="Type a monsters name to see its stats") String name ) {
    	return mp.parseMonsters(name);
    }*/