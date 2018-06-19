package org.starchartlabs.corona.test.ui;

import java.nio.file.Path;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.starchartlabs.corona.core.model.Workspace;
import org.starchartlabs.corona.core.service.IWorkspaceService;
import org.starchartlabs.corona.ui.CoronaUIApplication;

public class WindowFeaturesTest extends CoronaUITest {

    @Inject
    private IWorkspaceService workspaceService;

    @Before
    public void setup() throws Exception {
        launch(CoronaUIApplication.class);
    }

    @Test
    public void workspaceTitleTest() {
        Workspace workspace = workspaceService.getActiveWorkspace();
        Path workingDir = workspace.getWorkingDirectory();

        Assert.assertEquals("Expected application title bar to have the correct title.",
                CoronaUIApplication.getPrimaryStage().getTitle(),
                workingDir.getName(workingDir.getNameCount() - 2).toString() + " - Corona");
    }

}
