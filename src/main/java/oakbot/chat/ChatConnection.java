package oakbot.chat;

import java.io.IOException;
import java.util.List;

/**
 * Represents a connection to a chat room.
 * @author Michael Angstadt
 */
public interface ChatConnection {
	/**
	 * Logs into the chat room. This should be called before any other method.
	 * @param email the login email
	 * @param password the login password
	 * @throws IOException if there's a problem logging in
	 * @throws IllegalArgumentException if the login credentials are bad
	 */
	void login(String email, String password) throws IllegalArgumentException, IOException;

	/**
	 * Posts a message to a chat room.
	 * @param room the ID of the chat room
	 * @param message the message to post
	 * @throws IOException if there's a problem posting the message
	 */
	void sendMessage(int room, String message) throws IOException;

	/**
	 * Gets the most recent messages from a chat room.
	 * @param room the chat room ID
	 * @param count the number of messages to retrieve
	 * @return the messages
	 * @throws IOException if there's a problem retrieving the messages
	 */
	List<ChatMessage> getMessages(int room, int count) throws IOException;

	/**
	 * Gets the messages that were posted since the last time the chat room was
	 * polled for new messages (i.e. since the last time this method was
	 * called).
	 * @param room the room ID
	 * @return the new messages
	 * @throws IOException if there's a problem retrieving the messages
	 */
	List<ChatMessage> getNewMessages(int room) throws IOException;
}
