package com.qa.ims.controller;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;
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
        LOGGER.info("Order created");
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
            case ADD_ITEM:
                this.addItem(order_id);
                break;
            case REMIOVE_ITEM:
                this.removeItem(order_id);
                break;
            default:
                break;
            }
        LOGGER.info("Order Updated");
        return null ;
    }

    private void removeItem(Long order_id) {
    }

    private void addItem(Long order_id) {
    }

    /**
     * Deletes an existing customer by the id of the customer
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the order you would like to delete");
        LOGGER.info("OR enter the id of the order and the item inside the order that you would like to delete");
        Long[] ids = utils.getLongs();
        if (ids.length == 2) {
            return orderDAO.delete(ids[0], ids[1]);
        } else {
            Long id = ids[0];
            return orderDAO.delete(id);
        }
    }

    public enum UpdateAction {

        ADD_ITEM("To add an item to the order"),
        REMIOVE_ITEM("To remove an item from the order");
    
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
