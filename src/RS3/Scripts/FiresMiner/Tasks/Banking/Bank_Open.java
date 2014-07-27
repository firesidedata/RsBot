package RS3.Scripts.FiresMiner.Tasks.Banking;

import org.powerbot.script.rt6.ClientContext;

import RS3.Scripts.FiresMiner.Framework.Task;

public class Bank_Open extends Task<ClientContext> {

	public Bank_Open(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.bank.inViewport() && !ctx.bank.opened()
				&& ctx.backpack.select().count() > 0;
	}

	@Override
	public void execute() {
		ctx.bank.open();
	}

}
