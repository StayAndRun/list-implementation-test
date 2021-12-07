package com.necracker.edu.list;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public abstract class AbstractListInterfaceGeneralMethodsTest {

    List<String> testedList;

    @Before
    public void setUp() throws Exception {
        testedList = initEmptyList();
    }

    @Test
    public void acceptSizeIsCorrectly() {
        populateListWithSimpleStrings(testedList);
        Assertions.assertEquals(5, testedList.size(), "List should contains 5 elements");
    }

    @Test
    public void acceptGetByIndexWorks() {
        populateListWithSimpleStrings(testedList);
        Assertions.assertEquals("1", testedList.get(0));
        Assertions.assertEquals("2", testedList.get(1));
        Assertions.assertEquals("3", testedList.get(2));
        Assertions.assertEquals("4", testedList.get(3));
        Assertions.assertEquals("5", testedList.get(4));
    }

    @Test
    public void acceptGetElementIndexWorks() {
        populateListWithSimpleStrings(testedList);
        Assertions.assertEquals(0, testedList.indexOf("1"));
        Assertions.assertEquals(1, testedList.indexOf("2"));
        Assertions.assertEquals(2, testedList.indexOf("3"));
        Assertions.assertEquals(3, testedList.indexOf("4"));
        Assertions.assertEquals(4, testedList.indexOf("5"));

    }

    @Test
    public void acceptIsEmptyMethodDone() {
        Assertions.assertTrue(testedList.isEmpty());
        testedList.add("1");
        Assertions.assertFalse(testedList.isEmpty());
    }

    @Test
    public void acceptContainsMethodIsDone() {
        populateListWithSimpleStrings(testedList);
        Assertions.assertTrue(testedList.contains("1"));
        Assertions.assertTrue(testedList.contains("2"));
        Assertions.assertTrue(testedList.contains("3"));
        Assertions.assertTrue(testedList.contains("4"));
        Assertions.assertTrue(testedList.contains("5"));
        Assertions.assertFalse(testedList.contains("45"));
    }

    @Test
    public void acceptElementIsRemoved() {
        populateListWithSimpleStrings(testedList);
        testedList.remove("4");
        Assertions.assertEquals(4, testedList.size());
        Assertions.assertEquals("1", testedList.get(0));
        Assertions.assertEquals("2", testedList.get(1));
        Assertions.assertEquals("3", testedList.get(2));
        Assertions.assertEquals("5", testedList.get(3));
    }

    @Test
    public void acceptElementRemovedByIndex() {
        populateListWithSimpleStrings(testedList);
        testedList.remove(2);
        Assertions.assertEquals(4, testedList.size());
        Assertions.assertEquals("1", testedList.get(0));
        Assertions.assertEquals("2", testedList.get(1));
        Assertions.assertEquals("4", testedList.get(2));
        Assertions.assertEquals("5", testedList.get(3));
    }

    @Test
    public void acceptAddElementToTail() {
        populateListWithSimpleStrings(testedList);
        testedList.add("6");
        Assertions.assertEquals(6, testedList.size());
        Assertions.assertEquals("6", testedList.get(5));
    }

    @Test
    public void acceptInsertElementByIndex() {
        populateListWithSimpleStrings(testedList);
        testedList.add(2, "42");
        Assertions.assertEquals(6, testedList.size());
        Assertions.assertEquals("1", testedList.get(0));
        Assertions.assertEquals("2", testedList.get(1));
        Assertions.assertEquals("42", testedList.get(2));
        Assertions.assertEquals("3", testedList.get(3));
        Assertions.assertEquals("4", testedList.get(4));
        Assertions.assertEquals("5", testedList.get(5));
    }

    @Test
    public void acceptSetElementValueByIndex() {
        populateListWithSimpleStrings(testedList);
        testedList.set(4, "42");
        Assertions.assertEquals(5, testedList.size());
        Assertions.assertEquals("1", testedList.get(0));
        Assertions.assertEquals("2", testedList.get(1));
        Assertions.assertEquals("3", testedList.get(2));
        Assertions.assertEquals("4", testedList.get(3));
        Assertions.assertEquals("42", testedList.get(4));
    }

    @Test
    public void acceptClearMethodIsDone() {
        populateListWithSimpleStrings(testedList);
        testedList.clear();
        Assertions.assertEquals(0, testedList.size());
        Assertions.assertTrue(testedList.isEmpty());
    }

    @Test
    public void acceptEqualsListsWithSameData() {
        List<String> first = initEmptyList();
        first.add("1");
        first.add("2");
        List<String> second = initEmptyList();
        second.add("1");
        second.add("2");
        Assertions.assertTrue(first.equals(second), "Lists with same data should be equals!");
    }

    @Test
    public void rejectEqualsListsWithDifferentData() {
        List<String> first = initEmptyList();
        first.add("1");
        first.add("2");
        first.add("3");
        List<String> second = initEmptyList();
        second.add("1");
        second.add("2");
        Assertions.assertFalse(first.equals(second), "Lists with same data should not be equals!");
    }


    private List<String> populateListWithSimpleStrings(List<String> list) {
        for (int value = 1; value <=5; value++) {
            list.add(String.valueOf(value));
        }
        return list;
    }

    protected abstract List<String> initEmptyList();
}
