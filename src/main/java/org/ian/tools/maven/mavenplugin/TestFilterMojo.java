package org.ian.tools.maven.mavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.ian.tools.maven.testFilter.FilterGroups;
import org.ian.tools.maven.testFilter.TestFilter;

import java.util.ArrayList;
import java.util.List;

@Mojo(name = "test-filter", defaultPhase = LifecyclePhase.VALIDATE)
@Execute( goal = "test-filter",
        lifecycle = "test-filter" )
public class TestFilterMojo extends AbstractMojo {

    // inject the project
    @Parameter(readonly = true, defaultValue = "${project}")
    private MavenProject mavenProject;

    /**
     * Skip running this plugin
     */
    @Parameter(readonly = true, defaultValue = "false")
    private boolean skip = false;

    /**
     * Test groups to include / exclude.
     * Default is include all.
     */
    @Parameter(readonly = true, defaultValue = "${filter}")
    private String filter = "";

    /**
     * Defined test groups.
     * Default is none.
     */
    @Parameter(readonly = true)
    private List<String> categories = new ArrayList<>();



    public void execute() throws MojoExecutionException, MojoFailureException {

        if (this.skip) {
            getLog().info("Skipping");
            return;
        }

        try {

            invoke(this.categories, this.filter);

        } catch (RuntimeException e) {
            throw e;
        }
    }

    private void invoke(List<String> definitions, String selections) {
        getLog().debug("filtering tests with config:");
        if (categories.size() > 0) {
            for (String cat : categories) {
                getLog().debug("category => " + cat);
            }
        } else {
            getLog().debug("NO CATEGORIES DEFINED");
        }
        getLog().debug("filter = " + filter);
        TestFilter filterParser = new TestFilter(definitions);
        FilterGroups result = filterParser.select(selections);

        getLog().info("filter includes " + result.getIncludedCount());
        getLog().info("filter excludes " + result.getExcludedCount());

        this.mavenProject.getProperties().setProperty("includedTestGroups", result.getIncludedGroups());
        this.mavenProject.getProperties().setProperty("excludedTestGroups", result.getExcludedGroups());
    }
}
