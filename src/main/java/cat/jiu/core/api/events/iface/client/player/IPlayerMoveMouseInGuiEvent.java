package cat.jiu.core.api.events.iface.client.player;

import cat.jiu.core.api.IJiuEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface IPlayerMoveMouseInGuiEvent extends IJiuEvent{
	/**
	 * 
	 * key 0 = Left.
	 * key 1 = right.
	 * key 2 = middle.
	 * 
	 * @param gui Player open the gui
	 * @param x Mouse click x
 	 * @param y Mouse click y
	 * 
	 * @author small_jiu
	 */
	void onPlayerMoveMouseInGui(GuiScreen gui, int x, int y);
}
