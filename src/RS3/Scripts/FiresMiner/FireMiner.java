package RS3.Scripts.FiresMiner;

import java.awt.Graphics;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

@Script.Manifest(name = "FiresDrinker", description = "Mines ore and banks or Drops them")
public class FireMiner extends PollingScript<ClientContext> implements
		PaintListener {

	@Override
	public void poll() {

	}

	public void repaint(Graphics arg0) {

	}

}
