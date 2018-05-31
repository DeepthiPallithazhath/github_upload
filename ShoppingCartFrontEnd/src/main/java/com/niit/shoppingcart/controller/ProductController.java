package com.niit.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession httpSession;

	@RequestMapping("admin/product/save")
	public ModelAndView saveProduct(
			@RequestParam String name, 
			@RequestParam String description,
			@RequestParam String price,
			@RequestParam String id,
			@RequestParam int cid,@RequestParam int sid,@RequestParam("file") MultipartFile file,HttpServletRequest request
			) {

		ModelAndView mv = new ModelAndView("redirect:/admin");
		product.setDescription(description);
		product.setName(name);
		product.setId(id);
		product.setCategory(categoryDAO.get(cid));
		//String value should be converted into integer
		product.setSupplier(supplierDAO.get(sid));
		
		product.setPrice(Integer.parseInt(price));
		/*String originalfile = file.getOriginalFilename();
		product.setP_image(originalfile);
String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();

		

		System.out.println(filepath);

		try {

			byte imagebyte[] = file.getBytes();

			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));

			fos.write(imagebyte);

			fos.close();

			} catch (IOException e) {

			e.printStackTrace();

			} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}*/

	
		
	/*try {

			byte imagebyte[] = file.getBytes();

			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));

			fos.write(imagebyte);

			fos.close();

			} catch (IOException e) {

			e.printStackTrace();

			} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			}*/
		// need to write one more condition.
		
	
		
		if (productDAO.save(product)) {
			
			String path="F:\\Project_ShoppingCart\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images\\";
			
			path=path+String.valueOf(product.getId())+".jpg";
			
			System.out.println("Path ...."+path);
			File filepath=new File(path);
			try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mv.addObject("message", "Product created Successfully");
			return mv;
		} else {
			mv.addObject("message", "Could not create product.");

		}
		return mv;

	}
	
	
	@RequestMapping("admin/product/delete")
	public ModelAndView deleteProduct(@RequestParam String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/admin");
		
		if(productDAO.delete(id))
		{
			mv.addObject("message", "The product successfully deleted");
		}
		else
		{
			mv.addObject("message", "Could not delete the product.  Please try after some time.");
		}
		return mv;
	}
	
	@RequestMapping("admin/product/update")
	public ModelAndView updateC(
			@RequestParam String name, 
			@RequestParam String description,
			@RequestParam String price,
			@RequestParam String id,
			@RequestParam int cid,@RequestParam int sid,@RequestParam("file") MultipartFile file,HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("redirect:/admin");
		product=productDAO.get(id);
		product.setDescription(description);
		product.setName(name);
		product.setCategory(categoryDAO.get(cid));
		//String value should be converted into integer
		product.setSupplier(supplierDAO.get(sid));
		
		product.setPrice(Integer.parseInt(price));

		if (productDAO.update(product)) {
			
String path="F:\\Project_ShoppingCart\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images\\";
			
			path=path+String.valueOf(product.getId())+".jpg";
			
			System.out.println("Path ...."+path);
			File filepath=new File(path);
			try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


			mv.addObject("message", "You successfully Updated Product");

		} else {

			mv.addObject("message", "Could not Updated.  please try after some time.");



		}
		return mv;
	}

	
	
	@RequestMapping("admin/product/edit")
	public ModelAndView editProduct(@RequestParam("id") String id)
	{
		
		System.out.println("------Entered edit-------------");
		//ModelAndView mv = new ModelAndView("redirect:/manage_products");
		ModelAndView mv = new ModelAndView("updateP");
		product = productDAO.get(id);
		List<Category> categories =  categoryDAO.list();
        mv.addObject("categories", categories);

        List<Supplier> suppliers =  supplierDAO.list();
        mv.addObject("suppliers", suppliers);
		mv.addObject("product", product);
		//httpSession.setAttribute("selectedProduct", product);
		
		//why we need to have mv as we are using httpSession;
		
		//return mv;
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	

}