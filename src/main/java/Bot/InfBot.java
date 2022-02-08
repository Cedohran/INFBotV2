package Bot;

import Bot.DiscordData.BotMessage;
import Bot.DiscordData.DiscordRole;
import Bot.Response.BotResponse;
import Bot.Response.BotResponseBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class InfBot {
    public static ArrayList<DiscordRole> ROLE_COLLECTION = new ArrayList();
    public static ArrayList<BotMessage> MESSAGE_COLLECTION = new ArrayList();
    public static Message ROLE_MESSAGE;
    public static Guild INF_SERVER;
    public static net.dv8tion.jda.api.JDA JDA;
    private static Writer LOG_WRITER;

    public BotResponse executeSlashCommand(String commandName, List<OptionMapping> options) throws UnknownCommandException {
        BotResponse botResponse = new BotResponse();
        if(commandName.equals("echo")) {
            botResponse = BotResponseBuilder.stringResponse(options.get(0).getAsString());
        } else {
            throw new UnknownCommandException("No such comment");
        }
        return botResponse;
    }
}
