package com.necracker.edu.list;

import java.util.LinkedList;
import java.util.List;

public class DefaultLinkedListTest extends AbstractListInterfaceGeneralMethodsTest {

    @Override
    protected List<String> initEmptyList() {
        return new LinkedList<>();
    }
}
