package com.betting.scraping;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.betting.scraping.bean.MarkerBean;

public class CodaElaborazione<T extends MarkerBean> {

	private Queue<T> listaDirigenti = new LinkedBlockingQueue<T>();
	private boolean finishReader = false;

	public void enqueue(T d) {
		listaDirigenti.add(d);
		synchronized (listaDirigenti) {
			listaDirigenti.notifyAll();
		}

	}

	public T dequeue() {
		while (listaDirigenti.size() == 0 && finishReader == false) {
			try {
				synchronized (listaDirigenti) {
					listaDirigenti.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return listaDirigenti.size() != 0 ? listaDirigenti.remove() : null;
	}

	public void setFinishReader(boolean finishReader) {
		this.finishReader = finishReader;
		synchronized (listaDirigenti) {
			listaDirigenti.notifyAll();
		}
	}

	public boolean isFinishReader() {
		return finishReader;
	}

	public boolean isEmpty() {
		return listaDirigenti.isEmpty();
	}

}
