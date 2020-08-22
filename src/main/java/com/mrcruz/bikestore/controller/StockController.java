package com.mrcruz.bikestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.model.Stock;
import com.mrcruz.bikestore.model.StockId;
import com.mrcruz.bikestore.model.Store;
import com.mrcruz.bikestore.repository.StockRepository;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping
	public List<Stock> getStocks(){
		return stockRepository.findAll();
	}
	
	@GetMapping("/{sid}/{pid}")
	public ResponseEntity<Stock> getStock(@PathVariable("sid") Long sId, @PathVariable("pid") Long pId){
		Optional<Stock> stock = stockRepository.findById(new StockId(sId,pId));
		if(stock.isPresent()) {
			return ResponseEntity.ok(stock.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock createStock(@RequestBody Stock stock) {
		stock.setId(new StockId());
		
		return stockRepository.save(stock);
	}
	
	@PutMapping
	public ResponseEntity<Stock> updateStock( @RequestBody Stock stock){
		if(!stockRepository.existsById(stock.getId())) {
			return ResponseEntity.notFound().build();
		}

		stock = stockRepository.save(stock);
		
		return ResponseEntity.ok(stock);
	}
	
	@DeleteMapping("/{sid}/{pid}")
	public ResponseEntity deleteStock(@PathVariable("sid") Long sId, @PathVariable("pid") Long pId) {
		StockId id = new StockId(sId,pId);
		if(!stockRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		stockRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
