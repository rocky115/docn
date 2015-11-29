/**
 * 
 */
package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author rm
 *
 */
public interface BookRepository extends MongoRepository<Book,String>
{
	@Query("{'pages':{$gt : ?0,$lt : ?1}}")
	public List<Book> findPagesInBetween(int start , int end);

}
