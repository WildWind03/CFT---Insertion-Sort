package com.chirikhin.cft.test_task;

import org.junit.Assert;
import org.junit.Test;

public class ArgumentParserTest {
    @Test(expected = IllegalArgumentException.class)
    public void parseConfigurationException() {
        ArgumentParser.parseConfiguration(new String[]{null, null, null, null});
        ArgumentParser.parseConfiguration(null);
        ArgumentParser.parseConfiguration(new String[]{"a", "b", "c", "d", "e"});
        ArgumentParser.parseConfiguration(new String[]{"a", "b"});
        ArgumentParser.parseConfiguration(new String[]{"in", "out", "-f", "-a"});
        ArgumentParser.parseConfiguration(new String[]{"in", "out", "-d", "-g"});
    }

    @Test
    public void parseConfiguration() {
        SortConfiguration sortConfiguration = ArgumentParser.parseConfiguration(new String[]{"in", "out", "-s", "-a"});
        Assert.assertEquals("in", sortConfiguration.getInFilename());
        Assert.assertEquals("out", sortConfiguration.getOutFilename());
        Assert.assertEquals(SortConfiguration.SortType.ASCENDING, sortConfiguration.getSortType());
        Assert.assertEquals(SortConfiguration.SourceType.STRING, sortConfiguration.getSourceType());
    }



}