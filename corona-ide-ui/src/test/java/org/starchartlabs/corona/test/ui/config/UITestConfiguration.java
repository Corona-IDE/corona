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
package org.starchartlabs.corona.test.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.starchartlabs.corona.core.config.CoronaIdeCoreConfiguration;
import org.starchartlabs.corona.ui.config.UIControllerConfiguration;

/**
 * Aggregation of the configuration classes required to run the Corona UI tests
 *
 * @author nickavv
 * @since 0.1
 */
@Configuration
@Import({
        CoronaIdeCoreConfiguration.class,
        UIControllerConfiguration.class
})
public class UITestConfiguration {

}
