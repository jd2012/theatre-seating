/**
 * This file is part of bagarino.
 *
 * bagarino is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * bagarino is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with bagarino.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.bagarino.repository;

import io.bagarino.datamapper.AutoGeneratedKey;
import io.bagarino.datamapper.Bind;
import io.bagarino.datamapper.Query;
import io.bagarino.datamapper.QueryRepository;
import io.bagarino.model.Event;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.Date;

@QueryRepository
public interface EventRepository {

    @Query("select * from event where id = :eventId")
    Event findById(@Bind("eventId") int eventId);

    @Query("insert into event(description, short_name, owner, location, latitude, longitude, start_ts, end_ts, regular_price, currency, available_seats, vat_included, vat) " +
            "values(:description, :shortName, :owner, :location, :latitude, :longitude, :start_ts, :end_ts, :regular_price, :currency, :available_seats, :vat_included, :vat)")
    @AutoGeneratedKey
    Pair<Integer, Integer> insert(@Bind("description") String description, @Bind("shortName") String shortName, @Bind("owner") int owner, @Bind("location") String location,
               @Bind("latitude") String latitude, @Bind("longitude") String longitude, @Bind("start_ts") Date begin,
               @Bind("end_ts") Date end, @Bind("regular_price") BigDecimal regular_price, @Bind("currency") String currency,
               @Bind("available_seats") int available_seats, @Bind("vat_included") boolean vat_included, @Bind("vat") BigDecimal vat);

}
