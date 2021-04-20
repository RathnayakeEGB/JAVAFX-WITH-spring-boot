package com.example.controllers;

import com.example.entities.Customer;
import com.example.services.CustomerService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Controller
public class MainController {

    @FXML
    private JFXTextField customerId;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField address;

    @FXML
    private JFXButton saveCustomer;

    @Autowired
    private CustomerService customerService;

    @FXML
    public void saveCustomer(){

        try {
            Customer customer = getCustomer();
            customerService.save(customer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private Customer getCustomer(){

        Customer c = new Customer();

        try {
            c.setId(Long.parseLong(this.customerId.getText()));
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Invalid Number", ButtonType.OK).showAndWait();
        }
        c.setAddress(address.getText());
        c.setCustomerName(name.getText());
        return c;
    }
}
