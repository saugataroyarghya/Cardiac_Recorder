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
    /**
     * Test case for adding a duplicate record to the DataList, expecting an exception to be thrown.
     */
    @Test
    public void testAddRecordException() {
        // Create a new DataList
        DataList dataList = new DataList();

        // Create a new DataModel
        health_info_model dataModel = new health_info_model("03-02-2023", "11:00AM","85", "125", "85");


        // Add the dataModel to the dataList
        dataList.addData(dataModel);

        // Assert that adding the same dataModel again throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> dataList.addData(dataModel));
    }

    /**
     * Test case for deleting a record that does not exist in the DataList, expecting an exception to be thrown.
     */
    @Test
    public void testDeleteRecordException() {
        // Create a new DataList
        DataList dataList = new DataList();

        // Create a new DataModel
        health_info_model dataModel = new health_info_model("03-02-2023", "11:00AM","85", "125", "85");


        // Add the dataModel to the dataList
        dataList.addData(dataModel);

        // Assert that adding the same dataModel again throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> dataList.addData(dataModel));

        // Delete the dataModel from the dataList
        dataList.deleteData(dataModel);

        // Assert that deleting the same dataModel again throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> dataList.deleteData(dataModel));
    }

    /**
     * Test case for updating a data record in the DataList.
     */
    @Test
    public void testUpdateData() {
        // Create a new DataList
        DataList dataList = new DataList();

        // Create initial data
        health_info_model data1 = new health_info_model("03-02-2023", "11:00AM","85", "125", "85");

        health_info_model data2 = new health_info_model("03-02-2023", "11:00AM","88", "130", "95");


        // Add initial data to the list
        dataList.addData(data1);
        dataList.addData(data2);

        // Create updated data
        health_info_model updatedData = new health_info_model("03-02-2023", "11:00AM","85", "125", "85");


        // Update the first data entry
        dataList.updateData(data1, updatedData);

        // Check if the data was updated
        Assert.assertEquals(2, dataList.countData());  // Number of records should remain the same
        Assert.assertEquals(updatedData, dataList.getData().get(0));  // Updated data should be at index 0
        Assert.assertEquals(data2, dataList.getData().get(1));  // Second data should remain unchanged
    }

}