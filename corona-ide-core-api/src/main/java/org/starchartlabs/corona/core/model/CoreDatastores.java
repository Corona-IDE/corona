/*
 * Copyright (c) Mar 29, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.corona.core.model;

import org.starchartlabs.corona.core.datastore.Datastore;
import org.starchartlabs.corona.core.datastore.JsonDatastore;

/**
 * Provides common datastore-related operations to core implementation classes
 *
 * @author romeara
 * @since 0.1
 */
public final class CoreDatastores {

    private static final Datastore<WorkspaceMetaData> WORKSPACE_DATASTORE = new JsonDatastore<>("metadata",
            WorkspaceMetaData.class);

    /**
     * Prevent instantiation of utility class
     */
    private CoreDatastores() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate instance of utility class '" + getClass().getName() + "'");
    }

    /**
     * @return Datastore for use within a workspace to manipulate the basic workspace information
     * @since 0.1
     */
    public static final Datastore<WorkspaceMetaData> getWorkspaceDatastore() {
        return WORKSPACE_DATASTORE;
    }
}
