package Bot.DiscordData;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public record BotMessage(long messageId, TextChannel channel) {
    @Override
    public String toString() {
        return (messageId + ";" + getChannelId());
    }

    public Message getMessage() {
        return channel.retrieveMessageById(messageId).complete();
    }

    public TextChannel getChannel() {
        return channel;
    }

    public long getMessageId() {
        return messageId;
    }

    public long getChannelId() {
        return channel.getIdLong();
    }
}
