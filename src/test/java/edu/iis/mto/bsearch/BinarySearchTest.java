package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
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
        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasOneElementAndKeyIsNotInSeq() {
        int[] seq = new int [1];
        seq[0] = 2;
        int key = 3;
        int expectedIndex = -1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(false));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasMoreThanOneElementAndKeyIsFirstInSeq() {
        int[] seq = new int [5];
        seq[0] = 1;
        seq[1] = 3;
        seq[2] = 5;
        seq[3] = 7;
        seq[4] = 9;
        int key = 1;
        int expectedIndex = 0;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasMoreThanOneElementAndKeyIsLastInSeq() {
        int[] seq = new int [5];
        seq[0] = 1;
        seq[1] = 3;
        seq[2] = 5;
        seq[3] = 7;
        seq[4] = 9;
        int key = 9;
        int expectedIndex = 4;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasMoreThanOneElementAndKeyIsMiddleInSeq() {
        int[] seq = new int [5];
        seq[0] = 1;
        seq[1] = 3;
        seq[2] = 5;
        seq[3] = 7;
        seq[4] = 9;
        int key = 5;
        int expectedIndex = 2;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasMoreThanOneElementAndKeyIsNotInSeq() {
        int[] seq = new int [5];
        seq[0] = 1;
        seq[1] = 3;
        seq[2] = 5;
        seq[3] = 7;
        seq[4] = 9;
        int key = 11;
        int expectedIndex = -1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(false));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }

    @Test
    public void testWhenSeqHasOnlyOneValueAndKeyIsInSeq() {
        int[] seq = new int [5];
        seq[0] = 1;
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;
        seq[4] = 1;
        int key = 1;
        int expectedIndex = 2;
        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(), is(true));
        Assert.assertThat(expectedIndex, is(searchResult.getPosition()));
    }
}