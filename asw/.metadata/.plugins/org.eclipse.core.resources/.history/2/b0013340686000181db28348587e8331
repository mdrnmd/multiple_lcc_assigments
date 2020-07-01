package sonc.game;

import java.util.List;

import sonc.shared.Movie;
import sonc.shared.SoncException;

public interface managerInterface {

	boolean register(String userId, String password) throws SoncException;

	boolean updatePassword(String nick, String oldPassword, String newPassword) throws SoncException;

	boolean authenticate(String nick, String password);

	String getCurrentCode(String nick, String password) throws SoncException;

	void buildShip(String nick, String password, String code) throws SoncException;

	Movie battle(List<String> nicks);

}