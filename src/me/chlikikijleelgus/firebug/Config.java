package me.chlikikijleelgus.firebug;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
        // Static fields loaded from the configuration file
		public static boolean MessagePlayer;
        public static String Message;
        public static boolean LogUsers;
        public static boolean ReplaceSteel;
        public static int ReplaceWithID;
        public static boolean RemoveFire;

        /**
         * Load the configuration file
         * @param config - Configuration to load
         */
        static FileConfiguration config;
 
        public static void load(Plugin plugin) {
        	config = plugin.getConfig();
        	config.options().copyDefaults(true);
            plugin.saveDefaultConfig();

             //If these are not set in the config file, it uses the second argument, and inserts it into the config file.
             MessagePlayer = config.getBoolean("MessagePlayer", true);
             Message = config.getString("Message","Burn for your destructive actions!");
             ReplaceSteel = config.getBoolean("ReplaceSteel", true);
             ReplaceWithID = config.getInt("ReplaceWithID", 0);
             LogUsers = config.getBoolean("LogUsers", true);
             RemoveFire = config.getBoolean("RemoveFire", true);

            
            plugin.saveConfig();
        }
}