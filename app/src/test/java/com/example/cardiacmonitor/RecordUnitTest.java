package com.example.cardiacmonitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecordUnitTest {

    private RecordList mockList()
    {
        RecordList record=new RecordList();
        record.add(mockRecord());
        return record;
    }

    private Record mockRecord()
    {
        return new Record("22/07/2022","11:20pm",130,80,80,"healthy");
    }


    @Test
    public void testAdd()
    {
        RecordList recordList=mockList();
        assertEquals(1,recordList.getRecord().size());

        Record m=new Record("23/07/2022","8:45pm",120,70,85,"Lively");
        recordList.add(m);

        assertEquals(2,recordList.getRecord().size());
        assertTrue(recordList.getRecord().contains(m));
    }

    @Test
    public void testAddException()
    {
        RecordList recordList=mockList();
        assertThrows(IllegalArgumentException.class,()->{
            recordList.add(mockRecord());
        });
    }



    @Test
    public void testGetRecord()
    {
        RecordList recordList = mockList();
        assertEquals(0, mockRecord().compareTo(mockList().getRecord().get(0)));

        Record record = new Record("23/07/2022","8:45pm",120,70,85,"Lively");
        recordList.add(record);

        assertEquals(0, record.compareTo(recordList.getRecord().get(1)));
        assertEquals(0, mockRecord().compareTo(recordList.getRecord().get(0)));
    }

    @Test
    public void testRemove()
    {
        RecordList recordList=mockList();
        Record record = new Record("23/07/2022","8:45pm",120,70,85,"Lively");
        recordList.add(record);
        assertTrue(recordList.getRecord().contains(record));
        recordList.remove(record);
        assertFalse(recordList.getRecord().contains(record));

    }
    @Test
    public void testRemoveException()
    {
        RecordList recordList=mockList();
        Record record = new Record("23/07/2022","8:45pm",120,70,85,"Lively");
        assertThrows(IllegalArgumentException.class,()->{
            recordList.remove(record);
        });
    }

    @Test
    public void testEdit()
    {
        RecordList recordList=mockList();
        Record record = new Record("23/07/2022","8:45pm",120,70,85,"Lively");
        recordList.add(record);
        assertTrue(recordList.getRecord().contains(record));
        Record another=new Record("28/07/2022","1:45am",110,90,95,"Fit");
        recordList.edit(1,another);
        assertFalse(recordList.getRecord().contains(record));
        assertTrue(recordList.getRecord().contains(another));
    }
}
