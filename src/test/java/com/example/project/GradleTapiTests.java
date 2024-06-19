package com.example.project;

import java.io.File;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.events.ProgressListener;
import org.gradle.tooling.events.OperationType;
import org.gradle.tooling.events.ProgressEvent;
import org.junit.jupiter.api.Test;

class GradleTapiTests {

    @Test
    void test() {
        File project = new File(System.getProperty("user.dir"));
        GradleConnector connector = GradleConnector.newConnector()
            .forProjectDirectory(project);
        connector.connect()
            .newTestLauncher()
            .addProgressListener(new ProgressListener() {

                @Override
                public void statusChanged(ProgressEvent event) {
                    System.out.println(event.getDisplayName());
                }

            }, OperationType.TEST)
            .withJvmTestClasses("com.example.project.NestedTests")
            .run();
    }

}
