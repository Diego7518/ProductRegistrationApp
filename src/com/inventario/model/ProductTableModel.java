package com.inventario.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private final List<Product> products = new ArrayList<>();
    private final String[] columnNames = {"Name", "Price", "Quantity"};

    public void addProduct(Product product) {
        products.add(product);
        fireTableRowsInserted(products.size() - 1, products.size() - 1);
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getName();
            case 1:
                return product.getPrice();
            case 2:
                return product.getQuantity();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}