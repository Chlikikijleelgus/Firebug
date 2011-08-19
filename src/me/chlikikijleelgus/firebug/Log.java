package me.chlikikijleelgus.firebug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.entity.Player;

public class Log {
	  public static String systime() {
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("[MM/dd/yyyy HH:mm:ss]");
		    return sdf.format(cal.getTime());}
	  public static void log(Player player) {
			try {
				String pname =player.getName();//get the name of the player passed into log
			    BufferedWriter fout = new BufferedWriter(new FileWriter(new File()+File.separator+"log.txt",true));
			    fout.write(systime()+pname+"Used flint and steel.\n");//write the time, player name, then message with newline
			    fout.close();
			} catch (IOException e) {e.printStackTrace();}
	  } 

}
