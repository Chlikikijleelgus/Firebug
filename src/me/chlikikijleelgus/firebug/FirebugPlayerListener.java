package me.chlikikijleelgus.firebug;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class FirebugPlayerListener extends PlayerListener {
	public static Firebug plugin;
	private Player player;
	public FirebugPlayerListener(Firebug instance) {plugin = instance;}
	
	public void onPlayerInteract (PlayerInteractEvent event){
		player=event.getPlayer();//Gets the player
		if(event.getMaterial() == Material.FLINT_AND_STEEL) {//Check if item in hand is Flint&Steel
			player.setFireTicks (2000);//Sets the player on fire for 2000 ticks (Overkill?)
			if(Config.MessagePlayer){player.sendMessage(Config.Message);}// If allowed, send message specified in config.
			if(Config.LogUsers){log(player.getName());}//If allowed, write to file.
		}	
	} 
	public void log(String pname) {
		  File logfile=new File(Config.DataFolder, "FirebugLog.txt");
		  if (!logfile.exists()){//if file does not exist, do this.
			  	try{
			  		logfile.mkdirs();
			  		//make file
			  		logfile.createNewFile();
			  	} catch (IOException e) {e.printStackTrace();}
		  	}
			  try {
				  BufferedWriter fout = new BufferedWriter(new FileWriter(logfile,true));
				  fout.write(systime()+pname+"Used flint and steel.");//write the time, player name, then message with newline
				  fout.newLine();// prints a new line, \n for windows \r for macs \r\n for linux
				  fout.close();
			  } catch (IOException e) {e.printStackTrace();}}
	public String systime() {//A system-time return method
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
	    return sdf.format(cal.getTime());}
}
