package com.condation.cms.modules.ui.extensionpoints;

/*-
 * #%L
 * thymeleaf-module
 * %%
 * Copyright (C) 2023 Marx-Software
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

import com.condation.cms.api.feature.features.DBFeature;
import com.condation.cms.api.module.CMSModuleContext;
import com.condation.cms.api.module.CMSRequestContext;
import com.condation.modules.api.ModuleLifeCycleExtension;
import com.condation.modules.api.annotation.Extension;
import com.condation.cms.modules.ui.services.FileSystemService;
import com.condation.cms.modules.ui.services.FileUserService;
import com.condation.cms.modules.ui.services.LockService;
import com.condation.cms.modules.ui.services.UserService;
import com.condation.cms.modules.ui.utils.TemplateEngine;


/**
 *
 * @author t.marx
 */
@Extension(ModuleLifeCycleExtension.class)
public class UILifecycleExtension extends ModuleLifeCycleExtension<CMSModuleContext, CMSRequestContext> {

	public static UserService userService;
	public static FileSystemService fileSystemService;
	
	public static LockService lockService;
	
	public static TemplateEngine templateEngine;
	
	@Override
	public void init() {
	}

	@Override
	public void activate() {
		userService = new FileUserService(configuration.getDataDir().getAbsolutePath());
		fileSystemService = new FileSystemService(getContext().get(DBFeature.class).db());
		lockService = new LockService();
		templateEngine = new TemplateEngine();
	}

	@Override
	public void deactivate() {
	}
}
