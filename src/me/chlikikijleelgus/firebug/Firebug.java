package me.chlikikijleelgus.firebug;

import java.util.logging.Logger;
import me.chlikikijleelgus.firebug.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Firebug extends JavaPlugin {
	
	static Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
			/* Register a new player listener */
			getServer().getPluginManager().registerEvents(new PlayerListener(), this);
			
			/* Load the configuration */
			Config.load(this);
		}
	public void onDisable(){}

}
