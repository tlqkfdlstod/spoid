//package com.spoid.action;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//
//public class AvgScoreAction implements Action {
//
//	@Override
//	public ActionForward excute(HttpServletRequest paramHttpServletRequest,
//			HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
//		
//		
//		MongoClient mongoClient = new MongoClient("localhost",27017);
//		System.out.println("MongoClient Connected");
//		
//		MongoDatabase db = mongoClient.getDatabase("movie");
//		System.out.println("Get 'movie' MongoDatabase");
//		
//		MongoCollection<Document> collections = db.getCollection("naverreview");
//		System.out.println("데이터베이스명: "+db.getName());
//		
//		FindIterable<Document> iterate = collections.find();
//		MongoCursor<Document> cursor = iterate.iterator();
//		System.out.println("나와라아");
//		
//		// 평점평균 출력
//		while(cursor.hasNext()) {
//			Document document = cursor.next();
//
//			AggregateIterable<Document> iterable = collections.aggregate(Arrays.asList(
//		            new Document("$group", new Document("_id", new Document("movieCd", "$movieCd").append("total", "$sum") ).append("avgScore", new Document("$avg", "$score")))));
//				
//			for(Document doc : iterable) {
//				System.out.println(doc);
//			}
//			break;
//				
//		}
//		
//		return null;
//	}
//	
//}
