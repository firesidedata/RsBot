package RS3.Scripts.FiresMiner.Tasks.Actions;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import RS3.Scripts.FiresMiner.Database.Rocks;
import RS3.Scripts.FiresMiner.Framework.Task;

public class Mine extends Task<ClientContext> {
	Rocks rock;

	public Mine(ClientContext ctx, Rocks rock) {
		super(ctx);
		this.rock = rock;
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() < 28
				&& !ctx.objects.select().id(rock.getRockIds()).isEmpty()
				&& ctx.players.local().animation() == -1;
	}

	@Override
	public void execute() {
		GameObject rock2 = ctx.objects.id(rock.getRockIds()).nearest().poll();
		if (rock2.inViewport()) {
			rock2.interact("Mine");
		} else {
			ctx.movement.step(rock2);
			ctx.camera.turnTo(rock2);
		}

	}

}
