package com.daa.cli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CLITest {

    @Test
    public void testMergesort() {

        String[] args = {"mergesort", "5,2,8,3,1,4"};
        CLI.main(args);

    }

    @Test
    public void testClosestPair() {

        String[] args = {"closestpair", "0,0,1,1,2,2,3,3"};
        CLI.main(args);

    }
}
