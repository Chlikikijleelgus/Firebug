package me.chlikikijleelgus.firebug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener{
	@EventHandler(ignoreCancelled=true)
	public void onPlayerInteract (PlayerInteractEvent event)
	{
		Player player = event.getPlayer();//Gets the player
		Block block = event.getClickedBlock();
		
		if(! (player.hasPermission("firebug.canusefire")|player.isOp()) ){// If the user does not have the node and is not an op, 
				if(event.getMaterial() == Material.FLINT_AND_STEEL){//Check if item in hand is Flint&Steel
						player.setFireTicks (2000);//Sets the player on fire for 2000 ticks (Overkill?)
						if(Config.MessagePlayer){player.sendMessage(ChatColor.RED + Config.Message);}// If allowed, send message specified in config.
						if(Config.ReplaceSteel){player.setItemInHand(new ItemStack(Config.ReplaceWithID, 1));}//Takes the ID turns -> material -> item stack, then replaces it with a stack defined
						if(Config.LogUsers){Firebug.log.info("[Firebug]"+systime()+player.getName()+" Used flint and steel on "+block.getType()+" @ ("+block.getX()+","+block.getY()+","+block.getZ()+")"+ "in World: "+ block.getWorld());}//If allowed, print name, time, material, and coordinates to console.
						if(Config.RemoveFire){event.setCancelled(true);}
					}
		}
	} 

	public String systime() {//A system-time return method
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
	    return sdf.format(cal.getTime());}
}
