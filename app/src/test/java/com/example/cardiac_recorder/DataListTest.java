package com.example.cardiac_recorder;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DataListTest {

    /**
     * Test case for adding data to the DataList.
     */
    @Test
    public void testAddData() {
        // Create a new DataList
        DataList dataList = new DataList();

        // Create a new DataModel
        health_info_model dataModel = new health_info_model("01-01-2023", "12:00AM","75", "130", "72");

        // Add the dataModel to the dataList
        dataList.addData(dataModel);

        // Assert that the dataList contains one record
        assertEquals(1, dataList.getData().size());

        // Create another DataModel
        health_info_model dataModel2 = new health_info_model("01-02-2023", "10:00AM","75", "130", "72");

        // Add the dataModel2 to the dataList
        dataList.addData(dataModel2);

        // Assert that the dataList contains two records
        assertEquals(2, dataList.getData().size());

        // Assert that the dataList contains both dataModel and dataModel2
        assertTrue(dataList.getData().contains(dataModel));
        assertTrue(dataList.getData().contains(dataModel2));
    }

    /**
     * Test case for deleting data from the DataList.
     */
    @Test
    public void testDeleteData() {
        // Create a new DataList
        DataList dataList = new DataList();

        // Create a new DataModel
        health_info_model dataModel = new health_info_model("01-02-2023", "10:00AM","75", "130", "72");

        // Add the dataModel to the dataList
        dataList.addData(dataModel);

        // Assert that the dataList contains one record
        assertEquals(1, dataList.getData().size());

        // Create another DataModel
        health_info_model dataModel2 = new health_info_model("03-02-2023", "11:00AM","85", "125", "85");

        // Add the dataModel2 to the dataList
        dataList.addData(dataModel2);

        // Assert that the dataList contains two records
        assertEquals(2, dataList.getData().size());

        // Delete dataModel from the dataList
        dataList.deleteData(dataModel);

        // Assert that the dataList contains one record after deletion
        assertEquals(1, dataList.getData().size());

        // Assert that the dataList no longer contains dataModel
        assertFalse(dataList.getData().contains(dataModel));

        // Delete dataModel2 from the dataList
        dataList.deleteData(dataModel2);

        // Assert that the dataList is empty after deletion
        assertEquals(0, dataList.getData().size());

        // Assert that the dataList no longer contains dataModel2
        assertFalse(dataList.getData().contains(dataModel2));
    }

}