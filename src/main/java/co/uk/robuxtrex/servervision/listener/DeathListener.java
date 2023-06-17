package co.uk.robuxtrex.servervision.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeathListener implements Listener 
{
    // Method is called whenever a player dies!
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        // Give the player the Potion Effect.
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 255));
    }
}
