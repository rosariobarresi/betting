package com.betting.scraping.writer;

import org.springframework.beans.factory.annotation.Autowired;

import com.betting.dao.entity.EurobetMatchEntity;
import com.betting.dao.repository.EurobetMatchRepository;
import com.betting.scraping.connection.abstractwriter.WriterAbstract;
import com.betting.scraping.connection.bean.response.Partita;
import com.betting.scraping.connection.bean.response.PartiteLega;

public class WriterMongo extends WriterAbstract<PartiteLega> {
	@Autowired
	private EurobetMatchRepository matchRepository;

	@Override
	public void run() {
		while (!codaElaborazione.isFinishReader() || !codaElaborazione.isEmpty()) {
			PartiteLega element = codaElaborazione.dequeue();
			for (Partita partita : element.getListaPartite()) {
				EurobetMatchEntity eurobetMatchEntity = new EurobetMatchEntity();
				eurobetMatchEntity.setMatch(partita.getPartita());
				eurobetMatchEntity.setAwayWins(partita.getQuotaVittoriaFuoriCasa());
				eurobetMatchEntity.setDraw(partita.getQuotaPareggio());
				eurobetMatchEntity.setGoal(partita.getQuotaGoal());
				eurobetMatchEntity.setHomeWins(partita.getQuotaVittoriaCasa());
				eurobetMatchEntity.setIdMatch(partita.getPartita().hashCode());
				eurobetMatchEntity.setNoGoal(partita.getQuotaNoGoal());
				eurobetMatchEntity.setOver25(partita.getQuoteOver());
				eurobetMatchEntity.setTime(System.currentTimeMillis());
				eurobetMatchEntity.setUnder25(partita.getQuotaUnder());
				matchRepository.insertMatch(eurobetMatchEntity);
			}

		}
	}

}
