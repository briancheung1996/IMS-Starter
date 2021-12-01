package com.qa.ims.controller;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.dao.OrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderController implements CrudController<Order>{
    public static final Logger LOGGER = LogManager.getLogger();
    private OrderDAO orderDAO;
    private Utils utils;

    public OrderController(OrderDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order : orders) {
            LOGGER.info(order);
        }
        return orders;
    }

    @Override
    public Order read() {
        LOGGER.info("Please enter the id of the order you would like to read");
        Long id = utils.getLong();
        Order order = orderDAO.read(id);
        LOGGER.info(order);
        return order;
    }

    @Override
    public Order readByName() {
        return null;
    }

    /**
     * Creates a customer by taking in user input
     */
    @Override
    public Order create() {
        LOGGER.info("Please enter a order id");
        long order_id = utils.getLong();
        LOGGER.info("Please enter a customer id");
        long customer_id = utils.getLong();
        Order order = orderDAO.create(new Order(order_id, customer_id));
        LOGGER.info("Customer created");
        return order;
    }

    /**
     * Updates an existing customer by taking in user input
     */
    @Override
    public Order update() {
        LOGGER.info("Please enter the id of the order you would like to update");
        Long order_id = utils.getLong();
        LOGGER.info(() -> "What would you like to do with order #" + order_id.toString().toLowerCase() + ":");
        UpdateAction.printActions();
        UpdateAction updateAction = UpdateAction.getAction(utils);
        switch (updateAction) {
            case CHANGECUSTOMER:
                this.updateCustomer();
                break;
            case ADDITEM:
                this.addItem();
                break;
            case REMIOVEITEM:
                this.removeItem();
                break;
            default:
                break;
            }
        LOGGER.info("Order Updated");
        return null;
    }

    /**
     * Deletes an existing customer by the id of the customer
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the order you would like to delete");
        Long id = utils.getLong();
        return orderDAO.delete(id);
    }

    public enum UpdateAction {

        CHANGECUSTOMER("To change the order's Customer_ID"),
        ADDITEM("To add an item to the order"),
        REMIOVEITEM("To remove an item from the order");
    
        private String description;
    
        private UpdateAction(String description) {
            this.description = description;
        }
    
        public String getDescription() {
            return this.name() + ": " + this.description;
        }
    
        public static void printActions() {
            for (UpdateAction updateAction : UpdateAction.values()) {
                LOGGER.info(updateAction.getDescription());
            }
        }
    
        public static UpdateAction getAction(Utils utils) {
            UpdateAction updateAction;
            while (true) {
                try {
                    updateAction = UpdateAction.valueOf(utils.getString().toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    LOGGER.error("Invalid selection please try again");
                }
            }
            return updateAction;
        }
    
    }
    

}
