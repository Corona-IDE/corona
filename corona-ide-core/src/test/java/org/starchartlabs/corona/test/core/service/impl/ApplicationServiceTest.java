/*******************************************************************************
 * Copyright (c) Oct 24, 2016 Corona IDE.
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
import org.starchartlabs.corona.core.internal.service.ICoreConfiguration;
import org.starchartlabs.corona.core.model.Application;
import org.starchartlabs.corona.core.service.IApplicationService;
import org.starchartlabs.corona.core.service.impl.ApplicationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests basic operations of the application service
 *
 * @author romeara
 */
public class ApplicationServiceTest {

    private final Path applicationDirectory = Paths.get("corona-ide");

    @Mock
    private ICoreConfiguration coreConfiguration;

    private IApplicationService applicationService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(coreConfiguration.getApplicationMetaDataDirectory()).thenReturn(applicationDirectory);

        applicationService = new ApplicationService(coreConfiguration);
    }

    @Test
    public void getApplication() throws Exception {
        Application application = applicationService.get();

        Assert.assertNotNull(application);
        Assert.assertNotNull(application.getVersion());
        Assert.assertEquals(application.getWorkingDirectory().toString(), applicationDirectory.toString());
    }

}
