/* 
 * Copyright 2005  The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.commons.exec.launcher;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.exec.environment.EnvironmentUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A command launcher for JDK/JRE 1.3 (and higher). Uses the built-in
 * Runtime.exec() command
 */
public class Java13CommandLauncher extends CommandLauncherImpl {
	private static Log log = LogFactory.getLog(Java13CommandLauncher.class);

	public Java13CommandLauncher() {
	}

	/**
	 * Launches the given command in a new process, in the given working
	 * directory
	 * 
	 * @param cmd
	 *            the command line to execute as an array of strings
	 * @param env
	 *            the environment to set as an array of strings
	 * @param workingDir
	 *            the working directory where the command should run
	 * @throws IOException
	 *             probably forwarded from Runtime#exec
	 */
	public Process exec(final String[] cmd, final Map env,
			final File workingDir) throws IOException {
		log.debug("Execute:Java13CommandLauncher: " + cmd);

		String[] envVars = null;
		if(env != null) {
			envVars = EnvironmentUtil.toStrings(env);
		}

		return Runtime.getRuntime().exec(cmd,
                envVars, workingDir);
	}
}
