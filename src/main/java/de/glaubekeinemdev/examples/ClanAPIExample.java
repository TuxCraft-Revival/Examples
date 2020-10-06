package de.glaubekeinemdev.examples;

import de.glaubekeinemdev.servercore.ServerCore;

public class ClanAPIExample {

    /**
     *
     * The ServerCore has its own clan system in the
     * example below you will see how you can work with it
     *
     */
    public void clanExample(final String clanName) {

        // Fetch the clan
        ServerCore.getInstance().getClan( clanName, networkClan -> {

            // If the clan is null then it does not exist
            if(networkClan == null)
                return;

            // Then we simply add clan elo points with this method
            networkClan.addClanElo( 1 );

            // Then we want to change the clan name
            networkClan.setName( "NewClanName" );

            // Then we also want to change the clan color
            networkClan.setColorCode( "§c" );

            // Dont forget to update then clan to apply changes
            networkClan.update();
        } );

    }
}
