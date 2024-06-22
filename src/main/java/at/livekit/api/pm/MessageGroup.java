package at.livekit.api.pm;

import java.util.List;
import java.util.UUID;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "livekit_message_groups")
public class MessageGroup {
    
    @DatabaseField(id = true)
    private UUID uuid;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<MessagingGroupMember> members;

    @DatabaseField(width = 64)
    private String name;

    @DatabaseField
    private UUID owner;

    protected MessageGroup(){}

    public MessageGroup(UUID owner, String name) {
        this.owner = owner;
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public UUID getUUID() {
        return uuid;
    }

    public List<UUID> getMembers() {
        return members.stream().map(MessagingGroupMember::getPlayerUUID).toList();
    }

    public List<MessagingGroupMember> getMemberObjects() {
        return members.stream().toList();
    }

    public void addMember(MessagingGroupMember member) {
        members.add(member);
    }

    public void removeMember(MessagingGroupMember member) {
        members.remove(member);
    }

    public static MessageGroup createGroup(UUID owner, String name) {
        return new MessageGroup(owner, name);
    }

    @DatabaseTable(tableName = "livekit_message_group_members")
    protected static class MessagingGroupMember {

        @DatabaseField(generatedId = true)
        private int id;

        @DatabaseField
        private UUID playerUuid;

        @DatabaseField(foreign = true, foreignAutoRefresh = true)
        private MessageGroup group;

        protected MessagingGroupMember(){}

        public MessagingGroupMember(MessageGroup group, UUID playerUuid) {
            this.playerUuid = playerUuid;
            this.group = group;
        }

        public UUID getPlayerUUID() {
            return playerUuid;
        }

        public MessageGroup getGroup() {
            return group;
        }
    }
}
