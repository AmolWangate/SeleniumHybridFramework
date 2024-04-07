package com.test.onwerinterface;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/envconfig.properties")
public interface EnvConfigInterface extends Config {

	String browser();

	String url();

	int retrycount();

	boolean passscreenshot();

	boolean failscreenshot();

	boolean skipscreenshot();

	boolean infoscreenshot();

	boolean overridereport();

}
