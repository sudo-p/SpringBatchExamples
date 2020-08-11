package com.example.batchprocessing.Mappers;

import com.example.batchprocessing.Domain.OldCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@Builder
//@NoArgsConstructor
public class CustomerRowMapper implements RowMapper<OldCustomer> {

    @Override
    public OldCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {

        return OldCustomer.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .birthdate(rs.getString("birthdate"))
                .build();
    }
}
