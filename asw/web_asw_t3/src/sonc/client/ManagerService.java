package sonc.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

import sonc.shared.Movie;
import sonc.shared.SoncException;

public interface ManagerService extends RemoteService {

	boolean register(String userId, String password) throws SoncException;

	boolean updatePassword(String nick, String oldPassword, String newPassword) throws SoncException;

	boolean authenticate(String nick, String password);

	String getCurrentCode(String nick, String password) throws SoncException;

	void buildShip(String nick, String password, String code) throws SoncException;

	Movie battle(List<String> nicks);

}