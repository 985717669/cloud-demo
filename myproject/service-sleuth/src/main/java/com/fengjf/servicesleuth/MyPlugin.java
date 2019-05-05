package com.fengjf.servicesleuth;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Author fengjf
 * Desc   自定义插件
 */
@Mojo(name = "myPlugin", defaultPhase = LifecyclePhase.PACKAGE)
public class MyPlugin extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
