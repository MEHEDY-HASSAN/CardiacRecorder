package com.example.cardiacmonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that keeps track of list of Record
 */

public class RecordList {
    List<Record> records = new ArrayList<>();

    /**
     * @param record : Record
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
     * @param record : Record
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
     * @param  pos : int
     * @param record : Record
     */
    public void edit(int pos, Record record)
    {
        records.set(pos,record);
    }

    /**
     * @return : Record
     */
    public List<Record>getRecord()
    {
        return records;
    }
}
