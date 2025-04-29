package com.condation.cms.modules.ui.demo;

/*-
 * #%L
 * ui-module-demo
 * %%
 * Copyright (C) 2024 Marx-Software
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import com.condation.cms.api.hooks.HookSystem;
import com.condation.cms.api.extensions.HookSystemRegisterExtensionPoint;
import com.condation.cms.api.hooks.ActionContext;
import com.condation.cms.api.hooks.FilterContext;
import com.condation.cms.modules.ui.api.FilterContextHelper;
import com.condation.cms.modules.ui.api.action.HookAction;
import com.condation.cms.modules.ui.api.menu.MenuEntry;
import com.condation.modules.api.annotation.Extension;
import java.util.Map;

/**
 *
 * @author t.marx
 */
@Extension(HookSystemRegisterExtensionPoint.class)
public class MenuHookExtension extends HookSystemRegisterExtensionPoint {

	@Override
	public void register(HookSystem hookSystem) {
		hookSystem.registerFilter("module/ui/menu", (FilterContext<String> context)
				-> FilterContextHelper.filterList(context, (entries) -> {
					entries.add(MenuEntry.builder()
							.child(MenuEntry.builder().name("Child1").position(0).build())
							.child(MenuEntry.builder().divider(true).position(1).build())
							.child(MenuEntry.builder().name("Child1")
									.position(2)
									.action(new HookAction("module/ui/demo/menu/action", Map.of("name", "CondationCMS")))
									.build())
							.name("ExampleMenu")
							.build());
				}, MenuEntry.class)
		);
		
		hookSystem.registerAction("module/ui/demo/menu/action", (ActionContext<String> context) -> {
			System.out.println("hook action executed");
			System.out.println("hello " + context.arguments().get("name"));
			return "";
		});

	}

}
