package enums;

/**
 * <p>
 * Created on Jan 27, 2018 
 *
 * @author IdeFFiX
 */

public enum Level {
	
	ZERO(0),
	FINAL(1),
	SEMI_FINAL(2),
	QUARTEL_FINAL(3),
	ROUND_OF_16(4),
	ROUND_OF_32(5),
	ROUND_OF_64(6),
	ROUND_OF_128(7),
	ROUND_OF_256(8),
	ROUND_OF_512(9),
	ROUND_OF_1024(10);
	
	private int level;
	
	private Level(int level) {
		this.level = level;
	}

	public static Level getLevel(int level) {
		for (Level currentLevel : Level.values()) {
			if (currentLevel.getLevel() == level) {
				return currentLevel;
			}
		}
		return null;
	}
	
	public int getLevel() {
		return level;
	}
	

}
