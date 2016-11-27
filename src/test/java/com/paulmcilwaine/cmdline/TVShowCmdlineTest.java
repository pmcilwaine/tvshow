package com.paulmcilwaine.cmdline;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TVShowCmdlineTest {
    @Test(expected = TVShowCmdlineException.class)
    public void initialiseTVShowCmdlineThrowsExceptionMissingArguments() throws TVShowCmdlineException {
        new TVShowCmdline();
    }

    @Test(expected = TVShowCmdlineException.class)
    public void initialiseTVShowCmdlineThrowsExceptionWithEmptyArguments() throws TVShowCmdlineException {
        new TVShowCmdline(new String[]{});
    }

    @Test
    public void initialiseTVShowCmdline() throws TVShowCmdlineException {
        new TVShowCmdline(new String[]{"-f", "filename"});
    }

    @Test(expected = ParseException.class)
    public void parseInvalidArgumentThrowsException() throws ParseException, TVShowCmdlineException {
        TVShowCmdline cmdline = new TVShowCmdline(new String[]{"-f"});
        cmdline.parse();
    }

    @Test
    public void parseArgument() throws ParseException, TVShowCmdlineException {
        TVShowCmdline cmdline = new TVShowCmdline(new String[]{"-f", "filename"});
        cmdline.parse();
    }

    @Test
    public void retrieveFilename() throws TVShowCmdlineException, ParseException {
        TVShowCmdline cmdline = new TVShowCmdline(new String[]{"-f", "filename"});
        cmdline.parse();

        assertSame("filename", cmdline.getFilename());
    }
}