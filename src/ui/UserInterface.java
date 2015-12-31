package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.FibonacciIndex;

public class UserInterface {
	// Components
	static JTextField textField;
	static JFrame frame;
	static JPanel panel;
	static JButton button;
	static JLabel instructions;
	static JLabel emptyLabel;
	static JTextArea ta;
	private static String results;

	private static void createAndShowGUI() {
		initializeWindow();
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				try {
					validate();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame, "You must Enter a number.");
				}
				removeOldResults();
				displayResults();
			}
		});
		panel.add(instructions);
		panel.add(textField);
		panel.add(button);
		frame.add(panel);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	protected static void validate() {
		try {
			String enteredText = textField.getText();
			if (enteredText.isEmpty()) {
				textField.setText("0");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "You must Enter a number.");
		}
	}

	protected static void removeOldResults() {
		List<Component> list = Arrays.asList(panel.getComponents());
		if (list.contains(ta)) {
			panel.remove(ta);
			frame.repaint();
			frame.revalidate();
		}

	}

	private static void initializeWindow() {
		// Create and set up the window.
		frame = new JFrame("Fibonacci!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emptyLabel = new JLabel("");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		panel = new JPanel();
		instructions = new JLabel("<html>Enter a number and we'll give you that many numbers <br>from the Fibonacci sequence.</html>");
		textField = new JTextField(10);
		button = new JButton("Compute");
	}

	@SuppressWarnings("deprecation")
	protected static void displayResults() {
		ta = new JTextArea(20, 10);
		Integer tryThisNumber = 0;
		try{
			tryThisNumber = Integer.valueOf(textField.getText());
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame,"You must Enter a number. \n" + e.getMessage());
		}
		FibonacciIndex fi = new FibonacciIndex();
		Integer[] resultsToDisplay = fi.returnIndices(tryThisNumber);
		StringBuilder sb = new StringBuilder();
		for (int i : resultsToDisplay) {
			sb.append(i + " ");
		}
		results = sb.toString();

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		ta.setText(results);
		ta.setBorder(border);
		ta.setEditable(false);
		ta.setFont(new Font("Verdana", Font.BOLD, 12));
		ta.setLineWrap(true);
		panel.add(ta);
		panel.resize(300, 300);
		frame.resize(panel.getSize());
		frame.repaint();
		frame.revalidate();
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame,e.getMessage());
				}
			}
		});
	}
}
