package com.example.notebook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NotebookController {
    @FXML
    Button buttonAdd;
    @FXML
    Button buttonDelete;
    @FXML
    TextField inputField;
    @FXML
    ListView <String> listView;
    @FXML
    Label computerNameLabel;
    @FXML
    ImageView avatarImageView;
    @FXML
    ObservableList<String> list = FXCollections.observableArrayList();

    public void initialize(){
        try {
            String computerName = InetAddress.getLocalHost().getHostName();
            computerNameLabel.setText(computerName);
        } catch (UnknownHostException e) {
            computerNameLabel.setText("Неизвестный компьютер");
        }

        Image avatarImage = new Image("https://media.discordapp.net/attachments/1125898813912125483/1172216042165117019/IMG_2731.JPG?ex=655f8243&is=654d0d43&hm=121c3ea49a366dd2e30a7d8c2aadb0dc20528f6dbc5319742baa8e7041d4665f&=&width=477&height=477");
        avatarImageView.setImage(avatarImage);
    }

    @FXML
    public void buttonClickAdd(){
        String inputWords = inputField.getText();
        list.add(inputWords);
        listView.setItems(list);
    }

    @FXML
    public void buttonClickDelete(){
        String inputWordsForDelete = inputField.getText();
        list.remove(inputWordsForDelete);
        listView.setItems(list);
    }
}
