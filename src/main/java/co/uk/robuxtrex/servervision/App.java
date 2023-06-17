package co.uk.robuxtrex.servervision;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import co.uk.robuxtrex.servervision.extra.Metrics;

import co.uk.robuxtrex.servervision.listener.DeathListener;
import co.uk.robuxtrex.servervision.listener.JoinListener;

public class App extends JavaPlugin
{
    // Share APP class with other files: Static Getter
    private static App instance; 
    {
        instance = this;
    }
    public static App getInstance() 
    {
        return instance;
    }
    // Method is called when the plugin is originally initialised on Server Startup.
    @Override
    public void onEnable()
    {
        // BSTATS: https://bstats.org/plugin/bukkit/ServerVision/18780
        int pluginId = 18780;
        Metrics metrics = new Metrics(this, pluginId);
        // Log Plugin Start
        getLogger().info("Loaded ServerVision by RobuxTRex!");
        // Initialise the Listeners to renew the Effect
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        // Make a BukkitRunnable (something that iterates every {DURATION} ticks)
        BukkitScheduler runnable = getServer().getScheduler();
        long duration = 0;
        runnable.scheduleSyncRepeatingTask(this, new Runnable() 
        {
            @Override
            public void run()
            {
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 255));
                }
            }
        }, 0L, duration);
    }
    // Method is called when the plugin is disable on Server Termination.
    @Override
    public void onDisable()
    {
        getLogger().info("ServerVision by RobuxTRex has been disabled successfully!");
    }
}
