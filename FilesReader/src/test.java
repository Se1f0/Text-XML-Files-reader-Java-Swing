import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

public class test {

	private JFrame frmTp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmTp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTp = new JFrame();
		frmTp.setTitle("TP2");
		frmTp.setBounds(100, 100, 500, 350);
		frmTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 45, 446, 222);
		frmTp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 446, 222);
		panel.add(scrollPane);
		
		JTextArea jTextArea1 = new JTextArea();
		scrollPane.setViewportView(jTextArea1);
		jTextArea1.setEditable ( false );
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 278, 446, 14);
		lblNewLabel.setVisible(false);
		frmTp.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Read");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser("C:\\Users\\seif9\\Desktop");
				FileFilter txtFilter = new FileTypeFilter(".txt", "Text Documents");
				FileFilter xmlFilter = new FileTypeFilter(".xml", "XML Documents");
				chooser.addChoosableFileFilter(txtFilter);
				chooser.addChoosableFileFilter(xmlFilter);
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				if (f != null) {
					String filename = f.getAbsolutePath();
					try {
						//FileReader reader = new FileReader(filename);
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
						jTextArea1.read(br, null);
						lblNewLabel.setText(f.getName());
						lblNewLabel.setVisible(true);
						br.close();
						jTextArea1.requestFocus();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					} 
				}
			}
		});
		btnNewButton.setBounds(20, 11, 206, 23);
		frmTp.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTp.dispose();
			}
		});
		btnNewButton_1.setBounds(260, 11, 206, 23);
		frmTp.getContentPane().add(btnNewButton_1);
	}
}