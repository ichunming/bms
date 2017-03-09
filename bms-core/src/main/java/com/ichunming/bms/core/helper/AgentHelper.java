/**
 * @author ming
 * @date 2017年3月8日 下午3:07:57
 */
package com.ichunming.bms.core.helper;

public class AgentHelper {
    private static String[] pcHeaders=new String[]{
    "Windows 98",
    "Windows ME",
    "Windows 2000",
    "Windows XP",
    "Windows NT",
    "Ubuntu"
    };
    
    public static boolean isPcDevice(String agent) {
    	for(String pcHeader : pcHeaders) {
    		if(agent.toLowerCase().contains(pcHeader.toLowerCase())) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}
