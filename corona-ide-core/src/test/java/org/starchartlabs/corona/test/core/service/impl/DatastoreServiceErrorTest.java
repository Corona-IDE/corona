/*******************************************************************************
 * Copyright (c) Oct 18, 2016 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.starchartlabs.corona.test.core.service.impl;

import java.nio.file.Paths;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.starchartlabs.corona.core.datastore.Datastore;
import org.starchartlabs.corona.core.internal.service.IDatastoreManager;
import org.starchartlabs.corona.core.model.Application;
import org.starchartlabs.corona.core.model.Module;
import org.starchartlabs.corona.core.model.Version;
import org.starchartlabs.corona.core.model.Workspace;
import org.starchartlabs.corona.core.service.IDatastoreService;
import org.starchartlabs.corona.core.service.impl.DatastoreService;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test basic error behavior of the datastore service
 *
 * @author romeara
 */
public class DatastoreServiceErrorTest {

    /** Logger reference to output information to the application log files */
    private static final Logger logger = LoggerFactory.getLogger(DatastoreServiceErrorTest.class);

    @Mock
    private IDatastoreManager datastoreManager;

    @Mock
    private Module module;

    @Mock
    private Datastore<String> datastore;

    private Application application;

    private Workspace workspace;

    private IDatastoreService datastoreService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(module.getId()).thenReturn("com.coronaide.test");
        Mockito.when(module.getVersion()).thenReturn(new Version(1, 0, 0));

        application = new Application(Paths.get("app-dir"));
        workspace = new Workspace(Paths.get("workspace-dir"));

        datastoreService = new DatastoreService(datastoreManager);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.trace("Verifying mock interactions for {}", result);

        Mockito.verifyNoMoreInteractions(datastoreManager);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeApplicationNullApplication() throws Exception {
        datastoreService.store((Application) null, module, datastore, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeApplicationDataNullModule() throws Exception {
        datastoreService.store(application, null, datastore, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeApplicationDataNullDatastore() throws Exception {
        datastoreService.store(application, module, null, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeApplicationDataNullData() throws Exception {
        datastoreService.store(application, module, datastore, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadApplicationDataNullApplication() throws Exception {
        datastoreService.load((Application) null, module, datastore);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadApplicationDataNullModule() throws Exception {
        datastoreService.load(application, null, datastore);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadApplicationDataNullDatastore() throws Exception {
        datastoreService.load(application, module, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void clearApplicationDataNullApplication() throws Exception {
        datastoreService.clear((Application) null, module);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void clearApplicationDataNullModule() throws Exception {
        datastoreService.clear(application, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeWorkspaceNullWorkspace() throws Exception {
        datastoreService.store((Workspace) null, module, datastore, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeWorkspaceDataNullModule() throws Exception {
        datastoreService.store(workspace, null, datastore, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeWorkspaceDataNullDatastore() throws Exception {
        datastoreService.store(workspace, module, null, "data");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void storeWorkspaceDataNullData() throws Exception {
        datastoreService.store(workspace, module, datastore, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadWorkspaceDataNullWorkspace() throws Exception {
        datastoreService.load((Workspace) null, module, datastore);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadWorkspaceDataNullModule() throws Exception {
        datastoreService.load(workspace, null, datastore);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void loadWorkspaceDataNullDatastore() throws Exception {
        datastoreService.load(workspace, module, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void clearWorkspaceDataNullWorkspace() throws Exception {
        datastoreService.clear((Workspace) null, module);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void clearWorkspaceDataNullModule() throws Exception {
        datastoreService.clear(workspace, null);
    }

}
