package com.github.thmarx.cms.modules.ui.commands;

/*-
 * #%L
 * ui-module
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
import com.github.thmarx.cms.api.Constants;
import com.github.thmarx.cms.api.content.ContentResponse;
import com.github.thmarx.cms.api.db.ContentNode;
import com.github.thmarx.cms.api.db.DB;
import com.github.thmarx.cms.api.feature.features.DBFeature;
import com.github.thmarx.cms.api.feature.features.RequestFeature;
import com.github.thmarx.cms.api.module.CMSModuleContext;
import com.github.thmarx.cms.api.module.CMSRequestContext;
import com.github.thmarx.cms.api.request.RequestContext;
import com.github.thmarx.cms.api.utils.PathUtil;
import com.github.thmarx.cms.modules.ui.extensionpoints.UILifecycleExtension;
import com.github.thmarx.cms.modules.ui.services.CommandService;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author t.marx
 */
public class GetContentNodeCommand {

	public static final String NAME = "getContentNode";

	public static final CommandService.CommandHandler getHandler(
			final CMSModuleContext moduleContext, final CMSRequestContext requestContext
	) {
		final DB db = moduleContext.get(DBFeature.class).db();
		var contentBase = db.getFileSystem().resolve(Constants.Folders.CONTENT);
		return command -> {
			var url = (String) command.parameters().get("url");

			var path = URI.create(url).getPath();

			var contextPath = requestContext.get(RequestFeature.class).context();
			if (!"/".equals(contextPath) && path.startsWith(contextPath)) {
				path = path.replaceFirst(contextPath, "");
			}

			if (path.startsWith("/")) {
				path = path.substring(1);
			}

			var contentPath = contentBase.resolve(path);
			Path contentFile = null;
			if (Files.exists(contentPath) && Files.isDirectory(contentPath)) {
				// use index.md
				var tempFile = contentPath.resolve("index.md");
				if (Files.exists(tempFile)) {
					contentFile = tempFile;
				}
			} else {
				var temp = contentBase.resolve(path + ".md");
				if (Files.exists(temp)) {
					contentFile = temp;
				}
			}

			Map<String, Object> result = new HashMap<>();
			result.put("url", "url");
			if (contentFile != null) {
				result.put("uri", PathUtil.toRelativeFile(contentFile, contentBase));
			}

			return result;
		};
	}
}
