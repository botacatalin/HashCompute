package ui;

import general.MD5;
import general.SHA1;
import general.SHA256;
import general.WriteToFile;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/***
 * Author Bota Catalin
 * Email  bota.catalin@gmail.com
 * Desc This software can compute several hash functions used in verification of messages / file integrity. 
 */
public class HashComputeApp {

	private JFrame frmHashCompute;
	private final JTextPane txtInfoDisplay = new JTextPane();
	private final JTextField textField = new JTextField();
	private final JButton btnBrowse = new JButton("Browse");
	private final JLabel lblMd = new JLabel("MD5");
	private final JLabel lblSha1 = new JLabel("SHA1");
	private final JLabel lblSha256 = new JLabel("SHA256");
	private final JRadioButton rdbtn_MD5 = new JRadioButton("");
	private final JRadioButton rdbtnI_SHA1 = new JRadioButton("");
	private final JRadioButton rdbtnI_SHA256 = new JRadioButton("");

	private final String md5_info = "The MD5 hash algorithm should not be used! It is here only for historical reasons. ";	
	private final String sha1_info = "Published in 1995, SHA-1 produces a 160-bit (20-byte) hash value. A SHA-1 hash value is typically rendered as a hexadecimal number, 40 digits long.";
	private final String sha256_info = "Published in 2001, SHA-256 produces a 256-bit (32-byte) hash value. In 2005, security flaws were identified in SHA-1 recommendation is to use SHA-2 hash algorithm family. ";
	
	private final String about_info = "Version v1. 02072014, Author: bota.catalin@gmail.com \n" +
										"GitHub https://github.com/botacatalin/HashCompute, Licence: GPLv2 https://www.gnu.org/licenses/gpl-2.0.txt \n";
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblFile = new JLabel("File");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnHashcompute = new JMenu("Info");
	private final JMenuItem mntmAbout = new JMenuItem("About");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	
	
	JFileChooser fc = new JFileChooser();

	MD5 md5 = new MD5();
	SHA1 sha1 = new SHA1();
	SHA256 sha256 = new SHA256();
	
	private final JTextField txtmd5_hash = new JTextField();
	private final JTextField txtSha1_hash = new JTextField();
	private final JTextField txtSha256_hash = new JTextField();
	private final JLabel lblNewLabel = new JLabel("Information ");
	private final JCheckBox chckbxWriteToFile = new JCheckBox("write to file");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashComputeApp window = new HashComputeApp();
					window.frmHashCompute.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HashComputeApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtSha256_hash.setColumns(10);
		txtSha1_hash.setColumns(10);
		txtmd5_hash.setColumns(10);
		frmHashCompute = new JFrame();
		frmHashCompute.getContentPane().setBackground(new Color(245, 245, 245));
		frmHashCompute.setIconImage(Toolkit.getDefaultToolkit().getImage(HashComputeApp.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
		frmHashCompute.setTitle("Hash Compute (Message Digest)");
		frmHashCompute.setBounds(100, 100, 550, 310);
		frmHashCompute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 50, 271, 189, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 0, 10, 0, 0, 0, 65, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmHashCompute.getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblFile = new GridBagConstraints();
		gbc_lblFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblFile.anchor = GridBagConstraints.EAST;
		gbc_lblFile.gridx = 1;
		gbc_lblFile.gridy = 1;
		frmHashCompute.getContentPane().add(lblFile, gbc_lblFile);
		
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.fill = GridBagConstraints.BOTH;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 4;
		gbc_btnBrowse.gridy = 1;
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 if (e.getSource() == btnBrowse) {
			            int returnVal = fc.showOpenDialog(btnBrowse);
			 
			            if (returnVal == JFileChooser.APPROVE_OPTION) {
			                File file = fc.getSelectedFile();
			                textField.setText(file.getName());
			             
			                //call computation
			               	
			                txtmd5_hash.setText(md5.computeHash(file));
			               	txtSha1_hash.setText(sha1.computeHash(file));
			               	txtSha256_hash.setText(sha256.computeHash(file));
			               	
			               	//check write to file
			               	if(chckbxWriteToFile.isSelected()) {
			               		WriteToFile.go(file, txtmd5_hash.getText(), txtSha1_hash.getText(), txtSha256_hash.getText());
			               	}
			               	
			            } else {
			            	 textField.setText("Open command cancelled by user.");
			            }
				 }
			}
		});
		textField.setColumns(10);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frmHashCompute.getContentPane().add(textField, gbc_textField);
		frmHashCompute.getContentPane().add(btnBrowse, gbc_btnBrowse);
		
		GridBagConstraints gbc_rdbtn_MD5 = new GridBagConstraints();
		gbc_rdbtn_MD5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_MD5.gridx = 1;
		gbc_rdbtn_MD5.gridy = 3;
		buttonGroup.add(rdbtn_MD5);
		rdbtn_MD5.setBackground(new Color(245, 245, 245));
		rdbtn_MD5.setToolTipText("info");
		rdbtn_MD5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txtInfoDisplay.setText("");
				txtInfoDisplay.setText(md5_info);
				
			}
		});
		
		GridBagConstraints gbc_chckbxWriteToFile = new GridBagConstraints();
		gbc_chckbxWriteToFile.anchor = GridBagConstraints.WEST;
		gbc_chckbxWriteToFile.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWriteToFile.gridx = 4;
		gbc_chckbxWriteToFile.gridy = 2;
		frmHashCompute.getContentPane().add(chckbxWriteToFile, gbc_chckbxWriteToFile);
		frmHashCompute.getContentPane().add(rdbtn_MD5, gbc_rdbtn_MD5);
		
		GridBagConstraints gbc_lblMd = new GridBagConstraints();
		gbc_lblMd.anchor = GridBagConstraints.WEST;
		gbc_lblMd.insets = new Insets(0, 0, 5, 5);
		gbc_lblMd.gridx = 2;
		gbc_lblMd.gridy = 3;
		frmHashCompute.getContentPane().add(lblMd, gbc_lblMd);
		
		GridBagConstraints gbc_txtmd5_hash = new GridBagConstraints();
		gbc_txtmd5_hash.gridwidth = 2;
		gbc_txtmd5_hash.insets = new Insets(0, 0, 5, 5);
		gbc_txtmd5_hash.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmd5_hash.gridx = 3;
		gbc_txtmd5_hash.gridy = 3;
		frmHashCompute.getContentPane().add(txtmd5_hash, gbc_txtmd5_hash);
		
		GridBagConstraints gbc_rdbtnI_SHA1 = new GridBagConstraints();
		gbc_rdbtnI_SHA1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnI_SHA1.gridx = 1;
		gbc_rdbtnI_SHA1.gridy = 4;
		buttonGroup.add(rdbtnI_SHA1);
		rdbtnI_SHA1.setBackground(new Color(245, 245, 245));
		rdbtnI_SHA1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txtInfoDisplay.setText("");
				txtInfoDisplay.setText(sha1_info);
			}
		});
		rdbtnI_SHA1.setToolTipText("info");
		frmHashCompute.getContentPane().add(rdbtnI_SHA1, gbc_rdbtnI_SHA1);
		
		GridBagConstraints gbc_lblSha1 = new GridBagConstraints();
		gbc_lblSha1.anchor = GridBagConstraints.WEST;
		gbc_lblSha1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSha1.gridx = 2;
		gbc_lblSha1.gridy = 4;
		frmHashCompute.getContentPane().add(lblSha1, gbc_lblSha1);
		
		GridBagConstraints gbc_txtSha1_hash = new GridBagConstraints();
		gbc_txtSha1_hash.gridwidth = 2;
		gbc_txtSha1_hash.insets = new Insets(0, 0, 5, 5);
		gbc_txtSha1_hash.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSha1_hash.gridx = 3;
		gbc_txtSha1_hash.gridy = 4;
		frmHashCompute.getContentPane().add(txtSha1_hash, gbc_txtSha1_hash);
		
		GridBagConstraints gbc_rdbtnI_SHA256 = new GridBagConstraints();
		gbc_rdbtnI_SHA256.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnI_SHA256.gridx = 1;
		gbc_rdbtnI_SHA256.gridy = 5;
		buttonGroup.add(rdbtnI_SHA256);
		rdbtnI_SHA256.setBackground(new Color(245, 245, 245));
		rdbtnI_SHA256.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txtInfoDisplay.setText("");
				txtInfoDisplay.setText(sha256_info);
			}
		});
		rdbtnI_SHA256.setToolTipText("info");
		frmHashCompute.getContentPane().add(rdbtnI_SHA256, gbc_rdbtnI_SHA256);
		
		GridBagConstraints gbc_lblSha256 = new GridBagConstraints();
		gbc_lblSha256.anchor = GridBagConstraints.WEST;
		gbc_lblSha256.insets = new Insets(0, 0, 5, 5);
		gbc_lblSha256.gridx = 2;
		gbc_lblSha256.gridy = 5;
		frmHashCompute.getContentPane().add(lblSha256, gbc_lblSha256);
		
		GridBagConstraints gbc_txtSha256_hash = new GridBagConstraints();
		gbc_txtSha256_hash.gridwidth = 2;
		gbc_txtSha256_hash.insets = new Insets(0, 0, 5, 5);
		gbc_txtSha256_hash.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSha256_hash.gridx = 3;
		gbc_txtSha256_hash.gridy = 5;
		frmHashCompute.getContentPane().add(txtSha256_hash, gbc_txtSha256_hash);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 6;
		lblNewLabel.setForeground(Color.GRAY);
		frmHashCompute.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_txtInfoDisplay = new GridBagConstraints();
		gbc_txtInfoDisplay.insets = new Insets(0, 0, 0, 5);
		gbc_txtInfoDisplay.gridwidth = 4;
		gbc_txtInfoDisplay.fill = GridBagConstraints.BOTH;
		gbc_txtInfoDisplay.gridx = 1;
		gbc_txtInfoDisplay.gridy = 7;
		txtInfoDisplay.setText("This software can compute several hash functions used in verification of messages / file integrity. ");
		txtInfoDisplay.setBackground(new Color(245, 245, 245));
		txtInfoDisplay.setEditable(false);
		frmHashCompute.getContentPane().add(txtInfoDisplay, gbc_txtInfoDisplay);
		
		frmHashCompute.setJMenuBar(menuBar);
		mnHashcompute.setIcon(new ImageIcon(HashComputeApp.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));
		
		menuBar.add(mnHashcompute);
		mntmAbout.setIcon(new ImageIcon(HashComputeApp.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtInfoDisplay.setText("");
				txtInfoDisplay.setText(about_info);
			}
		});
		
		mnHashcompute.add(mntmAbout);
		mntmExit.setIcon(new ImageIcon(HashComputeApp.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		mnHashcompute.add(mntmExit);
	}

}
