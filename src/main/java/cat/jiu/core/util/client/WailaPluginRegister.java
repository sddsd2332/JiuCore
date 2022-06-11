package cat.jiu.core.util.client;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

import mcp.mobius.waila.api.IWailaBlockDecorator;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaEntityProvider;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.IWailaTooltipRenderer;
import mcp.mobius.waila.api.WailaPlugin;
import mcp.mobius.waila.cbcore.Layout;

import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;

@WailaPlugin
@InterfaceList({
	@Interface(iface = "mcp.mobius.waila.api.IWailaBlockDecorator", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.IWailaDataProvider", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.IWailaEntityProvider", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.IWailaPlugin", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.IWailaRegistrar", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.IWailaTooltipRenderer", modid = "waila", striprefs = true),
	@Interface(iface = "mcp.mobius.waila.api.WailaPlugin", modid = "waila", striprefs = true)
})
public class WailaPluginRegister implements IWailaPlugin {
	private static List<Plugin<?>> plugins = Lists.newArrayList();
	
	public static void addWailaPlugin(@Nonnull Layout layout, @Nonnull IWailaDataProvider plugin, @Nonnull Class<?> clazz, @Nonnull boolean needNBT) {
		plugins.add(new Plugin<IWailaDataProvider>(layout, plugin, clazz, needNBT));
	}
	
	public static void addWailaPlugin(@Nonnull Layout layout, @Nonnull IWailaEntityProvider plugin, @Nonnull Class<?> clazz, @Nonnull boolean needNBT, @Nonnull boolean needOverride) {
		plugins.add(new Plugin<IWailaEntityProvider>(layout, plugin, clazz, needNBT, needOverride));
	}
	
	public static void addWailaPlugin(@Nonnull IWailaBlockDecorator plugin, @Nonnull Class<?> clazz) {
		plugins.add(new Plugin<IWailaBlockDecorator>(plugin, clazz));
	}
	
	public static void addWailaPlugin(@Nonnull IWailaTooltipRenderer plugin, @Nonnull String name) {
		plugins.add(new Plugin<IWailaTooltipRenderer>(name, plugin));
	}
	
	@Override
	public void register(IWailaRegistrar registrar) {
		for(Plugin<?> plugin : plugins) {
			if(plugin == null) continue;
			
			if(plugin.plugin instanceof IWailaTooltipRenderer) {
				registrar.registerTooltipRenderer(plugin.name, (IWailaTooltipRenderer) plugin.plugin);
				continue;
			}else if(plugin.plugin instanceof IWailaBlockDecorator) {
				registrar.registerDecorator((IWailaBlockDecorator) plugin.plugin, plugin.clazz);
				continue;
			}
			
			switch(plugin.layout) {
				case HEADER:
					if(plugin.plugin instanceof IWailaDataProvider) {
						registrar.registerHeadProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						continue;
					}else if(plugin.plugin instanceof IWailaEntityProvider) {
						IWailaEntityProvider p = (IWailaEntityProvider) plugin.plugin;
						
						registrar.registerHeadProvider(p, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider(p, plugin.clazz);
						if(plugin.needOverride) registrar.registerOverrideEntityProvider(p, plugin.clazz);
						continue;
					}
					
				case BODY:
					if(plugin.plugin instanceof IWailaDataProvider) {
						registrar.registerBodyProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						continue;
					}else if(plugin.plugin instanceof IWailaEntityProvider) {
						IWailaEntityProvider p = (IWailaEntityProvider) plugin.plugin;
						
						registrar.registerBodyProvider(p, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider(p, plugin.clazz);
						if(plugin.needOverride) registrar.registerOverrideEntityProvider(p, plugin.clazz);
						continue;
					}
					
				case FOOTER:
					if(plugin.plugin instanceof IWailaDataProvider) {
						registrar.registerTailProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider((IWailaDataProvider) plugin.plugin, plugin.clazz);
						continue;
					}else if(plugin.plugin instanceof IWailaEntityProvider) {
						IWailaEntityProvider p = (IWailaEntityProvider) plugin.plugin;
						registrar.registerTailProvider(p, plugin.clazz);
						if(plugin.needNBT) registrar.registerNBTProvider(p, plugin.clazz);
						if(plugin.needOverride) registrar.registerOverrideEntityProvider(p, plugin.clazz);
						continue;
					}
			}
		}
	}
	
	private static class Plugin<T> {
		private Layout layout;
		private String name;
		private T plugin;
		private Class<?> clazz;
		private boolean needNBT;
		private boolean needOverride;
		
		public Plugin(String name, T plugin) {
			this.name = name;
			this.plugin = plugin;
		}
		public Plugin(Layout layout, T plugin, Class<?> clazz, boolean needNBT, boolean needOverride) {
			this(layout, plugin, clazz, needOverride);
			this.needOverride = needOverride;
		}
		
		public Plugin(@Nonnull Layout layout, T plugin, Class<?> clazz, boolean needNBT) {
			this.layout = layout;
			this.plugin = plugin;
			this.clazz = clazz;
			this.needNBT = needNBT;
		}
		public Plugin(T plugin, Class<?> clazz) {
			this.plugin = plugin;
			this.clazz = clazz;
		}
	}
}
