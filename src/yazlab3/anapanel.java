package yazlab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class anapanel extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anapanel frame = new anapanel();
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
	public anapanel() {
		getContentPane().setBackground(new Color(175, 176, 251));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 490);
		getContentPane().setLayout(null);
		
		JButton btnproblem1 = new JButton("Problem 1");
		btnproblem1.setBackground(new Color(175, 176, 251)); btnproblem1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		anapanel.super.setVisible(false);
	          		
	          	}
	          });
	          
		btnproblem1.setBounds(75, 179, 211, 108);
		 btnproblem1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		anapanel.super.setVisible(false);
	          		musteri_ekle musteri_ekle= new musteri_ekle();
	          		musteri_ekle.setVisible(true);
	          		
	          	}
	          });
	          
		getContentPane().add(btnproblem1);
		
		
		JButton btnProblem2 = new JButton("Problem2");
		btnProblem2.setBackground(new Color(175, 176, 251));
		btnProblem2.setBounds(372, 179, 211, 108);
		 btnProblem2.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		anapanel.super.setVisible(false);
	          		
	          	}
	          });
	          
		getContentPane().add(btnProblem2);
	}
}