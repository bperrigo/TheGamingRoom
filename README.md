# TheGamingRoom

This multi-user game application has the ability to have multiple instances of the game running at once, each having players and teams. Often, individual instances of the game will prompt users to save the new game being played. To ensure there are no duplicate instances of the game at the point of saving, the application checks to ensure that the name chosen by the user is not already in use.

To meet this requirement, I used an iterator pattern in the application. This will ensure that when a user starts a new game to play, the application checks every instance of the game already in play to determine if the new name chosen by the user is in use.
