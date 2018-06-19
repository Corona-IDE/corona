/*******************************************************************************
 * Copyright (c) Nov 17, 2016 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.starchartlabs.corona.test.core.service.impl;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.starchartlabs.corona.core.internal.datastore.util.Datastores;
import org.starchartlabs.corona.core.internal.service.ICoreConfiguration;
import org.starchartlabs.corona.core.model.Workspace;
import org.starchartlabs.corona.core.service.IWorkspaceService;
import org.starchartlabs.corona.core.service.impl.WorkspaceService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests basic operations of the workspace service
 *
 * @author romeara
 */
public class WorkspaceServiceTest {

    private final Path workspaceDirectory = Paths.get("workspace");

    @Mock
    private ICoreConfiguration coreConfiguration;

    private IWorkspaceService workspaceService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(coreConfiguration.getActiveWorkspaceDirectory()).thenReturn(workspaceDirectory);

        workspaceService = new WorkspaceService(coreConfiguration);
    }

    @Test
    public void getActiveWorkspace() throws Exception {
        Workspace workspace = workspaceService.getActiveWorkspace();

        Assert.assertNotNull(workspace);
        Assert.assertEquals(workspace.getWorkingDirectory(), Datastores.getMetaDataDirectory(workspaceDirectory));
    }

}
