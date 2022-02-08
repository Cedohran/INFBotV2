package Bot.DiscordData;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;

public class DiscordRole {
    private final long roleID;
    private final long channelID;
    private final String iconID;
    private final String name;
    private final String unicode;
    private final Guild server;

    public DiscordRole(Guild server, String name, long roleID, long channelID, String iconID) {
        this.server = server;
        this.name = name;
        this.roleID = roleID;
        this.channelID = channelID;
        this.iconID = iconID;
        unicode = iconID.substring(2);
    }

    @Override
    public String toString() {
        return(name+";"+roleID+";"+channelID+";"+iconID);
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public long getRoleID() {
        return roleID;
    }

    public long getChannelID() {
        return channelID;
    }

    public String getIconID() {
        return iconID;
    }

    public String getUnicode() {
        return unicode;
    }
}
