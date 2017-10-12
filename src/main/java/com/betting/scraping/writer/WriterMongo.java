package com.betting.scraping.writer;

<<<<<<< HEAD:src/main/java/com/betting/scraping/writer/WriterMongo.java
import java.io.IOException;

import javax.swing.text.AbstractWriter;
import javax.swing.text.BadLocationException;

import com.betting.scraping.connection.abstractwriter.WriterAbstract;
import com.betting.scraping.connection.bean.response.PartiteLega;
=======
import betting.scraping.connection.abstractwriter.WriterAbstract;
import betting.scraping.connection.bean.response.Partita;
import betting.scraping.connection.bean.response.PartiteLega;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
>>>>>>> 348cff16e52e5a3ba4a3f99bff43fae21d821c48:src/main/java/betting/scraping/writer/WriterMongo.java

public class WriterMongo extends WriterAbstract<PartiteLega> {
	private MongoClient mongoClient;
	private MongoDatabase db;

	public WriterMongo () {
		mongoClient = new MongoClient( "localhost" , 27017 );
		db = mongoClient.getDatabase( "Matches" );
		db.createCollection("testCollection");
	}

	@Override
	public void run() {
		while (!codaElaborazione.isFinishReader() || !codaElaborazione.isEmpty()) {
			PartiteLega element = codaElaborazione.dequeue();
			for(Partita partita : element.getListaPartite()){
				Document doc = new Document("match", partita.getPartita())
						.append("home", partita.getQuotaVittoriaCasa())
						.append("away", partita.getQuotaVittoriaFuoriCasa())
						.append("draw", partita.getQuotaPareggio())
						.append("under25", partita.getQuotaUnder())
						.append("over25", partita.getQuoteOver())
						.append("goal", partita.getQuotaGoal())
						.append("nogoal", partita.getQuotaNoGoal());

				MongoCollection<Document> collection = db.getCollection("testCollection");

				collection.insertOne(doc);
			}

		}
	}

}
