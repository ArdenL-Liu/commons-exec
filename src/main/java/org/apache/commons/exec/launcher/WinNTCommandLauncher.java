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

/**
 * A command launcher for Windows XP/2000/NT that uses 'cmd.exe' when launching
 * commands in directories other than the current working directory.
 */
public class WinNTCommandLauncher extends CommandLauncherProxy {
    public WinNTCommandLauncher(final CommandLauncher launcher) {
        super(launcher);
    }

    /**
     * Launches the given command in a new process, in the given working
     * directory.
     * 
     * @param cmd
     *            the command line to execute as an array of strings
     * @param env
     *            the environment to set as an array of strings
     * @param workingDir
     *            working directory where the command should run
     * @throws IOException
     *             forwarded from the exec method of the command launcher
     */
    public Process exec(final String[] cmd, final Map env,
            final File workingDir) throws IOException {
        if (workingDir == null) {
            return exec(cmd, env);
        }

        // Use cmd.exe to change to the specified directory before running
        // the command
        // TODO add code for switching to working dir
        
        String[] newCmd = new String[cmd.length + 2];
        newCmd[0] = "cmd";
        newCmd[1] = "/c";

        for (int i = 0; i < cmd.length; i++) {
			newCmd[i + 2] = cmd[i];
		}

        return exec(newCmd, env);
    }
}
