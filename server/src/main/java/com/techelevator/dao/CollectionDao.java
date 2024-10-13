package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    List<Collection> getAllCollections();
    Collection getCollectionById(int collectionId);
    Collection getCollectionByCollectionName (String collectionName);
    Collection createCollection(Collection newCollection);
    Collection updateCollection(Collection collection);

    int deleteCollectionById(int id);
}
