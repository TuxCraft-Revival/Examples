package de.glaubekeinemdev.examples;

import de.glaubekeinemdev.servercore.ServerCore;
import de.glaubekeinemdev.servercore.universal.NetworkPlayer;

import java.util.UUID;
import java.util.function.Consumer;

public class PlayerAPIExamples {

    /**
     *
     * The ServerCore has its own backend system and it also saves many stuff
     * about players
     *
     * In the example below you can see how you are able to work with it
     *
     */
    public void playerExample( final UUID uuid ) {

        // Fetch the NetworkPlayer, the NetworkPlayer could be offline to
        ServerCore.getInstance( ).getPlayer( uuid, new Consumer<NetworkPlayer>( ) {
            public void accept( NetworkPlayer networkPlayer ) {

                // If the player is null he never joined our server
                if(networkPlayer == null)
                    return;

                // To add coins use this method below
                networkPlayer.addCoins( 1000L );

                // To send a actionbar or title you can use the methods below
                // The ServerCore searches for the player and sends the information to the players server
                // So you are able to send actionbars through the Bungee
                networkPlayer.sendActionBar( "Hello" );
                networkPlayer.sendTitle( "Hey", "Hey" );

                // The NetworkPlayer could be offline or online to check if he is online use this method
                networkPlayer.isOnline();

                // Update the NetworkPlayer after every changes to apply changes
                networkPlayer.update();
            }
        } );
    }

    /**
     *
     * With the ServerCore each Player has its metadata you are able to work with it
     * and save personalised informations easily in the database
     *
     *
     */
    public void playerMetaDataExample(final UUID uuid) {

        // First of all fetch the player
        ServerCore.getInstance().getPlayer( uuid, networkPlayer -> {

            // Check if the player is registered
            if(networkPlayer == null)
                return;

            // You can just define a simple property for game stats e.g. kills or deaths
            networkPlayer.getPlayersStats().addProperty( "bedwars", "kills", 0 );

            // The you can fetch these information and work with it
            double kills = networkPlayer.getPlayersStats().getProperty( "bedwars", "kills" );

            // To update the property you can use the replace method but if you will add the property again it will replaced too
            networkPlayer.getPlayersStats().replaceProperty( "bedwars", "kills", kills + 1 );


            // You want to save more than just a double... no problem you are able to insert whole objects
            final TestObject testObject = new TestObject( "Lukas", 17, true );
            networkPlayer.getPlayersStats().insertObject( "Testobject", testObject );

            // To fetch the object just use this method
            TestObject fetchedObject = (TestObject) networkPlayer.getPlayersStats().getObject( "Testobject" );


            // IMPORTANT: Don't forget to update the player to apply changes
            networkPlayer.update();
        } );

    }

    private class TestObject {

        private String name;
        private int age;
        private boolean alive;

        public TestObject( String name, int age, boolean alive ) {
            this.name = name;
            this.age = age;
            this.alive = alive;
        }
    }

}
