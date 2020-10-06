package de.glaubekeinemdev.examples;

import de.glaubekeinemdev.servercore.ServerCore;
import de.glaubekeinemdev.servercore.bukkit.SpigotCore;
import de.glaubekeinemdev.servercore.universal.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerSkullExample {
    /**
     *
     * The Servercore has its own skin database to avoid mojang requests
     * We are saving each skin information and cache it on all of our servers
     *
     * With this method we will get some informations about the skin by the uuid
     */
    public void skinExample(final UUID uuid) {

        // Try to fetch the skin with this method.
        SpigotCore.getInstance().getSkin( uuid, playerSkin -> {

            // This method will return null if the player with this uuid is not registered on mojang servers
            if(playerSkin == null)
                return;

            // Then we can simply get the skin signature and value
            String signature = playerSkin.getSignature();
            String value = playerSkin.getValue();

            // We are also able to get a player head with PlayerSkin#getItemStack
            // But I prefer the method SpigotCore#getSkullItemStack to get the skull
            ItemStack playerHead = playerSkin.getItemStack();
        } );
    }

}
