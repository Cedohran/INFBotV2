package Listener;

import Bot.InfBot;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InfBotListener extends ListenerAdapter {
    private final InfBot bot;

    public InfBotListener(InfBot bot) {
        this.bot = bot;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(!event.getName().equals("echo")) return;
        event.reply(event.getOption("message").getAsString()).queue();
    }
}
