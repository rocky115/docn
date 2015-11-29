package hello;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private BookRepository repo;

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping(value = "/get/{bookid}")
	public Book getBook(@PathVariable("bookid") String bookid) {

		return repo.findOne(bookid);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map<String, Object> createBook(
			@RequestBody Map<String, Object> bookMap) {
		List<Remark> list = new ArrayList<Remark>();
		Remark r1 = new Remark();
		r1.setRemarkString("good");
		list.add(r1);

		Remark r2 = new Remark();
		r2.setRemarkString("fair");
		list.add(r2);

		
		Book book = new Book(bookMap.get("name").toString(), bookMap
				.get("isbn").toString(), bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString()),list

		);

		Map<String, Object> response = new LinkedHashMap<String, Object>();

		response.put("message", "seuccess");
		response.put("book", repo.save(book));

		return response;
	}

	@RequestMapping(value = "/del/{bookid}")
	public String delBook(@PathVariable("bookid") String bookid) {
		repo.delete(bookid);
		return "deleted successfully";
	}

	@RequestMapping(value = "/edit/{bookid}", method = RequestMethod.PUT)
	public Map<String, Object> editBook(@PathVariable("bookid") String bookid,
			@RequestBody Map<String, Object> bookMap) {

		Book book = new Book(bookMap.get("name").toString(), bookMap
				.get("isbn").toString(), bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString())

		);
		book.setId(bookid);

		Map<String, Object> response = new LinkedHashMap<String, Object>();

		response.put("message", "seuccess");
		response.put("book", repo.save(book));

		return response;
	}

	
}
