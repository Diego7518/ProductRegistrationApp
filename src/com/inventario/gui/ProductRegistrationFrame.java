package com.inventario.gui;

import com.inventario.model.Product;
import com.inventario.model.ProductTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductRegistrationFrame extends JFrame {
    private JTextField nameField, priceField, quantityField;
    private ProductTableModel tableModel;
    private JTable productTable; // Nueva tabla

    public ProductRegistrationFrame(ProductTableModel model) {
        this.tableModel = model;

        setTitle("Product Registration");
        setLayout(new BorderLayout()); // Usaremos BorderLayout para organizar la tabla y el formulario

        // Crear el panel del formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        // Añadir los componentes al formulario
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; formPanel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(priceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; formPanel.add(priceField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(quantityLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; formPanel.add(quantityField, gbc);
        gbc.gridx = 1; gbc.gridy = 3; formPanel.add(saveButton, gbc);

        // Crear la tabla que mostrará los productos
        productTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(productTable); // Añadir la tabla a un JScrollPane

        // Añadir el panel del formulario al norte del BorderLayout y la tabla en el centro
        add(formPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER); // La tabla ocupará el resto de la ventana

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void saveProduct() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(name, price, quantity);
            tableModel.addProduct(product); // Añadir el producto al modelo de la tabla

            // Limpiar campos después de guardar
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
