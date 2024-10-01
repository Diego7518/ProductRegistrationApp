package com.inventario.main;

import com.inventario.gui.ProductRegistrationFrame;
import com.inventario.model.ProductTableModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductTableModel model = new ProductTableModel();
            ProductRegistrationFrame frame = new ProductRegistrationFrame(model);
            frame.setVisible(true);
        });
    }
}