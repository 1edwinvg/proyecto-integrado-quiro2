package com.quiromasaje2.spring.app.models.service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.quiromasaje2.spring.app.models.dao.IFacturaDao;
import com.quiromasaje2.spring.app.models.entity.Factura;
import com.quiromasaje2.spring.app.models.entity.ItemFactura;

@Service
public class FacturasServiceImpl implements IFacturasService{
	
	@Autowired
	private IFacturaDao facturaDao;

	@Override
	public File getPdfFacturas(Locale locale, Long id) throws Exception {
		
		Factura factura = facturaDao.fetchByIdWithClienteWhithItemFacturaWithProducto(id);
		
		Document document = new Document();
		
		if(!new File("/temp/").exists()) {
			new File("/temp/").mkdirs();
		}
		
		PdfWriter.getInstance(document, new FileOutputStream("/temp/"+id+".pdf"));
		 
		document.open();
		
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("Datos del cliente"));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		tabla.addCell(cell);
		
		
		tabla.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		tabla.addCell(factura.getCliente().getEmail());
		
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);
		
		
		cell = new PdfPCell(new Phrase("Datos de la factura"));
		cell.setBackgroundColor(new Color(195, 230, 203));
		cell.setPadding(8f);
		
		tabla2.addCell(cell);
		tabla2.addCell("folio" + ": " +  factura.getId());
		tabla2.addCell("descripcion" + ": " + factura.getDescripcion());
		tabla2.addCell("fecha" + ": " + factura.getCreateAt());
		
		document.add(tabla);
		document.add(tabla2);
		
		PdfPTable tabla3 = new PdfPTable(4);
		tabla3.setWidths(new float [] {3.5f, 1, 1, 1});
		tabla3.addCell("Producto");
		tabla3.addCell("Precio");
		tabla3.addCell("Cantidad");
		tabla3.addCell("Total");
		
		for(ItemFactura item: factura.getItems()) {
			tabla3.addCell(item.getProducto().getNombre());
			tabla3.addCell(item.getProducto().getPrecio().toString());
			
			cell = new PdfPCell(new Phrase(item.getCantidad().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			tabla3.addCell(item.calcularImporte().toString());
		}
		
	    cell = new PdfPCell(new Phrase("Gran Total" + ": "));
	    cell.setColspan(3);
	    cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	    tabla3.addCell(cell);
	    tabla3.addCell(factura.getTotal().toString());
	    
	    document.add(tabla3);
	   
	    document.close();
	    
		return new File("/temp/"+id+".pdf");
	}

	
}
