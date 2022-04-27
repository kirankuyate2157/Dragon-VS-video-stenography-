package source;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	GraphicsEnvironment graphics =
						      GraphicsEnvironment.getLocalGraphicsEnvironment();
						      GraphicsDevice device = graphics.getDefaultScreenDevice();
						      
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                    
                    frame.setResizable(false);
				     // device.setFullScreenWindow(frame);
                    //frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
				      
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Securing Confidential Data Over Public Channel using Video Steganography using AES");

        setBounds(450, 190, 1030, 597);
        setResizable(false);
        contentPane = new JPanel();
		contentPane.setBackground(new Color(25,14,40));

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
		int yEnd=28;
		int pass=190;

		JLabel second_line= new JLabel("Steganography and Cryptography are two techniques for protecting messages.Steganography used to hide messages. The types of file are image, video or audio. The goal of steganography");
		second_line.setForeground(new Color(255, 255, 255));
		second_line.setFont(new Font("Tahoma", Font.BOLD, 10));
		second_line.setBounds(15, pass+300, 980, yEnd);
		contentPane.add(second_line);

		JLabel third_txt_file_lbl= new JLabel("steganography is hide message from third parties. Cryptography preserve the message and information. It has two processes are known as encryption and decryption. • Images, audio & ");
		third_txt_file_lbl.setForeground(new Color(255, 255, 255));
		third_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		third_txt_file_lbl.setBounds(15, pass+310, 980, yEnd);
		contentPane.add(third_txt_file_lbl);

		JLabel forth_txt_file_lbl= new JLabel("video are basic mediums. Images & audios are limited to short messages, videos are the best choice. Types of video file format are AVI, FLV, MPEG, MP4. • Dragon Video Steganography is a technique where the");
		forth_txt_file_lbl.setForeground(new Color(255, 255, 255));
		forth_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		forth_txt_file_lbl.setBounds(15, pass+320, 980, yEnd);
		contentPane.add(forth_txt_file_lbl);

		JLabel fifth_txt_file_lbl= new JLabel("where the secret message is hidden within a video file. The original video file is known as cover file and the video obtained after embedding the secret data is known as stego video. This project proposes a steganographic  ");
		fifth_txt_file_lbl.setForeground(new Color(255, 255, 255));
		fifth_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		fifth_txt_file_lbl.setBounds(15, pass+330, 980, yEnd);
		contentPane.add(fifth_txt_file_lbl);

        JLabel six_txt_file_lbl= new JLabel("a Dragon steganographic model which utilizes cover video files to conceal the presence of other sensitive data regardless of its format. The model presented is based on pixel-wise manipulation of colored raw video files to embed the secret data.");
		six_txt_file_lbl.setForeground(new Color(255, 255, 255));
		six_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		six_txt_file_lbl.setBounds(15, pass+340, 980, yEnd);
		contentPane.add(six_txt_file_lbl);

        JLabel brandHero = new JLabel(" Dragon VS");
        brandHero.setForeground(Color.white);
        brandHero.setBackground(new Color(64, 0, 128));
        brandHero.setFont(new Font("Tahoma", Font.BOLD, 35));
        brandHero.setBounds(400, 0, 200, 43);
        brandHero.setOpaque(true);
        contentPane.add(brandHero);

        JLabel label = new JLabel("Securing Confidential comunication and data transmission");//Securing Confidential Data Over Public Channel using Video Steganography using AES
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(310, 16, 1500, 78);
		contentPane.add(label);
		
        JLabel lblNewLabel = new JLabel("User Login");
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(423, 80, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        textField.setBounds(481, 190, 281, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        passwordField.setBounds(481, 286, 281, 48);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 24));
		
        lblUsername.setBounds(270, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
        
        lblPassword.setBounds(270, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(13,59,102));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setOpaque(true);

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 53);
        
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	String u="demo";
            	String p="demo";
                String userName = textField.getText();
                String password = passwordField.getText();
            
                    if ((userName.equals(u) && password.equals(p)) || (userName.equals("kiran")&&password.equals("12345"))||(userName.equals("dragon")&&password.equals("dragon"))) {
                        
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        dispose();
					
					VideoSteganography frame = new VideoSteganography();
					
					//frame.setUndecorated(true);
				      frame.setResizable(false);
				    //  device.setFullScreenWindow(frame);
				     
					frame.setVisible(true);
					 frame.setLocationRelativeTo(null);
	                    frame.setVisible(true); 
   
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
















