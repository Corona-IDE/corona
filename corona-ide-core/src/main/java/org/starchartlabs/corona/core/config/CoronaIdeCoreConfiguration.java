/*
 * Copyright (c) Apr 1, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.corona.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.starchartlabs.corona.core.internal.service.ICoreConfiguration;
import org.starchartlabs.corona.core.internal.service.IDatastoreManager;
import org.starchartlabs.corona.core.internal.service.impl.CoreConfiguration;
import org.starchartlabs.corona.core.internal.service.impl.DatastoreManager;
import org.starchartlabs.corona.core.service.IDatastoreService;
import org.starchartlabs.corona.core.service.IProjectService;
import org.starchartlabs.corona.core.service.IWorkspaceService;
import org.starchartlabs.corona.core.service.impl.DatastoreService;
import org.starchartlabs.corona.core.service.impl.ProjectService;
import org.starchartlabs.corona.core.service.impl.WorkspaceService;

/**
 * Configuration which provides instances of APIs for use via dependency injection throughout the application
 *
 * <p>
 * Utilizes the spring framework's Java configuration methodology to provide implementations
 *
 * @author romeara
 * @since 0.1.0
 */
@Configuration
public class CoronaIdeCoreConfiguration {

    @Bean
    public ICoreConfiguration coreConfiguration() {
        return new CoreConfiguration();
    }

    @Bean
    public IDatastoreManager datastoreManager() {
        return new DatastoreManager();
    }

    @Bean
    public IDatastoreService datastoreService(IDatastoreManager datastoreManager) {
        return new DatastoreService(datastoreManager);
    }

    @Bean
    public IWorkspaceService workspaceService(ICoreConfiguration coreConfiguration) {
        return new WorkspaceService(coreConfiguration);
    }

    @Bean
    public IProjectService projectService(IWorkspaceService workspaceService, IDatastoreService datastoreService) {
        return new ProjectService(workspaceService, datastoreService);
    }
}
