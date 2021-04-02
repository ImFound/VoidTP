package dev.imfound.voidtp.Commands;

import dev.imfound.voidtp.VoidTP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoidTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player && cmd.getName().equalsIgnoreCase("voidtp")) {
            if(p.hasPermission("voidtp.execute")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("setspawn")) {
                        if(p.hasPermission("voidtp.setspawn")) {
                            String x = String.valueOf(p.getLocation().getBlockX());
                            String y = String.valueOf(p.getLocation().getBlockY());
                            String z = String.valueOf(p.getLocation().getBlockZ());
                            String pl = String.valueOf(p.getLocation().getPitch());
                            String ya = String.valueOf(p.getLocation().getYaw());
                            VoidTP.getInstance().getConfig().set("Spawn.x", x);
                            VoidTP.getInstance().getConfig().set("Spawn.y", y);
                            VoidTP.getInstance().getConfig().set("Spawn.z", z);
                            VoidTP.getInstance().getConfig().set("Spawn.p", pl);
                            VoidTP.getInstance().getConfig().set("Spawn.ya", ya);
                            VoidTP.getInstance().saveConfig();
                            VoidTP.getInstance().reloadConfig();
                            p.sendMessage("§b• §7I set the coordinates, §bX: " + x + "§f, §bY: " + y + "§f, §bZ: " + z);
                        } else {
                            p.sendMessage("§b• §fYou don't have the permission!");
                        }
                    } else {
                        p.sendMessage("§b• §fThis arg dosen't exist");
                        p.sendMessage("§b• §7Running §b§n§oVoidTP 1.0§f by §b§n§oImFound");
                        p.sendMessage("§7» §b/voidtp setspawn");
                    }
                } else {
                    p.sendMessage("§b• §7Running §b§n§oVoidTP 1.0§f by §b§n§oImFound");
                    p.sendMessage("§7» §b/voidtp setspawn");
                }
            } else {
                p.sendMessage("§b• §7Running §b§nVoidTP 1.0§f by §bImFound");
            }
        }
        return false;
    }
}
