package me.SpicyMeme.py;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static Main instance;
	public static Main instance(){
		return instance;
	}
	
	FileConfiguration config = getConfig();
	  public void onEnable(){
		  Bukkit.getServer().getPluginManager().registerEvents(new rtp(), this);
		  getCommand("Setrtp").setExecutor(new rtp());
	  	  getLogger().info("onEnable");
		  File config = new File(getDataFolder() + File.separator + "config.yml");
		  if(!config.exists()) {
		  getLogger().info("Creating new config file...");
	   	  getConfig().options().copyDefaults(true);
		  saveDefaultConfig();
		  }
	  }
	  
	  public void  onDisable(){
		  getLogger().info("onDisable");
	  }
	  public void LocToConfig(String args, Location loc){
		  config.set("locations." + args + ".world", loc.getWorld().getName());
		  config.set("locations." + args + ".x", loc.getX());
		  config.set("locations." + args + ".y", loc.getY());
		  config.set("locations." + args + ".z", loc.getZ());
		  saveConfig();
	  }

}
