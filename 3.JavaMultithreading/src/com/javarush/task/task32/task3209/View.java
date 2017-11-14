package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane=new JTabbedPane();

    private JTextPane htmlTextPane=new JTextPane();

    private JEditorPane plainTextPane=new JEditorPane();

    private Controller controller;

    private UndoManager undoManager = new UndoManager();

    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
        }
    }

    public void init(){
        initGui();
        FrameListener frameListener=new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        this.getContentPane().add(menuBar,BorderLayout.NORTH);

    }

    public  void initEditor(){

            htmlTextPane.setContentType("text/html");

            tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

            tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

            tabbedPane.setPreferredSize(new Dimension(800, 600));
            tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
            this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){

        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }

    public boolean canUndo(){

        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void undo(){
        try {
        undoManager.undo();}
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();}
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

   public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public boolean isHtmlTabSelected(){
       if (tabbedPane.getSelectedIndex()==0)return true;
       return false;
    }

    public  void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Тестовая прога", "О программк", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exit(){
        controller.exit();
    }
}
