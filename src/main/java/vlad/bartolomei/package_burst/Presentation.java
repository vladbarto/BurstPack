package vlad.bartolomei.package_burst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;

public class Presentation {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);
    private final FileService fileService;
    private JFrame frame;

    public Presentation() {
        this.fileService = new FileService();

        this.frame = new JFrame("I have no idea what am I doing here");
        localLayout();

        frame.setSize(500, 600);
        frame.setLayout(null); // using no layout managers
        frame.setVisible(true); // making the frame visible
    }

    //------------------------- Local panel --------------------------------
    private JButton sendButton;
    private JLabel fileToSendLabel;
    private JTextField filePathTextField;
    private JLabel receiverIPAddressLabel;
    private JTextField receiverIPAddressTextField;

    private void localLayout() {
        receiverIPAddressLabel = new JLabel("Receiver IP Address");
        receiverIPAddressLabel.setBounds(50, 50, 200, 50);
        frame.add(receiverIPAddressLabel);

        receiverIPAddressTextField = new JTextField();
        receiverIPAddressTextField.setBounds(200, 50, 220, 50);
        frame.add(receiverIPAddressTextField);

        fileToSendLabel = new JLabel("Path of the file to send");
        fileToSendLabel.setBounds(50, 100, 200, 50);
        frame.add(fileToSendLabel);

        filePathTextField = new JTextField();
        filePathTextField.setBounds(200, 100, 220, 50);
        frame.add(filePathTextField);

        sendButton = new JButton("Click me");
        sendButton.setBounds(150, 200, 220, 50);
        sendButton.addActionListener(e -> onSend());
        frame.add(sendButton);
    }

    private void onSend() {
        fileService.sendFileOverInternet(
                new File(filePathTextField.getText()),
                receiverIPAddressTextField.getText()
        );
        log.info("clicked");
    }

    //---------------------------------------------------------
    private void remoteLayout() {
        // deocamdata nimic
    }
}
