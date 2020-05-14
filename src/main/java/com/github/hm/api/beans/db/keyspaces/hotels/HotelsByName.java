package com.github.hm.api.beans.db.keyspaces.hotels;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class HotelsByName {
    @PrimaryKey
    private String name;
    private String phone;
    @CassandraType(type = DataType.Name.UDT, userTypeName = "address")
    private HotelAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HotelAddress getAddress() {
        return address;
    }

    public void setAddress(HotelAddress address) {
        this.address = address;
    }
}