package me.chlikikijleelgus.firebug;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Firebug extends JavaPlugin {
	
	static Logger log = Logger.getLogger("Minecraft");
	private final FirebugPlayerListener playerListener = new FirebugPlayerListener(this);
	
public void onEnable(){ 
		log.info("[Firebug] v1.2 has been enabled.");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
		Config.configSetup(getDataFolder());
	}	 
public void onDisable(){ 
		log.info("[Firebug] has been disabled.");
	}

}
