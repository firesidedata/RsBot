package RS3.Scripts.FiresMiner.Database;

import org.powerbot.script.Tile;

public enum Banks {
	VarrWBank("Varraock West Bank", new Tile(3186, 3441), new Tile(3187, 3442),
			new Tile(3189, 3443), new Tile(3190, 3445), new Tile(3188, 3444)), VarrEBank(
			"Varraock East Bank", new Tile(3253, 3421), new Tile(3254, 3422),
			new Tile(3255, 3423), new Tile(3256, 3426), new Tile(3257, 3427)), LumbridgeBank(
			"Lumbridge Bank", new Tile(3241, 3256), new Tile(3240, 3255),
			new Tile(3242, 3257), new Tile(3243, 3258), new Tile(3244, 3259));

	private final String name;
	private final Tile[] bankTile;

	Banks(String name, Tile... bank) {
		this.name = name;
		this.bankTile = bank;
	}

	public Tile[] getTile() {
		return bankTile;
	}

}
