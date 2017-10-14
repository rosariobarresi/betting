package com.betting.scraping.writer;

import org.springframework.beans.factory.annotation.Autowired;

import com.betting.dao.entity.MatchEntity;
import com.betting.dao.repository.MatchRepository;
import com.betting.scraping.connection.abstractwriter.WriterAbstract;
import com.betting.scraping.connection.bean.response.Partita;
import com.betting.scraping.connection.bean.response.PartiteLega;

public class WriterMongo extends WriterAbstract<PartiteLega> {
	@Autowired
	private MatchRepository matchRepository;

	@Override
	public void run() {
		while (!codaElaborazione.isFinishReader() || !codaElaborazione.isEmpty()) {
			PartiteLega element = codaElaborazione.dequeue();
			for (Partita partita : element.getListaPartite()) {
				MatchEntity matchEntity = new MatchEntity();
				matchEntity.setMatch(partita.getPartita());
				matchRepository.insertMatch(matchEntity);
			}

		}
	}

}
