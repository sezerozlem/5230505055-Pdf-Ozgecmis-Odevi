package com.jts.annotation.pdf;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ResumeGenerator {

	public static void main(String[] args) throws DocumentException, MalformedURLException, URISyntaxException, IOException {
		Document doc = new Document();

		PdfWriter.getInstance(doc, new FileOutputStream("Ozgecmis.pdf"));

		doc.open();


		Image img = Image.getInstance("C:\\Users\\sezer\\Desktop\\5230505055-Pdf-Ozgecmis-Odevi\\Pdf Özgeçmiş Ödevi 5230505055 Sezer Özlem\\Picture\\a.png"); // Resminizin dosya yolunu burada belirtin
		img.scaleToFit(100, 100);
		img.setAbsolutePosition(450, 710);
		doc.add(img);


		Paragraph title = new Paragraph("Ozgecmis", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 24, com.itextpdf.text.Font.BOLD));
		title.setAlignment(Element.ALIGN_CENTER);
		doc.add(title);

		doc.add(new Paragraph("\n")); // Boşluk


		doc.add(new Paragraph("Ad: SEZER OZLEM"));
		doc.add(new Paragraph("E-posta: 5230505055@ogr.klu.edu.tr"));
		doc.add(new Paragraph("Telefon: +1234567890"));

		doc.add(new Paragraph("\n")); // Boşluk


		PdfPTable table = new PdfPTable(3);
		tableHeader(table);
		addExperienceRow(table, "Sirket A", "Pozisyon A", "1 Ocak 2020 - 23 Ocak 2021");
		addExperienceRow(table, "Sirket B", "Pozisyon B", "2 Şubat 2022 - 7 Temmuz 2023");
		addExperienceRow(table, "Sirket C", "Pozisyon C", "14 Ekim 2024 - Devam Ediyor");

		doc.add(table);

		doc.close();
	}

	private static void tableHeader(PdfPTable table) {
		Stream.of("Sirket", "Pozisyon", "Tarih Araligi").forEach(title -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.YELLOW);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(title));
			table.addCell(header);
		});
	}

	private static void addExperienceRow(PdfPTable table, String company, String position, String duration) {
		table.addCell(company);
		table.addCell(position);
		table.addCell(duration);
	}
}
