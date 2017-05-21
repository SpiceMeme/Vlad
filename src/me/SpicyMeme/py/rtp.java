package me.SpicyMeme.py;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class rtp implements Listener, CommandExecutor {
	
	
	
	public boolean abs(CommandSender sender){
		if(sender instanceof Player){
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("setrtp")){
			if (abs(sender)){
				sender.sendMessage("No player and args");
				return true;
			}
		}
			
		Player p = (Player) sender;
		Main.instance.LocToConfig(args[0], p.getLocation());
		p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', "Òî÷êà ïîñòàâëåíà!"));
		return true;
	}
	

}
