package co.uk.robuxtrex.servervision.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener 
{
    // Method is called whenever someone joins the server!
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        // Give the player the Potion Effect.
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 255));
    }
}
