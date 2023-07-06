package com.example.cardiac_recorder;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of data records.
 */
public class DataList {

    public List<health_info_model> records = new ArrayList<>(); // a list of type "AddNewData" is declared

    /**
     * Adds a new data record to the list.
     *
     * @param data The new record to be added.
     * @throws IllegalArgumentException if the data already exists in the list.
     */
    public void addData(health_info_model data) {
        if (records.contains(data)) {
            throw new IllegalArgumentException("Data already exists");
        }
        records.add(data);
    }

    /**
     * Returns the list of data records.
     *
     * @return The list of data records.
     */
    public List<health_info_model> getData() {
        List<health_info_model> dataList = records;
        return dataList;
    }

    /**
     * Deletes a particular data record from the list.
     *
     * @param data The data record to be deleted.
     * @throws IllegalArgumentException if the data does not exist in the list.
     */
    public void deleteData(health_info_model data) {
        if (records.contains(data)) {
            records.remove(data);
        } else {
            throw new IllegalArgumentException("Data not found");
        }
    }

    /**
     * Returns the size of the data list.
     *
     * @return The size of the data list.
     */
    public int countData() {
        return records.size();
    }

    /**
     * Updates a data record in the list.
     *
     * @param oldData The old data record to be updated.
     * @param newData The new data record.
     * @throws IllegalArgumentException if the old data record is not found in the list.
     */
    public void updateData(health_info_model oldData, health_info_model newData) {
        int index = records.indexOf(oldData);
        if (index != -1) {
            records.set(index, newData);
        } else {
            throw new IllegalArgumentException("Data not found");
        }
    }
}