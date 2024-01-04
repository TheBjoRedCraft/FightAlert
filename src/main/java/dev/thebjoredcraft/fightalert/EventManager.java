package dev.thebjoredcraft.fightalert;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventManager implements Listener {
    @EventHandler
    public void onFight(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player damager && event.getEntity() instanceof Player target){
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.hasPermission("fightalert.getalert")){
                    player.sendMessage(MiniMessage.miniMessage().deserialize(FightAlert.getInstance().getConfig().getString("AlertMessage", "").replace("%damager%", damager.getDisplayName()).replace("%target%", target.getDisplayName())));
                }
            }
        }
    }
}
