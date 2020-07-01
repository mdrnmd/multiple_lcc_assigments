package sonc.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import sonc.server.src.sonc.battle.*;
import sonc.client.ManagerService;
import sonc.game.Players;
import sonc.shared.*;

public class Manager implements Serializable, ManagerService {

	private static final long serialVersionUID = 1L;
	Players allPlayers;
	static Manager instance;
	static File store;

	private Manager() {
		allPlayers = new Players();
		instance = null;
	}

	public static File getPlayersFile() {
		return store;
	}

	public static void setPlayersFile(java.io.File managerFile) {
		store = managerFile;
	}

	public static Manager getInstance() throws SoncException {
		if(instance != null) {
			return instance;
		}
		else {
			try{
				instance = restore();
				return instance;
			}
			catch(Exception e) {
				instance = new Manager();
				throw new SoncException();
			}
		}
	}

	private static Manager restore() {
		// TODO Auto-generated method stub
		Manager tmp;
		try {
			FileInputStream fileStream = new FileInputStream(store);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);
			tmp = (Manager) objStream.readObject();  
			objStream.close();
		}
		catch(Exception e) {
			tmp = null;
		}
		return tmp;  
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#register(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean register(String userId, String password)
			throws SoncException {
		return false;	
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#updatePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updatePassword(String nick, String oldPassword, String newPassword)
			throws SoncException {
		return false;
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String nick, String password) {
		return false;
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#getCurrentCode(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCurrentCode(String nick,String password)
			throws SoncException {
		return password;	
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#buildShip(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void buildShip(String nick,String password,String code)
			throws SoncException {

	}

	List<String> getPlayersNamesWithShips() {
		return allPlayers.getPlayersNamesWithShips();
	}

	/* (non-Javadoc)
	 * @see sonc.game.ManagerService#battle(java.util.List)
	 */
	@Override
	public Movie battle(List<String> nicks) {
		World currentWorld = new World();
        List<Ship> ships = new LinkedList<Ship>();
        for(String name : getPlayersNamesWithShips()) {
            ships.add(allPlayers.getPlayer(name).instanceShip());
        }  
        return currentWorld.battle(ships);
	}

	void reset() {
		instance = new Manager();
	}
}