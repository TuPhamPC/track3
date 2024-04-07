package dao;

import model.Customer;

public class CustomerDAO implements DAOInterface<Customer>{

    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }


    @Override
    public int insert(Customer khachHang) {
        return 0;
    }

    @Override
    public int update(Customer khachHang) {
        return 0;
    }

    @Override
    public int delete(Customer khachHang) {
        return 0;
    }
}