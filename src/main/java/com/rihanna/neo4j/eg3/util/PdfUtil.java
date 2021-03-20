package com.rihanna.neo4j.eg3.util;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;

public class PdfUtil {

	public Document generateRecipeListPdf(Document document, Map<Integer, List<Recipe>> recipesPerDay) throws FileNotFoundException, DocumentException {

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		
		for(Integer i : recipesPerDay.keySet()) {
			List<Recipe> recipes = recipesPerDay.get(i);
			
			Chunk chunk = new Chunk("Day " + i, font);
			document.add(chunk);
			document.add( Chunk.NEWLINE );

			PdfPTable table = new PdfPTable(new float[] { 30, 70 });
			table.setSpacingAfter(25);
			table.setSpacingBefore(5);
			addTableHeader(table);

			for(Recipe recipe : recipes) {
				addIngredientsCell(table, recipe);
				addInstruction(table, recipe);
			}

			document.add(table);
		}
		
		document.close();
		
		return document;
	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("Ingredients", "Instructions").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(new BaseColor(142, 195, 252));
			header.setBorderWidth(1);
			header.setExtraParagraphSpace(4);
			header.setPhrase(new Phrase(columnTitle, new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.WHITE)));
			table.addCell(header);
		});
	}

	private void addInstruction(PdfPTable table, Recipe recipe) {
		table.addCell(recipe.getInstructions());
	}
	
	private void addIngredientsCell(PdfPTable table, Recipe recipe) {
		PdfPCell ings = new PdfPCell();
		ings.setExtraParagraphSpace(3);
		
		String cellContent = "";
		if(recipe == null || recipe.getIngredients() == null)
			System.out.println(recipe);
		
		for(int i = 0; i < recipe.getIngredients().size(); i++) {
			IngredientQuantity iq = recipe.getIngredients().get(i);
			cellContent += (i+1) + ". " + iq.getIngredient().getName() + " " + iq.getQuantity() + 
					(iq.getMeasurementType() == null ? "gr" : iq.getMeasurementType()) + "\n";
		}
		ings.setPhrase(new Phrase(cellContent));
		table.addCell(ings);
	}

//	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
//		Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
//		Image img = Image.getInstance(path.toAbsolutePath().toString());
//		img.scalePercent(10);
//
//		PdfPCell imageCell = new PdfPCell(img);
//		table.addCell(imageCell);
//
//		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
//		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table.addCell(horizontalAlignCell);
//
//		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
//		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
//		table.addCell(verticalAlignCell);
//	}
}
