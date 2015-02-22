package noki.chunkvisualizer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;


/**********
 * @class EventJoinWorld
 *
 * @description
 * @description_en
 */
public class EventJoinWorld {
	
	//******************************//
	// define member variables.
	//******************************//


	//******************************//
	// define member methods.
	//******************************//
	
	@SubscribeEvent
	public void onJoinWorld(EntityJoinWorldEvent event) {
		
		if(event.world.isRemote && event.entity instanceof EntityPlayer
				&& ((EntityPlayer)event.entity).getDisplayName() == Minecraft.getMinecraft().thePlayer.getDisplayName()) {			
			ChunkVisualizerCore.versionInfo.notifyUpdate(Side.CLIENT);
			
			EventWorldRender.activatedChunk = false;
			EventWorldRender.activatedBeacon = false;
			EventWorldRender.position = null;
			EventWorldRender.level = 0;
		}
		
	}
	
}
