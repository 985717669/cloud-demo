package com.example.plugindemo;

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
public class MyPluginMoJo extends AbstractMojo {

    //参数
//    @Parameter
//    private String msg;
//
//    @Parameter
//    private List<String> options;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
//        System.out.println("this is my plugin   msg= " + msg +"   list ="+options);
        System.out.println("233333333333333");
    }
}
