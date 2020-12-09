package com.awt.book;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the printing of a multi-page book. It prints a "banner", by blowing up
 * a text string to fill the entire page vertically. The program also contains a generic print
 * preview dialog.
 * @version 1.13 2016-05-10
 * @author Cay Horstmann
 */
public class BookTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new BookTestFrame();
            frame.setTitle("BookTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}