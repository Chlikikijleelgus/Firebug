package me.chlikikijleelgus.firebug;

import java.io.File;
import java.io.IOException;
import org.bukkit.util.config.Configuration;
 
public class Config {
        // Static fields loaded from the configuration file
        public static boolean MessagePlayer;
        public static String Message;
        public static boolean LogUsers;
 
        /**
         * Load the configuration file
         * @param config - Configuration to load
         */
        public static void load(Configuration config) {
        	config.load(); //Load the Configuration file into memory.
               
                // Check if it's empty, if so set default, if not, load it
                if(config.getBoolean("MessagePlayer", true)) {
                        config.setProperty("MessagePlayer", "true");
                        MessagePlayer = config.getBoolean("MessagePlayer", true);
                }else{ MessagePlayer = config.getBoolean("MessagePlayer", false);}
                
                if(config.getBoolean("LogUsers", true)) {
                    config.setProperty("LogUsers", "true");
                    LogUsers = config.getBoolean("LogUsers", true);
            }else{ LogUsers = config.getBoolean("LogUsers", false);}
               
                // Check if it's empty, if so set default, if not, load it
                if(config.getString("Message")==null) {
                        config.setProperty("Message", "Burn for your destructive actions!");
                        Message = config.getString("Message");
                }
                else {
                        Message = config.getString("Message");
                }
               
                config.save();
 
        }
 
        /**
         * Setup and load the configuration file and hashmap
         * @param directory
         * @param configFile
         */
        public static void configSetup(File directory) {
                File configFile;
                // Make the folder and configuration file if they don't exist.
                if (!directory.exists()) {
                        directory.mkdirs();
                        System.out.println("[Firebug] No Firebug directory found, creating...");
                }
 
                configFile = new File(directory, "config.yml");
                if (!configFile.exists()) {
                        try {
                                configFile.createNewFile();

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
 
                        // Make the new configuration file
                        Configuration config = new Configuration(new File(
                                        directory, "config.yml"));
                        System.out.println("[Firebug] No config.yml found, creating...");
                        config.save();
 
                        // Load the configuration file
                        load(config);
                } else {
                        // Load the configuration file
                        load(new Configuration(new File(directory, "config.yml")));
                }
               
        }

}
