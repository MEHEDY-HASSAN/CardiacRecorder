package com.example.cardiacmonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that keeps track of list of Record
 */

public class RecordList {
    List<Record> records = new ArrayList<>();

    /**
     * This adds record to the arrayList
     * @param record
     *      This is the record to add
     */

    public void add(Record record)
    {
        if(records.contains(record))
        {
            throw new IllegalArgumentException();
        }
        records.add(record);
    }

    /**
     * This removes a record from the list
     * @param record
     *      This is the record to delete
     */

    public void remove(Record record)
    {
        if(records.contains(record))
        {
            records.remove(record);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This is edits a record in given position
     * @param pos
     *      the position where we will edit
     * @param record
     *      the record which will update the values
     */

    public void edit(int pos, Record record)
    {
        records.set(pos,record);
    }

    /**
     * This returns the list
     * @return
     *      return the list
     */

    public List<Record>getRecord()
    {
        return records;
    }
}
