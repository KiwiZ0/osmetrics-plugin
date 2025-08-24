package osmetrics.plugin;

import lombok.ToString;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.util.Text;

import java.time.Clock;
import java.time.ZonedDateTime;

@ToString
public class ChatEntry {

    private final ZonedDateTime timestamp;
    private final long id;
    private final ChatMessageType chatType;
    private final String chatName;
    private final String sender;
    private final int rank;
    private final String message;

    private ChatEntry(long id, ChatMessageType chatType, String chatName, String sender, int rank, String message) {
        this.id = id;
        this.chatType = chatType;
        this.timestamp = ZonedDateTime.now(Clock.systemUTC());
        this.chatName = chatName;
        this.sender = sender;
        this.rank = rank;
        this.message = message;
    }

    public static ChatEntry from(long messageId, ChatMessageType chatType, String chatName, String sender, int rank, ChatMessage chatMessage) {
        return new ChatEntry(messageId, chatType, Text.standardize(chatName), sender, rank, chatMessage.getMessage());
    }
}
