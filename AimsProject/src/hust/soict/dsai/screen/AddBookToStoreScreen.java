package src.hust.soict.dsai.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

import src.hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.io.IOException;

public class AddBookToStoreScreen extends JFrame {

    private StoreScreen storeScreen;
    private Store store;

    public AddBookToStoreScreen(StoreScreen storeScreen,Store store) {
        super();
        this.storeScreen = storeScreen;
        this.store=store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book to Store");
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/hust/soict/dsai/screen/AddBookToStoreScreen.fxml"));
                AddBookToStoreScreenController controller = new AddBookToStoreScreenController(storeScreen,store);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
