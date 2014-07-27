package RS3.Scripts.FiresMiner.Tasks.Banking;

import org.powerbot.script.rt6.ClientContext;

import RS3.Scripts.FiresMiner.Database.Rocks;
import RS3.Scripts.FiresMiner.Framework.Task;

public class Bank_Deposit extends Task<ClientContext> {

	public Bank_Deposit(ClientContext ctx, Rocks rock) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.bank.opened() && ctx.backpack.select().count() > 0;
	}

	@Override
	public void execute() {
		if (ctx.backpack.select().isEmpty()) {
			ctx.bank.close();
		}
		else ctx.bank.depositInventory();
	}

}
