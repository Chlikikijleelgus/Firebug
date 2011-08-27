package me.chlikikijleelgus.firebug;

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
			if(Config.LogUsers){Firebug.log.info("[Firebug]"+systime()+player.getName()+" Used flint and steel.");}//If allowed, print name and time to console.
		}	
	} 

	public String systime() {//A system-time return method
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
	    return sdf.format(cal.getTime());}
}
