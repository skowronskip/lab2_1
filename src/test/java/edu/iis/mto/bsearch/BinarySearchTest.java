package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testInputSequenceEqualsZero() {
        exception.expect(IllegalArgumentException.class);
        int[] seq = new int[0];
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
    }

    @Test
    public void testWhenSeqHasOneElementAndKeyIsInSeq() {
        int[] seq = new int [1];
        seq[0] = 2;
        int key = 2;
        int expectedIndex = 0;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(expectedIndex, searchResult.getPosition());
    }
}