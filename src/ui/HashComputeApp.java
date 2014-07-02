package ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HashComputeApp {

	private JFrame frame;
	private final JTextPane txtInfoDisplay = new JTextPane();
	private final JTextField textField = new JTextField();
	private final JButton btnBrowse = new JButton("Browse");
	private final JLabel lblMd = new JLabel("MD5");
	private final JLabel lblSha1 = new JLabel("SHA1");
	private final JLabel lblSha256 = new JLabel("SHA256");
	private final JLabel lblmd5_hash = new JLabel("...");
	private final JLabel lblSha1_hash = new JLabel("...");
	private final JLabel lblSha256_hash = new JLabel("...");
	private final JRadioButton rdbtn_MD5 = new JRadioButton("");
	private final JRadioButton rdbtnI_SHA1 = new JRadioButton("");
	private final JRadioButton rdbtnI_SHA256 = new JRadioButton("");

	private final String md5_info = " This hash algorithm should not be used! \n"
									+ " It is here only for historical reasons. ";	
	private final String about_info = " Version v1. 02072014 \n" +
										" Author: bota.catalin@gmail.com \n" +
										" GitHub https://github.com/botacatalin/HashCompute \n" +
										" Licence: GPLv2 https://www.gnu.org/licenses/gpl-2.0.txt \n";
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblFile = new JLabel("File");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnHashcompute = new JMenu("HashCompute");
	private final JMenuItem mntmAbout = new JMenuItem("About");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashComputeApp window = new HashComputeApp();
					window.frame.setVisible(true);
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
		textField.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 217, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 10, 0, 0, 85, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblFile = new GridBagConstraints();
		gbc_lblFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblFile.anchor = GridBagConstraints.EAST;
		gbc_lblFile.gridx = 0;
		gbc_lblFile.gridy = 1;
		frame.getContentPane().add(lblFile, gbc_lblFile);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.fill = GridBagConstraints.VERTICAL;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 2;
		gbc_btnBrowse.gridy = 1;
		frame.getContentPane().add(btnBrowse, gbc_btnBrowse);
		
		GridBagConstraints gbc_rdbtn_MD5 = new GridBagConstraints();
		gbc_rdbtn_MD5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_MD5.gridx = 0;
		gbc_rdbtn_MD5.gridy = 2;
		buttonGroup.add(rdbtn_MD5);
		rdbtn_MD5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtInfoDisplay.setText("");
				txtInfoDisplay.setText(md5_info);
				
			}
		});
		frame.getContentPane().add(rdbtn_MD5, gbc_rdbtn_MD5);
		
		GridBagConstraints gbc_lblMd = new GridBagConstraints();
		gbc_lblMd.anchor = GridBagConstraints.WEST;
		gbc_lblMd.insets = new Insets(0, 0, 5, 5);
		gbc_lblMd.gridx = 1;
		gbc_lblMd.gridy = 2;
		frame.getContentPane().add(lblMd, gbc_lblMd);
		
		GridBagConstraints gbc_lblmd5_hash = new GridBagConstraints();
		gbc_lblmd5_hash.anchor = GridBagConstraints.WEST;
		gbc_lblmd5_hash.insets = new Insets(0, 0, 5, 0);
		gbc_lblmd5_hash.gridx = 2;
		gbc_lblmd5_hash.gridy = 2;
		frame.getContentPane().add(lblmd5_hash, gbc_lblmd5_hash);
		
		GridBagConstraints gbc_rdbtnI_SHA1 = new GridBagConstraints();
		gbc_rdbtnI_SHA1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnI_SHA1.gridx = 0;
		gbc_rdbtnI_SHA1.gridy = 3;
		buttonGroup.add(rdbtnI_SHA1);
		frame.getContentPane().add(rdbtnI_SHA1, gbc_rdbtnI_SHA1);
		
		GridBagConstraints gbc_lblSha1 = new GridBagConstraints();
		gbc_lblSha1.anchor = GridBagConstraints.WEST;
		gbc_lblSha1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSha1.gridx = 1;
		gbc_lblSha1.gridy = 3;
		frame.getContentPane().add(lblSha1, gbc_lblSha1);
		
		GridBagConstraints gbc_lblSha1_hash = new GridBagConstraints();
		gbc_lblSha1_hash.anchor = GridBagConstraints.WEST;
		gbc_lblSha1_hash.insets = new Insets(0, 0, 5, 0);
		gbc_lblSha1_hash.gridx = 2;
		gbc_lblSha1_hash.gridy = 3;
		frame.getContentPane().add(lblSha1_hash, gbc_lblSha1_hash);
		
		GridBagConstraints gbc_rdbtnI_SHA256 = new GridBagConstraints();
		gbc_rdbtnI_SHA256.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnI_SHA256.gridx = 0;
		gbc_rdbtnI_SHA256.gridy = 4;
		buttonGroup.add(rdbtnI_SHA256);
		frame.getContentPane().add(rdbtnI_SHA256, gbc_rdbtnI_SHA256);
		
		GridBagConstraints gbc_lblSha256 = new GridBagConstraints();
		gbc_lblSha256.anchor = GridBagConstraints.WEST;
		gbc_lblSha256.insets = new Insets(0, 0, 5, 5);
		gbc_lblSha256.gridx = 1;
		gbc_lblSha256.gridy = 4;
		frame.getContentPane().add(lblSha256, gbc_lblSha256);
		
		GridBagConstraints gbc_lblSha256_hash = new GridBagConstraints();
		gbc_lblSha256_hash.anchor = GridBagConstraints.WEST;
		gbc_lblSha256_hash.insets = new Insets(0, 0, 5, 0);
		gbc_lblSha256_hash.gridx = 2;
		gbc_lblSha256_hash.gridy = 4;
		frame.getContentPane().add(lblSha256_hash, gbc_lblSha256_hash);
		
		GridBagConstraints gbc_txtInfoDisplay = new GridBagConstraints();
		gbc_txtInfoDisplay.gridwidth = 3;
		gbc_txtInfoDisplay.fill = GridBagConstraints.BOTH;
		gbc_txtInfoDisplay.gridx = 0;
		gbc_txtInfoDisplay.gridy = 5;
		txtInfoDisplay.setEditable(false);
		frame.getContentPane().add(txtInfoDisplay, gbc_txtInfoDisplay);
		
		frame.setJMenuBar(menuBar);
		
		menuBar.add(mnHashcompute);
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtInfoDisplay.setText(about_info);
			}
		});
		
		mnHashcompute.add(mntmAbout);
		
		mnHashcompute.add(mntmExit);
	}

}
