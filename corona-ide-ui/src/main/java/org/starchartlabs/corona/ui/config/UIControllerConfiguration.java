package org.starchartlabs.corona.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.starchartlabs.corona.core.service.IProjectService;
import org.starchartlabs.corona.core.service.IWorkspaceService;
import org.starchartlabs.corona.ui.controller.MainController;

/**
 * Since we replace the JavaFX FXMLLoader's dependency master with Spring, we need to manually configure our controller
 * classes
 * 
 * @author nickavv
 * @since 0.1
 */
@Configuration
public class UIControllerConfiguration {

    @Bean
    public MainController simpleController(IWorkspaceService workspaceService, IProjectService projectService) {
        return new MainController(workspaceService, projectService);
    }

}
