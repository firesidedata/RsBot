package RS3.Scripts.FiresMiner.Database;

public enum Rocks {
	
	
	Copper(436, "Copper",2090),
	Tin(438, "Tin",2094),
	Iron(440, "Iron",2092),
	Silver(442, "Silver",2100),
	Gold(444, "Gold",2096),
	Mithril(447, "Mithril",2098),
	Adamant(449, "Adamant",2102),
	Runite(451, "Runite",2104);
    
    private final int RockId;
    private final int itemid;
    private final String name;
    
    private Rocks(int itemId, String name, int RockIds) {
        this.itemid = itemId;
        this.name = name;
        this.RockId = RockIds;
    }

    public int getitemid() {
        return itemid;
    }

    public String getName() {
        return name;
    }

    public int getRockIds() {
        return RockId;
    }


    @Override
    public String toString() {
        return name().substring(0,1) + "" + name().substring(1).toLowerCase();
    }
}