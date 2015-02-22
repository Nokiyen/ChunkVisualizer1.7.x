package noki.chunkvisualizer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


/**********
 * @ModName ChunkVisualizerCore
 * 
 * @description
 * 
 * @caution ここはコアファイルなので、原則、具体的な処理をしないよう気を付ける。
 */
@Mod(modid = "ChunkVisualizer", name = "Chunk Visualizer", version = "1.0.2")
public class ChunkVisualizerCore {
	
	//******************************//
	// define member variables.
	//******************************//
	//	core.
	@Instance(value = "ChunkVisualizer")
	public static ChunkVisualizerCore instance;
	@Metadata
	public static ModMetadata metadata;
	public static VersionInfo versionInfo;
	@SidedProxy(clientSide = "noki.chunkvisualizer.ProxyClient", serverSide = "noki.chunkvisualizer.ProxyCommon")
	public static ProxyCommon proxy;

	
	//******************************//
	// define member methods.
	//******************************//
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		EventKeyInput.setData(event);
		
		versionInfo = new VersionInfo(metadata.modId.toLowerCase(), metadata.version, metadata.updateUrl);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
				
		proxy.register();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		//	nothing to do.
		
	}

}
