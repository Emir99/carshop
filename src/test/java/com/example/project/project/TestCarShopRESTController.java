package com.example.project.project;

import com.example.project.project.controller.CarshopController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CarshopController.class)
public class TestCarShopRESTController {

    @Autowired
    private MockMvc mvc;
}