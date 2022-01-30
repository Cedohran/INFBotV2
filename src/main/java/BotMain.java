import Bot.DiscordBot;
import net.dv8tion.jda.api.entities.Activity;

import java.util.List;

public class BotMain {
    public static void main(String[] args) {
        final DiscordBot bot = DiscordBot.create(args[0]);
        bot.setBotActivity(Activity.ActivityType.PLAYING, "test");

        bot.random_activity_list.addAll(List.of("Dark Souls", "Gaming", "Battlefield", "Monster Hunter"));
        bot.activateRandomActivity();
    }
}
