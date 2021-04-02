package dev.imfound.voidtp.Listeners;

import dev.imfound.voidtp.VoidTP;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class VoidTPFirstMethod implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.getLocation().getBlockY() <= -8) {
            VoidTP.getInstance().reloadConfig();
            String x = VoidTP.getInstance().getConfig().getString("Spawn.x");
            String y = VoidTP.getInstance().getConfig().getString("Spawn.y");
            String z = VoidTP.getInstance().getConfig().getString("Spawn.z");
            int xint = Integer.parseInt(x);
            int yint = Integer.parseInt(y);
            int zint = Integer.parseInt(z);
            float pint = Float.parseFloat(VoidTP.getInstance().getConfig().getString("Spawn.p"));
            float yaint = Float.parseFloat(VoidTP.getInstance().getConfig().getString("Spawn.ya"));
            Location loc = new Location(p.getWorld(), xint, yint, zint);
            loc.setPitch(pint);
            loc.setYaw(yaint);
            p.teleport(loc);
        }
    }

}
