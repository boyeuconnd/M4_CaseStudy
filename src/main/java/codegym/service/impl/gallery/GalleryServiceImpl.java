package codegym.service.impl.gallery;

import codegym.models.Gallery;
import codegym.repositories.GalleryRepository;
import codegym.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Iterable<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery findOne(Long id) {
        return galleryRepository.findOne(id);
    }

    @Override
    public Gallery save(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery delete(Long id) {
        Gallery gallery = galleryRepository.findOne(id);
        galleryRepository.delete(id);
        return gallery;
    }
}
