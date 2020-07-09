package codegym.service;

import codegym.models.Gallery;

public interface GalleryService {
    Iterable<Gallery> findAll();

    Gallery findOne(Long id);

    Gallery save (Gallery gallery);

    Gallery delete(Long id);
}
