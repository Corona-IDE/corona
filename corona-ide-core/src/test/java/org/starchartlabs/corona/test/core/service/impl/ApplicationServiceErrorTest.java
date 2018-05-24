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

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.starchartlabs.corona.core.internal.service.ICoreConfiguration;
import org.starchartlabs.corona.core.service.impl.ApplicationService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test basic error behavior of the application service
 *
 * @author romeara
 */
public class ApplicationServiceErrorTest {

    @Mock
    private ICoreConfiguration coreConfiguration;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void createNullCoreConfiguration() throws Exception {
        new ApplicationService(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void createNullApplicationDirectory() throws Exception {
        Mockito.when(coreConfiguration.getApplicationMetaDataDirectory()).thenReturn(null);

        new ApplicationService(coreConfiguration);
    }

}
