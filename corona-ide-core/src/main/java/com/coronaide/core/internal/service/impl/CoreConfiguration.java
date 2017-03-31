/*******************************************************************************
 * Copyright (c) Oct 17, 2016 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.coronaide.core.internal.service.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import com.coronaide.core.internal.service.ICoreConfiguration;

/**
 * Implementation of {@link ICoreConfiguration}. Not intended for direct use by clients - use dependency injection to
 * obtain an instance of {@link ICoreConfiguration} instead
 *
 * @author romeara
 * @since 0.1
 */
public class CoreConfiguration implements ICoreConfiguration {

    private Path applicationLocation;

    private Path workspaceLocation;

    @Override
    public void setLocations(Path applicationLocation, Path workspaceLocation) {
        Objects.requireNonNull(applicationLocation);
        Objects.requireNonNull(workspaceLocation);

        if (this.applicationLocation != null) {
            throw new IllegalStateException(
                    "Application locations have already been set - additional calls are not permitted");
        }

        this.applicationLocation = applicationLocation;
        this.workspaceLocation = workspaceLocation;
    }

    @Override
    public Path getWorkingDirectoryName() {
        return Paths.get(".corona-ide");
    }

    @Override
    public Path getApplicationWorkingDirectory() {
        if (applicationLocation == null) {
            throw new IllegalStateException("Application location was not initialized");
        }

        return applicationLocation.resolve(getWorkingDirectoryName());
    }

    @Override
    public Path getActiveWorkspaceDirectory() {
        if (workspaceLocation == null) {
            throw new IllegalStateException("Workspace location was not initialized");
        }

        return workspaceLocation;
    }

}
