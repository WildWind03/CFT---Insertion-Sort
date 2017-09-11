package com.chirikhin.cft.sorter;

import com.chirikhin.cft.algorithm.SortType;
import com.chirikhin.cft.algorithm.SourceType;
import com.chirikhin.cft.argumentparser.ArgumentParser;
import com.chirikhin.cft.argumentparser.SortConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class ArgumentParserTest {
    @Test(expected = IllegalArgumentException.class)
    public void parseConfigurationException() {
        ArgumentParser argumentParser = new ArgumentParser(new String[]{null, null, null, null});
        argumentParser.parseConfiguration();

        ArgumentParser argumentParser1 = new ArgumentParser(null);
        argumentParser1.parseConfiguration();

        ArgumentParser argumentParser2 = new ArgumentParser(new String[]{"a", "b", "c", "d", "e"});
        argumentParser2.parseConfiguration();

        ArgumentParser argumentParser3 = new ArgumentParser(new String[]{"a", "b"});
        argumentParser3.parseConfiguration();

        ArgumentParser argumentParser4 = new ArgumentParser(new String[]{"in", "out", "-f", "-a"});
        argumentParser4.parseConfiguration();

        ArgumentParser argumentParser5 = new ArgumentParser(new String[]{"in", "out", "-d", "-g"});
        argumentParser5.parseConfiguration();
    }

    @Test
    public void parseConfiguration() {
        ArgumentParser argumentParser = new ArgumentParser(new String[]{"in", "out", "-s", "-a"});
        SortConfiguration sortConfiguration = argumentParser.parseConfiguration();

        Assert.assertEquals("in", sortConfiguration.getInFilename());
        Assert.assertEquals("out", sortConfiguration.getOutFilename());
        Assert.assertEquals(SortType.ASCENDING, sortConfiguration.getSortType());
        Assert.assertEquals(SourceType.STRING, sortConfiguration.getSourceType());
    }



}