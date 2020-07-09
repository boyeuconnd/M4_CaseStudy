package codegym.repositories;

import codegym.models.Gallery;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GalleryRepository extends PagingAndSortingRepository<Gallery,Long> {

}
