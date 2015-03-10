package tose.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import tose.model.SearchResultMetadataDTO;
import tose.util.ToseConstants;

public class SearchApi {

	// TODO Nicht DTO zur�ckgeben, sondern ein JSON String
	public static List<SearchResultMetadataDTO> search(String searchParameter) {
		// Connection is the only JDBC resource that we need
		// PreparedStatement and ResultSet are handled by jOOQ, internally
		try (Connection conn = DriverManager.getConnection(ToseConstants.DB_URL, ToseConstants.DB_USER,
				ToseConstants.DB_PASSWORD)) {

			// DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			// Result<Record> result = create.select().from(AUTHOR).fetch();
		}

		// For the sake of this tutorial, let's keep exception handling simple
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// TODO Nicht DTO zur�ckgeben, sondern ein JSON String
	public static List<SearchResultMetadataDTO> mockSearch() {
		List<SearchResultMetadataDTO> results = new ArrayList<SearchResultMetadataDTO>();
		
		List<String> tags = new ArrayList<String>();
		tags.add("test");
		tags.add("tranny");
		tags.add("nice");

		SearchResultMetadataDTO item1 = new SearchResultMetadataDTO(
				"https://www.flickr.com/photos/klink692/14001294434/sizes/l/",
				"test 003", 0, "https://www.flickr.com/photos/klink692/", tags);
		
		SearchResultMetadataDTO item2 = new SearchResultMetadataDTO(
				"https://www.flickr.com/photos/manart/5513630131/sizes/o/",
				"Life size Frankenstein head", 15, "https://www.flickr.com/photos/manart/", tags);
		
		SearchResultMetadataDTO item3 = new SearchResultMetadataDTO(
				"https://www.flickr.com/photos/33365398@N05/3831923403/sizes/o/",
				"Pikachu Lolz", 0, "https://www.flickr.com/photos/33365398@N05/", tags);
		
		results.add(item1);
		results.add(item2);
		results.add(item3);
		
		return results;
	}
}
