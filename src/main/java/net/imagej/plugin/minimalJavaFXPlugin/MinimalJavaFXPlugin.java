/*
 * The MIT License
 *
 * Copyright 2016 Fiji.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.imagej.plugin.minimalJavaFXPlugin;

import net.imagej.ImageJ;
import net.imagej.plugin.minimalJavaFXPlugin.gui.MainAppFrame;

import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = "Plugins>Example>Minimal JavaFX Plugin")
public class MinimalJavaFXPlugin implements Command {

    @Parameter
    private ImageJ ij;

    @Parameter
    private LogService log;

    public static final String PLUGIN_NAME = "Minimal JavaFX Plugin";
    public static final String VERSION = version();

    private static String version() {
        String version = null;
        final Package pack = MinimalJavaFXPlugin.class.getPackage();
        if (pack != null) {
            version = pack.getImplementationVersion();
        }
        return version == null ? "DEVELOPMENT" : version;
    }

    @Override
    public void run() {

        log.info("Running " + PLUGIN_NAME + " version " + VERSION);
               
        // Launch JavaFX interface
        MainAppFrame app = new MainAppFrame(ij);
        app.setTitle(PLUGIN_NAME + " version " + VERSION);
        app.init();
        
    }

    public static void main(final String... args) throws Exception {
        // Launch ImageJ as usual.
        final ImageJ ij = net.imagej.Main.launch(args);

        // Launch the command.
        ij.command().run(MinimalJavaFXPlugin.class, true);
    }
}
