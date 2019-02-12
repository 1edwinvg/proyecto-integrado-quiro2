package com.quiromasaje2.spring.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quiromasaje2.spring.app.models.dao.IFacturaDao;
import com.quiromasaje2.spring.app.models.entity.Cliente;
import com.quiromasaje2.spring.app.models.entity.Factura;
import com.quiromasaje2.spring.app.models.entity.ItemFactura;
import com.quiromasaje2.spring.app.models.entity.Producto;
import com.quiromasaje2.spring.app.models.service.IClienteService;
import com.quiromasaje2.spring.app.models.service.IFacturasService;

//@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IFacturasService facturasServices;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private IFacturaDao facturaDao;
	
	@GetMapping("/ver/{id}")
	public Factura ver(@PathVariable(value = "id") Long id) {

		Factura factura = clienteService.fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(id); // clienteService.findFacturaById(id);
		return factura;
	}

	@GetMapping("/form/{clienteId}")
	public Factura crear(@PathVariable(value = "clienteId") Long clienteId) {

		Cliente cliente = clienteService.findOne(clienteId);
		Factura factura = new Factura();
		factura.setCliente(cliente);
		facturaDao.save(factura);
		return factura;
	}

	@GetMapping("/cargar-productos/{term}")
	public List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}

	@PostMapping("/form")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura guardar(@Valid Factura factura,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash) {

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);

			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}
		factura.setCreateAt(new Date());

		
		return  factura;
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		return String.valueOf(this.clienteService.deleteFactura(id));

	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> download(HttpServletRequest request, @PathVariable("id") Long id){
		FileInputStream fis=null;
		try {
			ServletContext context = request.getServletContext();
			File file = facturasServices.getPdfFacturas(request.getLocale(), id);
			String mimeType = context.getMimeType(file.getAbsolutePath());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=" + file.getName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		fis = new FileInputStream(file);
		headers.setContentLength(file.length());
		
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType(mimeType)).body(new InputStreamResource(fis));
		} catch (Exception e) {
			return null;
		}
	}

}
