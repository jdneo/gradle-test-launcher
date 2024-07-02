package com.example.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.events.OperationType;
import org.gradle.tooling.events.ProgressEvent;
import org.gradle.tooling.events.ProgressListener;

public class App {

    public static void main(String[] args) {
        File project = new File(System.getProperty("user.dir"));
        GradleConnector connector = GradleConnector.newConnector()
            .forProjectDirectory(project);
        Map<String, String> env = new HashMap<>();
        env.put("key", "value");

        try (ProjectConnection connection = connector.connect()) {
            connection
            .newTestLauncher()
            .addProgressListener(new ProgressListener() {

                @Override
                public void statusChanged(ProgressEvent event) {
                    System.out.println(event.getDisplayName());
                }

            }, OperationType.TEST)
            .withJvmTestClasses("com.example.project.EnvTests*")
        //    .setEnvironmentVariables(env)
            .run();
        }
    }
}