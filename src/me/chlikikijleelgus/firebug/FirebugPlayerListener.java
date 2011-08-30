package me.chlikikijleelgus.firebug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class FirebugPlayerListener extends PlayerListener {
	public static Firebug plugin;
	private Player player;
	private Block block;
	public FirebugPlayerListener(Firebug instance) {plugin = instance;}
	
	public void onPlayerInteract (PlayerInteractEvent event){
		player=event.getPlayer();//Gets the player
		block=event.getClickedBlock();
		if(player.hasPermission("firebug.canusefire")|player.isOp()){//if player has the node or is an op, do:
		//Empty for now. Here if something needs to be done to allowed players.
			}else{
				if(event.getMaterial() == Material.FLINT_AND_STEEL) {//Check if item in hand is Flint&Steel
					player.setFireTicks (2000);//Sets the player on fire for 2000 ticks (Overkill?)
					if(Config.MessagePlayer){player.sendMessage(Config.Message);}// If allowed, send message specified in config.
					if(Config.LogUsers){Firebug.log.info("[Firebug]"+systime()+player.getName()+" Used flint and steel on "+block.getType()+" @ ("+block.getX()+","+block.getY()+","+block.getZ()+")"+ "in World: "+ block.getWorld());}//If allowed, print name, time, material, and coordinates to console.
			
			}
		}	
	} 

	public String systime() {//A system-time return method
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
	    return sdf.format(cal.getTime());}
}
