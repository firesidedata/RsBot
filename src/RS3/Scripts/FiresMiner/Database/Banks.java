package RS3.Scripts.FiresMiner.Database;

public enum Banks {
    VarrWBank("Varraock West Bank",3186,3441),
    VarrEBank("Varraock East Bank",3253,3421),
    LumbridgeBank("Lumbridge Bank",3241,3256);

    private final String name;
    private final int[] bankLoc;
    
    Banks(String name, int... bank) {
        this.name = name;
        this.bankLoc = bank;
    }
    public int[] getloc()
    {
      return bankLoc;
    }
    
}
