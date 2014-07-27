package RS3.Scripts.FiresMiner.Tasks.Actions.Walk;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import RS3.Scripts.FiresMiner.Framework.Task;

public class Bank_Walk extends Task<ClientContext> {
    Tile[] path;
	public Bank_Walk(ClientContext ctx,Tile[] path) {
		super(ctx);
		this.path=path;
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count()==28 && !ctx.bank.inViewport();
	}

	@Override
	public void execute() {
      ctx.movement.newTilePath(path).traverse();
	}

}
