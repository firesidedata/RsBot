package RS3.Scripts.FiresMiner.Tasks.Actions;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import RS3.Scripts.FiresMiner.Database.Rocks;
import RS3.Scripts.FiresMiner.Framework.Task;

public class Drop extends Task<ClientContext> {
Rocks rock;
	public Drop(ClientContext ctx,Rocks rock) {
		super(ctx);
		this.rock=rock;
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() {
		for(Item i : ctx.backpack.id(rock.getitemid())) {
		    i.interact("Drop");
	}

}
}
