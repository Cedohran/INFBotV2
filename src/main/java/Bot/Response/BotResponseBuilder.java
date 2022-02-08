package Bot.Response;

public class BotResponseBuilder {
    public static BotResponse stringResponse(String content) {
        BotResponse botResponse = new BotResponse();
        botResponse.type = BotResponseType.STRING;
        botResponse.content = content;
        return botResponse;
    }
}
