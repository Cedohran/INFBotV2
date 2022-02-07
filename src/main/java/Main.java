import Bot.InfBot;
import DiscordClient.DiscordBotClient;
import Listener.InfBotListener;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) {
        final DiscordBotClient client = DiscordBotClient.create(args[0]);
        client.setClientActivity(Activity.ActivityType.PLAYING, "test");

//        client.random_activity_list.addAll(List.of("Dark Souls", "Gaming", "Battlefield", "Monster Hunter"));
//        client.activateRandomActivity();

        client.addEventListener(new InfBotListener(new InfBot()));
    }
}
