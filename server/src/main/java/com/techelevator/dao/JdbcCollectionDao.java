package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate template;
    public JdbcCollectionDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }


    private final RowMapper<Collection> mapper = new RowMapper<Collection>(){
        @Override
        public Collection mapRow(ResultSet rs, int rowNum) throws SQLException {
            int collectionId = rs.getInt("collection_id");
            String collectionName = rs.getString("collection_name");
            return new Collection(collectionId, collectionName);
        }
    };

    @Override
    public List<Collection> getAllCollections() {
        return template.query("SELECT * FROM collections", mapper);
    }

    @Override
    public Collection getCollectionById(int collectionId) {
        String sql = "SELECT * FROM collections WHERE collection_id = ?";
        return template.queryForObject(sql,mapper,collectionId);
    }

    @Override
    public Collection getCollectionByCollectionName(String collectionName) {
        String sql = "SELECT * FROM collections WHERE collection_name = ?";
        return template.queryForObject(sql,mapper,collectionName);
    }

    @Override
    public Collection createCollection(Collection newCollection) {
        String sql = "INSERT INTO collections (collection_name) VALUES (?)";
        int id = template.update(sql, newCollection.getName());
        return getCollectionById(id);
    }

    @Override
    public Collection updateCollection(Collection collection) throws DaoException {
        try {
            getCollectionById(collection.getId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection Not Found");
        }
        String sql = "UPDATE collections SET collection_name = ? WHERE collection_id = ?";
         template.update(sql, collection.getName(), collection.getId());
         return getCollectionById(collection.getId());
    }

    @Override
    public int deleteCollectionById(int id) {
        String sql = "DELETE FROM collections WHERE collection_id = ?";
        return template.update(sql, id);
    }
}
