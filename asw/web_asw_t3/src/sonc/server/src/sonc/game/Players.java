package sonc.server.src.sonc.game;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class Players extends java.lang.Object implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Players() {

	}



	boolean register(String nick, String password) {
		return false;

	}

	boolean updatePassword(String nick, String oldPassword, String newPassword) {
		return false;

	}

	boolean authenticate(String nick, String password) {
		return false;

	}

	Player getPlayer(String name) {
		return null;

	}

	List<String> getPlayersNamesWithShips() {
		return null;

	}
}
