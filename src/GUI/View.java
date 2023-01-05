/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import CodeFiles.CodeForCompress;
import CodeFiles.CodeForDecompress;
import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author VULCUN
 */
public class View extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(50,100,150,20);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(250, 100,150,20);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(500,300);
        this.getContentPane().setBackground(Color.darkGray);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);
            try{
                CodeForCompress.compressFunction(file);
            }
            catch(Exception excp){
                JOptionPane.showMessageDialog(null, excp.toString());
            }
        }
      }
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);
            try{
                CodeForDecompress.decompressFunction(file);
            }
            catch(Exception excp){
                JOptionPane.showMessageDialog(null, excp.toString());
            }
        }
      }
    }
    
    
    public static void main(String [] args){
        View view = new View();
        view.setVisible(true);
    }
}
