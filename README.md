# Snap
 ## Instructions for running Snap Game 
- Clone the repo
- Enter the `src` directory of the repo in your terminal
- Run the command `javac Main.java`
- Run the command `java Main`
- Now you can watch a game of snap!
- Alternatively this can be run quite simply using Intellij! Just run the `Main` class.
  
## Design Choices
This task could in theory be completed in one single Java file but it is important to adhere to the principle of 'the seperation of concerns' which object oriented programming enables nquite naturally. A `Player` receives their stack of `playingCards` from an initialized `Deck` that distributes each `Card` appropriately. This also allows for encapsulation, where the `Snap` game only uses the methods made available by the `Player` for them to play the game with no direct access to their stack of cards:
- The `Snap` class is where the game is simulated
- The `Player` class is responsible for managing the player's stack, score and their playing ability.
- The `Deck` class handles the initialization of the deck, shuffling, and dealing cards.
- The `Card` class represents individual cards

## Optional Extras
I chose 2 out of the 5 optional extras given by looking at each option from the perspective of a 'user'. Of course, this application only simulates a game, however thinking about what players would want out of a game of snap is similar to thinking about what a user would like out of an application - and actually developing features based off that. Snap is in priniciple a fast and simple game, hence these decisions were made with that and the 'user's' perspective in mind
- Make your application work with multiple decks of cards. Your application should ask how
many playing card decks to play with at the start. => Snap is inherently a simple and fast game, two players may not want to elongate the game for that long
- Add support for multiple players. Your application should ask how many players are taking part at the start. => it is a nice possibility to play with more people but this will be restricted with how many cards you have. If you only have a single deck of cards and just 4 players the game ends fairly quickly i.e. this would have to be coupled with the first option which I have decided not to implement
- Add support for multiple rounds before a game finishes. Your application should ask the number of rounds to play at the start. =>  it is very common for two people playing to do a ‘best of 3’ or ‘best of 5’ etc., this is a practical and therefore good option to implement
- Add support for a different ‘stop condition’, rather than playing x number of rounds the game should finish when one player has won all the cards in the game. => it’s not exactly clear how this other stop condition would be implemented – how would a player win all the cards in the game? From a player’s perspective this rule may be too complex for what they are looking for in a game of snap
- Add support for multiple types of ‘snap’: on suit, value/number, or both. Your application should confirm the snap type at the start. => this feature changes the game in a way that keeps the spirit of snap which is fast paced and simple but also adds variety to how two individuals would like to play, therefore I have implemented it




