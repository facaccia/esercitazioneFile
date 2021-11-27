package it.fabio.esercitazione;


import it.fabio.esercitazione.service.ReportService;

public class Main {

	
	public static void main(String[] args) {
		ReportService reportService = new ReportService();
		reportService.chooseFile();
	}
	
}
