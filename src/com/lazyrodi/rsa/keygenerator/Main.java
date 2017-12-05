package com.lazyrodi.rsa.keygenerator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

public class Main extends JFrame {

	private JPanel contentPane;

	JTextArea publicTextArea;
	JTextArea privateTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/lazyrodi/rsa/keygenerator/images/lazyrodi_36x36.png")));
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RSA Key Generator");
		setBounds(100, 100, 800, 380);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCreateKeyPair = new JButton("Create KeyPair");
		btnCreateKeyPair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setKeyInTextArea();
			}
		});
		btnCreateKeyPair.setBounds(10, 262, 764, 55);
		contentPane.add(btnCreateKeyPair);

		JPanel publicPanel = new JPanel();
		publicPanel.setToolTipText("");
		publicPanel.setBorder(new TitledBorder(null, "Public Key", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		publicPanel.setBounds(10, 11, 372, 240);
		contentPane.add(publicPanel);
		publicPanel.setLayout(null);

		JScrollPane publicScroll = new JScrollPane();
		publicScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		publicScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		publicScroll.setBounds(10, 22, 352, 207);
		publicPanel.add(publicScroll);

		publicTextArea = new JTextArea();
		publicTextArea.setEditable(false);
		publicTextArea.setLineWrap(true);
		publicScroll.setViewportView(publicTextArea);

		JLabel lblLazyrodigmailcom = new JLabel("lazyrodi@gmail.com");
		lblLazyrodigmailcom.setVerticalAlignment(SwingConstants.TOP);
		lblLazyrodigmailcom.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLazyrodigmailcom.setBounds(650, 325, 124, 22);
		contentPane.add(lblLazyrodigmailcom);

		JPanel privatePanel = new JPanel();
		privatePanel.setLayout(null);
		privatePanel.setToolTipText("");
		privatePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Private Key",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		privatePanel.setBounds(402, 11, 372, 240);
		contentPane.add(privatePanel);

		JScrollPane privateScroll = new JScrollPane();
		privateScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		privateScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		privateScroll.setBounds(10, 22, 352, 207);
		privatePanel.add(privateScroll);

		privateTextArea = new JTextArea();
		privateTextArea.setEditable(false);
		privateTextArea.setLineWrap(true);
		privateScroll.setViewportView(privateTextArea);

		setKeyInTextArea();
		btnCreateKeyPair.setFocusPainted(false);
	}

	private void setKeyInTextArea() {
		KeyPair keyPair = RSA.makeKeyPair();
		String publicKey = RSA.byteArrToHexStr(keyPair.getPublic().getEncoded());
		String privateKey = RSA.byteArrToHexStr(keyPair.getPrivate().getEncoded());

		publicTextArea.setText(publicKey);
		privateTextArea.setText(privateKey);
	}
}
