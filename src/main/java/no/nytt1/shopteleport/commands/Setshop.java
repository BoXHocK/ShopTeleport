package no.nytt1.shopteleport.commands;

import no.nytt1.shopteleport.Messages;
import no.nytt1.shopteleport.ShopTeleport;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Setshop extends JavaPlugin implements CommandExecutor {


	private final ShopTeleport plugin; // The global variable.
	
	public Setshop(ShopTeleport plugin) // A method without a return type and the classes name is a constructor
    {
        this.plugin = plugin; //Save the given reference in our global variable.
    }
	
	


	public boolean isSafe(Location loc){
	    World world = loc.getWorld();
	    double y = loc.getY();
	    //Check for suffocation
	    loc.setY(y+1);
	    Block block1 = world.getBlockAt(loc);
	    loc.setY(y+2);
	    Block block2 = world.getBlockAt(loc);
	    if(!(block1.getTypeId()==0||block2.getTypeId()==0)){
	        return false;//not safe, suffocated
	    }
	    //Check for lava/void
	    for(double i=128;i>-1;i--){
	        loc.setY(i);
	        Block block = world.getBlockAt(loc);
	        if(block.getTypeId()!=0){
	            if(block.getType()==Material.LAVA){
	                return false;//not safe, lava above or below you
	            }else{
	                if(!(block.getType()==Material.TORCH||block.getType()==Material.REDSTONE_TORCH_ON||block.getType()==Material.REDSTONE_TORCH_OFF||block.getType()==Material.PAINTING)){
	                    if(i<y){
	                        loc.setY(-1);//set y to negitive 1 to end loop, we hit solid ground.
	                    }
	                    //Check for painful fall
	                    if((y-i)>10){
	                        return false;//would fall down at least 11 blocks = painful landing...
	                }else{
	                	return true;
	                }
	            }
	            }
	        }else{
	            if(i==0){
	                if(block.getTypeId()==0){
	                    return false;//not safe, void
	                }else{
	                	return true;
	                }
	            }
	        }
	    }
		return false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("shopteleport.setshop")){
		String playername1 = player.getName().toLowerCase();
        Location loc = player.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();
        World world = loc.getWorld();
        
		if (isSafe(loc)==true){
			plugin.getConfig().set("shops." + playername1 + ".x", Double.valueOf(x));
			plugin.getConfig().set("shops." + playername1 + ".y", Double.valueOf(y));
			plugin.getConfig().set("shops." + playername1 + ".z", Double.valueOf(z));
			plugin.getConfig().set("shops." + playername1 + ".yaw", Double.valueOf(yaw));
            plugin.getConfig().set("shops." + playername1 + ".pitch", Double.valueOf(pitch));
            plugin.getConfig().set("shops." + playername1 + ".world", world.getName());
            
            plugin.saveConfig();
player.sendMessage(ChatColor.GREEN + "Your shop has been set");
return true;
        }else if (isSafe(loc)==false){
        	player.sendMessage(Messages.colours(plugin.getConfig().getString("messages.location-not-safe")));
        	return true;
        }
	}else{
		player.sendMessage(Messages.colours(plugin.getConfig().getString("messages.no-permission")));
		return true;
	}
		return false;
	}

}
