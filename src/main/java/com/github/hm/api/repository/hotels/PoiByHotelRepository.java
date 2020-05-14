package com.github.hm.api.repository.hotels;

import com.github.hm.api.beans.db.keyspaces.hotels.PoiByHotel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiByHotelRepository extends CassandraRepository<PoiByHotel, String> {
}
