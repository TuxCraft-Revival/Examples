package de.glaubekeinemdev.examples;

import de.glaubekeinemdev.servercore.bukkit.events.BukkitGameServerPerformanceInfoEvent;
import de.glaubekeinemdev.servercore.bukkit.events.BukkitNetworkPlayerBanEvent;
import de.glaubekeinemdev.servercore.bukkit.events.BukkitNetworkPlayerChangeLanguageEvent;
import de.glaubekeinemdev.servercore.universal.network.punishments.NetworkBan;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventExample implements Listener {

    /**
     *
     * The ServerCore has many custom events
     * That are just Bungeecord and Spigot events
     * Some examples below
     *
     */


    /**
     *
     * Each server has its own heartbeat and each server is communicating
     * with another server the event below will be fired when a gameserver
     * sends a heartbeat with its current informations
     *
     */
    @EventHandler
    public void handlePerformanceUpdate( final BukkitGameServerPerformanceInfoEvent event) {

        // Get the average player ping
        event.getAveragePing();

        // Get the current online count
        event.getOnlineCount();

        // Get the current ticks per second
        event.getTps();

        // Get the servername
        event.getServerName();

        // Get the cpu usage in percent
        event.getCpuUsagePercent();
    }

    /**
     *
     * This event will be fired if a player changes his language
     *
     */
    @EventHandler
    public void handleLanguageChange(final BukkitNetworkPlayerChangeLanguageEvent event) {

        // Get the new language
        event.getLanguage();

        // Get the uuid of the player of the change
        event.getUuid();
    }

    /**
     *
     * This event will be fired if a player got banned from the network
     *
     */
    @EventHandler
    public void handlePlayerBan( final BukkitNetworkPlayerBanEvent event ) {

        NetworkBan networkBan = event.getNetworkBan();

        // Get the ban reason
        networkBan.getReason();

        // Get the duration
        networkBan.getDuration();

        // Get the proof if available
        networkBan.getProof();

        // Get the banned player
        event.getNetworkPlayer();
    }

}
