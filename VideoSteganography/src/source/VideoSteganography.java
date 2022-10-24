package source;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

@SuppressWarnings("serial")
public class VideoSteganography extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JButton btnData;
	private JButton btnVideoFile;

	String DataFile, VideoFile, FinalFile, file1, file2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	// private JLabel input_txt_file_lbl;
	// private JLabel input_vdo_file_lbl;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// GraphicsEnvironment graphics =
					// GraphicsEnvironment.getLocalGraphicsEnvironment();
					// GraphicsDevice device = graphics.getDefaultScreenDevice();

					VideoSteganography frame = new VideoSteganography();

					// frame.setUndecorated(true);
					frame.setResizable(false);
					frame.setUndecorated(true);
					// device.setFullScreenWindow(frame);

					// device.setFullScreenWindow(frame);
					// frame.pack();
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
	public VideoSteganography() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(VideoSteganography.class.getResource("/source/hackerb.jpg")));
		setTitle("Securing Confidential Data Over Public Channel using Video Steganography using AES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 400, 1400, 1700); // 30, 100, 1500, 1700

		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 14, 40));// 25,147,240 85, 180, 176
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int xEnd = 350;
		int xStart = 400;
		int yEnd = 28;
		int yStart = 240;
		int pass = 480;

		JLabel second_line = new JLabel(
				"Existing system were developed by keeping an eye over the following technologies:I.Plain Video Steganograph.II.Water marketing Technique.III.Video Steganography with password.But the problems with above techniques is that the users data can begets in hand to");
		second_line.setForeground(new Color(255, 255, 255));
		second_line.setFont(new Font("Tahoma", Font.BOLD, 10));
		second_line.setBounds(15, pass + 300, 1370, yEnd);
		contentPane.add(second_line);

		JLabel third_txt_file_lbl = new JLabel(
				"attackers which could be dangerous.Hence the proposed system comes in picture.Achieve secure communication.This method featured security, capacity, and robustness.The use of Steganography Corporation government and law enforcement agencies can");
		third_txt_file_lbl.setForeground(new Color(255, 255, 255));
		third_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		third_txt_file_lbl.setBounds(15, pass + 310, 1370, yEnd);
		contentPane.add(third_txt_file_lbl);

		JLabel forth_txt_file_lbl = new JLabel(
				"communicate secretly.Supports for hiding multiple text files behind a video.Applications : • Military application Industrial application Provide Protection of sensitive data. • Confidential communication and secret data. • Scientist use this technique to hide secret formula.• Protection against data alteration.");
		forth_txt_file_lbl.setForeground(new Color(255, 255, 255));
		forth_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		forth_txt_file_lbl.setBounds(15, pass + 320, 1370, yEnd);
		contentPane.add(forth_txt_file_lbl);

		JLabel fifth_txt_file_lbl = new JLabel(
				"secret formula. Protection against data alteration. Limitations • Huge number of data, huge file size. So someone Can suspect about it.• Large the Size of video- larger it takes to upload and download • Current version Supported mainly focusing on mpu files.");
		fifth_txt_file_lbl.setForeground(new Color(255, 255, 255));
		fifth_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		fifth_txt_file_lbl.setBounds(15, pass + 330, 1370, yEnd);
		contentPane.add(fifth_txt_file_lbl);

		// label input
		JLabel input_txt_file_lbl = new JLabel("Select Text File");
		input_txt_file_lbl.setForeground(new Color(255, 255, 255));
		input_txt_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		input_txt_file_lbl.setBounds(xStart, yStart - 30, xEnd, yEnd);
		contentPane.add(input_txt_file_lbl);

		textField = new JTextField();
		textField.setToolTipText("Opened filename");
		textField.setBounds(xStart, yStart, xEnd, yEnd); // 48
		contentPane.add(textField);
		textField.setColumns(10);

		btnData = new JButton("Data");
		btnData.setBackground(new Color(13, 59, 102));// 13,59,102
		btnData.setForeground(Color.WHITE);
		btnData.setOpaque(true);

		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataFile = selectFile();

				textField.setText(file1);

				String key = "This is a secret";
				File inputFile = new File(DataFile);
				File encryptedFile = new File(DataFile + ".encrypted");
				File decryptedFile = new File(DataFile + "de.txt");

				try {
					VideoSteganography.fileProcessor(Cipher.ENCRYPT_MODE, key, inputFile, encryptedFile);
					VideoSteganography.fileProcessor(Cipher.DECRYPT_MODE, key, encryptedFile, decryptedFile);
					System.out.println("Sucess");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		btnData.setBounds(xEnd + 450, yStart, 89, 30); // 48
		contentPane.add(btnData);

		btnVideoFile = new JButton("Video file");
		btnVideoFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VideoFile = selectFile();
				textField_1.setText(file1);

			}
		});

		btnVideoFile.setBounds(xEnd + 450, yStart + 60, 89, 30); // 217 xStart, yStart+60, xEnd, yEnd
		btnVideoFile.setBackground(new Color(13, 59, 102));
		btnVideoFile.setForeground(Color.WHITE);
		btnVideoFile.setOpaque(true);

		contentPane.add(btnVideoFile);
		// label for input video
		// label input
		JLabel input_vdo_file_lbl = new JLabel("Select Video File");
		input_vdo_file_lbl.setForeground(new Color(255, 255, 255));
		input_vdo_file_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		input_vdo_file_lbl.setBounds(xStart, yStart + 30, xEnd, yEnd);
		contentPane.add(input_vdo_file_lbl);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Opened filename\r\n");
		textField_1.setColumns(10);
		textField_1.setBounds(xStart, yStart + 60, xEnd, yEnd); // 220
		contentPane.add(textField_1);

		int xStart2 = 415;
		int xEnd2 = 180;
		int yStart2 = 384;
		int yEnd2 = 70;

		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBackground(new Color(13, 59, 102));
		btnEncrypt.setForeground(Color.WHITE);
		btnEncrypt.setOpaque(true);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					zipFiles(DataFile, VideoFile);

					JOptionPane.showMessageDialog(contentPane, "Your files were encrypted");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(contentPane, "No files were selected!!!");
				}

			}
		});
		btnEncrypt.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEncrypt.setBounds(xStart2 + 270, yStart2, xEnd2, yEnd2); // 87
		contentPane.add(btnEncrypt);

		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBackground(new Color(13, 59, 102));
		btnDecrypt.setForeground(Color.WHITE);
		btnDecrypt.setOpaque(true);
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unzipFiles();
				JOptionPane.showMessageDialog(contentPane, "Your files were decrypted");

			}
		});
		btnDecrypt.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDecrypt.setBounds(xStart2, yStart2, xEnd2, yEnd2); // 87
		contentPane.add(btnDecrypt);
		// ------ for logout -----------
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
				// obj.setVisible(true);
				if (a == JOptionPane.YES_OPTION) {
					dispose();
					UserLogin obj = new UserLogin();

					obj.setTitle("Securing Confidential Data Over Public Channel using Video Steganography using AES");
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					obj.setVisible(true);
					// System.exit(0);
				} else {
					remove(a);
				}

			}
		});
		// graphics interface
		btnNewButton.setBackground(new Color(13, 59, 102));
		btnNewButton.setForeground(Color.red);
		btnNewButton.setOpaque(true);

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(xStart2 + 50, yStart2 + 100, 350, 30); // 87
		contentPane.add(btnNewButton);

		// for log out
		int Hp = 200;
		JLabel brandHero = new JLabel(" Dragon VS");
		brandHero.setForeground(Color.white);
		brandHero.setBackground(new Color(64, 0, 128));
		brandHero.setFont(new Font("Tahoma", Font.BOLD, 35));
		brandHero.setBounds(Hp + 400, 0, 200, 43);
		brandHero.setOpaque(true);
		contentPane.add(brandHero);

		JLabel brandLine = new JLabel("Securing Confidential comunication and data transmission");
		brandLine.setForeground(new Color(255, 255, 255));
		brandLine.setFont(new Font("Arial", Font.BOLD, 13));
		brandLine.setBounds(Hp + 310, 16, 1500, 78);
		contentPane.add(brandLine);

		JLabel BGPg = new JLabel();
		BGPg.setForeground(Color.white);
		BGPg.setBackground(new Color(20, 0, 51));
		BGPg.setFont(new Font("Tahoma", Font.BOLD, 35));
		BGPg.setBounds(200, 170, 900, 403);
		BGPg.setOpaque(true);
		contentPane.add(BGPg);

		// setBackground(Color.red)
		JLabel label = new JLabel("Securing Confidential Data Over Public Channel using Video Steganography using AES");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.BOLD, 26));
		label.setBounds(74, 100, 1500, 78);
		contentPane.add(label);
		int x = 631;
		lblNewLabel = new JLabel("Group Members :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(471, x, 200, 28);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("1. Miss.snehal kad ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(623, x, 500, 28);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("2. Mr.Kiran Kuyate");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(623, x += 31, 500, 28);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("3. Mr.Prathamesh Jadhav");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));

		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(623, x += 31, 500, 28);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("4. Miss.Madhuri Purker");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));

		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(623, x += 31, 500, 28);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("5. Miss.snehal Sayker");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));

		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(623, x += 31, 500, 28);
		contentPane.add(lblNewLabel_5);
	}

	static void fileProcessor(int cipherMode, String key, File inputFile, File outputFile) {
		{
			try {
				Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(cipherMode, secretKey);

				FileInputStream inputStream = new FileInputStream(inputFile);
				byte[] inputBytes = new byte[(int) inputFile.length()];
				inputStream.read(inputBytes);

				byte[] outputBytes = cipher.doFinal(inputBytes);

				FileOutputStream outputStream = new FileOutputStream(outputFile);
				outputStream.write(outputBytes);

				inputStream.close();
				outputStream.close();

			} catch (NoSuchPaddingException | NoSuchAlgorithmException
					| InvalidKeyException | BadPaddingException
					| IllegalBlockSizeException | IOException e) {
				e.printStackTrace();
			}
			// finally {}
		}
	}

	// method to select file
	String selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			file1 = selectedFile.getName();
			return selectedFile.getAbsolutePath();
			// file encrypt
		}
		return null;
	}

	// --------- start of zip file method --------------------------
	public void zipFiles(String Text, String Video) {

		new File("D:\\Video Steganography\\Encryted Files").mkdirs();
		String zipFile = "D:\\Video Steganography\\Encryted Files\\new.mp4";

		String[] srcFiles = { Video, Text };

		try {

			// create byte buffer
			byte[] buffer = new byte[1024];

			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < srcFiles.length; i++) {
				File srcFile = new File(srcFiles[i]);
				FileInputStream fis = new FileInputStream(srcFile);

				// begin writing a new ZIP entry, positions the stream to the start of the entry
				// data
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
				zos.closeEntry();
				// close the InputStream
				fis.close();

			}

			// close the ZipOutputStream
			zos.close();

		} catch (IOException ioe) {
			System.out.println(DataFile + "\n" + VideoFile);
			System.out.println("Error creating zip file: " + ioe);
		}

	}

	// -------- /end of zip file ----------------

	// start of unzip file

	public void unzipFiles() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			String zipFilePath = selectedFile.getAbsolutePath();

			new File("D:\\Video Steganography\\Extracted Data").mkdirs();
			String destDir = "D:\\Video Steganography\\Extracted Data";

			unzip(zipFilePath, destDir);

		}
	}

	private static void unzip(String zipFilePath, String destDir) {
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
