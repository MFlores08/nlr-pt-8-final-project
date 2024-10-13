package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {
    private CollectionDao collectionDao;

    public CollectionController(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Collection> getAllCollections(){
        List<Collection> collections = collectionDao.getAllCollections();
        if (collections == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
        } else {
            return collections;
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{collectionName}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public Collection getCollectionByName(@PathVariable String collectionName){
            Collection collection = collectionDao.getCollectionByCollectionName(collectionName);
            if (collection == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
            } else {
                return collection;
            }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{collectionId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public Collection getCollectionById(@PathVariable int collectionId){
        Collection collection = collectionDao.getCollectionById(collectionId);
        if (collection == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
        } else {
            return collection;
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Collection createCollection(@RequestBody Collection collection){
        Collection createdCollection = collectionDao.createCollection(collection);
        if (createdCollection == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
        } else {
            return createdCollection;
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Collection updateCollection(@RequestBody Collection collection, @PathVariable int id){
        collection.setId(id);
        try {
            Collection updatedCollection = collectionDao.updateCollection(collection);
            return updatedCollection;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection Not Found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCollectionById(@PathVariable int id) {
        int rowsAffected = collectionDao.deleteCollectionById(id);
        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found", null);
        }
    }
}
