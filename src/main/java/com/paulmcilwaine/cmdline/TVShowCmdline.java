package com.paulmcilwaine.cmdline;

import org.apache.commons.cli.*;

final public class TVShowCmdline {
    private String filename;
    private String[] args;

    public TVShowCmdline() throws TVShowCmdlineException {
        throw new TVShowCmdlineException("Missing arguments.");
    }

    public TVShowCmdline(String[] args) throws TVShowCmdlineException {
        if (args.length == 0) {
            throw new TVShowCmdlineException("Missing arguments.");
        }

        this.args = args;
    }

    public void parse() throws ParseException {
        Options options = new Options();

        Option configFile = new Option("f", "file", true, "Configuration file");
        configFile.setRequired(true);

        options.addOption(configFile);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, this.args);

        this.filename = cmd.getOptionValue("file");
    }

    public String getFilename() {
        return filename;
    }
}
