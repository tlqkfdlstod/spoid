package com.spoid.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import com.spoid.common.DBManager;
import com.spoid.dto.BestDTO;
import com.spoid.dto.ReviewCountDTO;
import com.spoid.mybatis.SqlMapConfig;

public class ReviewDAO {
	private ReviewDAO() {
		
	};
	
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance(){
		return instance;
	}
	SqlSession sqlSession;
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession(); 
	
	
	public double scoreAvg(String cate, String movieCd) {
		int movieCd3 = Integer.parseInt(movieCd);
		
		MongoClient mongoClient = new MongoClient("localhost",27017);
		System.out.println("MongoClient Connected");
		
		
		MongoDatabase db = mongoClient.getDatabase("movie");
		System.out.println("Get 'movie' MongoDatabase");
		String collection = "naverreview";
		if(cate.equals("daum")) {
			collection = "daumreview";
		}
		MongoCollection<Document> collections = db.getCollection(collection);
		System.out.println("데이터베이스명: "+db.getName());
		
		FindIterable<Document> iterate = collections.find();
		MongoCursor<Document> cursor = iterate.iterator();
		System.out.println("나와라아");
		double avg = 0;
		
		System.out.println("==================="+cate+"======================="+movieCd);
		// 평점평균 출력
		while(cursor.hasNext()) {
			Document document = cursor.next();
			int i= 0;
			AggregateIterable<Document> iterable = collections.aggregate(Arrays.asList(
					new Document("$match", new Document("movieCd",movieCd3)),
					new Document("$group", new Document("_id", new Document("movieCd", "$movieCd"))
							.append("total", new Document("$sum",1))
							.append("avgScore", new Document("$avg", "$score")))));
			
			for(Document doc : iterable) {
				System.out.println(doc);
				Document id = (Document) doc.get("_id");
				int movieCd2 = id.getInteger("movieCd");
				System.out.println("===========>>>>"+movieCd2);
				
				String id2 = id.toString();
				System.out.println("===========>>>>>>"+id2);
				
				int  total = doc.getInteger("total");
				System.out.println(doc.get("_id"));
				System.out.println("총합 : "+total);
				
				avg = Math.round((doc.getDouble("avgScore")*10))/10.0;
				System.out.println("되냐 ? "+avg);
				break;
			}
			
			break;
		}
		
		return avg;
	}
	
	
	// 베스트 리뷰 가져오기
	public ArrayList<BestDTO> selectBest(String movieCd) {
		List<BestDTO> list = new ArrayList<>();
		try {
			System.out.println("베스트 댓글 : " + movieCd);
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("bestlist",movieCd);
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return (ArrayList<BestDTO>) list;
	}	
	//평점 분포 
	public ArrayList<ReviewCountDTO> scoreCount(String moviecode,String cate) {
		int movieCd = Integer.parseInt(moviecode);
		
		MongoClient mongoClient = new MongoClient("localhost",27017);
		System.out.println("MongoClient Connected");
		
		ArrayList<ReviewCountDTO> list = new ArrayList<>();
		
		MongoDatabase db = mongoClient.getDatabase("movie");
		System.out.println("Get 'movie' MongoDatabase");
		String collection = "naverreview";
		if(cate.equals("daum")) {
			collection = "daumreview";
		}
		MongoCollection<Document> collections = db.getCollection(collection);
		System.out.println("데이터베이스명: "+db.getName());
		
		FindIterable<Document> iterate = collections.find();
		MongoCursor<Document> cursor = iterate.iterator();

		
		System.out.println("==================="+cate+"======================="+movieCd);
		// 평점평균 출력
		while(cursor.hasNext()) {
			Document document = cursor.next();
			int i= 0;

			AggregateIterable<Document> iterable = collections.aggregate(Arrays.asList(
					new Document("$match", new Document("movieCd",movieCd)),
					new Document("$group", new Document("_id","$score")
								.append("total", new Document("$sum",1))),
					Aggregates.sort(Sorts.ascending("_id"))
					));
			
			for(Document doc : iterable) {
				
				System.out.println(doc);
				
				int score = doc.getInteger("_id");
				int total = doc.getInteger("total");
				System.out.println("점수 : "+score + "개수 "+total);
				
				ReviewCountDTO rdto = new ReviewCountDTO(score, total);
				
				list.add(rdto);
			
			}
			break;
		}
		return list;
					
	}
}
