package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ImageController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Integer id, HttpServletResponse response) throws IOException {
        Product product = productService.getProductById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(product.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.POST)
    public void doUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        productService.saveImageToTemporaryRepo(multipartFile.getBytes());
    }


}
