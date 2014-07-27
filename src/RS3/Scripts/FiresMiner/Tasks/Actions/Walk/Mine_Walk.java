package RS3.Scripts.FiresMiner.Tasks.Actions.Walk;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import RS3.Scripts.FiresMiner.Framework.Task;

public class Mine_Walk extends Task<ClientContext> {
	Tile[] path;

	public Mine_Walk(ClientContext ctx, Tile[] path) {
		super(ctx);
		this.path = path;
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 0;
	}

	@Override
	public void execute() {
		ctx.movement.newTilePath(path).reverse().traverse();
	}

}
