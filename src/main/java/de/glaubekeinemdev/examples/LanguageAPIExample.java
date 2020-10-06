package de.glaubekeinemdev.examples;

import de.glaubekeinemdev.servercore.universal.language.Language;
import de.glaubekeinemdev.servercore.universal.language.LanguageManager;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LanguageAPIExample {

    /**
     *
     * The ServerCore has its own language system
     * so we support about 7 different languages
     * If you develop a plugin you have to use this system!
     *
     * All messages are structured like:
     * MessageName - Message
     *
     */
    public void languageExample(final Player player) {
        // Get a message with the right language for the player... very easy
        String message = LanguageManager.getInstance().getMessage( "messageName", player );


        // Register own messages. If you have more messages to register at once use the method LanguageManager#registerMany
        // First of all define a name of your plugin
        LanguageManager.getInstance().registerPluginName( "MyAwesomePlugin" );


        // Register one message. Define a custom name for your message, then define the message entry
        // and the language in which the original message was written
        LanguageManager.getInstance().registerMessage( "testMessage", "Hello this is a test", Language.ENGLISH );


        // If you got many messages create a String, String HashMap and insert each message,
        // starts with the messageName and the message entry
        final HashMap<String, String> messages = new HashMap<>();

        messages.put( "Hello-lukas", "Hello I am Lukas" );
        messages.put( "Hello-tim", "Hello I am Tim" );
        messages.put( "Hello-franz", "Hello I am Franz" );
        messages.put( "Hello-alex", "Hello I am Alex" );

        // Register many messages
        LanguageManager.getInstance().registerMany( messages, Language.ENGLISH );
    }


}
