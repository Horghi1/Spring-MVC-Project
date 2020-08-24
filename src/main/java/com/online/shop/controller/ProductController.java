package com.online.shop.controller;


import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.online.shop.domain.Client;
import com.online.shop.domain.Sale;
import com.online.shop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.online.shop.domain.Product;
import com.online.shop.exception.InvalidProductException;
import com.online.shop.service.ProductService;
import com.online.shop.utils.Validator;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@Autowired
        private ClientService clientService;
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model){
		Product p = productService.getProductById(productId);
                if(p == null) {
                    return "redirect:/products";
                }
                
		List<Client> clients = clientService.getAllClients();

		model.addAttribute("product", p);
		model.addAttribute("clients", clients);
		model.addAttribute("newSale", new Sale());
                
		return "product/product";
	}
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "product/products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "product/addProduct";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, 
                Model model, BindingResult result, HttpServletRequest request){

            try {
                Validator.validateProduct(newProduct);
            } catch(InvalidProductException e) {
                model.addAttribute("error", e.getMessage());
                return "product/addProduct";
            }
                
                
		newProduct.setProductId(UUID.randomUUID().toString());
		String[] supressedFields = result.getSuppressedFields();
		if(supressedFields.length > 0){
			throw new RuntimeException("Attempting to bind disallowed fields:"+ StringUtils.arrayToCommaDelimitedString(supressedFields));
		}
		
		MultipartFile productImage = newProduct.getProductImage();
		String fileName = productImage.getOriginalFilename();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
                newProduct.setProductId(UUID.randomUUID().toString());
		if(productImage != null && !productImage.isEmpty()){
			try{
				File file = new File(rootDirectory+"\\WEB-INF\\resources\\images\\" + newProduct.getProductId() + "." +
								productService.getFileExtension(fileName));
				productImage.transferTo(file);
			} catch( Exception e){
				throw new RuntimeException("Product Image saving failed!", e);
			}
		}
		
		newProduct.setImageSource(newProduct.getProductId()+"."+ productService.getFileExtension(fileName));
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateClientById(@RequestParam("id") String productId, Model model) {
            Product updateProduct = productService.getProductById(productId);
            model.addAttribute("updateProduct", updateProduct);
            return "product/updateProduct";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateClientById(@RequestParam("id") String productId, 
                Product updateProduct, Model model) {
            try {
                Validator.validateProduct(updateProduct);
            } catch(InvalidProductException e) {
                model.addAttribute("error", e.getMessage());
                model.addAttribute("updateProduct", updateProduct);
                
                return "product/updateProduct";
            }
	
            productService.updateProduct(productId, updateProduct);
            return "redirect:/products/product?id=" + productId;
	}

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteClientById(@RequestParam("id") String productId, Model model) {
        productService.deleteProduct(productId);
        return "redirect:/products";
    }

}
