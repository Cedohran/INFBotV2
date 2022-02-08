package DiscordClient;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.managers.Presence;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class DiscordBotClient {
    private JDA jda;
    private Presence presence;
    private Thread random_activity_thread;

    /**
     * This List is for activities the Bot can do with the RandomActivity method
     */
    public List<String> random_activity_list = new ArrayList<>();

    /**
     * Factory Method to create a bot instance with Discord REST API connection (wrapped in JDA by DV8FromTheWorld)
     * @param token The OAuth token for the Discord Bot Client
     */
    public static DiscordBotClient create(String token) {
        DiscordBotClient bot = new DiscordBotClient();
        try {
            bot.jda = JDABuilder
                    .createDefault(token)
                    .addEventListeners(new ListenerAdapter() {
                        @Override
                        public void onReady(@NotNull ReadyEvent event) {
                            System.out.println("API ready");
                        }
                    })
                    .build();
            bot.jda.awaitReady();
        } catch (LoginException | InterruptedException e) {
            System.err.println("Login failed.");
            e.printStackTrace();
            return null;
        }
        /*bot.jda.updateCommands()
                .addCommands(Commands.slash("echo", "echoes given text").addOption(OptionType.STRING, "message", "message to echo"))
                .queue();*/
        bot.presence = bot.jda.getPresence();
        return bot;
    }

    //================== Client Activity

    /**
     * Sets the Client's activity
     * @param activityType Sets what the Bot is doing (playing, listening ...)
     * @param activity The name of the Bot's activity
     */
    public void setClientActivity(Activity.ActivityType activityType, String activity) {
        presence.setActivity(Activity.of(activityType, activity));
    }

    public void activateRandomActivity(){
        random_activity_thread = new Thread(new RandomActivity(this));
        random_activity_thread.start();
    }

    public void stopRandomActivity(){
        if(random_activity_thread == null) return;
        if(random_activity_thread.isAlive()) random_activity_thread.interrupt();
    }

    public void addEventListener(ListenerAdapter listener) {
        jda.addEventListener(listener);
    }

    public void addSlashCommand(){

    }
}
