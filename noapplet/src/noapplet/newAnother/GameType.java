
package noapplet.newAnother;
/**
 * Represents the type of game being played in the Omok console application.
 * This class is used to distinguish between human vs. human and human vs. strategy games.
 */
public class GameType {
    /**
     * Creates and returns a new GameType representing a human player.
     *
     * @return a GameType object representing a human player
     */
    public static GameType Human() {
        return new GameType("Human");
    }
    /**
     * Creates and returns a new GameType representing a strategy (AI) player.
     *
     * @return a GameType object representing a strategy player
     */
    public static GameType Strategy() {
        return new GameType("Strategy");
    }
    /**
     * Private field that holds the type of game.
     */
    private String type;
    /**
     * Private constructor to ensure that objects of GameType can only be created
     * through the provided static methods.
     *
     * @param type the type of game (e.g., "Human" or "Strategy")
     */
    private GameType(String type){
        this.type = type;
    }

    /**
     * Determines if the given object is equal to the current GameType object.
     * Two GameType objects are considered equal if they represent the same type of game.
     *
     * @param obj the object to compare with the current GameType
     * @return true if the given object is equal to the current GameType, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        GameType gameType = (GameType) obj;
        return type.equals(gameType.type);
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return the hash code value for the current GameType object
     */
    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
