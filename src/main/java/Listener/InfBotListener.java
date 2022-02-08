package Listener;

import Bot.Response.BotResponse;
import Bot.Response.BotResponseType;
import Bot.InfBot;
import Bot.UnknownCommandException;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InfBotListener extends ListenerAdapter {
    private final InfBot infBot;

    //TODO Bot interface abstrahieren
    public InfBotListener(InfBot bot) {
        this.infBot = bot;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        BotResponse response = null;

        try {
            response = infBot.executeSlashCommand(event.getName(), event.getOptions());
        } catch (UnknownCommandException e) {
            e.printStackTrace();
            event.reply("Oopsie whoopsie swomethwing went twewwibly wrong uwu").queue();
        }
        if(response.type == BotResponseType.STRING)
            event.reply(response.content).queue();
    }
}
