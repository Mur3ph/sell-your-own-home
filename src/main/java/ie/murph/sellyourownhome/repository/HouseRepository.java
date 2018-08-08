package ie.murph.sellyourownhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ie.murph.sellyourownhome.domain.PhotoInformation;

public interface HouseRepository extends CrudRepository<PhotoInformation, Long>{
	
	@Query("FROM PhotoInformation")
	List<PhotoInformation> findPhotoInformation();

}
