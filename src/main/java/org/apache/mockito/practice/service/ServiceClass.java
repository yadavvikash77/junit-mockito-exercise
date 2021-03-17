package org.apache.mockito.practice.service;

public class ServiceClass {
    private DatabaseClass databaseClass;

    public ServiceClass(DatabaseClass databaseClass) {
        this.databaseClass=databaseClass;
    }

    public boolean query(String query){
        return databaseClass.isAvailable();
    }

    public String toString(){
        return "Unique ID :"+String.valueOf(databaseClass.getUniqueId());
    }
}
