package DiscordClient;

import net.dv8tion.jda.api.entities.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomActivity implements Runnable{
    DiscordBotClient bot;

    RandomActivity(DiscordBotClient bot) {
        this.bot = bot;
    }

    @Override
    public void run() {
        while(true) {
            List<String> activities = new ArrayList<>();
            activities.addAll(bot.random_activity_list);
            Collections.shuffle(activities);
            String activity = activities.get(0);
            bot.setClientActivity(Activity.ActivityType.PLAYING, activity);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
