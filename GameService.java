package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	
	private static List<Game> games = new ArrayList<Game>(); // list of active games

	
	private static long nextGameId = 1; // holds next game identifier

	private static long nextPlayerId = 1; // holds next player identifier

   
    private static long nextTeamId = 1; // holds next team identifier

	
	
	
	private static GameService service = null; // created private var to track instance of GameService
	
	private GameService() { // default constructor
		
	}
	
	/*
	 Singleton pattern is a design pattern which restricts a class to instantiate its multiple objects.
	 Only one instance of the class is created and is used when only one single instance of a class is 
	 required to control actions. In this case there is only one instance of the GameService class that exists
	 in the memory at a time.
	 */
	
		public static GameService getInstance() { //does GameService exist?
			if (service == null) {
				service = new GameService(); // creates new instance in heap memory
				System.out.println("New Game Service Created.");
			}
			else {
				System.out.println("Game Service already instantiated."); // if already exists, lets user know
			}
			return service;
		}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
	Iterator<Game> gamesIterator = games.iterator(); // instance iterator of type Game
	
	while (gamesIterator.hasNext()) { // iterate over list of games
		Game gameInstance = gamesIterator.next(); // set local game var to next item in list
		
		if (gameInstance.getName().equalsIgnoreCase(name)) { // does game already exist?
			return gameInstance; // if game already exists
		}
	}
		
	
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		

	Iterator <Game> gamesIterator = games.iterator(); // instance iterator
	
	/*
	 The iterator pattern is used to access the elements of a collection object in a 
	 sequential way without exposing its underlying representation.
	*/
	
	while (gamesIterator.hasNext()) { // iterate over list of games
		Game gameInstance = gamesIterator.next(); // set local game var to next item in list
		if (gameInstance.getId() == id) { // does game already exist?
			return gameInstance; // if game already exists call to return game instance
		}
	}
	
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		
		
	Iterator<Game> gamesIterator = games.iterator(); // instance iterator
		
	while (gamesIterator.hasNext()) { // iterate over games list
		Game gameInstance = gamesIterator.next(); // set local game var to next item in list
		if (gameInstance.getName().equalsIgnoreCase(name)) { // does game already exist?
				game = gameInstance; // if game already exists, return game instance
			}
			
		}
		
		return game;
	}

	
	public int getGameCount() { // returns number of active games
		return games.size();
	}
	
    public long getNextPlayerId() { // returns next player
	    return nextPlayerId;
    }

    
    public long getNextTeamId() { // returns the next team
        return nextTeamId;
    }
}

