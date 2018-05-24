package org.starchartlabs.corona.test.ui;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.starchartlabs.corona.core.model.Project;
import org.starchartlabs.corona.core.model.ProjectRequest;
import org.starchartlabs.corona.core.service.IProjectService;
import org.starchartlabs.corona.ui.CoronaUIApplication;

import javafx.scene.control.ListView;

public class ProjectListTest extends CoronaUITest {

    @Inject
    private IProjectService projectService;

    private List<Project> testProjects = new ArrayList<>();

    @Before
    public void setup() throws Exception {
        testProjects.add(projectService.create(new ProjectRequest(Paths.get("testProject"))));
        testProjects.add(projectService.create(new ProjectRequest(Paths.get("testProject2"))));
        launch(CoronaUIApplication.class);
    }

    @Test
    public void projectListTest() {
        List<String> projectNamesList = testProjects.stream().map(Project::getName).collect(Collectors.toList());
        ListView<Project> listViewProjects = lookup("#listViewProjects").query();

        listViewProjects.getItems().forEach(System.out::println);

        Assert.assertEquals("Expected the correct number of projects to be in the projects list.", 2,
                listViewProjects.getItems().size());
        for (Project project : listViewProjects.getItems()) {
            Assert.assertTrue("Expected all of our test projects to be present in the projects list.",
                    projectNamesList.contains(project.getName()));
        }
    }

    @After
    public void teardown() throws IOException {
        for (Project t : testProjects) {
            projectService.delete(t);
        }
    }

}
