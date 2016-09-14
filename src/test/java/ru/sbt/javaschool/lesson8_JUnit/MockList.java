package ru.sbt.javaschool.lesson8_JUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by скурихин on 01.09.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockList {

    @Mock
    private List<String> mockedList;

    @Mock
    private List<String> mockedList1;

    @Mock
    private List<String> mockedList2;

    @Mock
    private List<String> mockedList3;

    @Test
    public void testVerifyList() {
        mockedList.add("One");
        mockedList.add("Two");
        mockedList.add("Two");

        verify(mockedList).add("One");
        verify(mockedList, times(2)).add("Two");
        verify(mockedList, never()).add("Three");
        verify(mockedList).add("One");
    }

//    @Test(expected = NullPointerException.class)
//    public void asdfadsf(){
//
//    }


}
